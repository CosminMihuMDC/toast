---
title: ToastBuilder
---
//[toast](../../../index.html)/[ro.cosminmihu.toast](../index.html)/[ToastBuilder](index.html)



# ToastBuilder



[androidJvm]\
class [ToastBuilder](index.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))

A builder class for creating, customizing and showing Toast messages.



## Constructors


| | |
|---|---|
| [ToastBuilder](-toast-builder.html) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |


## Types


| Name | Summary |
|---|---|
| [PositionBuilder](-position-builder/index.html) | [androidJvm]<br>class [PositionBuilder](-position-builder/index.html)<br>A builder class for customizing the position of the Toast. |


## Functions


| Name | Summary |
|---|---|
| [long](long.html) | [androidJvm]<br>fun [long](long.html)()<br>Sets the duration of the Toast to long. |
| [message](message.html) | [androidJvm]<br>fun [message](message.html)(@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>fun [message](message.html)(message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Sets the message to be displayed in the Toast. |
| [onDismiss](on-dismiss.html) | [androidJvm]<br>fun [onDismiss](on-dismiss.html)(onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Sets a callback to be invoked when the Toast is dismissed. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked. |
| [onShown](on-shown.html) | [androidJvm]<br>fun [onShown](on-shown.html)(onShown: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Sets a callback to be invoked when the Toast is shown. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked. |
| [position](position.html) | [androidJvm]<br>fun [position](position.html)(gravity: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), build: [ToastBuilder.PositionBuilder](-position-builder/index.html).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>Sets the position of the Toast on the screen. |
| [short](short.html) | [androidJvm]<br>fun [short](short.html)()<br>Sets the duration of the Toast to short. |
| [show](show.html) | [androidJvm]<br>fun [show](show.html)()<br>Shows the Toast. |
