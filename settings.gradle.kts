pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    }
}

val paplinLocalPath = providers.gradleProperty("paplin.local.path").orNull
if (paplinLocalPath != null) {
    includeBuild(paplinLocalPath)
}

rootProject.name = "paplin-example-project"