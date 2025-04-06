package ro.cosminmihu.toast.sample

import android.content.Context
import android.util.Log
import android.view.Gravity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ro.cosminmihu.toast.toast

private const val TAG = "ToastSample"

@Composable
fun SampleContextShortToast(context: Context) {
    Button(
        onClick = {
            context.toast {
                message("Short Toast \uD83C\uDF5E Context")
                short()
                onShown {
                    Log.d(TAG, "Context Short Toast shown")
                }
                onDismiss {
                    Log.d(TAG, "Context Short Toast dismissed")
                }
            }
        }
    ) {
        Text(text = "SHORT toast using CONTEXT")
    }
}

@Composable
fun SampleContextLongToast(context: Context) {
    Button(
        onClick = {
            context.toast {
                message("Long Toast \uD83C\uDF5E Context")
                long()
                onShown {
                    Log.d(TAG, "Context Long Toast shown")
                }
                onDismiss {
                    Log.d(TAG, "Context Long Toast dismissed")
                }
            }
        }
    ) {
        Text(text = "LONG toast using CONTEXT")
    }
}


@Composable
fun SampleContextPositionToast(context: Context) {
    Button(
        onClick = {
            context.toast {
                message("Position Toast \uD83C\uDF5E Context")
                short()
                onShown {
                    Log.d(TAG, "Context Position Toast shown")
                }
                onDismiss {
                    Log.d(TAG, "Context Position Toast dismissed")
                }
                position(Gravity.TOP or Gravity.CENTER_HORIZONTAL) {
                    xOffset = 100
                    yOffset = 200
                }
            }
        }
    ) {
        Text(text = "POSITION toast using CONTEXT")
    }
}