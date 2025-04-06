
[![Maven Central](https://img.shields.io/maven-central/v/ro.cosminmihu.toast/toast?logo=apachemaven&label=Maven%20Central&link=https://search.maven.org/artifact/ro.cosminmihu.toast/toast/)](https://search.maven.org/artifact/ro.cosminmihu.toast/toast)
[![License](https://img.shields.io/github/license/CosminMihuMDC/toast?label=License&logo=lintcode&logoColor=white&color=#3DA639)](https://github.com/CosminMihuMDC/toast/blob/main/LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-F05032.svg?logo=git&logoColor=white)](http://makeapullrequest.com)
![Platforms](https://img.shields.io/badge/Platforms-Android%20+%20iOS%20+%20JVM-brightgreen?logo=bambulab&logoColor=white&color=8d69e0)
[![GitHub stars](https://img.shields.io/github/stars/CosminMihuMDC/toast)](https://github.com/CosminMihuMDC/toast)
[![GitHub forks](https://img.shields.io/github/forks/CosminMihuMDC/toast)](https://github.com/CosminMihuMDC/toast/fork)

# <img src="./extra/toast_ic_launcher.svg" width="35"/> Toast

Toast is a library that provides a simple Kotlin DSL for creating and displaying toasts on Android.

## Setup

### <img src="https://upload.wikimedia.org/wikipedia/commons/6/6b/Gradle_logo.svg" width="100"/>

```kotlin  
dependencies {
    implementation("ro.cosminmihu.toast:toast:1.0.0")
}  
```  

## 🧩 Integration

Check out below how to integrate Toast.

```kotlin  
toast {  
	message("Toast message")
	message(R.string.message_toast)
	short() // by default
	long()
	position(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL) {
		  xOffset = 0 // by default
		  yOffset = 0 // by default
	}
    onShown { /* toast is shown */ }         // API level 30 (Android R) and above
    onDismiss { /* toast is dismissed */ }   // API level 30 (Android R) and above
}
```  

## ✍️ Feedback

Feel free to send feedback or [file an issue](https://github.com/CosminMihuMDC/Toast/issues/new).

## 🙌 Acknowledgments

[![Kotlin](https://img.shields.io/badge/2.1.20-white?logo=kotlin&logoColor=white&color=7F52FF)](http://kotlinlang.org)  
[![Compose Multiplatform](https://img.shields.io/badge/1.8.0-white?logo=jetpackcompose&logoColor=white&color=4284F3)](https://www.jetbrains.com/lp/compose-multiplatform)  
[![Android](https://img.shields.io/badge/Android%2015-white?logo=android&logoColor=white&color=34A853)](https://developer.android.com/about/versions/15)

Thanks to JetBrains and Kotlin!

## 💸 Sponsors
Toast is maintained and improved during nights, weekends and whenever team has free time. If you use Toast in your project, please consider sponsoring us.

You can sponsor us by clicking <span style="color:#bf3989">♥ Sponsor</span> Button.

## 🙏🏻 Credits

Toast is brought to you by these [contributors](https://github.com/CosminMihuMDC/toast/graphs/contributors).