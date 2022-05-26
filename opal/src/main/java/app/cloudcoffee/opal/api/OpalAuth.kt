package app.cloudcoffee.opal.api


class AuthResult(val userUid: String) {

}

interface OpalAuth {
    suspend fun loginUserPassword(email: String, password: String): CloudResult<AuthResult>
}