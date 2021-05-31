package reference.coroutines.flow

// Sequence计算过程阻塞运行该代码的主线程
private fun simple(): Sequence<Int> = sequence { // 序列构建器
    for (i in 1..3) {
        Thread.sleep(100) // 假装我们正在计算
        yield(i) // 产生下一个值
    }
}

fun main() {
    simple().forEach { value -> println(value) }
}