plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.s21.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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

//    implementation(project(":domain"))

    implementation(project(":productsapi"))
    implementation(project(":productsdatabase"))

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

//    //Retrofit
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    //Gson
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//
//    // Room
//    implementation("androidx.room:room-runtime:2.4.3")
//    kapt("androidx.room:room-compiler:2.4.3")
//    implementation("androidx.room:room-ktx:2.4.3")
//
//    // Dagger
//    implementation("com.google.dagger:dagger:2.45")
//    kapt("com.google.dagger:dagger-compiler:2.45")

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}