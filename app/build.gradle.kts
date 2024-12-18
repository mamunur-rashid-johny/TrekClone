import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.johny.trekclone"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.johny.trekclone"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
        multiDexEnabled = true
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        compose = true
        resValues = true
    }
}

ktlint {
    android = true
    ignoreFailures = false
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.SARIF)
        reporter(ReporterType.JSON)
    }
}

dependencies {
    //<editor-fold desc = "Android Core, ViewModel, Life-Cycle">
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)
    //</editor-fold>

    //<editor-fold desc = "Desuger for backward compatibility">
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    //</editor-fold>

    //<editor-fold desc = "Koin">
    implementation(libs.bundles.koin)
    //</editor-fold>

    //<editor-fold desc = "ktor">
    implementation(libs.bundles.ktor)
    //</editor-fold>

    //<editor-fold desc = "Testing Related">
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    //</editor-fold>

    //<editor-fold desc = "Splash Screen API">
    implementation(libs.androidx.splashscreen)
    //</editor-fold>

    //<editor-fold desc = "Compose Navigation">
    implementation(libs.navigation.compose)
    //</editor-fold>

    //<editor-fold>
    implementation (libs.lottie.compose)
    //</editor-fold>

    //<editor-fold desc = "Constrain Layout">
    implementation (libs.androidx.constraintlayout.compose)
    //</editor-fold>
}