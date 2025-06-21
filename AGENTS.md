# Agent Instructions

This repository hosts the **Devious Client** project, built with **Gradle** and **JDK 11**.  
Follow these guidelines whenever you contribute code or perform automated maintenance.

---

## 1 · Development Guidelines

| Task | Requirement |
|------|-------------|
| Gradle wrapper | Ensure `./gradlew` is executable: `chmod +x ./gradlew`. |
| JDK | Use **JDK 11** for all builds and tests (set `JAVA_HOME` accordingly). |
| Commit style | Keep commit messages short, imperative (e.g., “add feature”). |
| Code style | Follow RuneLite’s [Code Conventions](https://github.com/runelite/runelite/wiki/Code-Conventions). |

---

## 2 · Required Local Checks

Run **both** lines before committing / pushing:

```bash
# Fast build (skips tests & style checks that run separately)
./gradlew build --stacktrace -x test -x checkstyleMain -x checkstyleTest --console=plain

# Enforce code style
./gradlew checkstyleMain --console=plain
```

---

# Operational Policy for Automated Repository Maintenance

## 3 · Version-Control Protocol

| Objective | Directive |
|-----------|-----------|
| **YOU MUST PUSH DIRECTLY** | Applies to all automated agents. |
| Branch creation | `git checkout -b <branch-name>` whenever the user requests a new stream of work. |
| Thirty-item batch | Address ~30 discrete fixes/enhancements per iteration. |
| Single-push strategy | After finishing the batch, **push once** to the default branch—**never open a PR**. |
| Conflict resolution | Handle merges locally, keep the better solution, ensure a clean history, and push again if needed. |
| Transparent records | Keep `CHANGE_TRACKER.md` current with:<br>• Completed fixes/features<br>• Outstanding TODOs<br>• Planned enhancements |

---

## 4 · Execution Environment

| Requirement | Directive |
|-------------|-----------|
| **Hardware** | Assume **CPU-only**; do not introduce GPU dependencies. |
| **Tool gaps** | If a command is missing, install it immediately (`apt`, `pip`, `npm`, etc.)—**except** `nano`, which must remain uninstalled. |
| **Core utilities** | Bootstrap with:<br>`sudo apt-get update -y && sudo apt-get install -y apt-utils` |
| **Privilege escalation** | Retry failed unprivileged commands with `sudo`, including Docker or package installs. |

---

## 5 · Network-Constraint Mitigation

| Scenario | Directive |
|----------|-----------|
| Blocked downloads | Pause, locate mirrors/proxies/offline bundles, and document the workaround in `CHANGE_TRACKER.md`. |
| Persistence | Exhaust caching, retries, or mirrored registries before declaring a task infeasible. |

---

## 6 · Proactive Codebase Stewardship  
**YOU MUST PUSH DIRECTLY**

- While implementing any feature or fix, **scan adjacent code** for lint issues, outdated deps, or failing tests.  
- **Consolidate** related fixes within the current batch when it measurably improves stability or maintainability.

---

## 7 · Summary

Work responsibly, commit atomically, **push once**, and document continuously.  
Resolve conflicts or environment hurdles decisively and record your solutions in-repo.  
The overarching goal: **continuous, systematic improvement** of the codebase.

---

## 8 · Open Task Backlog  *(Snapshot: 20 Jun 2025)*

> Knock these down in ~30-item waves; update the list + `CHANGE_TRACKER.md` as you go.

- [ ] **Add** `jvmArgs` to every `JavaExec` task
- [ ] **Update** workflow files → `actions/setup-java@v3`
- [ ] **Enhance** `README.md` with full Gradle-task rundown
- [ ] **Audit** + bump deps in `Dependencies.kt`
- [ ] **Create** test source set for annotation retention
- [ ] **Refresh** blocked-domains list (with comments)
- [ ] **Verify** `resetCursor()` on Linux & macOS
- [ ] **Extend** invokedynamic call-site gathering
- [ ] **Add** example checks; expand docs
- [ ] **Tighten** `insertReturn` condition logic + tests
- [ ] **Fix** LDC instruction field naming
- [ ] **Refactor** `IF` logic + add tests
- [ ] **Cull** obsolete code branches
- [ ] **Tweak** tab-wrapping logic + UI tests
- [ ] **Explain** the `sz * 2` rationale in docs
- [ ] **Investigate** cursor handling; implement solid fix
- [ ] **Rename** constant + update usages
- [ ] **Validate** & update lunar spell widget IDs
- [ ] **Modify** `toEquipmentSlot` for dual-slot gear
- [ ] **Extract** `SoundJarResource` into dedicated files
- [ ] **Build** teleport loader; refactor references
- [ ] **Revise** overshoot generation + tests
- [ ] **Verify** Western Provinces diary tier IDs
- [ ] **Verify** Western Provinces diary varbits
- [ ] **Query** world info; choose best endpoint
- [ ] **Fix** injector NPE + related tests
- [ ] **Implement** plugin-unload cleanup process
- [ ] **Map** `WorldType` enums 1:1
- [ ] **Remove** `-x test` flag from Gradle build
- [ ] **Update** README for minimal build & launch
- [ ] **Edit** GitHub Actions workflow name
- [ ] **Migrate** to **JUnit Jupiter** in Gradle scripts
- [ ] **Replace** `Thread.sleep` → `CountDownLatch`
- [ ] **Adjust** `maxHeapSize` in `cache.gradle.kts`
- [ ] **Enable** PMD task
- [ ] **Test & fix** all outstanding issues
- [ ] **Repair** client-injection errors in tests
- [ ] **Inspect** + bump **Logback** deps
- [ ] **Secure** in-memory credential storage
- [ ] **Document** recent fixes + new TODOs
- [ ] **Polish** `AGENTS.md` functionality doc
- [ ] **Define** contribution rules in `AGENTS.md`
- [ ] **Validate** final `AGENTS.md` content
- [ ] **End-to-end** sanity check – client runs clean

---

## 9 · Contribution Rules

- Keep patches focused and small when possible.
- Update documentation alongside code changes.
- Always run the local checks listed above before pushing.

