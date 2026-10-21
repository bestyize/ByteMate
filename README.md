# ByteMate

[English](README.md) | [简体中文](README.zh-CN.md)

ByteMate is an open-source, cross-platform desktop toolkit built with **Compose Multiplatform (Desktop)**. It provides utilities for inspecting files and working with binary data.

![Byte pattern search](readme/pic/byte_search.png)

## Features

- Search a file or directory for hexadecimal byte patterns, including `??` wildcards.
- Search for text within files and directories.
- Inspect SQLite databases and export results as JSON or CSV.
- Java/JAR bytecode manipulation utilities (some are code-only or experimental).
- A legacy IntelliJ-related patching page exists in the codebase. Use ByteMate only with software and files you are authorized to modify; this project does not grant rights to third-party software.

## Language

English and Simplified Chinese are supported. ByteMate initially selects Chinese if the system locale is Chinese, otherwise English. Switch languages at any time with the **English / 中文** control in the title bar; no restart is required.

## Development

**Requirements:** JDK 21 and an operating system supported by Compose Desktop (Windows, macOS, or Linux). Build on the target OS when creating native installers.

```bash
./gradlew run
./gradlew build
./gradlew packageDistributionForCurrentOS
```

On Windows, use `gradlew.bat` in Command Prompt or PowerShell instead of `./gradlew`. Installers are generated under `build/compose/binaries/main/`.

## Releases

GitHub Actions builds on Windows, macOS and Linux for pull requests and commits to `master`. Pushing a version tag like `v1.0.1` also creates a GitHub Release containing the three native installers:

- **Windows:** `.msi`
- **macOS:** `.dmg`
- **Linux:** `.deb` (Debian/Ubuntu)

Example:

```bash
git tag v1.0.1
git push origin v1.0.1
```

Packages are currently **unsigned**. Windows and macOS may display publisher/security warnings; distribution signing and macOS notarization must be configured separately. Native packages are OS- and CPU-architecture-specific.

## License

ByteMate source code is licensed under the [MIT License](LICENSE). Bundled third-party dependencies retain their respective licenses. Do not use this tool to bypass software license requirements.
