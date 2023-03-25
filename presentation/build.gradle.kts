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
    namespace = "com.example.presentation"
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
    // ViewBinding
    buildFeatures.viewBinding = true
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

    // Fragment
    implementation(Dependencies.Fragment.fragment)

    //Hilt
    Dependencies.Hilt.apply {
        implementation(hilt)
        implementation(legacy)
        implementation(lifecycle)
        kapt(hiltCompiler)
    }

    // Navigation
    Dependencies.Navigation.apply {
        implementation(navigation)
        implementation(navigationUI)
    }

    // ViewBindingPropertyDelegate
    implementation(Dependencies.Viewbinding.viewbinding)

    // Glide
    implementation(Dependencies.Glide.glide)
    annotationProcessor(Dependencies.Glide.bumptech)

    // Paging 3
    implementation(Dependencies.Paging.paging)

    //Domain
    implementation(project(":domain"))
}
