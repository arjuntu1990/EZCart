plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://demo7574417.mockable.io/\"")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://demo7574417.mockable.io/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.CORE_KTX)

    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)

    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // AppCompat
    implementation(Libs.APPCOMPAT)

    // Architecture Components
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.ROOM_KTX)
    implementation(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_COMPILER)
    testImplementation(Libs.ARCH_TESTING)

    // Navigation
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.NAVIGATION_UI_KTX)


    // Utils
    api(Libs.TIMBER)
    implementation(Libs.GSON)
    implementation(Libs.CORE_KTX)

    // OkHttp
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)

    // retrofit
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)

    // Kotlin
    implementation(Libs.KOTLIN_STDLIB)

    // Coroutines
    api(Libs.COROUTINES)
    testImplementation(Libs.COROUTINES_TEST)

    // Dagger Hilt
    /*implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)*/

    implementation(Libs.DAGGER_ANDROID)
    kapt(Libs.DAGGER_COMPILER)


    // Has to be replaced to avoid compile / runtime conflicts between okhttp and firestore
    // api(Libs.OKIO)

    // ThreeTenBP for the shared module only. Date and time API for Java.
    /*testImplementation(Libs.THREETENBP)
    compileOnly("org.threeten:threetenbp:${Versions.THREETENBP}:no-tzdb")*/

    // Unit tests
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.HAMCREST)
    testImplementation(Libs.MOCKITO_CORE)
    testImplementation(Libs.MOCKITO_KOTLIN)

    // unit tests livedata
    testImplementation(Libs.ARCH_TESTING)
}