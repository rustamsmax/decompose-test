import org.jetbrains.compose.compose


plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
//    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(30)
/*
    signingConfigs {
        getByName("debug") {
            storeFile = file("abroaduz.keystore")
            storePassword = "bismillah"
            keyAlias = "abroaduz"
            keyPassword = "bismillah"
        }
    }*/

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
//        signingConfig = signingConfigs.getByName("debug")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        //exclude("META-INF/*")
    }
//    dynamicFeatures = mutableSetOf(":common:android:admin", ":common:android:expert")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":compose"))
//    implementation(project(":common:utils"))
//    implementation(project(":common:decompose:main"))
//    implementation(project(":common:compose-ui:main-ui"))
    implementation(compose.material)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinLogging)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinTimeTravel)
    implementation(Deps.ArkIvanov.Decompose.decompose)
    implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
    implementation(Deps.Badoo.Reaktive.reaktive)
    implementation(Deps.Badoo.Reaktive.utils)
    implementation(Deps.JetBrains.Kotlin.reflect)

    implementation(Deps.AndroidX.AppCompat.appCompat)
//    implementation(Deps.javaJWT)
    implementation(Deps.napier)

//    implementation(Deps.Android.PlayServices.playCore)

}
