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
fun SampleContext(context: Context) {
    Button(
        onClick = {
            context.toast {
                message("Context Toast \uD83C\uDF5E")
                short()
                onShown {
                    Log.d(TAG, "Context Toast shown")
                }
                onDismiss {
                    Log.d(TAG, "Context Toast dismissed")
                }
                position(Gravity.BOTTOM)
            }
        }
    ) {
        Text(text = "Show toast using CONTEXT")
    }
}