// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        // Hilt Jetpack integrations
        maven { url = uri("https://androidx.dev/snapshots/builds/6515566/artifacts/repository") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${Versions.BENCHMARK}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        // Hilt Jetpack integrations
        maven { url = uri("https://androidx.dev/snapshots/builds/6515566/artifacts/repository") }
        maven { url = uri("https://jitpack.io") }

        flatDir {
            dirs = setOf(file("libs"))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}