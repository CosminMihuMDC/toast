//[toast](../../../index.md)/[ro.cosminmihu.toast](../index.md)/[ToastBuilder](index.md)/[onShown](on-shown.md)

# onShown

[androidJvm]\
fun [onShown](on-shown.md)(onShown: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Sets a callback to be invoked when the Toast is shown. This callback will only be invoked on API level 30 (Android R) and above. For older devices it will not be invoked.

#### Parameters

androidJvm

| | |
|---|---|
| onShown | The callback to be invoked when the Toast is shown. |