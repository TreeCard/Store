plugins {
    id("org.mobilenativefoundation.store.multiplatform")
}

kotlin {

    cocoapods {
        summary = "Store5/Store"
        homepage = "https://github.com/MobileNativeFoundation/Store"
        ios.deploymentTarget = "13"
        version = libs.versions.store.get()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.datetime)
                api(libs.kotlinx.atomic.fu)
                implementation(libs.touchlab.kermit)
                implementation(projects.multicast)
                implementation(projects.cache)
                api(projects.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.store5"
}
