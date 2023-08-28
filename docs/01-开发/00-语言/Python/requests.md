# requests

:::info
Requests 唯一的一个非转基因的 Python HTTP 库，人类可以安全享用。

[GitHub](https://github.com/psf/requests)
| [pypi.org](https://pypi.org/project/requests/)
| [官方文档](https://requests.readthedocs.io/en/latest/)
| [中文文档](https://requests.readthedocs.io/projects/cn/zh_CN/latest/)
:::

## 请求

### 通过 `form-data` 发送文件

```python
import requests

POST_HOST = 'http://localhost:3000/upload'
jpg = open('image.jpg', 'rb')

response = requests.post(POST_HOST, files={'image': ('image.jpg', jpg.tobytes())})
```

## 响应

### 读取 Json 响应

```python
import requests

requests.get('https://api.github.com/events')
response.json().get('xxx')
```

