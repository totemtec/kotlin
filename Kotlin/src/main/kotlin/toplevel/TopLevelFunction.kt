package toplevel

fun joinToString(list: List<String>): String {
    val sb = StringBuilder("")

    list.forEachIndexed { index, str ->
        if (index > 0) {
            sb.append(",")
        }
        sb.append(str)
    }

    return sb.toString()
}