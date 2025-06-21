# Change Tracker

## Completed Fixes/Features
- Replaced `Thread.sleep(1000)` with a `CountDownLatch`-based shutdown in `ClientUI.shutdownClient`.
- Reduced test `maxHeapSize` in `cache/cache.gradle.kts` from `16192m` to `2g` to lower memory usage during testing.
- Verified and corrected varbit values for Western Provinces diaries.
- Added unit tests validating updated varbit IDs.
- Updated Logback dependency to version 1.5.18 in `runelite-client.gradle.kts` after verifying compatibility with SLF4J 1.7.32.
- Enabled PMD task in `runelite-client.gradle.kts` to surface rule violations.
- Resolved missing PMD rule references, removed incompatible rules, and allowed build to succeed.
- Consolidated CI workflows into `.github/workflows/ci.yml` and added reusable Gradle setup action.
- Updated tab wrapping logic to handle varying tab widths and added UI tests for mixed-size tabs.
- Added jvmArgs to all JavaExec tasks for reflective access.
- Commented blocked domains list and renamed CI workflow.
- Documented build and run commands in README.

## Outstanding TODO Items and Stubs
- Review other diary varbit constants for accuracy.
- Expand unit test coverage for additional quest constants.
- Review other dependencies for newer versions and potential security patches.
- Investigate build failure in `injected-client:inject` task.
- Verify cross-platform cursor reset behaviour.

## Planned Enhancements
- Monitor for additional graceful shutdown improvements.
- Monitor build performance to ensure memory reduction does not cause failures.
- Automate dependency version checks across all modules.
- Add CI step for building and testing.
- Documented workflow refactoring.
