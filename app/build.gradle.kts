plugins {
    id(Plugins.application)
    kotlin(Plugins.android)

    // Kapt
    kotlin(Plugins.kapt)

    // Hilt
    id(Plugins.hilt)

    // SafeArgs
    id(Plugins.safeargs)
}

android {
    namespace = "com.example.dz_2_7_rick_and_morty_search"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.dz_2_7_rick_and_morty_search"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    Dependencies.UIComponents.apply {
        // Core
        implementation(core)

        // AppCompat
        implementation(appcompat)

        // Material Design
        implementation(material)

        // UI Components
        implementation(constraintlayout)
    }

    Dependencies.Hilt.apply {
        //Hilt
        implementation(hilt)
        implementation(legacy)
        implementation(lifecycle)
        kapt(hiltCompiler)
    }

    //Data
    implementation(project(":data"))

    //Domain
    implementation(project(":domain"))

    //Presentation
    implementation(project(":presentation"))
}