plugins {
    id("java-platform")
    id("maven-publish")
}

val appcompat = "1.2.0"
val cardview = "1.0.0"
val browser = "1.0.0"
val constraintLayout = "2.0.4"
val coroutines = "1.3.4"
val coroutinesTest = "1.3.4"
val crashlytics = "2.9.8"
val drawerLayout = "1.1.0-rc01"
val fragment = "1.2.4"
val glide = "4.9.0"
val gson = "2.8.6"

val hamcrest = "1.3"
val testExt = "1.1.3"
val espresso = "3.1.1"
val archTesting = "2.0.0"
val benchmark = "1.0.0"
val junit = "4.13"
val mockito = "3.3.1"
val mockitoKotlin = "1.5.0"
val rules = "1.1.1"
val runner = "1.2.0"
val androidXTestCore = "1.4.0"
val robolectric = "4.5.1"

val hilt = Versions.HILT

val room = "2.2.5"
val okhttp = "3.10.0"
val retrofit = "2.9.0"
val activity = "1.2.2"
val lifecycle = "2.3.1"
val core = "1.3.2"

val hiltJetPack = "1.0.0-SNAPSHOT"
val lottie = "3.0.0"
val material = "1.3.0"
val timber = "4.7.1"
val viewpager2 = "1.0.0"
val mpChart = "v3.1.0"

dependencies {
    constraints {
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.ACTIVITY_KTX}:${activity}")
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")

        api("${Libs.LIFECYCLE_COMPILER}:$lifecycle")
        api("${Libs.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")

        /*api("${Libs.HILT_ANDROID}:${Versions.HILT}")
        api("${Libs.HILT_VIEWMODEL}:${Versions.HILT_JETPACK}")
        api("${Libs.HILT_COMPILER}:${Versions.HILT}")
        api("${Libs.ANDROIDX_HILT_COMPILER}:${Versions.HILT_JETPACK}")
        api("${Libs.HILT_TESTING}:${Versions.HILT}")*/

        api("${Libs.DAGGER_ANDROID}:${Versions.DAGGER}")
        api("${Libs.DAGGER}:${Versions.DAGGER}")
        api("${Libs.DAGGER_SUPPORT}:${Versions.DAGGER}")
        api("${Libs.DAGGER_PROCESSOR}:${Versions.DAGGER}")
        api("${Libs.DAGGER_COMPILER}:${Versions.DAGGER}")

        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")

        api("${Libs.OKHTTP}:$okhttp")
        api("${Libs.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.RETROFIT_GSON}:$retrofit")

        api("${Libs.GSON}:$gson")

        api("${Libs.FRAGMENT_KTX}:$fragment")
        api("${Libs.NAVIGATION_FRAGMENT_KTX}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_UI_KTX}:${Versions.NAVIGATION}")

        api("${Libs.VIEWPAGER2}:$viewpager2")
        api("${Libs.CARDVIEW}:$cardview")

        api("${Libs.TIMBER}:$timber")
        api("${Libs.MP_CHART}:$mpChart")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.GLIDE_COMPILER}:$glide")

        api("${Libs.CRASHLYTICS}:$crashlytics")
        api("${Libs.HAMCREST}:$hamcrest")

        api("${Libs.MOCKITO_CORE}:$mockito")
        api("${Libs.MOCKITO_KOTLIN}:$mockitoKotlin")
        api("${Libs.RULES}:$rules")
        api("${Libs.RUNNER}:$runner")
        api("${Libs.JUNIT}:$junit")
        api("${Libs.EXT_JUNIT}:$testExt")
        api("${Libs.EXT_JUNIT_KTX}:$testExt")
        api("${Libs.ESPRESSO_CORE}:$espresso")
        api("${Libs.ESPRESSO_CONTRIB}:$espresso")

        api("${Libs.ARCH_TESTING}:$archTesting")
        api("${Libs.BENCHMARK}:$benchmark")
        api("${Libs.COROUTINES_TEST}:$coroutines")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}