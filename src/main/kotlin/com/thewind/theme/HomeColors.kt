package com.thewind.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class HomeColors internal constructor(
    private val colorResId: String,
    private val colorMap: Map<String, Color>
) {

    private fun mapNameToColor(key: String): Color {
        return colorMap[key] ?: Color.Transparent
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is HomeColors) return false
        return this.colorResId == other.colorResId && this.colorMap == other.colorMap
    }

    override fun hashCode(): Int {
        return (colorResId.hashCode() * 31) + colorMap.hashCode()
    }


    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF101011
     */
    val Ga0: Color = mapNameToColor("Ga0")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF1E2022
     */
    val Ga0_s: Color = mapNameToColor("Ga0_s")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF0A0B0C
     */
    val Ga1: Color = mapNameToColor("Ga1")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF232527
     */
    val Ga1_s: Color = mapNameToColor("Ga1_s")

    /**
     * default  theme color:
     * day:   #FFE3E5E7
     * night: #FF2F3134
     */
    val Ga2: Color = mapNameToColor("Ga2")

    /**
     * default  theme color:
     * day:   #FFC9CCD0
     * night: #FF46494D
     */
    val Ga3: Color = mapNameToColor("Ga3")

    /**
     * default  theme color:
     * day:   #FFAEB3B9
     * night: #FF5E6267
     */
    val Ga4: Color = mapNameToColor("Ga4")

    /**
     * default  theme color:
     * day:   #FF9499A0
     * night: #FF757A81
     */
    val Ga5: Color = mapNameToColor("Ga5")

    /**
     * default  theme color:
     * day:   #FF797F87
     * night: #FF8B9097
     */
    val Ga6: Color = mapNameToColor("Ga6")

    /**
     * default  theme color:
     * day:   #FF61666D
     * night: #FFA2A7AE
     */
    val Ga7: Color = mapNameToColor("Ga7")

    /**
     * default  theme color:
     * day:   #FF484C53
     * night: #FFB9BDC2
     */
    val Ga8: Color = mapNameToColor("Ga8")

    /**
     * default  theme color:
     * day:   #FF2F3238
     * night: #FFD0D3D7
     */
    val Ga9: Color = mapNameToColor("Ga9")

    /**
     * default  theme color:
     * day:   #FF18191C
     * night: #FFE7E9EB
     */
    val Ga10: Color = mapNameToColor("Ga10")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF242628
     */
    val Ga11: Color = mapNameToColor("Ga11")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF202123
     */
    val Ga12: Color = mapNameToColor("Ga12")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF2B2C2F
     */
    val Ga12_s: Color = mapNameToColor("Ga12_s")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF2F3134
     */
    val Ga13_s: Color = mapNameToColor("Ga13_s")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF1A1B1D
     */
    val Ga13: Color = mapNameToColor("Ga13")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF17181A
     */
    val Wh0: Color = mapNameToColor("Wh0")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF2F3134
     */
    val Wh0_s: Color = mapNameToColor("Wh0_s")

    /**
     * default  theme color:
     * day:   #FF000000
     * night: #FF000000
     */
    val Ba0: Color = mapNameToColor("Ba0")

    /**
     * default  theme color:
     * day:   #FF000000
     * night: #FFFFFFFF
     */
    val Ba0_s: Color = mapNameToColor("Ba0_s")

    /**
     * default  theme color:
     * day:   #FFFFF3F6
     * night: #FF26161C
     */
    val Pi0: Color = mapNameToColor("Pi0")

    /**
     * default  theme color:
     * day:   #FFFFECF1
     * night: #FF2F1A22
     */
    val Pi1: Color = mapNameToColor("Pi1")

    /**
     * default  theme color:
     * day:   #FFFFD9E4
     * night: #FF472030
     */
    val Pi2: Color = mapNameToColor("Pi2")

    /**
     * default  theme color:
     * day:   #FFFFB3CA
     * night: #FF76304B
     */
    val Pi3: Color = mapNameToColor("Pi3")

    /**
     * default  theme color:
     * day:   #FFFF8CB0
     * night: #FFA73E65
     */
    val Pi4: Color = mapNameToColor("Pi4")

    /**
     * default  theme color:
     * day:   #FFFF6699
     * night: #FFD44E7D
     */
    val Pi5: Color = mapNameToColor("Pi5")

    /**
     * default  theme color:
     * day:   #FFE84B85
     * night: #FFDC6D94
     */
    val Pi6: Color = mapNameToColor("Pi6")

    /**
     * default  theme color:
     * day:   #FFD03171
     * night: #FFE38CAA
     */
    val Pi7: Color = mapNameToColor("Pi7")

    /**
     * default  theme color:
     * day:   #FFAD1C5B
     * night: #FFEBABC1
     */
    val Pi8: Color = mapNameToColor("Pi8")

    /**
     * default  theme color:
     * day:   #FF771141
     * night: #FFF2CAD8
     */
    val Pi9: Color = mapNameToColor("Pi9")

    /**
     * default  theme color:
     * day:   #FF3F0723
     * night: #FFFAE9EF
     */
    val Pi10: Color = mapNameToColor("Pi10")

    /**
     * default  theme color:
     * day:   #FFFEF3FC
     * night: #FF261525
     */
    val Ma0: Color = mapNameToColor("Ma0")

    /**
     * default  theme color:
     * day:   #FFFDEBFA
     * night: #FF2E182D
     */
    val Ma1: Color = mapNameToColor("Ma1")

    /**
     * default  theme color:
     * day:   #FFFBD7F4
     * night: #FF461C43
     */
    val Ma2: Color = mapNameToColor("Ma2")

    /**
     * default  theme color:
     * day:   #FFF7AEEB
     * night: #FF72296C
     */
    val Ma3: Color = mapNameToColor("Ma3")

    /**
     * default  theme color:
     * day:   #FFF286E2
     * night: #FFA13396
     */
    val Ma4: Color = mapNameToColor("Ma4")

    /**
     * default  theme color:
     * day:   #FFEE5DDB
     * night: #FFCB41BB
     */
    val Ma5: Color = mapNameToColor("Ma5")

    /**
     * default  theme color:
     * day:   #FFDA41CB
     * night: #FFD462C7
     */
    val Ma6: Color = mapNameToColor("Ma6")

    /**
     * default  theme color:
     * day:   #FFC525BA
     * night: #FFDD83D3
     */
    val Ma7: Color = mapNameToColor("Ma7")

    /**
     * default  theme color:
     * day:   #FF9B1797
     * night: #FFE6A4DE
     */
    val Ma8: Color = mapNameToColor("Ma8")

    /**
     * default  theme color:
     * day:   #FF670F67
     * night: #FFEFC5EA
     */
    val Ma9: Color = mapNameToColor("Ma9")

    /**
     * default  theme color:
     * day:   #FF330834
     * night: #FFF8E6F6
     */
    val Ma10: Color = mapNameToColor("Ma10")

    /**
     * default  theme color:
     * day:   #FFFEF3F2
     * night: #FF261314
     */
    val Re0: Color = mapNameToColor("Re0")

    /**
     * default  theme color:
     * day:   #FFFEECEA
     * night: #FF2E1617
     */
    val Re1: Color = mapNameToColor("Re1")

    /**
     * default  theme color:
     * day:   #FFFDD7D4
     * night: #FF471A1C
     */
    val Re2: Color = mapNameToColor("Re2")

    /**
     * default  theme color:
     * day:   #FFFCAFAA
     * night: #FF742728
     */
    val Re3: Color = mapNameToColor("Re3")

    /**
     * default  theme color:
     * day:   #FFFA857F
     * night: #FFA63131
     */
    val Re4: Color = mapNameToColor("Re4")

    /**
     * default  theme color:
     * day:   #FFF85A54
     * night: #FFD1403E
     */
    val Re5: Color = mapNameToColor("Re5")

    /**
     * default  theme color:
     * day:   #FFE23D3D
     * night: #FFD9615F
     */
    val Re6: Color = mapNameToColor("Re6")

    /**
     * default  theme color:
     * day:   #FFC9272C
     * night: #FFE18281
     */
    val Re7: Color = mapNameToColor("Re7")

    /**
     * default  theme color:
     * day:   #FF9F1922
     * night: #FFE9A3A2
     */
    val Re8: Color = mapNameToColor("Re8")

    /**
     * default  theme color:
     * day:   #FF710E18
     * night: #FFF1C5C4
     */
    val Re9: Color = mapNameToColor("Re9")

    /**
     * default  theme color:
     * day:   #FF3B060D
     * night: #FFF9E5E5
     */
    val Re10: Color = mapNameToColor("Re10")

    /**
     * default  theme color:
     * day:   #FFFFF6EE
     * night: #FF28180F
     */
    val Or0: Color = mapNameToColor("Or0")

    /**
     * default  theme color:
     * day:   #FFFFF0E3
     * night: #FF301B10
     */
    val Or1: Color = mapNameToColor("Or1")

    /**
     * default  theme color:
     * day:   #FFFFE1C7
     * night: #FF4A230E
     */
    val Or2: Color = mapNameToColor("Or2")

    /**
     * default  theme color:
     * day:   #FFFFC18F
     * night: #FF783610
     */
    val Or3: Color = mapNameToColor("Or3")

    /**
     * default  theme color:
     * day:   #FFFFA058
     * night: #FFA9490D
     */
    val Or4: Color = mapNameToColor("Or4")

    /**
     * default  theme color:
     * day:   #FFFF7F24
     * night: #FFD66011
     */
    val Or5: Color = mapNameToColor("Or5")

    /**
     * default  theme color:
     * day:   #FFE95B03
     * night: #FFDD7C3A
     */
    val Or6: Color = mapNameToColor("Or6")

    /**
     * default  theme color:
     * day:   #FFBB4100
     * night: #FFE49764
     */
    val Or7: Color = mapNameToColor("Or7")

    /**
     * default  theme color:
     * day:   #FF8D2D00
     * night: #FFEBB38D
     */
    val Or8: Color = mapNameToColor("Or8")

    /**
     * default  theme color:
     * day:   #FF5E1B00
     * night: #FFF2CEB6
     */
    val Or9: Color = mapNameToColor("Or9")

    /**
     * default  theme color:
     * day:   #FF2F0C00
     * night: #FFFAEADF
     */
    val Or10: Color = mapNameToColor("Or10")

    /**
     * default  theme color:
     * day:   #FFFFFAEF
     * night: #FF2A1E0F
     */
    val Ye0: Color = mapNameToColor("Ye0")

    /**
     * default  theme color:
     * day:   #FFFFF6E4
     * night: #FF342410
     */
    val Ye1: Color = mapNameToColor("Ye1")

    /**
     * default  theme color:
     * day:   #FFFFEEC9
     * night: #FF4D300B
     */
    val Ye2: Color = mapNameToColor("Ye2")

    /**
     * default  theme color:
     * day:   #FFFFDB93
     * night: #FF7C4C08
     */
    val Ye3: Color = mapNameToColor("Ye3")

    /**
     * default  theme color:
     * day:   #FFFFC65D
     * night: #FFAD6800
     */
    val Ye4: Color = mapNameToColor("Ye4")

    /**
     * default  theme color:
     * day:   #FFFFB027
     * night: #FFDB8700
     */
    val Ye5: Color = mapNameToColor("Ye5")

    /**
     * default  theme color:
     * day:   #FFFA9600
     * night: #FFE19C2C
     */
    val Ye6: Color = mapNameToColor("Ye6")

    /**
     * default  theme color:
     * day:   #FFC26E00
     * night: #FFE7B158
     */
    val Ye7: Color = mapNameToColor("Ye7")

    /**
     * default  theme color:
     * day:   #FF8A4A00
     * night: #FFEEC584
     */
    val Ye8: Color = mapNameToColor("Ye8")

    /**
     * default  theme color:
     * day:   #FF5B2E00
     * night: #FFF4DAB1
     */
    val Ye9: Color = mapNameToColor("Ye9")

    /**
     * default  theme color:
     * day:   #FF2F1600
     * night: #FFFAEFDD
     */
    val Ye10: Color = mapNameToColor("Ye10")

    /**
     * default  theme color:
     * day:   #FFFFFCEC
     * night: #FF2A2310
     */
    val Ly0: Color = mapNameToColor("Ly0")

    /**
     * default  theme color:
     * day:   #FFFFFADF
     * night: #FF332A11
     */
    val Ly1: Color = mapNameToColor("Ly1")

    /**
     * default  theme color:
     * day:   #FFFFF5BF
     * night: #FF49390C
     */
    val Ly2: Color = mapNameToColor("Ly2")

    /**
     * default  theme color:
     * day:   #FFFFEA80
     * night: #FF745909
     */
    val Ly3: Color = mapNameToColor("Ly3")

    /**
     * default  theme color:
     * day:   #FFFFDC40
     * night: #FFA27C00
     */
    val Ly4: Color = mapNameToColor("Ly4")

    /**
     * default  theme color:
     * day:   #FFFFCC00
     * night: #FFCCA000
     */
    val Ly5: Color = mapNameToColor("Ly5")

    /**
     * default  theme color:
     * day:   #FFD5A300
     * night: #FFD5B02C
     */
    val Ly6: Color = mapNameToColor("Ly6")

    /**
     * default  theme color:
     * day:   #FFAA7D00
     * night: #FFDEC158
     */
    val Ly7: Color = mapNameToColor("Ly7")

    /**
     * default  theme color:
     * day:   #FF805A00
     * night: #FFE7D184
     */
    val Ly8: Color = mapNameToColor("Ly8")

    /**
     * default  theme color:
     * day:   #FF553900
     * night: #FFEFE2B1
     */
    val Ly9: Color = mapNameToColor("Ly9")

    /**
     * default  theme color:
     * day:   #FF2B1B00
     * night: #FFF8F2DD
     */
    val Ly10: Color = mapNameToColor("Ly10")

    /**
     * default  theme color:
     * day:   #FFF7FBEF
     * night: #FF19220F
     */
    val Lg0: Color = mapNameToColor("Lg0")

    /**
     * default  theme color:
     * day:   #FFF2F9E4
     * night: #FF1E2911
     */
    val Lg1: Color = mapNameToColor("Lg1")

    /**
     * default  theme color:
     * day:   #FFE3F2C8
     * night: #FF273C0E
     */
    val Lg2: Color = mapNameToColor("Lg2")

    /**
     * default  theme color:
     * day:   #FFC7E691
     * night: #FF3C600F
     */
    val Lg3: Color = mapNameToColor("Lg3")

    /**
     * default  theme color:
     * day:   #FFA9D95B
     * night: #FF50840B
     */
    val Lg4: Color = mapNameToColor("Lg4")

    /**
     * default  theme color:
     * day:   #FF88CC24
     * night: #FF67A70E
     */
    val Lg5: Color = mapNameToColor("Lg5")

    /**
     * default  theme color:
     * day:   #FF66B105
     * night: #FF81B638
     */
    val Lg6: Color = mapNameToColor("Lg6")

    /**
     * default  theme color:
     * day:   #FF4E8E04
     * night: #FF9CC562
     */
    val Lg7: Color = mapNameToColor("Lg7")

    /**
     * default  theme color:
     * day:   #FF376A03
     * night: #FFB6D58B
     */
    val Lg8: Color = mapNameToColor("Lg8")

    /**
     * default  theme color:
     * day:   #FF224702
     * night: #FFD0E4B5
     */
    val Lg9: Color = mapNameToColor("Lg9")

    /**
     * default  theme color:
     * day:   #FF102301
     * night: #FFEBF3DF
     */
    val Lg10: Color = mapNameToColor("Lg10")

    /**
     * default  theme color:
     * day:   #FFEFFBF3
     * night: #FF102017
     */
    val Gr0: Color = mapNameToColor("Gr0")

    /**
     * default  theme color:
     * day:   #FFE4F8EA
     * night: #FF11271B
     */
    val Gr1: Color = mapNameToColor("Gr1")

    /**
     * default  theme color:
     * day:   #FFCAF1D6
     * night: #FF123923
     */
    val Gr2: Color = mapNameToColor("Gr2")

    /**
     * default  theme color:
     * day:   #FF95E4AF
     * night: #FF175C34
     */
    val Gr3: Color = mapNameToColor("Gr3")

    /**
     * default  theme color:
     * day:   #FF5FD689
     * night: #FF198042
     */
    val Gr4: Color = mapNameToColor("Gr4")

    /**
     * default  theme color:
     * day:   #FF2AC864
     * night: #FF1FA251
     */
    val Gr5: Color = mapNameToColor("Gr5")

    /**
     * default  theme color:
     * day:   #FF0EB350
     * night: #FF46B26F
     */
    val Gr6: Color = mapNameToColor("Gr6")

    /**
     * default  theme color:
     * day:   #FF089043
     * night: #FF6DC28D
     */
    val Gr7: Color = mapNameToColor("Gr7")

    /**
     * default  theme color:
     * day:   #FF046E35
     * night: #FF93D2AB
     */
    val Gr8: Color = mapNameToColor("Gr8")

    /**
     * default  theme color:
     * day:   #FF034926
     * night: #FFBAE2C9
     */
    val Gr9: Color = mapNameToColor("Gr9")

    /**
     * default  theme color:
     * day:   #FF012414
     * night: #FFE1F3E8
     */
    val Gr10: Color = mapNameToColor("Gr10")

    /**
     * default  theme color:
     * day:   #FFEDFBFB
     * night: #FF0C1F20
     */
    val Cy0: Color = mapNameToColor("Cy0")

    /**
     * default  theme color:
     * day:   #FFE2F8F8
     * night: #FF0D2627
     */
    val Cy1: Color = mapNameToColor("Cy1")

    /**
     * default  theme color:
     * day:   #FFC4EFF0
     * night: #FF093739
     */
    val Cy2: Color = mapNameToColor("Cy2")

    /**
     * default  theme color:
     * day:   #FF89E1E1
     * night: #FF085B5C
     */
    val Cy3: Color = mapNameToColor("Cy3")

    /**
     * default  theme color:
     * day:   #FF4FD3D1
     * night: #FF028080
     */
    val Cy4: Color = mapNameToColor("Cy4")

    /**
     * default  theme color:
     * day:   #FF14C4BF
     * night: #FF03A29F
     */
    val Cy5: Color = mapNameToColor("Cy5")

    /**
     * default  theme color:
     * day:   #FF02AAAA
     * night: #FF2FB2B0
     */
    val Cy6: Color = mapNameToColor("Cy6")

    /**
     * default  theme color:
     * day:   #FF018488
     * night: #FF5AC2C0
     */
    val Cy7: Color = mapNameToColor("Cy7")

    /**
     * default  theme color:
     * day:   #FF015F66
     * night: #FF86D2D1
     */
    val Cy8: Color = mapNameToColor("Cy8")

    /**
     * default  theme color:
     * day:   #FF013D44
     * night: #FFB2E2E1
     */
    val Cy9: Color = mapNameToColor("Cy9")

    /**
     * default  theme color:
     * day:   #FF001D22
     * night: #FFDDF3F3
     */
    val Cy10: Color = mapNameToColor("Cy10")

    /**
     * default  theme color:
     * day:   #FFECFAFE
     * night: #FF0A1B23
     */
    val Lb0: Color = mapNameToColor("Lb0")

    /**
     * default  theme color:
     * day:   #FFDFF6FD
     * night: #FF0B202A
     */
    val Lb1: Color = mapNameToColor("Lb1")

    /**
     * default  theme color:
     * day:   #FFBFEDFA
     * night: #FF082D40
     */
    val Lb2: Color = mapNameToColor("Lb2")

    /**
     * default  theme color:
     * day:   #FF80DAF6
     * night: #FF064A69
     */
    val Lb3: Color = mapNameToColor("Lb3")

    /**
     * default  theme color:
     * day:   #FF40C5F1
     * night: #FF006996
     */
    val Lb4: Color = mapNameToColor("Lb4")

    /**
     * default  theme color:
     * day:   #FF00AEEC
     * night: #FF0087BD
     */
    val Lb5: Color = mapNameToColor("Lb5")

    /**
     * default  theme color:
     * day:   #FF008AC5
     * night: #FF2C9CC8
     */
    val Lb6: Color = mapNameToColor("Lb6")

    /**
     * default  theme color:
     * day:   #FF00699D
     * night: #FF58B1D4
     */
    val Lb7: Color = mapNameToColor("Lb7")

    /**
     * default  theme color:
     * day:   #FF004B76
     * night: #FF84C5DF
     */
    val Lb8: Color = mapNameToColor("Lb8")

    /**
     * default  theme color:
     * day:   #FF002F4F
     * night: #FFB1DBEB
     */
    val Lb9: Color = mapNameToColor("Lb9")

    /**
     * default  theme color:
     * day:   #FF001627
     * night: #FFDDEFF6
     */
    val Lb10: Color = mapNameToColor("Lb10")

    /**
     * default  theme color:
     * day:   #FFF3F5FF
     * night: #FF151826
     */
    val Bl0: Color = mapNameToColor("Bl0")

    /**
     * default  theme color:
     * day:   #FFEBEFFF
     * night: #FF181C2F
     */
    val Bl1: Color = mapNameToColor("Bl1")

    /**
     * default  theme color:
     * day:   #FFD7DFFF
     * night: #FF1F2748
     */
    val Bl2: Color = mapNameToColor("Bl2")

    /**
     * default  theme color:
     * day:   #FFB0C1FF
     * night: #FF2E3C76
     */
    val Bl3: Color = mapNameToColor("Bl3")

    /**
     * default  theme color:
     * day:   #FF88A4FF
     * night: #FF3B53A8
     */
    val Bl4: Color = mapNameToColor("Bl4")

    /**
     * default  theme color:
     * day:   #FF6188FF
     * night: #FF4B6BD4
     */
    val Bl5: Color = mapNameToColor("Bl5")

    /**
     * default  theme color:
     * day:   #FF4C6DE4
     * night: #FF6A85DB
     */
    val Bl6: Color = mapNameToColor("Bl6")

    /**
     * default  theme color:
     * day:   #FF3752C8
     * night: #FF899EE3
     */
    val Bl7: Color = mapNameToColor("Bl7")

    /**
     * default  theme color:
     * day:   #FF2136AC
     * night: #FFA9B8EA
     */
    val Bl8: Color = mapNameToColor("Bl8")

    /**
     * default  theme color:
     * day:   #FF121F7F
     * night: #FFC8D2F2
     */
    val Bl9: Color = mapNameToColor("Bl9")

    /**
     * default  theme color:
     * day:   #FF080D41
     * night: #FFE7EBF9
     */
    val Bl10: Color = mapNameToColor("Bl10")

    /**
     * default  theme color:
     * day:   #FFF9F4FF
     * night: #FF1D1628
     */
    val Pu0: Color = mapNameToColor("Pu0")

    /**
     * default  theme color:
     * day:   #FFF6EDFF
     * night: #FF221A31
     */
    val Pu1: Color = mapNameToColor("Pu1")

    /**
     * default  theme color:
     * day:   #FFEDDBFF
     * night: #FF31214C
     */
    val Pu2: Color = mapNameToColor("Pu2")

    /**
     * default  theme color:
     * day:   #FFD8B6FF
     * night: #FF4E317D
     */
    val Pu3: Color = mapNameToColor("Pu3")

    /**
     * default  theme color:
     * day:   #FFC392FF
     * night: #FF6D3FB1
     */
    val Pu4: Color = mapNameToColor("Pu4")

    /**
     * default  theme color:
     * day:   #FFAC6DFF
     * night: #FF8C50E0
     */
    val Pu5: Color = mapNameToColor("Pu5")

    /**
     * default  theme color:
     * day:   #FF8F56E4
     * night: #FFA06EE5
     */
    val Pu6: Color = mapNameToColor("Pu6")

    /**
     * default  theme color:
     * day:   #FF723ECC
     * night: #FFB48DEB
     */
    val Pu7: Color = mapNameToColor("Pu7")

    /**
     * default  theme color:
     * day:   #FF5627B3
     * night: #FFC8ABF0
     */
    val Pu8: Color = mapNameToColor("Pu8")

    /**
     * default  theme color:
     * day:   #FF371683
     * night: #FFDBC9F5
     */
    val Pu9: Color = mapNameToColor("Pu9")

    /**
     * default  theme color:
     * day:   #FF190A44
     * night: #FFF0E8FB
     */
    val Pu10: Color = mapNameToColor("Pu10")

    /**
     * default  theme color:
     * day:   #FFFAF8F6
     * night: #FF211D1B
     */
    val Br0: Color = mapNameToColor("Br0")

    /**
     * default  theme color:
     * day:   #FFF7F3F0
     * night: #FF282320
     */
    val Br1: Color = mapNameToColor("Br1")

    /**
     * default  theme color:
     * day:   #FFEFE7E0
     * night: #FF382F2A
     */
    val Br2: Color = mapNameToColor("Br2")

    /**
     * default  theme color:
     * day:   #FFE0CFC1
     * night: #FF59483F
     */
    val Br3: Color = mapNameToColor("Br3")

    /**
     * default  theme color:
     * day:   #FFD0B7A3
     * night: #FF7A6154
     */
    val Br4: Color = mapNameToColor("Br4")

    /**
     * default  theme color:
     * day:   #FFC19D84
     * night: #FF9A7C6A
     */
    val Br5: Color = mapNameToColor("Br5")

    /**
     * default  theme color:
     * day:   #FFA5816A
     * night: #FFAC9384
     */
    val Br6: Color = mapNameToColor("Br6")

    /**
     * default  theme color:
     * day:   #FF856553
     * night: #FFBDA99E
     */
    val Br7: Color = mapNameToColor("Br7")

    /**
     * default  theme color:
     * day:   #FF634A3E
     * night: #FFCEBFB7
     */
    val Br8: Color = mapNameToColor("Br8")

    /**
     * default  theme color:
     * day:   #FF423029
     * night: #FFE0D7D1
     */
    val Br9: Color = mapNameToColor("Br9")

    /**
     * default  theme color:
     * day:   #FF211815
     * night: #FFF2EEEB
     */
    val Br10: Color = mapNameToColor("Br10")

    /**
     * default  theme color:
     * day:   #FFF9FBFC
     * night: #FF212325
     */
    val Si0: Color = mapNameToColor("Si0")

    /**
     * default  theme color:
     * day:   #FFF5F7FA
     * night: #FF27292C
     */
    val Si1: Color = mapNameToColor("Si1")

    /**
     * default  theme color:
     * day:   #FFEBEFF4
     * night: #FF36393F
     */
    val Si2: Color = mapNameToColor("Si2")

    /**
     * default  theme color:
     * day:   #FFD7E0EA
     * night: #FF535962
     */
    val Si3: Color = mapNameToColor("Si3")

    /**
     * default  theme color:
     * day:   #FFC3D0DF
     * night: #FF6F7987
     */
    val Si4: Color = mapNameToColor("Si4")

    /**
     * default  theme color:
     * day:   #FFAFC0D5
     * night: #FF8C99AA
     */
    val Si5: Color = mapNameToColor("Si5")

    /**
     * default  theme color:
     * day:   #FF8D9FB9
     * night: #FFA0ABB9
     */
    val Si6: Color = mapNameToColor("Si6")

    /**
     * default  theme color:
     * day:   #FF6D7F9C
     * night: #FFB4BCC7
     */
    val Si7: Color = mapNameToColor("Si7")

    /**
     * default  theme color:
     * day:   #FF4D5D7C
     * night: #FFC8CED6
     */
    val Si8: Color = mapNameToColor("Si8")

    /**
     * default  theme color:
     * day:   #FF323D54
     * night: #FFDCE0E5
     */
    val Si9: Color = mapNameToColor("Si9")

    /**
     * default  theme color:
     * day:   #FF191E2B
     * night: #FFF0F2F4
     */
    val Si10: Color = mapNameToColor("Si10")

    /**
     * default  theme color:
     * day:   #FFFF6699
     * night: #FFD44E7D
     */
    val Brand_pink: Color = mapNameToColor("Brand_pink")

    /**
     * default  theme color:
     * day:   #FFFFECF1
     * night: #FF2F1A22
     */
    val Brand_pink_thin: Color = mapNameToColor("Brand_pink_thin")

    /**
     * default  theme color:
     * day:   #FF00AEEC
     * night: #FF0087BD
     */
    val Brand_blue: Color = mapNameToColor("Brand_blue")

    /**
     * default  theme color:
     * day:   #FFDFF6FD
     * night: #FF0B202A
     */
    val Brand_blue_thin: Color = mapNameToColor("Brand_blue_thin")

    /**
     * default  theme color:
     * day:   #FFF85A54
     * night: #FFD1403E
     */
    val Stress_red: Color = mapNameToColor("Stress_red")

    /**
     * default  theme color:
     * day:   #FFFEECEA
     * night: #FF2E1617
     */
    val Stress_red_thin: Color = mapNameToColor("Stress_red_thin")

    /**
     * default  theme color:
     * day:   #FF2AC864
     * night: #FF1FA251
     */
    val Success_green: Color = mapNameToColor("Success_green")

    /**
     * default  theme color:
     * day:   #FFE4F8EA
     * night: #FF11271B
     */
    val Success_green_thin: Color = mapNameToColor("Success_green_thin")

    /**
     * default  theme color:
     * day:   #FFFF7F24
     * night: #FFD66011
     */
    val Operate_orange: Color = mapNameToColor("Operate_orange")

    /**
     * default  theme color:
     * day:   #FFFFF0E3
     * night: #FF301B10
     */
    val Operate_orange_thin: Color = mapNameToColor("Operate_orange_thin")

    /**
     * default  theme color:
     * day:   #FFFFB027
     * night: #FFDB8700
     */
    val Pay_yellow: Color = mapNameToColor("Pay_yellow")

    /**
     * default  theme color:
     * day:   #FFFFF6E4
     * night: #FF342410
     */
    val Pay_yellow_thin: Color = mapNameToColor("Pay_yellow_thin")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF17181A
     */
    val Bg1: Color = mapNameToColor("Bg1")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF101011
     */
    val Bg2: Color = mapNameToColor("Bg2")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF0A0B0C
     */
    val Bg3: Color = mapNameToColor("Bg3")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF242628
     */
    val Bg1_float: Color = mapNameToColor("Bg1_float")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF202123
     */
    val Bg2_float: Color = mapNameToColor("Bg2_float")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FFFFFFFF
     */
    val Text_white: Color = mapNameToColor("Text_white")

    /**
     * default  theme color:
     * day:   #FF18191C
     * night: #FFE7E9EB
     */
    val Text1: Color = mapNameToColor("Text1")

    /**
     * default  theme color:
     * day:   #FF61666D
     * night: #FFA2A7AE
     */
    val Text2: Color = mapNameToColor("Text2")

    /**
     * default  theme color:
     * day:   #FF9499A0
     * night: #FF757A81
     */
    val Text3: Color = mapNameToColor("Text3")

    /**
     * default  theme color:
     * day:   #FFC9CCD0
     * night: #FF46494D
     */
    val Text4: Color = mapNameToColor("Text4")

    /**
     * default  theme color:
     * day:   #FF00699D
     * night: #FF58B1D4
     */
    val Text_link: Color = mapNameToColor("Text_link")

    /**
     * default  theme color:
     * day:   #FFFA9600
     * night: #FFE19C2C
     */
    val Text_notice: Color = mapNameToColor("Text_notice")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF232527
     */
    val Line_light: Color = mapNameToColor("Line_light")

    /**
     * default  theme color:
     * day:   #FFE3E5E7
     * night: #FF2F3134
     */
    val Line_regular: Color = mapNameToColor("Line_regular")

    /**
     * default  theme color:
     * day:   #FFC9CCD0
     * night: #FF46494D
     */
    val Line_bold: Color = mapNameToColor("Line_bold")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FFFFFFFF
     */
    val Graph_white: Color = mapNameToColor("Graph_white")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF1E2022
     */
    val Graph_bg_thin: Color = mapNameToColor("Graph_bg_thin")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF232527
     */
    val Graph_bg_regular: Color = mapNameToColor("Graph_bg_regular")

    /**
     * default  theme color:
     * day:   #FFE3E5E7
     * night: #FF2F3134
     */
    val Graph_bg_thick: Color = mapNameToColor("Graph_bg_thick")

    /**
     * default  theme color:
     * day:   #FFC9CCD0
     * night: #FF46494D
     */
    val Graph_weak: Color = mapNameToColor("Graph_weak")

    /**
     * default  theme color:
     * day:   #FF9499A0
     * night: #FF757A81
     */
    val Graph_medium: Color = mapNameToColor("Graph_medium")

    /**
     * default  theme color:
     * day:   #FF61666D
     * night: #FFA2A7AE
     */
    val Graph_icon: Color = mapNameToColor("Graph_icon")

    /**
     * default  theme color:
     * day:   #FF61666D
     * night: #FFA2A7AE
     */
    val Graph_bold: Color = mapNameToColor("Graph_bold")

    /**
     * default  theme color:
     * day:   #FFFFFFFF
     * night: #FF2F3134
     */
    val Graph_bg_bright: Color = mapNameToColor("Graph_bg_bright")

    /**
     * default  theme color:
     * day:   #FFF6F7F8
     * night: #FF2B2C2F
     */
    val Graph_bg_thin_float: Color = mapNameToColor("Graph_bg_thin_float")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF2F3134
     */
    val Graph_bg_regular_float: Color = mapNameToColor("Graph_bg_regular_float")

    /**
     * default  theme color:
     * day:   #FFF1F2F3
     * night: #FF1A1B1D
     */
    val Bg3_float: Color = mapNameToColor("Bg3_float")

    /**
     * default  theme color:
     * day:   #FF000000
     * night: #FF000000
     */
    val Shadow: Color = mapNameToColor("Shadow")

    /**
     *  day: 0xFF001E36
     *  night: 0xFF001E36
     */
    val AdobeBlue: Color = mapNameToColor("Adobe_blue")


    val AdobeMediumBlue: Color = mapNameToColor("AdobeMediumBlue")

    val AdobeDark: Color = mapNameToColor("AdobeDark")

    val Black: Color = Color.Black

}

val dayColorsMap: Map<String, Color> by lazy(LazyThreadSafetyMode.NONE) {
    mutableMapOf<String, Color>().apply {
        put("Ga0", Color(0xFFF6F7F8))
        put("Ga0_s", Color(0xFFF6F7F8))
        put("Ga1", Color(0xFFF1F2F3))
        put("Ga1_s", Color(0xFFF1F2F3))
        put("Ga2", Color(0xFFE3E5E7))
        put("Ga3", Color(0xFFC9CCD0))
        put("Ga4", Color(0xFFAEB3B9))
        put("Ga5", Color(0xFF9499A0))
        put("Ga6", Color(0xFF797F87))
        put("Ga7", Color(0xFF61666D))
        put("Ga8", Color(0xFF484C53))
        put("Ga9", Color(0xFF2F3238))
        put("Ga10", Color(0xFF18191C))
        put("Ga11", Color(0xFFFFFFFF))
        put("Ga12", Color(0xFFF6F7F8))
        put("Ga12_s", Color(0xFFF6F7F8))
        put("Ga13_s", Color(0xFFF1F2F3))
        put("Ga13", Color(0xFFF1F2F3))
        put("Wh0", Color(0xFFFFFFFF))
        put("Wh0_s", Color(0xFFFFFFFF))
        put("Ba0", Color(0xFF000000))
        put("Ba0_s", Color(0xFF000000))
        put("Pi0", Color(0xFFFFF3F6))
        put("Pi1", Color(0xFFFFECF1))
        put("Pi2", Color(0xFFFFD9E4))
        put("Pi3", Color(0xFFFFB3CA))
        put("Pi4", Color(0xFFFF8CB0))
        put("Pi5", Color(0xFFFF6699))
        put("Pi6", Color(0xFFE84B85))
        put("Pi7", Color(0xFFD03171))
        put("Pi8", Color(0xFFAD1C5B))
        put("Pi9", Color(0xFF771141))
        put("Pi10", Color(0xFF3F0723))
        put("Ma0", Color(0xFFFEF3FC))
        put("Ma1", Color(0xFFFDEBFA))
        put("Ma2", Color(0xFFFBD7F4))
        put("Ma3", Color(0xFFF7AEEB))
        put("Ma4", Color(0xFFF286E2))
        put("Ma5", Color(0xFFEE5DDB))
        put("Ma6", Color(0xFFDA41CB))
        put("Ma7", Color(0xFFC525BA))
        put("Ma8", Color(0xFF9B1797))
        put("Ma9", Color(0xFF670F67))
        put("Ma10", Color(0xFF330834))
        put("Re0", Color(0xFFFEF3F2))
        put("Re1", Color(0xFFFEECEA))
        put("Re2", Color(0xFFFDD7D4))
        put("Re3", Color(0xFFFCAFAA))
        put("Re4", Color(0xFFFA857F))
        put("Re5", Color(0xFFF85A54))
        put("Re6", Color(0xFFE23D3D))
        put("Re7", Color(0xFFC9272C))
        put("Re8", Color(0xFF9F1922))
        put("Re9", Color(0xFF710E18))
        put("Re10", Color(0xFF3B060D))
        put("Or0", Color(0xFFFFF6EE))
        put("Or1", Color(0xFFFFF0E3))
        put("Or2", Color(0xFFFFE1C7))
        put("Or3", Color(0xFFFFC18F))
        put("Or4", Color(0xFFFFA058))
        put("Or5", Color(0xFFFF7F24))
        put("Or6", Color(0xFFE95B03))
        put("Or7", Color(0xFFBB4100))
        put("Or8", Color(0xFF8D2D00))
        put("Or9", Color(0xFF5E1B00))
        put("Or10", Color(0xFF2F0C00))
        put("Ye0", Color(0xFFFFFAEF))
        put("Ye1", Color(0xFFFFF6E4))
        put("Ye2", Color(0xFFFFEEC9))
        put("Ye3", Color(0xFFFFDB93))
        put("Ye4", Color(0xFFFFC65D))
        put("Ye5", Color(0xFFFFB027))
        put("Ye6", Color(0xFFFA9600))
        put("Ye7", Color(0xFFC26E00))
        put("Ye8", Color(0xFF8A4A00))
        put("Ye9", Color(0xFF5B2E00))
        put("Ye10", Color(0xFF2F1600))
        put("Ly0", Color(0xFFFFFCEC))
        put("Ly1", Color(0xFFFFFADF))
        put("Ly2", Color(0xFFFFF5BF))
        put("Ly3", Color(0xFFFFEA80))
        put("Ly4", Color(0xFFFFDC40))
        put("Ly5", Color(0xFFFFCC00))
        put("Ly6", Color(0xFFD5A300))
        put("Ly7", Color(0xFFAA7D00))
        put("Ly8", Color(0xFF805A00))
        put("Ly9", Color(0xFF553900))
        put("Ly10", Color(0xFF2B1B00))
        put("Lg0", Color(0xFFF7FBEF))
        put("Lg1", Color(0xFFF2F9E4))
        put("Lg2", Color(0xFFE3F2C8))
        put("Lg3", Color(0xFFC7E691))
        put("Lg4", Color(0xFFA9D95B))
        put("Lg5", Color(0xFF88CC24))
        put("Lg6", Color(0xFF66B105))
        put("Lg7", Color(0xFF4E8E04))
        put("Lg8", Color(0xFF376A03))
        put("Lg9", Color(0xFF224702))
        put("Lg10", Color(0xFF102301))
        put("Gr0", Color(0xFFEFFBF3))
        put("Gr1", Color(0xFFE4F8EA))
        put("Gr2", Color(0xFFCAF1D6))
        put("Gr3", Color(0xFF95E4AF))
        put("Gr4", Color(0xFF5FD689))
        put("Gr5", Color(0xFF2AC864))
        put("Gr6", Color(0xFF0EB350))
        put("Gr7", Color(0xFF089043))
        put("Gr8", Color(0xFF046E35))
        put("Gr9", Color(0xFF034926))
        put("Gr10", Color(0xFF012414))
        put("Cy0", Color(0xFFEDFBFB))
        put("Cy1", Color(0xFFE2F8F8))
        put("Cy2", Color(0xFFC4EFF0))
        put("Cy3", Color(0xFF89E1E1))
        put("Cy4", Color(0xFF4FD3D1))
        put("Cy5", Color(0xFF14C4BF))
        put("Cy6", Color(0xFF02AAAA))
        put("Cy7", Color(0xFF018488))
        put("Cy8", Color(0xFF015F66))
        put("Cy9", Color(0xFF013D44))
        put("Cy10", Color(0xFF001D22))
        put("Lb0", Color(0xFFECFAFE))
        put("Lb1", Color(0xFFDFF6FD))
        put("Lb2", Color(0xFFBFEDFA))
        put("Lb3", Color(0xFF80DAF6))
        put("Lb4", Color(0xFF40C5F1))
        put("Lb5", Color(0xFF00AEEC))
        put("Lb6", Color(0xFF008AC5))
        put("Lb7", Color(0xFF00699D))
        put("Lb8", Color(0xFF004B76))
        put("Lb9", Color(0xFF002F4F))
        put("Lb10", Color(0xFF001627))
        put("Bl0", Color(0xFFF3F5FF))
        put("Bl1", Color(0xFFEBEFFF))
        put("Bl2", Color(0xFFD7DFFF))
        put("Bl3", Color(0xFFB0C1FF))
        put("Bl4", Color(0xFF88A4FF))
        put("Bl5", Color(0xFF6188FF))
        put("Bl6", Color(0xFF4C6DE4))
        put("Bl7", Color(0xFF3752C8))
        put("Bl8", Color(0xFF2136AC))
        put("Bl9", Color(0xFF121F7F))
        put("Bl10", Color(0xFF080D41))
        put("Pu0", Color(0xFFF9F4FF))
        put("Pu1", Color(0xFFF6EDFF))
        put("Pu2", Color(0xFFEDDBFF))
        put("Pu3", Color(0xFFD8B6FF))
        put("Pu4", Color(0xFFC392FF))
        put("Pu5", Color(0xFFAC6DFF))
        put("Pu6", Color(0xFF8F56E4))
        put("Pu7", Color(0xFF723ECC))
        put("Pu8", Color(0xFF5627B3))
        put("Pu9", Color(0xFF371683))
        put("Pu10", Color(0xFF190A44))
        put("Br0", Color(0xFFFAF8F6))
        put("Br1", Color(0xFFF7F3F0))
        put("Br2", Color(0xFFEFE7E0))
        put("Br3", Color(0xFFE0CFC1))
        put("Br4", Color(0xFFD0B7A3))
        put("Br5", Color(0xFFC19D84))
        put("Br6", Color(0xFFA5816A))
        put("Br7", Color(0xFF856553))
        put("Br8", Color(0xFF634A3E))
        put("Br9", Color(0xFF423029))
        put("Br10", Color(0xFF211815))
        put("Si0", Color(0xFFF9FBFC))
        put("Si1", Color(0xFFF5F7FA))
        put("Si2", Color(0xFFEBEFF4))
        put("Si3", Color(0xFFD7E0EA))
        put("Si4", Color(0xFFC3D0DF))
        put("Si5", Color(0xFFAFC0D5))
        put("Si6", Color(0xFF8D9FB9))
        put("Si7", Color(0xFF6D7F9C))
        put("Si8", Color(0xFF4D5D7C))
        put("Si9", Color(0xFF323D54))
        put("Si10", Color(0xFF191E2B))
        put("Brand_pink", Color(0xFFFF6699))
        put("Brand_pink_thin", Color(0xFFFFECF1))
        put("Brand_blue", Color(0xFF00AEEC))
        put("Brand_blue_thin", Color(0xFFDFF6FD))
        put("Stress_red", Color(0xFFF85A54))
        put("Stress_red_thin", Color(0xFFFEECEA))
        put("Success_green", Color(0xFF2AC864))
        put("Success_green_thin", Color(0xFFE4F8EA))
        put("Operate_orange", Color(0xFFFF7F24))
        put("Operate_orange_thin", Color(0xFFFFF0E3))
        put("Pay_yellow", Color(0xFFFFB027))
        put("Pay_yellow_thin", Color(0xFFFFF6E4))
        put("Bg1", Color(0xFFFFFFFF))
        put("Bg2", Color(0xFFF6F7F8))
        put("Bg3", Color(0xFFF1F2F3))
        put("Bg1_float", Color(0xFFFFFFFF))
        put("Bg2_float", Color(0xFFF6F7F8))
        put("Text_white", Color(0xFFFFFFFF))
        put("Text1", Color(0xFF18191C))
        put("Text2", Color(0xFF61666D))
        put("Text3", Color(0xFF9499A0))
        put("Text4", Color(0xFFC9CCD0))
        put("Text_link", Color(0xFF00699D))
        put("Text_notice", Color(0xFFFA9600))
        put("Line_light", Color(0xFFF1F2F3))
        put("Line_regular", Color(0xFFE3E5E7))
        put("Line_bold", Color(0xFFC9CCD0))
        put("Graph_white", Color(0xFFFFFFFF))
        put("Graph_bg_thin", Color(0xFFF6F7F8))
        put("Graph_bg_regular", Color(0xFFF1F2F3))
        put("Graph_bg_thick", Color(0xFFE3E5E7))
        put("Graph_weak", Color(0xFFC9CCD0))
        put("Graph_medium", Color(0xFF9499A0))
        put("Graph_icon", Color(0xFF61666D))
        put("Graph_bold", Color(0xFF61666D))
        put("Graph_bg_bright", Color(0xFFFFFFFF))
        put("Graph_bg_thin_float", Color(0xFFF6F7F8))
        put("Graph_bg_regular_float", Color(0xFFF1F2F3))
        put("Bg3_float", Color(0xFFF1F2F3))
        put("Shadow", Color(0xFF000000))
        put("Adobe_blue", Color(0xFF001E36))
        put("AdobeMediumBlue", Color(0xFF31A8FF))
        put("AdobeDark", Color(0xFFFFFFFF))

    }
}

val nightColorsMap: Map<String, Color> by lazy(LazyThreadSafetyMode.NONE) {
    mutableMapOf<String, Color>().apply {
        put("Ga0", Color(0xFF101011))
        put("Ga0_s", Color(0xFF1E2022))
        put("Ga1", Color(0xFF0A0B0C))
        put("Ga1_s", Color(0xFF232527))
        put("Ga2", Color(0xFF2F3134))
        put("Ga3", Color(0xFF46494D))
        put("Ga4", Color(0xFF5E6267))
        put("Ga5", Color(0xFF757A81))
        put("Ga6", Color(0xFF8B9097))
        put("Ga7", Color(0xFFA2A7AE))
        put("Ga8", Color(0xFFB9BDC2))
        put("Ga9", Color(0xFFD0D3D7))
        put("Ga10", Color(0xFFE7E9EB))
        put("Ga11", Color(0xFF242628))
        put("Ga12", Color(0xFF202123))
        put("Ga12_s", Color(0xFF2B2C2F))
        put("Ga13_s", Color(0xFF2F3134))
        put("Ga13", Color(0xFF1A1B1D))
        put("Wh0", Color(0xFF17181A))
        put("Wh0_s", Color(0xFF2F3134))
        put("Ba0", Color(0xFF000000))
        put("Ba0_s", Color(0xFFFFFFFF))
        put("Pi0", Color(0xFF26161C))
        put("Pi1", Color(0xFF2F1A22))
        put("Pi2", Color(0xFF472030))
        put("Pi3", Color(0xFF76304B))
        put("Pi4", Color(0xFFA73E65))
        put("Pi5", Color(0xFFD44E7D))
        put("Pi6", Color(0xFFDC6D94))
        put("Pi7", Color(0xFFE38CAA))
        put("Pi8", Color(0xFFEBABC1))
        put("Pi9", Color(0xFFF2CAD8))
        put("Pi10", Color(0xFFFAE9EF))
        put("Ma0", Color(0xFF261525))
        put("Ma1", Color(0xFF2E182D))
        put("Ma2", Color(0xFF461C43))
        put("Ma3", Color(0xFF72296C))
        put("Ma4", Color(0xFFA13396))
        put("Ma5", Color(0xFFCB41BB))
        put("Ma6", Color(0xFFD462C7))
        put("Ma7", Color(0xFFDD83D3))
        put("Ma8", Color(0xFFE6A4DE))
        put("Ma9", Color(0xFFEFC5EA))
        put("Ma10", Color(0xFFF8E6F6))
        put("Re0", Color(0xFF261314))
        put("Re1", Color(0xFF2E1617))
        put("Re2", Color(0xFF471A1C))
        put("Re3", Color(0xFF742728))
        put("Re4", Color(0xFFA63131))
        put("Re5", Color(0xFFD1403E))
        put("Re6", Color(0xFFD9615F))
        put("Re7", Color(0xFFE18281))
        put("Re8", Color(0xFFE9A3A2))
        put("Re9", Color(0xFFF1C5C4))
        put("Re10", Color(0xFFF9E5E5))
        put("Or0", Color(0xFF28180F))
        put("Or1", Color(0xFF301B10))
        put("Or2", Color(0xFF4A230E))
        put("Or3", Color(0xFF783610))
        put("Or4", Color(0xFFA9490D))
        put("Or5", Color(0xFFD66011))
        put("Or6", Color(0xFFDD7C3A))
        put("Or7", Color(0xFFE49764))
        put("Or8", Color(0xFFEBB38D))
        put("Or9", Color(0xFFF2CEB6))
        put("Or10", Color(0xFFFAEADF))
        put("Ye0", Color(0xFF2A1E0F))
        put("Ye1", Color(0xFF342410))
        put("Ye2", Color(0xFF4D300B))
        put("Ye3", Color(0xFF7C4C08))
        put("Ye4", Color(0xFFAD6800))
        put("Ye5", Color(0xFFDB8700))
        put("Ye6", Color(0xFFE19C2C))
        put("Ye7", Color(0xFFE7B158))
        put("Ye8", Color(0xFFEEC584))
        put("Ye9", Color(0xFFF4DAB1))
        put("Ye10", Color(0xFFFAEFDD))
        put("Ly0", Color(0xFF2A2310))
        put("Ly1", Color(0xFF332A11))
        put("Ly2", Color(0xFF49390C))
        put("Ly3", Color(0xFF745909))
        put("Ly4", Color(0xFFA27C00))
        put("Ly5", Color(0xFFCCA000))
        put("Ly6", Color(0xFFD5B02C))
        put("Ly7", Color(0xFFDEC158))
        put("Ly8", Color(0xFFE7D184))
        put("Ly9", Color(0xFFEFE2B1))
        put("Ly10", Color(0xFFF8F2DD))
        put("Lg0", Color(0xFF19220F))
        put("Lg1", Color(0xFF1E2911))
        put("Lg2", Color(0xFF273C0E))
        put("Lg3", Color(0xFF3C600F))
        put("Lg4", Color(0xFF50840B))
        put("Lg5", Color(0xFF67A70E))
        put("Lg6", Color(0xFF81B638))
        put("Lg7", Color(0xFF9CC562))
        put("Lg8", Color(0xFFB6D58B))
        put("Lg9", Color(0xFFD0E4B5))
        put("Lg10", Color(0xFFEBF3DF))
        put("Gr0", Color(0xFF102017))
        put("Gr1", Color(0xFF11271B))
        put("Gr2", Color(0xFF123923))
        put("Gr3", Color(0xFF175C34))
        put("Gr4", Color(0xFF198042))
        put("Gr5", Color(0xFF1FA251))
        put("Gr6", Color(0xFF46B26F))
        put("Gr7", Color(0xFF6DC28D))
        put("Gr8", Color(0xFF93D2AB))
        put("Gr9", Color(0xFFBAE2C9))
        put("Gr10", Color(0xFFE1F3E8))
        put("Cy0", Color(0xFF0C1F20))
        put("Cy1", Color(0xFF0D2627))
        put("Cy2", Color(0xFF093739))
        put("Cy3", Color(0xFF085B5C))
        put("Cy4", Color(0xFF028080))
        put("Cy5", Color(0xFF03A29F))
        put("Cy6", Color(0xFF2FB2B0))
        put("Cy7", Color(0xFF5AC2C0))
        put("Cy8", Color(0xFF86D2D1))
        put("Cy9", Color(0xFFB2E2E1))
        put("Cy10", Color(0xFFDDF3F3))
        put("Lb0", Color(0xFF0A1B23))
        put("Lb1", Color(0xFF0B202A))
        put("Lb2", Color(0xFF082D40))
        put("Lb3", Color(0xFF064A69))
        put("Lb4", Color(0xFF006996))
        put("Lb5", Color(0xFF0087BD))
        put("Lb6", Color(0xFF2C9CC8))
        put("Lb7", Color(0xFF58B1D4))
        put("Lb8", Color(0xFF84C5DF))
        put("Lb9", Color(0xFFB1DBEB))
        put("Lb10", Color(0xFFDDEFF6))
        put("Bl0", Color(0xFF151826))
        put("Bl1", Color(0xFF181C2F))
        put("Bl2", Color(0xFF1F2748))
        put("Bl3", Color(0xFF2E3C76))
        put("Bl4", Color(0xFF3B53A8))
        put("Bl5", Color(0xFF4B6BD4))
        put("Bl6", Color(0xFF6A85DB))
        put("Bl7", Color(0xFF899EE3))
        put("Bl8", Color(0xFFA9B8EA))
        put("Bl9", Color(0xFFC8D2F2))
        put("Bl10", Color(0xFFE7EBF9))
        put("Pu0", Color(0xFF1D1628))
        put("Pu1", Color(0xFF221A31))
        put("Pu2", Color(0xFF31214C))
        put("Pu3", Color(0xFF4E317D))
        put("Pu4", Color(0xFF6D3FB1))
        put("Pu5", Color(0xFF8C50E0))
        put("Pu6", Color(0xFFA06EE5))
        put("Pu7", Color(0xFFB48DEB))
        put("Pu8", Color(0xFFC8ABF0))
        put("Pu9", Color(0xFFDBC9F5))
        put("Pu10", Color(0xFFF0E8FB))
        put("Br0", Color(0xFF211D1B))
        put("Br1", Color(0xFF282320))
        put("Br2", Color(0xFF382F2A))
        put("Br3", Color(0xFF59483F))
        put("Br4", Color(0xFF7A6154))
        put("Br5", Color(0xFF9A7C6A))
        put("Br6", Color(0xFFAC9384))
        put("Br7", Color(0xFFBDA99E))
        put("Br8", Color(0xFFCEBFB7))
        put("Br9", Color(0xFFE0D7D1))
        put("Br10", Color(0xFFF2EEEB))
        put("Si0", Color(0xFF212325))
        put("Si1", Color(0xFF27292C))
        put("Si2", Color(0xFF36393F))
        put("Si3", Color(0xFF535962))
        put("Si4", Color(0xFF6F7987))
        put("Si5", Color(0xFF8C99AA))
        put("Si6", Color(0xFFA0ABB9))
        put("Si7", Color(0xFFB4BCC7))
        put("Si8", Color(0xFFC8CED6))
        put("Si9", Color(0xFFDCE0E5))
        put("Si10", Color(0xFFF0F2F4))
        put("Brand_pink", Color(0xFFD44E7D))
        put("Brand_pink_thin", Color(0xFF2F1A22))
        put("Brand_blue", Color(0xFF0087BD))
        put("Brand_blue_thin", Color(0xFF0B202A))
        put("Stress_red", Color(0xFFD1403E))
        put("Stress_red_thin", Color(0xFF2E1617))
        put("Success_green", Color(0xFF1FA251))
        put("Success_green_thin", Color(0xFF11271B))
        put("Operate_orange", Color(0xFFD66011))
        put("Operate_orange_thin", Color(0xFF301B10))
        put("Pay_yellow", Color(0xFFDB8700))
        put("Pay_yellow_thin", Color(0xFF342410))
        put("Bg1", Color(0xFF17181A))
        put("Bg2", Color(0xFF101011))
        put("Bg3", Color(0xFF0A0B0C))
        put("Bg1_float", Color(0xFF242628))
        put("Bg2_float", Color(0xFF202123))
        put("Text1", Color(0xFFE7E9EB))
        put("Text2", Color(0xFFA2A7AE))
        put("Text3", Color(0xFF757A81))
        put("Text4", Color(0xFF46494D))
        put("Text_link", Color(0xFF58B1D4))
        put("Text_notice", Color(0xFFE19C2C))
        put("Line_light", Color(0xFF232527))
        put("Line_regular", Color(0xFF2F3134))
        put("Line_bold", Color(0xFF46494D))
        put("Graph_bg_thin", Color(0xFF1E2022))
        put("Graph_bg_regular", Color(0xFF232527))
        put("Graph_bg_thick", Color(0xFF2F3134))
        put("Graph_weak", Color(0xFF46494D))
        put("Graph_medium", Color(0xFF757A81))
        put("Graph_icon", Color(0xFFA2A7AE))
        put("Graph_bold", Color(0xFFA2A7AE))
        put("Graph_bg_bright", Color(0xFF2F3134))
        put("Graph_bg_thin_float", Color(0xFF2B2C2F))
        put("Graph_bg_regular_float", Color(0xFF2F3134))
        put("Bg3_float", Color(0xFF1A1B1D))
        put("Shadow", Color(0xFF000000))
        put("Text_white", Color(0xFFFFFFFF))
        put("Graph_white", Color(0xFFFFFFFF))
        put("Adobe_blue", Color(0xFF001E36))
        put("AdobeMediumBlue", Color(0xFF31A8FF))
        put("AdobeDark", Color(0xFF282828))

    }
}


val dayThemeColors by lazy(LazyThreadSafetyMode.NONE) {
    HomeColors(
        "day_color",
        HashMap(dayColorsMap)
    )
}

val nightThemeColors by lazy(LazyThreadSafetyMode.NONE) {
    HomeColors(
        "night_color",
        HashMap(nightColorsMap)
    )
}