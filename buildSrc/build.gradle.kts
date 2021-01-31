plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    // TODO: remove after new build is published
    mavenLocal()
    google()
    jcenter()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://packages.jetbrains.team/maven/p/skija/maven")
}

buildscript {
    repositories {
        // TODO: remove after new build is published
        mavenLocal()
        google()
        jcenter()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://packages.jetbrains.team/maven/p/skija/maven")
    }

    dependencies {
        classpath(Deps.Android.Tools.Build.gradlePlugin)
        classpath(Deps.JetBrains.Kotlin.gradlePlugin)
//      classpath(Deps.JetBrains.Kotlin.serialization)
        classpath(Deps.JetBrains.Compose.gradlePlugin)
        classpath(Deps.Android.PlayServices.plugin)
    }
}

dependencies {
    implementation(Deps.Android.Tools.Build.gradlePlugin)
    implementation(Deps.JetBrains.Kotlin.gradlePlugin)
    implementation(Deps.JetBrains.Compose.gradlePlugin)
    implementation(Deps.Squareup.SQLDelight.gradlePlugin)
    implementation(Deps.Android.PlayServices.plugin)
}

kotlin {
    // Add Deps to compilation, so it will become available in main project
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}
