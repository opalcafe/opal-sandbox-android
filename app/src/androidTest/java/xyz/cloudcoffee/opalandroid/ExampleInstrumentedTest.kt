package xyz.cloudcoffee.opalandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cloudcoffee.rigel.callCheck
import app.cloudcoffee.rigel.exam
import app.cloudcoffee.rigel.inspect
import app.cloudcoffee.rigel.report
import kotlinx.coroutines.delay
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    suspend fun getStrs(): String {
        return buildString {
            for(i in 1..10) {
                delay(10)
                appendLine("NUM->$i")
            }
        }
    }

    @Test
    fun useAppContext() {
        //Assert.assertTrue(false)
        report(Thread.currentThread().name)
        val myCall = callCheck()
        exam {
            myCall.call(this)
            report(Thread.currentThread().name)
            report("Hello there")
        }
        myCall.isCalled()
    }
}