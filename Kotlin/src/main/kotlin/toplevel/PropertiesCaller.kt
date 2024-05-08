package toplevel

import toplevel.clickCount
import toplevel.LINE_SEPARATOR

fun click() {
    clickCount++
}

fun main() {
    for (i in (1..5)) click()

    print("Click count is $clickCount $LINE_SEPARATOR")
}