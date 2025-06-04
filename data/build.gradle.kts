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

    api(libs.retrofit)
    api(libs.converter.gson)
    implementation(libs.kotlinx.datetime)

    implementation(libs.javax.inject)

}
