package app.cloudcoffee.opal.example

import app.cloudcoffee.opal.api.AuthResult
import app.cloudcoffee.opal.api.CloudResult
import app.cloudcoffee.opal.api.OpalAuth
import app.cloudcoffee.rigel.exam
import app.cloudcoffee.rigel.report
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class FakeAuth: OpalAuth {
    override suspend fun loginUserPassword(
        email: String,
        password: String
    ): CloudResult<AuthResult> {
        return CloudResult.success(AuthResult("user-123"))
    }
}

@RunWith(JUnit4::class)
class MovieTest {

    @Test
    fun testMovie() {

        val mySeal = SealExample.Movie
        report("Heya")

        exam {
            report(mySeal.myFunc())
        }
    }

    @Test
    fun testLogin() {
        exam {
            val opalAuth = FakeAuth()

            val login1 = opalAuth.loginUserPassword("", "")
            val login2= opalAuth.loginUserPassword("", "")

            CloudResult.allSuccessful(login1, login2) {

            }
        }
    }
}