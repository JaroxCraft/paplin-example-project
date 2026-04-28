# Paplin Example Project

Example Paper plugin demonstrating [Paplin](https://github.com/JaroxCraft/paplin) — a Kotlin library that wraps the Paper Minecraft server API with idiomatic Kotlin DSLs.

## What it shows

- **Command DSL** — `command { }`, `argument<T>()`, `runs { }` for Brigadier commands
- **Event DSL** — `listen<BlockBreakEvent> { }` for event handling
- **Chat components** — `component { }` for Kyori Adventure text building
- **Plugin lifecycle** — extending `PaplinPlugin` with `enable()` / `disable()` hooks

## Prerequisites

- Java 25+
- Git

## Quick start

```bash
git clone https://github.com/JaroxCraft/paplin-example-project
cd paplin-example-project
```

Run a local Paper server with the plugin loaded:

```bash
./gradlew runServer
```

Then test the example command:

```
/mycommand
/mycommand Hello from Paplin!
```

## Dependencies

Paplin is fetched from Repsy Maven. Versions are managed in `gradle/libs.versions.toml`:

```toml
[versions]
minecraft = "26.1.2"
paplin = "1.0.0"
```

The artifact coordinate uses a `+` separator (SemVer build metadata):

```kotlin
implementation("de.jarox:paplin:${libs.versions.paplin.get()}+${libs.versions.minecraft.get()}")
```

## Updating Paplin

Bump `paplin` in `gradle/libs.versions.toml` and rebuild. Renovate will also open PRs automatically when new versions are published.

## Building

```bash
./gradlew build          # compile the plugin
./gradlew shadowJar      # build the fat JAR (output in build/libs/)
./gradlew runServer      # run a local Paper server with the plugin
```
