package reference.coroutines.flow

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
