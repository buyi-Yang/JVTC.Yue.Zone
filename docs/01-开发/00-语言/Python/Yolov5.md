# Yolov5

:::info
YOLOv5🚀是一个在COCO数据集上预训练的物体检测架构和模型系列，它代表了Ultralytics对未来视觉AI方法的公开研究，
其中包含了在数千小时的研究和开发中所获得的经验和最佳实践。

[GitHub](https://github.com/ultralytics/yolov5/blob/master/README.zh-CN.md)
:::

## 本地部署

```sh
git clone https://github.com/ultralytics/yolov5.git
cd yolov5
conda create --name yolov5 python=3.11
conda activate yolov5
pip install -i http://mirrors.aliyun.com/pypi/simple/ -r ./requirements.txt --trusted-host mirrors.aliyun.com
# pip install -i https://pypi.tuna.tsinghua.edu.cn/simple -r ./requirements.txt
```

## 运行检测

```text
Run YOLOv5 detection inference on images, videos, directories, globs, YouTube, webcam, streams, etc.

Usage - sources:
    $ python detect.py --weights yolov5s.pt --source 0                               # webcam
                                                     img.jpg                         # image
                                                     vid.mp4                         # video
                                                     screen                          # screenshot
                                                     path/                           # directory
                                                     list.txt                        # list of images
                                                     list.streams                    # list of streams
                                                     'path/*.jpg'                    # glob
                                                     'https://youtu.be/Zgi9g1ksQHc'  # YouTube
                                                     'rtsp://example.com/media.mp4'  # RTSP, RTMP, HTTP stream

Usage - formats:
    $ python detect.py --weights yolov5s.pt                 # PyTorch
                                 yolov5s.torchscript        # TorchScript
                                 yolov5s.onnx               # ONNX Runtime or OpenCV DNN with --dnn
                                 yolov5s_openvino_model     # OpenVINO
                                 yolov5s.engine             # TensorRT
                                 yolov5s.mlmodel            # CoreML (macOS-only)
                                 yolov5s_saved_model        # TensorFlow SavedModel
                                 yolov5s.pb                 # TensorFlow GraphDef
                                 yolov5s.tflite             # TensorFlow Lite
                                 yolov5s_edgetpu.tflite     # TensorFlow Edge TPU
                                 yolov5s_paddle_model       # PaddlePaddle

```

## 使用 GPU 训练自己的数据集

### NVIDIA CUDA

首先确保自己有一块支持 CUDA 的 GPU。
[查看自己的 GPU 是否支持 CUDA](https://developer.nvidia.com/cuda-gpus)。

下载安装 [CUDA toolkit](https://developer.nvidia.com/cuda-downloads)。
安装完成后可能需要配置 `Path` 环境变量（看看自己的安装位置）：`C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v12.1\bin`。

使用 `nvcc -V` 查看 CUDA 版本：

```text {1}
$ nvcc.exe -V
nvcc: NVIDIA (R) Cuda compiler driver
Copyright (c) 2005-2023 NVIDIA Corporation
Built on Mon_Apr__3_17:36:15_Pacific_Daylight_Time_2023
Cuda compilation tools, release 12.1, V12.1.105
Build cuda_12.1.r12.1/compiler.32688072_0
```

查看自己安装的 torch：

```ps {1}
(yolov5) PS D:\yolo\v5> conda list | findstr torch
torch                     2.0.1                    pypi_0    pypi
torchvision               0.15.2                   pypi_0    pypi
```

按照 [本地部署](#本地部署) 安装的是使用 CPU 计算的 torch，现在需要卸载它，安装使用 CUDA 计算的 torch：

参考 [PyTorch 官网](https://pytorch.org/get-started/locally/) 下载安装 CUDA 版：

```ps
# 文件很大，你忍一下（1.36G）
conda install pytorch torchvision torchaudio pytorch-cuda=11.8 -c pytorch -c nvidia

# 不知道为啥少个包↓
pip install chardet

# 训练过程中提示需要的包（但不装也能跑）↓
# pip install clearml comet_ml
```

#### Error #15: Initializing libiomp5md.dll, but found libiomp5md.dll already initialized.

```text
OMP: Error #15: Initializing libiomp5md.dll, but found libiomp5md.dll already initialized.
OMP: Hint This means that multiple copies of the OpenMP runtime have been linked into the program. That is dangerous, since it can degrade performance or cause incorrect results. The best thing to do is to ensure that only a single OpenMP runtime is linked into the process, e.g. by avoiding static linking of the OpenMP runtime in any library. As an unsafe, unsupported, undocumented workaround you can set the environment variable KMP_DUPLICATE_LIB_OK=TRUE to allow the program to continue to execute, but that may cause crashes or silently produce incorrect results. For more information, please see http://www.intel.com/software/products/support/.
```

设置环境变量：

`KMP_DUPLICATE_LIB_OK` : `TRUE`

### AMD ROCm

[官方网站](https://www.amd.com/zh-hans/graphics/servers-solutions-rocm-ml)
| [官方文档](https://rocm.docs.amd.com/en/latest/)
| [GPU 与系统兼容性（Linux）](https://rocm.docs.amd.com/en/latest/release/gpu_os_support.html)
| [GPU 与系统支持（Windows）](https://rocm.docs.amd.com/en/latest/release/windows_support.html)
| [GitHub](https://github.com/RadeonOpenCompute/ROCm)

综上所述目前 PyTorch 2.x 并不支持在 Windows 上使用 ROCm。

#### DirectML

:::caution
Torch-directml 软件包仅支持 PyTorch 1.13。
:::

参考：[在 Windows 上使用 DirectML 启用 PyTorch](https://learn.microsoft.com/en-us/windows/ai/directml/gpu-pytorch-windows)
| [在 WSL 2 上通过 DirectML 启用 PyTorch](https://learn.microsoft.com/zh-cn/windows/ai/directml/gpu-pytorch-wsl)
