plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Dependencies.kotlinVersion
    id("com.squareup.sqldelight")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.ktorCore)
                implementation(Dependencies.ktorSerialization)
                implementation(Dependencies.ktorSerializationJson)
                implementation(Dependencies.sqlDelightRuntime)
                implementation(Dependencies.sqlDelightCoroutinesExtensions)
                implementation(Dependencies.kotlinDateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Dependencies.assertK)
                implementation(Dependencies.turbine)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.ktorAndroid)
                implementation(Dependencies.sqlDelightAndroidDriver)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Dependencies.ktorIOS)
                implementation(Dependencies.sqlDelightNativeDriver)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.kmm_template"
    compileSdk = 33
    defaultConfig {
        minSdk = 28
        targetSdk = 33
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.example.kmm_template.database"
        sourceFolders = listOf("sqldelight")
    }
}