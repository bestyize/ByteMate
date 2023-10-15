package com.thewind.main

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.bytecode.page.ByteCodeModifyPage
import com.thewind.hacker.page.HexSearchPage
import com.thewind.hacker.page.StringSearchPage
import com.thewind.main.vm.MainPageViewModel
import com.thewind.theme.LocalColors
import com.thewind.widget.NoticeDialog
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun MainPage(
    vm: MainPageViewModel = remember { MainPageViewModel.INSTANCE }
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f, pageCount = { vm.tabs.size })
    Box(modifier = Modifier.fillMaxSize().background(color = LocalColors.current.AdobeDark)) {
        Column(modifier = Modifier.fillMaxSize()) {
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                edgePadding = 10.dp,
                divider = {},
                backgroundColor = LocalColors.current.AdobeDark,
                indicator = {
                    Spacer(
                        modifier = Modifier
                            .tabIndicatorOffset(it[pagerState.currentPage])
                            .height(3.dp)
                            .background(LocalColors.current.AdobeMediumBlue, RoundedCornerShape(3.dp))
                    )
                },
                modifier = Modifier.wrapContentSize()
            ) {
                vm.tabs.forEachIndexed { index, title ->
                    val isSelected = index == pagerState.currentPage
                    Text(text = title,
                        color = if (isSelected) LocalColors.current.AdobeMediumBlue else LocalColors.current.Text1,
                        fontSize = if (isSelected) 16.sp else 15.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 5.dp)
                            .clickable(indication = null, interactionSource = remember {
                                MutableInteractionSource()
                            }) {
                                scope.launch {
                                    pagerState.scrollToPage(index)
                                }
                            })
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(LocalColors.current.Bg3))
            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { pageIndex ->
                when (pageIndex) {
                    0 -> HexSearchPage()
                    1 -> StringSearchPage()
                    else -> ByteCodeModifyPage()
                }
            }
        }
    }

    val noticeState = vm.noticeState.collectAsState()

    noticeState.value?.let { notice ->
        NoticeDialog(title = notice.title, content = notice.content, onOk = {
            vm.updateNotice(null)
        })
    }
}