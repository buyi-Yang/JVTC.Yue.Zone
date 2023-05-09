# InfluxDB

:::info
**InfluxDB** 是一个用于存储和分析时间序列数据的开源数据库。


  [OSS 文档](https://docs.influxdata.com/influxdb/v2.7/)
| [中文文档](https://jasper-zhang1.gitbooks.io/influxdb/content/)
:::

## Influx CLI

### 配置组织

```bash
influx config create --config-name <config-name> \
  --host-url http://localhost:8086 \
  --org <your-org> \
  --token <your-auth-token> \
  --active
```
