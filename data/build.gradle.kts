plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

//kotlin {
//    compilerOptions {
//        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
//    }
//}
dependencies {
    implementation(project(":domain"))

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
}
