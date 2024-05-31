plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
  id("com.google.gms.google-services")
  id("com.google.firebase.crashlytics")
}

android {
  namespace = "com.example.backfrontmovie"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.backfrontmovie"
    minSdk = 30
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  viewBinding {
    enable = true
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.11.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation(project(":data"))
  implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
  implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
  implementation("androidx.navigation:navigation-common:2.7.6")
  implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
  implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
  implementation("com.github.bumptech.glide:glide:4.16.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  kapt("androidx.room:room-compiler:2.6.1")
  implementation("androidx.room:room-common:2.6.1")
  implementation("androidx.room:room-ktx:2.6.1")
  implementation("io.insert-koin:koin-android:3.6.0-wasm-alpha2")
  implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
  implementation("com.google.firebase:firebase-crashlytics")
  implementation("com.google.firebase:firebase-analytics")
  implementation("com.google.firebase:firebase-messaging-ktx:24.0.0")
}