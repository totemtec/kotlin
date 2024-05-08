package extensions.strings

fun String.lastWord(): String {
    var spaceIndex = this.lastIndexOf(" ")
    return substring(spaceIndex+1)
}