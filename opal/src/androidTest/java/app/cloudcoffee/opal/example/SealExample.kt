package app.cloudcoffee.opal.example

private fun doMovie(): String {
    return "do Movie"
}

sealed class SealExample(val myFunc: () -> String) {
    object Movie: SealExample(::doMovie)

}