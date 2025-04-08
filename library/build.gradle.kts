import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
    alias(libs.plugins.binary.compatibility.validator)
}

kotlin {
    explicitApi()
}

val module = "toast"
val artifact = "toast"
group = "ro.cosminmihu.toast"
version = "1.0.0"

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), artifact, version.toString())

    pom {
        name.set("Toast")
        description.set("""Kotlin DSL Wrapper for Android Toast""".trimMargin())
        inceptionYear.set("2025")
        url.set("https://github.com/CosminMihuMDC/toast")

        licenses {
            license {
                name = "The Apache Software License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        developers {
            developer {
                id = "Cosmin Mihu"
                name = "Cosmin Mihu"
                url = "https://www.cosminmihu.ro/"
            }
        }

        scm {
            url = "https://github.com/CosminMihuMDC/toast.git"
            connection = "scm:git:git://github.com/CosminMihuMDC/toast.git"
            developerConnection = "scm:git:git://github.com/CosminMihuMDC/toast.git"
        }

        issueManagement {
            system = "GitHub Issues"
            url = "https://github.com/CosminMihuMDC/toast/issues"
        }

        ciManagement {
            system = "GitHub Actions"
            url = "https://github.com/CosminMihuMDC/toast/actions"
        }

        distributionManagement {
            downloadUrl = "https://github.com/CosminMihuMDC/toast/releases"
        }
    }
}

tasks {
    dokkaHtml {
        moduleName = module
        moduleVersion = project.version.toString()
        outputDirectory = File(rootDir, "docs/html")
    }

    dokkaGfm {
        moduleName = module
        moduleVersion = project.version.toString()
        outputDirectory = File(rootDir, "docs/gfm")
    }

    dokkaJekyll {
        moduleName = module
        moduleVersion = project.version.toString()
        outputDirectory = File(rootDir, "docs/jekyll")
    }
}

android {
    namespace = "ro.cosminmihu.toast"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()

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

    // AndroidX.
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Testing.
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose.
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}