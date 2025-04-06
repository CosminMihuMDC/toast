package ro.cosminmihu.toast

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.platform.LocalContext

/**
 * A builder class for creating, customizing and showing Toast messages.
 */
public class ToastBuilder(private val context: Context) {
    private var message: String? = null
    private var duration: Int = Toast.LENGTH_SHORT
    private var gravity: Int = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
    private var xOffset: Int = 0
    private var yOffset: Int = 0
    private var onShown: (() -> Unit)? = null
    private var onDismiss: (() -> Unit)? = null

    /**
     * Sets the message to be displayed in the Toast.
     */
    public fun message(@StringRes resId: Int) {
        this.message = context.getString(resId)
    }

    /**
     * Sets the message to be displayed in the Toast.
     */
    public fun message(message: String) {
        this.message = message
    }

    /**
     * Sets the duration of the Toast to short.
     */
    public fun short() {
        this.duration = Toast.LENGTH_SHORT
    }

    /**
     * Sets the duration of the Toast to long.
     */
    public fun long() {
        this.duration = Toast.LENGTH_LONG
    }

    /**
     * Sets a callback to be invoked when the Toast is shown.
     * This callback will only be invoked on API level 30 (Android R) and above.
     * For older devices it will not be invoked.
     * @param onShown The callback to be invoked when the Toast is shown.
     */
    public fun onShown(onShown: () -> Unit) {
        this.onShown = onShown
    }

    /**
     * Sets a callback to be invoked when the Toast is dismissed.
     * This callback will only be invoked on API level 30 (Android R) and above.
     * For older devices it will not be invoked.
     * @param onDismiss The callback to be invoked when the Toast is dismissed.
     */
    public fun onDismiss(onDismiss: () -> Unit) {
        this.onDismiss = onDismiss
    }

    /**
     * Sets the position of the Toast on the screen.
     * @param gravity The gravity of the Toast.
     * @param build Customize the position.
     */
    public fun position(gravity: Int, build: PositionBuilder.() -> Unit = {}) {
        this.gravity = gravity
        val position = PositionBuilder().apply(build)
        xOffset = position.xOffset
        yOffset = position.yOffset
    }

    /**
     * Shows the Toast.
     */
    public fun show() {
        val toast = Toast.makeText(context, message, duration)
        if (onShown != null || onDismiss != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                toast.addCallback(
                    object : Toast.Callback() {
                        override fun onToastShown() {
                            onShown?.invoke()
                        }

                        override fun onToastHidden() {
                            onDismiss?.invoke()
                        }
                    }
                )
            }
        }
        toast.setGravity(gravity, xOffset, yOffset)
        toast.show()
    }

    /**
     * A builder class for customizing the position of the Toast.
     */
    public class PositionBuilder {
        internal var xOffset: Int = 0
        internal var yOffset: Int = 0
    }
}


/**
 * Extension function to show a Toast message.
 * @receiver The [Context] in which the Toast is shown.
 * @param build Customize the Toast message.
 */
public fun Context.toast(build: ToastBuilder.() -> Unit) {
    val builder = ToastBuilder(this)
    builder.build()
    builder.show()
}