plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.google.mapsplatform)
}

android {
    namespace = "com.example.runandtrack"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.runandtrack"
        minSdk = 26
        targetSdk = 34
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

    viewBinding { enable = true }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //     Lifecycle
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.extension)

//    Navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

//    Room
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)

//    Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)

//    Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

//    Glide
    implementation(libs.glide.glide)
    kapt(libs.glide.compiler)

//    Google Maps and Location Services
    implementation(libs.services.location)
    implementation(libs.services.maps)

//    Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

//    Easy Permission
    implementation(libs.easypermissions)

//    Timber
    implementation(libs.timber)

}