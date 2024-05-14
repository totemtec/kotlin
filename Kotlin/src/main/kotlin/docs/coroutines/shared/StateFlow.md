# StateFlow

- 热流
- 表示一个状态
- 一次只持有 1 个值，而且只保持最新值，一旦有新值，立即持有新值并发给 Collector
- 必须有初始值
- 多个 Collector，可以拿到相同的 value
- 多用于持有状态，并自动分发最新状态给 Collector
