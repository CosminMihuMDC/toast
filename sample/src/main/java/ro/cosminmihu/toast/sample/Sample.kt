package ro.cosminmihu.toast.sample

import android.content.Context
import android.util.Log
import android.view.Gravity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ro.cosminmihu.toast.Toast
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

@Composable
fun SampleCompose() {
    var showToast by remember { mutableStateOf(false) }
    Button(onClick = { showToast = true }) {
        Text(text = "Show toast in COMPOSE")
    }

    Toast(showToast) {
        message("Compose Toast \uD83C\uDF5E")
        short()
        onShown {
            Log.d(TAG, "Compose Toast shown")
        }
        onDismiss {
            Log.d(TAG, "Compose Toast dismissed")
            showToast = false
        }
    }
}