//[toast](../../../index.md)/[ro.cosminmihu.toast](../index.md)/[ToastBuilder](index.md)

# ToastBuilder

[androidJvm]\
class [ToastBuilder](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))

A builder class for creating, customizing and showing Toast messages.

## Constructors

| | |
|---|---|
| [ToastBuilder](-toast-builder.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Types

| Name | Summary |
|---|---|
| [PositionBuilder](-position-builder/index.md) | [androidJvm]<br>class [PositionBuilder](-position-builder/index.md)<br>A builder class for customizing the position of the Toast. |

## Functions

| Name | Summary |
|---|---|
| [long](long.md) | [androidJvm]<br>fun [long](long.md)()<br>Sets the duration of the Toast to long. |
| [message](message.md) | [androidJvm]<br>fun [message](message.md)(@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>fun [message](message.md)(message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Sets the message to be displayed in the Toast. |
| [onDismiss](on-dismiss.md) | [androidJvm]<br>fun [onDismiss](on-dismiss.md)(onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Sets a callback to be invoked when the Toast is dismissed. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked. |
| [onShown](on-shown.md) | [androidJvm]<br>fun [onShown](on-shown.md)(onShown: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Sets a callback to be invoked when the Toast is shown. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked. |
| [position](position.md) | [androidJvm]<br>fun [position](position.md)(gravity: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), build: [ToastBuilder.PositionBuilder](-position-builder/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>Sets the position of the Toast on the screen. |
| [short](short.md) | [androidJvm]<br>fun [short](short.md)()<br>Sets the duration of the Toast to short. |
| [show](show.md) | [androidJvm]<br>fun [show](show.md)()<br>Shows the Toast. |