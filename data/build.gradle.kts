plugins {
    id(Plugins.library)
    kotlin(Plugins.android)
    // Kapt
    kotlin(Plugins.kapt)

    // Hilt
    id(Plugins.hilt)

    // SafeArgs
    id(Plugins.safeargs)
}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    Dependencies.Retrofit.apply {
        // Retrofit
        implementation(retrofit2)
        implementation(gson)
    }

    Dependencies.OkHttp.apply {
        // OkHttp Client
        implementation(platform(okhttp3))
        implementation(okhttp)
        implementation(logging)
    }
    Dependencies.Hilt.apply {
        //Hilt
        implementation(hilt)
        implementation(legacy)
        implementation(lifecycle)
        kapt(hiltCompiler)
    }

    //Domain
    implementation(project(":domain"))
}