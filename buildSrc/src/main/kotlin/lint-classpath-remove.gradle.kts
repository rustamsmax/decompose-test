import org.gradle.kotlin.dsl.invoke

plugins {
    id("com.android.library")
}

android{
    configurations{
        removeIf { conf ->
            conf.name == "lintClassPath"
        }
    }
}