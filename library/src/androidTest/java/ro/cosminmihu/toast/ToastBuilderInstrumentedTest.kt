package ro.cosminmihu.toast

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented tests for [ToastBuilder] running on a real device or emulator.
 */
@RunWith(AndroidJUnit4::class)
class ToastBuilderInstrumentedTest {

    private val instrumentation = InstrumentationRegistry.getInstrumentation()
    private val context = instrumentation.targetContext

    @Test
    fun packageName_isCorrect() {
        assertEquals("ro.cosminmihu.toast.test", context.packageName)
    }

    @Test
    fun toast_showsWithoutCrashing() {
        // Toast.makeText must run on a thread with a Looper (the main thread).
        instrumentation.runOnMainSync {
            context.toast {
                message("Instrumented test toast")
                short()
            }
        }
    }

    @Test
    fun toast_withoutMessage_isNoOp() {
        // No message set: show() should silently no-op, not throw.
        instrumentation.runOnMainSync {
            ToastBuilder(context).show()
        }
    }
}

