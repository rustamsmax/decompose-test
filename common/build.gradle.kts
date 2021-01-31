plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version(Deps.JetBrains.Kotlin.VERSION)
    id("multiplatform-ktor-setup")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.JetBrains.KotlinX.dateTime)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.MVIKotlin.rx)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtReaktive)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtCoroutines)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.napier)
            }
        }
    }
}
