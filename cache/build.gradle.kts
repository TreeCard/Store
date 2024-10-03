import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    id("org.mobilenativefoundation.store.multiplatform")
}

kotlin {

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        nodejs()
    }

    cocoapods {
        summary = "Store5/Cache"
        homepage = "https://github.com/MobileNativeFoundation/Store"
        ios.deploymentTarget = "13"
        version = libs.versions.store.get()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.atomic.fu)
                api(projects.core)
                implementation(libs.kotlinx.coroutines.core)
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
    namespace = "org.mobilenativefoundation.store.cache"
}
