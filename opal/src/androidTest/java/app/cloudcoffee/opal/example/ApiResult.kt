package app.cloudcoffee.opal.example

import java.lang.Exception


sealed class ApiResult<out T: Any> {
    data class Success<out T: Any>(val result: T):      ApiResult<T>()
    data class Error(val exception: Exception):         ApiResult<Nothing>()
}


fun handle(apiResult: ApiResult<String>) {
    val reso = when(apiResult) {
        is ApiResult.Success -> {
            
        }
        is ApiResult.Error -> {

        }
    }
}

fun example() {




}