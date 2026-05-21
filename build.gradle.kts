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
    if (providers.gradleProperty("useMavenLocal").isPresent) {
        mavenLocal()
    }
    maven {
        name = "Paplin"
        url = uri("https://maven.pkg.github.com/JaroxCraft/paplin")
        credentials {
            username = providers.environmentVariable("GITHUB_ACTOR").orNull
            password = providers.environmentVariable("GITHUB_TOKEN").orNull
        }
    }
}

dependencies {
    paperweight.paperDevBundle("${libs.versions.minecraft.get()}.build.+")

    shadow(kotlin("stdlib"))

    implementation("de.jarox:paplin:${libs.versions.paplin.get()}+${libs.versions.minecraft.get()}")
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

    apiVersion = libs.versions.minecraft.get()
}

tasks.runServer {
    minecraftVersion(libs.versions.minecraft.get())
}
