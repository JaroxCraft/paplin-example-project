plugins {
    alias(libs.plugins.kotlin.jvm)

    alias(libs.plugins.shadow)

    alias(libs.plugins.paperweight.userdev)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.plugin.yml.paper)
}

group = "de.jarox"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "Paplin"
        url = uri("https://repo.repsy.io/mvn/jaroxcraft/paplin")
    }
}

dependencies {
    paperweight.paperDevBundle("${libs.versions.minecraft.get()}-R0.1-SNAPSHOT")

    shadow(kotlin("stdlib"))

    implementation("de.jarox:paplin:${libs.versions.paplin.get()}-${libs.versions.minecraft.get()}")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

paper {
    name = rootProject.name
    website = "https://github.com/JaroxCraft/paplin-example-project"
    author = "JaroxCraft"

    main = "de.jarox.paplin.example.ExamplePlugin"

    apiVersion = libs.versions.minecraft.get()
}

tasks.runServer {
    minecraftVersion(libs.versions.minecraft.get())
}
