plugins {
   id("android-setup")
   id("multiplatform-compose-setup")
}

kotlin {
   sourceSets {
      val commonMain by getting {
         dependencies {
//            implementation(project(":common:utils"))
            implementation(project(":common"))
            implementation(Deps.ArkIvanov.Decompose.decompose)
            implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
            implementation(Deps.libphonenumber)
            implementation(Deps.napier)
            implementation(Deps.JetBrains.KotlinX.dateTime)
         }
      }

      val jvmCommonMain by creating{
         dependsOn(commonMain)
      }

      val androidMain by getting{
         dependsOn(jvmCommonMain)
      }
      val desktopMain by getting{
         dependsOn(jvmCommonMain)
      }
   }
}
