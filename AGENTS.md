# Agent Instructions

This repository hosts the Devious Client project built with Gradle and JDK 11. Follow these guidelines when making changes.

## Development guidelines
- Ensure `./gradlew` is executable with `chmod +x ./gradlew`.
- Use JDK 11 for all builds and tests.
- Commit messages should be short and use the imperative mood (e.g. "add feature").
- Refer to RuneLite's [Code Conventions](https://github.com/runelite/runelite/wiki/Code-Conventions) for formatting and style.

## Required checks
Run the following commands before committing:

```bash
./gradlew build --stacktrace -x test -x checkstyleMain -x checkstyleTest --console=plain
./gradlew checkstyleMain --console=plain
```

The `build` task assembles the project while skipping long-running tests, and `checkstyleMain` verifies code style.
