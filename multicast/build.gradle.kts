plugins {
    id("org.mobilenativefoundation.store.multiplatform")
}

kotlin {

    cocoapods {
        summary = "Store5/Multicast"
        homepage = "https://github.com/MobileNativeFoundation/Store"
        ios.deploymentTarget = "13"
        version = libs.versions.store.get()
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.atomic.fu)
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.turbine)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.multicast"
}
