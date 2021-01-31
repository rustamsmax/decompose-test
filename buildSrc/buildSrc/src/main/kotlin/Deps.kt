object Deps {

   const val playServices = "com.google.gms:google-services:4.3.4"
   const val napier = "com.github.aakira:napier:1.4.1"
   const val uuidkmm = "com.benasher44:uuid:0.2.3"
   const val libphonenumber = "com.googlecode.libphonenumber:libphonenumber:8.12.12"

   const val javaJWT = "com.auth0:java-jwt:3.12.0"

   object JetBrains {
      const val skija = "org.jetbrains.skiko:skiko-jvm-runtime:0.2.2"
      object Kotlin {
         // __KOTLIN_COMPOSE_VERSION__
         const val VERSION = "1.4.21-2"
         private const val pckg = "org.jetbrains.kotlin"
         const val gradlePlugin     = "$pckg:kotlin-gradle-plugin:$VERSION"
         const val stdlib           = "$pckg:kotlin-stdlib:$VERSION"
         const val stdlibJdk8       = "$pckg:kotlin-stdlib-jdk8:$VERSION"
         const val stdlibCommon     = "$pckg:kotlin-stdlib-common:$VERSION"
         const val serialization    = "$pckg:kotlin-serialization:$VERSION"
         const val reflect          = "$pckg:kotlin-reflect:$VERSION"
         const val testCommon       = "$pckg:kotlin-test-common:$VERSION"
         const val testJunit        = "$pckg:kotlin-test-junit:$VERSION"
         const val testAnnotationsCommon = "$pckg:kotlin-test-annotations-common:$VERSION"
      }


      object KotlinX {
         private const val pckg = "org.jetbrains.kotlinx"

         const val dateTime = "$pckg:kotlinx-datetime:0.1.1"

         object Serialization {
            private const val version = "0.20.0"
            const val core = "$pckg:kotlinx-serialization-core:1.0.1"
            const val json = "$pckg:kotlinx-serialization-json:1.0.1"
         }

         object Coroutines {
            private const val version = "1.4.2"
            private const val pckg = "org.jetbrains.kotlinx"
            const val bom     = "$pckg:kotlinx-coroutines-bom:$version"
            const val common  = "$pckg:kotlinx-coroutines-core-common:1.3.8"
            const val core    = "$pckg:kotlinx-coroutines-core:$version"
            const val android = "$pckg:kotlinx-coroutines-android:$version"
            const val jvm     = "$pckg:kotlinx-coroutines-core-jvm:$version"
            const val native  = "$pckg:kotlinx-coroutines-core-native:1.3.8"
            const val testCoroutine = "$pckg:kotlinx-coroutines-test:$version"
         }
      }

      object Compose {
         // __LATEST_COMPOSE_RELEASE_VERSION__
         const val VERSION = "0.3.0-build146"
         const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
      }
   }

   object Accompanist{
      private const val VERSION = "0.4.2"
      private const val pckg = "dev.chrisbanes.accompanist"

      const val coil = "${pckg}:accompanist-coil:${VERSION}"
   }

   object Android {
      object Tools {
         object Build {
            const val gradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha05"
         }
         const val desugar = "com.android.tools:desugar_jdk_libs:1.1.1"
      }
      object PlayServices {
         private const val VERSION = "19.0.0"
         const val plugin = "com.google.gms:google-services:4.3.4"
         const val auth = "com.google.android.gms:play-services-auth:$VERSION"
         const val nearby = "com.google.android.gms:play-services-nearby:$VERSION"
         const val playCore = "com.google.android.play:core-ktx:1.7.0"
      }
   }

   object AndroidX {
      object AppCompat {
         const val appCompat = "androidx.appcompat:appcompat:1.1.0"
      }

      object DataStore {
         private const val version = "1.0.0-alpha04"
         const val typed = "androidx.datastore:datastore:$version"
         const val typedCore = "androidx.datastore:datastore-core:$version"
         const val prefs = "androidx.datastore:datastore-preferences:$version"
         const val prefsCore = "androidx.datastore:datastore-preferences-core:$version"
      }
   }

   object ArkIvanov {
      object MVIKotlin {
         private const val VERSION = "2.0.0"
         private const val pckg = "com.arkivanov.mvikotlin"
         const val rx = "$pckg:rx:$VERSION"
         const val mvikotlin = "$pckg:mvikotlin:$VERSION"
         const val mvikotlinMain = "$pckg:mvikotlin-main:$VERSION"
         const val mvikotlinMainIosX64 = "$pckg:mvikotlin-main-iosx64:$VERSION"
         const val mvikotlinMainIosArm64 = "$pckg:mvikotlin-main-iosarm64:$VERSION"
         const val mvikotlinLogging = "$pckg:mvikotlin-logging:$VERSION"
         const val mvikotlinTimeTravel = "$pckg:mvikotlin-timetravel:$VERSION"
         const val mvikotlinExtReaktive = "$pckg:mvikotlin-extensions-reaktive:$VERSION"
         const val mvikotlinExtCoroutines = "$pckg:mvikotlin-extensions-coroutines:$VERSION"
      }

      object Decompose {
         private const val VERSION = "0.1.7"
         const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
         const val decomposeIosX64 = "com.arkivanov.decompose:decompose-iosx64:$VERSION"
         const val decomposeIosArm64 = "com.arkivanov.decompose:decompose-iosarm64:$VERSION"
         const val extensionsCompose = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
      }
   }

   object Badoo {
      object Reaktive {
         private const val VERSION = "1.1.19"
         const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
         const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
         const val utils = "com.badoo.reaktive:utils:$VERSION"
         const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
      }
   }

   object Squareup {
      object SQLDelight {
         private const val VERSION = "1.4.4"

         const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$VERSION"
         const val androidDriver = "com.squareup.sqldelight:android-driver:$VERSION"
         const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$VERSION"
         const val nativeDriver = "com.squareup.sqldelight:native-driver:$VERSION"
         const val coroutine = "com.squareup.sqldelight:coroutines-extensions:$VERSION"
      }
   }

   object Ktor {
      private const val version = "1.5.0"
      private const val pckg = "io.ktor"
      const val utils         = "$pckg:ktor-utils:$version"
      const val ktor          = "$pckg:ktor-client:$version"
      const val core          = "$pckg:ktor-client-core:$version"
      const val android       = "$pckg:ktor-client-android:$version"
      const val java          = "$pckg:ktor-client-core-jvm:$version"
      const val native        = "$pckg:ktor-client-core-native:$version"
      const val okhttp        = "$pckg:ktor-client-okhttp:$version"
      const val ser           = "$pckg:ktor-client-serialization:$version"
      const val serNative     = "$pckg:ktor-client-serialization-native:$version"
      const val logging       = "$pckg:ktor-client-logging:$version"
      const val json          = "$pckg:ktor-client-json:$version"
      const val ios           = "$pckg:ktor-client-ios:$version"
      const val jsonJvm       = "$pckg:ktor-client-json-jvm:$version"
      const val jsonNative    = "$pckg:ktor-client-json-native:$version"
      const val auth          = "$pckg:ktor-client-auth:$version"
      const val cio           = "$pckg:ktor-client-cio:$version"
   }

   object Firebase {
      private const val version = "19.4.0"
      const val bom = "com.google.firebase:firebase-bom:25.12.0"
      const val auth = "com.google.firebase:firebase-auth"
      const val messaging = "com.google.firebase:firebase-messaging"
      const val analytics = "com.google.firebase:firebase-analytics"
   }

   object Kodein {
      private const val version = "7.1.0"
      private const val art = "org.kodein.di"
      const val di = "$art:kodein-di:$version"
      const val core = "$art:kodein-di-core:$version"
      const val coreJvm = "$art:kodein-di-core-jvm:$version"
      const val coreNative = "$art:kodein-di-core-native:$version"
      const val coreJs = "$art:kodein-di-core-js:$version"
      const val androidCore = "$art:kodein-di-framework-android-core:$version"
      const val androidX = "$art:kodein-di-framework-android-x:$version"
   }

   object RemalDependency {
      const val version = "1.1.6"
      const val plugin = "name.remal:gradle-plugins:$version"
      const val updatePlugin = "name.remal.check-dependency-updates"
   }
}
