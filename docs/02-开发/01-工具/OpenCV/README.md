# OpenCV

:::info
OpenCV 的全称是 Open Source Computer Vision Library，是一个跨平台的计算机视觉库。
OpenCV 是由英特尔公司发起并参与开发，以 BSD 许可证授权发行，可以在商业和研究领域中免费使用。
OpenCV 可用于开发实时的图像处理、计算机视觉以及模式识别程序。
该程序库也可以使用英特尔公司的 IPP 进行加速处理。

  [官网](https://opencv.org/)
| [官方文档](https://docs.opencv.org/)
| https://opencv.apachecn.org/
| http://www.woshicver.com/
:::

## `cv2.waitKey(delay: int)`

参数 `delay` 为等待的毫秒数，为 0 时将会无限期地等待一个按键事件。

```python
delay = 100
while True:
  cv2.waitKey(delay)
```

