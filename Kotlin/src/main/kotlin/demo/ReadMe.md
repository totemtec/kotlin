# 教程文档

https://juejin.cn/post/6908271959381901325

## 基础概念

### 使用场景
- 耗时操作，比如IO，网络请求，CPU耗时计算(几十毫秒以上)
- 延迟

### suspend function 挂起函数

- 挂起函数只能由协程或者由其它挂起函数来调用
- 挂起函数不会阻塞其所在线程，而是会将协程挂起，在特定的时候才再恢复执行
- suspend 关键字只是声明，什么时候挂起由函数内部决定，比如 withContext(Dispatchers.IO){ ... } 开始才会真的挂起
- resume 用于让已暂停的协程从暂停处继续执行

### CoroutineScope 协程作用域
- 用于对协程进行生命周期跟踪及管理
- Kotlin 不允许在没有 CoroutineScope 的情况下启动协程
- ViewModel 有 viewModelScope，Lifecycle 有 lifecycleScope
- GlobalScope 全局协程作用域，在这个范围内启动的协程可以一直运行直到应用停止运行。日常开发中应该谨慎使用 GlobalScope
- runBlocking 一个顶层函数，不是挂起函数，和 GlobalScope 不一样，它会阻塞当前线程直到其内部所有相同作用域的协程执行结束
- coroutineScope 一个顶层函数，函数用于创建一个独立的协程作用域，直到所有启动的协程都完成后才结束自身
- supervisorScope 函数用于创建一个使用了 SupervisorJob 的 coroutineScope，该作用域的特点就是抛出的异常不会连锁取消同级协程和父协程
- 自定义作用域

### CoroutineBuilder 携程构建器
- launch
- Job
- async
- await
- Deferred

### CoroutineContext 携程上下文
使用以下元素集定义协程的行为：
- Job：控制协程的生命周期
- CoroutineDispatcher：将任务指派给适当的线程
- CoroutineName：协程的名称，可用于调试
- CoroutineExceptionHandler：处理未捕获的异常
- 组合上下文元素
- withContext
- 