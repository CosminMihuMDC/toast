package ro.cosminmihu.toast.sample

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.cosminmihu.toast.toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _root_ide_package_.ro.cosminmihu.toast.sample.theme.ToastTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                _root_ide_package_.ro.cosminmihu.toast.Toast {
                    message("Hello from the toast library!")
                    short()
                    onShown {
                        Log.d("XXX", "Toast shown")
                    }
                    onDismiss {
                        Log.d("XXX", "Toast dismissed")
                    }
                }
            }
        }

        toast {
            message("Hello from the toast library!")
            short()
            onShown {
                Log.d("XXX", "Toast shown")
            }
            onDismiss {
                Log.d("XXX", "Toast dismissed")
            }
            position(Gravity.BOTTOM)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _root_ide_package_.ro.cosminmihu.toast.sample.theme.ToastTheme {
        Greeting("Android")
    }
}