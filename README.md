# Paplin Example Project

Example Paper plugin demonstrating [Paplin](https://github.com/JaroxCraft/paplin) — a Kotlin library that wraps the Paper Minecraft server API with idiomatic Kotlin DSLs.

## What it shows

- **Commands** — [CommandAPI](https://commandapi.jorel.dev) Kotlin DSL (`commandTree { }`), initialized automatically by `PaplinPlugin`
- **Event DSL** — `listen<BlockBreakEvent>(plugin) { }` for event handling
- **Chat components** — `component { }` for Kyori Adventure text building
- **Scheduler DSL** — `runSync(ticks) { }`, `runAsync { }`, `runTimer(interval) { }` for task scheduling
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

Paplin is fetched from Repsy Maven. Its version lives in `gradle/libs.versions.toml` and uses a `+` separator (SemVer build metadata) to name the Minecraft version it is built for:

```toml
[versions]
paplin = "1.2.1+26.2"

[libraries]
paplin = { module = "de.jarox:paplin", version.ref = "paplin" }
```

The Minecraft version (Paper dev bundle, `api-version`, `runServer`) is derived from the part after `+`, so Paplin and Minecraft are always updated together.

## Updating Paplin

Renovate opens a PR whenever a new Paplin release is published to Repsy (see `renovate.json`). To update manually, change `paplin` in `gradle/libs.versions.toml` and rebuild.

## Building

```bash
./gradlew build          # compile the plugin
./gradlew shadowJar      # build the fat JAR (output in build/libs/)
./gradlew runServer      # run a local Paper server with the plugin
```
