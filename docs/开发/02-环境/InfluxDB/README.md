# InfluxDB

:::info
**InfluxDB** 是一个用于存储和分析时间序列数据的开源数据库。


  [OSS 文档](https://docs.influxdata.com/influxdb/v2.7/)
| [中文文档](https://jasper-zhang1.gitbooks.io/influxdb/content/)
| [下载安装 InfluxDB](https://docs.influxdata.com/influxdb/v2.7/install/)
| [下载安装 influx CLI](https://docs.influxdata.com/influxdb/cloud/tools/influx-cli/)
| [Chronograf](https://www.influxdata.com/time-series-platform/chronograf/)
:::

## Influx CLI

### 管理组织

参考：[Manage organizations](https://docs.influxdata.com/influxdb/v2.7/organizations/)

#### 本地添加组织

```bash
influx config create --config-name <config-name> \
  --host-url http://localhost:8086 \
  --org <your-org> \
  --token <your-auth-token> \
  --active
```

### 管理用户

参考：[Manage users](https://docs.influxdata.com/influxdb/v2.7/users/)

#### 添加用户

```bash
influx user create -n <username> -p <password> -o <org-name>
```

#### 修改用户密码

```bash
influx user password -n <username> -t <token>
```

## 示例代码

### 使用 `curl` 工具通过 WebAPI 发送数据

```bash
curl --request POST \
"http://localhost:8086/api/v2/write?org=YOUR_ORG&bucket=YOUR_BUCKET&precision=ns" \
  --header "Authorization: Token YOUR_API_TOKEN" \
  --header "Content-Type: text/plain; charset=utf-8" \
  --header "Accept: application/json" \
  --data-binary '
    airSensors,sensor_id=TLM0201 temperature=73.97038159354763,humidity=35.23103248356096,co=0.48445310567793615 1630424257000000000
    airSensors,sensor_id=TLM0202 temperature=75.30007505999716,humidity=35.651929918691714,co=0.5141876544505826 1630424257000000000
    '
```

### 使用 Python 的 request 库通过 WebAPI 发送数据

```python
import random
import time
import requests

PARAMS = {
    "org": "jvtc",
    "bucket": "test",
}

HEADERS = {
    "Authorization": "Token sLAqOjOFuDB0xjMIkRWoMqwPpHdW4Hqd2zqaRlvZEvnj5nO9AP5RttUNzG0w_jXiMA0LdymWaXSw1F6t3BKN1w==",
    "Content-Type": "text/plain; charset=utf-8",
    "Accept": "application/json",
}

while True:
    data = "A001 temp=" + str(random.randint(0, 100))
    r = requests.post(
        url="http://localhost:8086/api/v2/write",
        params=PARAMS,
        headers=HEADERS,
        data=data
    )
    print(r.status_code, data)
    time.sleep(1)
```