package ro.cosminmihu.toast

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


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
     * Note: only invoked on API level 30 (Android R) and above; silently ignored on older devices.
     * @param onShown The callback to be invoked when the Toast is shown.
     */
    public fun onShown(onShown: () -> Unit) {
        this.onShown = onShown
    }

    /**
     * Sets a callback to be invoked when the Toast is dismissed.
     * Note: only invoked on API level 30 (Android R) and above; silently ignored on older devices.
     * @param onDismiss The callback to be invoked when the Toast is dismissed.
     */
    public fun onDismiss(onDismiss: () -> Unit) {
        this.onDismiss = onDismiss
    }

    /**
     * Sets the position of the Toast on the screen.
     * Note: [android.widget.Toast.setGravity] has no effect on apps targeting API 30 (Android R)
     * and above. On those devices the position will be ignored.
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
        if (message == null) return
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
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            toast.setGravity(gravity, xOffset, yOffset)
        }
        toast.show()
    }

    /**
     * A builder class for customizing the position of the Toast.
     */
    public class PositionBuilder {
        public var xOffset: Int = 0
        public var yOffset: Int = 0
    }
}

/**
 * Extension function to show a Toast message from a [Context].
 * @receiver The [Context] in which the Toast is shown.
 * @param build Customize the Toast message.
 */
public fun Context.toast(build: ToastBuilder.() -> Unit) {
    ToastBuilder(this).apply(build).show()
}

/**
 * Extension function to show a Toast message from a [Fragment].
 * @receiver The [Fragment] in which the Toast is shown.
 * @param build Customize the Toast message.
 */
public fun Fragment.toast(build: ToastBuilder.() -> Unit) {
    ToastBuilder(requireContext()).apply(build).show()
}