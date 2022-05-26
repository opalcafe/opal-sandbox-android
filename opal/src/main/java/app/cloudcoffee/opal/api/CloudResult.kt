package app.cloudcoffee.opal.api

import app.cloudcoffee.opal.global.EMPTY_CALLBACK
import java.lang.Exception

class CloudResult<T> private constructor(private val result: T?,
                                         private val exception: Exception?) {

    companion object {
        fun <T> success(successValue: T): CloudResult<T> {
            return CloudResult(successValue, null)
        }
        fun <T> failed(exception: Exception): CloudResult<T> {
            return CloudResult(null, exception)
        }

        fun <T> allSuccessful(vararg results: CloudResult<T>, callbackIfSuccess: () -> Unit) {
            val allResultsAreSuccess = results.all { it.isSuccess() }
            if(allResultsAreSuccess)
                callbackIfSuccess()
        }
        fun <T> anyFailed(vararg results: CloudResult<T>, callbackIfAnyFailed: () -> Unit) {
            val allResultsAreSuccess = results.all { it.isSuccess() }
            if(!allResultsAreSuccess)
                callbackIfAnyFailed()
        }
    }

    fun isSuccess(): Boolean {
        return exception == null
    }
    fun isFailed(): Boolean {
        return exception != null
    }

    fun onSuccess(callbackIfSuccess: () -> Unit = EMPTY_CALLBACK): CloudResult<T> {
        if(isSuccess())
            callbackIfSuccess()
        return this
    }

    fun onFailed(callbackIfFailed: () -> Unit): CloudResult<T> {
        if(!isSuccess())
            callbackIfFailed()
        return this
    }
}