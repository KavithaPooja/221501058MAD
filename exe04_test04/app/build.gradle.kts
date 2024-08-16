plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.exe04_test04"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exe04_test04"
        minSdk = 24
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Add packaging options to exclude duplicate files
    packaging {
        resources {
            excludes += listOf(
                "META-INF/INDEX.LIST",
                "META-INF/DEPENDENCIES"
            )
        }
    }
}

dependencies {
    implementation("com.google.apis:google-api-services-sheets:v4-rev20240402-2.0.0")
    implementation("com.google.api-client:google-api-client-android:1.32.1")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.32.1")
    implementation(libs.google.api.client.android)
    implementation(libs.google.api.services.sheets)
    implementation(libs.google.oauth.client.jetty)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}