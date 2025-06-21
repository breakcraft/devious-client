# System Instructions

These guidelines govern how automated agents (and humans) work on the **Devious Client** repository.  
Read this once, then ship code like a pro.

---

## 1 · Development Guidelines

| Task            | Requirement                                                                                  |
|-----------------|----------------------------------------------------------------------------------------------|
| Gradle wrapper  | Make `./gradlew` executable → `chmod +x ./gradlew`.                                           |
| JDK             | Build & test with **JDK 11** (set `JAVA_HOME`).                                               |
| Commit style    | Keep messages short + imperative (e.g. “add feature”).                                        |
| Code style      | Follow RuneLite’s [Code Conventions](https://github.com/runelite/runelite/wiki/Code-Conventions). |

---

## 2 · Required Local Checks

```bash
# Fast sanity build – skips heavyweight stuff that CI handles
./gradlew build --stacktrace -x checkstyleMain -x checkstyleTest --console=plain

# Style gate
./gradlew checkstyleMain --console=plain
```

---

## 3 · Version-Control Protocol

| Objective                | Directive                                                                                      |
|--------------------------|-------------------------------------------------------------------------------------------------|
| **Push directly**        | All agents push straight to the default branch.                                                |
| Branch creation          | `git checkout -b <branch-name>` when a new stream of work is requested.                        |
| Thirty-item batch        | Tackle ≈ 30 related fixes/enhancements per iteration.                                           |
| Single-push strategy     | Finish the batch, **push once**, never open a PR.                                              |
| Conflict resolution      | Merge locally, keep the better solution, push clean history.                                   |
| Transparent records      | Keep `CHANGE_TRACKER.md` updated (Completed / TODO / Planned).                                 |

---

## 4 · Execution Environment

| Requirement      | Directive                                                                                                   |
|------------------|-------------------------------------------------------------------------------------------------------------|
| Hardware         | Assume **CPU-only**; no GPU deps.                                                                           |
| Missing tools    | Install immediately (`apt`, `pip`, `npm`, etc.) – except **don’t touch `nano`**.                            |
| Core utilities   | Bootstrap with `sudo apt-get update -y && sudo apt-get install -y apt-utils`.                               |
| Privilege bumps  | Retry failed unprivileged commands with `sudo` as needed.                                                   |

---

## 5 · Network-Constraint Mitigation

| Scenario            | Directive                                                                                                             |
|---------------------|-----------------------------------------------------------------------------------------------------------------------|
| Blocked downloads   | Pause, hunt mirrors/offline bundles, log workaround in `CHANGE_TRACKER.md`.                                            |
| Persistence         | Exhaust caching, retries, or mirrored registries before marking a task infeasible.                                    |

---

## 6 · Proactive Codebase Stewardship  **(always on)**

- While fixing anything, **scan nearby code** for lint, stale deps, or flaky tests.  
- **Bundle** fixes that raise overall quality within the current 30-item budget.

---

## 7 · Operational Mantra

Ship responsibly, commit atomically, push once, document always.  
Squash conflicts, slay blockers, leave the repo better than you found it.

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

### Ready?  
Pick a slice, blaze through it, push once, update the tracker. Rinse, repeat.  
Happy hacking. 🚀
