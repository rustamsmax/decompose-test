plugins {
   id("android-setup")
   id("kotlin-multiplatform")
}

kotlin {
   jvm("desktop")
   android()

   val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
   if (onPhone) {
      iosArm64("ios")
   } else {
      iosX64("ios")
   }

   sourceSets {
      named("commonMain") {
         dependencies {
            implementation(Deps.JetBrains.Kotlin.stdlib)
            implementation(Deps.JetBrains.KotlinX.Coroutines.core)
            implementation(Deps.Ktor.core)
            implementation(Deps.Ktor.ser)
            implementation(Deps.Ktor.auth)
            implementation(Deps.Ktor.logging)
         }
      }

      named("androidMain") {
         dependencies {
            implementation(Deps.JetBrains.KotlinX.Coroutines.android)
            implementation(Deps.Ktor.android)
            implementation(Deps.Ktor.okhttp)
         }
      }
      named("desktopMain") {
         dependencies {
            implementation(Deps.JetBrains.KotlinX.Coroutines.jvm)
            implementation(Deps.Ktor.java)
            implementation(Deps.Ktor.cio)
            implementation(Deps.Ktor.okhttp)
         }
      }
      named("iosMain") {
         dependencies {
            implementation(Deps.JetBrains.KotlinX.Coroutines.native)
            implementation(Deps.Ktor.ios)
         }
      }
   }
}
