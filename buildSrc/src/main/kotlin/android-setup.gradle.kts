//import gradle.kotlin.dsl.accessors._a523fae42137999b730e2b2719d3c3fe .android

plugins {
   id("com.android.library")
}

android {
   compileSdkVersion(30)

   defaultConfig {
      minSdkVersion(21)
      targetSdkVersion(30)
   }

   compileOptions {
      isCoreLibraryDesugaringEnabled = true
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   sourceSets {
      named("main") {
         manifest.srcFile("src/androidMain/AndroidManifest.xml")
         res.srcDirs("src/androidMain/res")
      }
   }
   // KT-43944 Workaround
   configurations {
      maybeCreate("androidTestApi")
      maybeCreate("androidTestDebugApi")
      maybeCreate("androidTestReleaseApi")
      maybeCreate("testApi")
      maybeCreate("testDebugApi")
      maybeCreate("testReleaseApi")
   }
}

/*dependencies{
   coreLibraryDesugaring(Deps.Android.Tools.desugar)
}*/


fun Project.android(configure: com.android.build.gradle.LibraryExtension.() -> Unit): Unit =
   (this as ExtensionAware).extensions.configure("android", configure)

