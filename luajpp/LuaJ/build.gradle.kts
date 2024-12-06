plugins {
    id("com.android.library")
}

android {
    namespace = "org.luaj.vm2"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testOptions {
            targetSdk = 33
        }

        lint {
            targetSdk = 33
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
}