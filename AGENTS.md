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
