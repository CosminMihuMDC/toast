//[toast](../../../index.md)/[ro.cosminmihu.toast](../index.md)/[ToastBuilder](index.md)/[onDismiss](on-dismiss.md)

# onDismiss

[androidJvm]\
fun [onDismiss](on-dismiss.md)(onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Sets a callback to be invoked when the Toast is dismissed. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked.

#### Parameters

androidJvm

| | |
|---|---|
| onDismiss | The callback to be invoked when the Toast is dismissed. |