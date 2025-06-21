# Change Tracker

## Completed Fixes/Features
- Replaced `Thread.sleep(1000)` with a `CountDownLatch`-based shutdown in `ClientUI.shutdownClient`.
- Reduced test `maxHeapSize` in `cache/cache.gradle.kts` from `16192m` to `4g` to lower memory usage during testing.
- Verified and corrected varbit values for Western Provinces diaries.
- Added unit tests validating updated varbit IDs.
- Updated Logback dependency to version 1.2.13 in `runelite-client.gradle.kts` after verifying compatibility with SLF4J 1.7.32.
- Enabled PMD task in `runelite-client.gradle.kts` to surface rule violations.
- Resolved missing PMD rule references, removed incompatible rules, and allowed build to succeed.
- Consolidated CI workflows into `.github/workflows/ci.yml` and added reusable
  Gradle setup action.
- Updated tab wrapping logic to handle varying tab widths and added UI tests for
  mixed-size tabs.
- Resolved PMD build failure by aligning toolVersion to 6.55.0 and pruning
  unsupported rules.
- Removed deprecated `EmptyControlStatement` rule from PMD ruleset.
- Corrected `ignoredAnnotations` delimiter in `pmd-ruleset.xml` to use `|` and
  remove illegal Java binary name errors.
- Added `--add-opens` argument to every `JavaExec` task for reliability.
- Removed `-x test` flags from CI and JitPack build commands.
- Documented minimal build process in `README.md`.
- Explained stack size multiplication logic in `Stack` class.
- Commented blocked domain entries in `runelite.properties`.

## Outstanding TODO Items and Stubs
- Review other diary varbit constants for accuracy.
- Expand unit test coverage for additional quest constants.
- Review other dependencies for newer versions and potential security patches.
- Investigate build failure in `injected-client:inject` task.
- Review GitHub workflow names for clarity.
- Refresh dependency versions in `Dependencies.kt`.
- Implement plugin unload cleanup.

## Planned Enhancements
- Monitor for additional graceful shutdown improvements.
- Monitor build performance to ensure memory reduction does not cause failures.
- Automate dependency version checks across all modules.
- Add CI step for building and testing.
- Documented workflow refactoring.
