package ro.cosminmihu.toast

import android.app.Application
import android.os.Build
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
class ToastBuilderTest {

    private val context: Application get() = RuntimeEnvironment.getApplication()

    @Test
    fun `show returns silently when message is not set`() {
        // Should not throw, simply no-op
        ToastBuilder(context).show()
    }

    @Test
    fun `show does not throw when message is set`() {
        ToastBuilder(context).apply {
            message("Hello Toast")
        }.show()
    }

    @Test
    fun `short duration does not throw`() {
        ToastBuilder(context).apply {
            message("test")
            short()
        }.show()
    }

    @Test
    fun `long duration does not throw`() {
        ToastBuilder(context).apply {
            message("test")
            long()
        }.show()
    }

    @Test
    fun `Context toast extension shows toast without throwing`() {
        context.toast {
            message("Context extension toast")
            short()
        }
    }
}