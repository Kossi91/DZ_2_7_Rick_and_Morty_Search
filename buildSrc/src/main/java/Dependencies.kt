object Dependencies {

    object UIComponents{
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.8.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Hilt{
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }
    object Retrofit{
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }
    object OkHttp{
        const val okhttp3 = "com.squareup.okhttp3:okhttp-bom:4.10.0"
        const val okhttp =  "com.squareup.okhttp3:okhttp"
        const val logging = "com.squareup.okhttp3:logging-interceptor"
    }
    object Coroutines{
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
        const val inject = "javax.inject:javax.inject:1"
    }
    object Fragment{
        const val fragment = "androidx.fragment:fragment-ktx:1.5.6"
    }
    object Navigation{
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }
    object Viewbinding{
        const val viewbinding = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
    }
    object Glide{
        const val glide = "com.github.bumptech.glide:glide:${Versions.glade}"
        const val bumptech = "com.github.bumptech.glide:compiler:${Versions.glade}"
    }
    object Paging{
        const val paging = "androidx.paging:paging-runtime:3.1.1"
    }
}
