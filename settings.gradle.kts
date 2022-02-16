pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "pencil-ui"

include(":android-demo")
include(":desktop-demo")
include(":common-demo")
include(":lib")

