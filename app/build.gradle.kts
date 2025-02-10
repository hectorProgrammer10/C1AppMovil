plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt.android) // Usa alias para Hilt
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.c1moviles"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.c1moviles"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("com.google.accompanist:accompanist-permissions:0.30.1")
    implementation("com.google.maps.android:maps-compose:2.11.2")
    implementation(libs.play.services.location)
    implementation(libs.play.services.maps)
    // Cliente Ktor básico
    implementation("io.ktor:ktor-client-core:2.3.4")

    // Cliente Ktor para Android (motor Android)
    implementation("io.ktor:ktor-client-android:2.3.4")

    // Para la negociación de contenido (ContentNegotiation)
    implementation("io.ktor:ktor-client-content-negotiation:2.3.4")

    // Para la serialización con Gson (si lo usas, de lo contrario puedes usar kotlinx.serialization)
    implementation("io.ktor:ktor-serialization-gson:2.3.4")

    // Opcional: Para ver logs de las peticiones (muy útil en desarrollo)
    implementation("io.ktor:ktor-client-logging:2.3.4")
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.squareup.retrofit2.converter.json)
    implementation(libs.androidx.compose.material.icons.extended)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.animation.core.lint)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
