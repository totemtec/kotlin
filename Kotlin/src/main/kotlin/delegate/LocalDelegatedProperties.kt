package delegate

class Foo() {
    fun isValid(): Boolean {
        return true
    }

    fun doSomething() {
        println("doSomething()")
    }
}

var control: Int = 10
/**
 * The memoizedFoo variable will be computed on first access only.
 * If someCondition fails, the variable won't be computed at all.
 */
fun example(computeFoo:() -> Foo) {
    val memoizedFoo by lazy(computeFoo)

    control--

    val someCondition = control % 2 == 0
    if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}

fun main() {
    example {
        Foo()
    }

    example {
        Foo()
    }

    example {
        Foo()
    }

    example {
        Foo()
    }
}