# SharedFlow

- 热流，emit 独立于 Collector
- 多个 Collector，可以拿到相同的 value
- 多用于广播，多个订阅者
- 可以没有初始值
- 可以配置 replay 缓存数量，新的 Collector 可以拿到缓存里的值
