plugins {
    alias(libs.plugins.kotlin.jvm)

    alias(libs.plugins.shadow)

    alias(libs.plugins.paperweight.userdev)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.plugin.yml.paper)
}

group = "de.jarox"
version = "1.0.0"

// Paplin releases are built against exactly one Minecraft version: <paplin>+<minecraft>
val minecraftVersion = libs.versions.paplin.get().substringAfter('+')

repositories {
    if (providers.gradleProperty("useMavenLocal").orNull == "true") {
        mavenLocal()
    }
    mavenCentral()
    maven {
        name = "Paplin"
        url = uri("https://repo.repsy.io/mvn/jaroxcraft/paplin")
    }
}

dependencies {
    paperweight.paperDevBundle("$minecraftVersion.build.+")

    shadow(kotlin("stdlib"))

    implementation(libs.commandapi.paper.shade)
    implementation(libs.paplin)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

paper {
    name = rootProject.name
    website = "https://github.com/JaroxCraft/paplin-example-project"
    author = "JaroxCraft"

    main = "de.jarox.paplin.example.ExamplePlugin"

    apiVersion = minecraftVersion
}

tasks.runServer {
    minecraftVersion(minecraftVersion)
}
