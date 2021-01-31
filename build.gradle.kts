
plugins {
    `kotlin-dsl`
}

allprojects {

    repositories {
        google()
        jcenter()
        mavenLocal()
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
buildscript {
    dependencies {
        classpath(Deps.JetBrains.Kotlin.gradlePlugin)
    }
}
