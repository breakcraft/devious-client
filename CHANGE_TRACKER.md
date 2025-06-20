# Change Tracker

## Completed Fixes/Features
- Updated Logback dependency to version 1.2.13 in `runelite-client.gradle.kts` after verifying compatibility with SLF4J 1.7.32.

## Outstanding TODO Items and Stubs
- Review other dependencies for newer versions and potential security patches.
- Investigate build failure in `injected-client:inject` task.

## Planned Enhancements
- Automate dependency version checks across all modules.
- Add CI step for building and testing.
