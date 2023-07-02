# Jupyter

:::info
| [官网](https://jupyter.org/)
| [文档](https://docs.jupyter.org/en/latest/)
| [JupyterHub 文档](https://jupyterhub.readthedocs.io/en/stable/)
| [Littlest JupyterHub 文档](https://tljh.jupyter.org/en/latest/)
| [Ipynb.Yue.Zone](https://github.com/Yue-plus/Ipynb.Yue.Zone)
|
:::

## 安装

* 参考官网 [安装 Jupyter](https://jupyter.org/install)
* [Anaconda](/docs/开发/工具/包管理器/Anaconda/) 中就包含了 JupyterLab 和 Jupyter Notebook。
* [DataSpell](https://www.jetbrains.com/zh-cn/dataspell/) 专业数据科学家的 IDE
* [Datalore](https://www.jetbrains.com/zh-cn/datalore/) 在线协作平台
* [Deepnote](https://deepnote.com/home) 在线协作平台

## 配置 JupyterLab

### 安装中文语言包

```text
(base) PS C:\Users\Yue_plus> pip install jupyterlab-language-pack-zh-CN
Defaulting to user installation because normal site-packages is not writeable
Collecting jupyterlab-language-pack-zh-CN
  Downloading jupyterlab_language_pack_zh_CN-3.5.post2-py2.py3-none-any.whl (130 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.5/130.5 kB 1.1 MB/s eta 0:00:00
Installing collected packages: jupyterlab-language-pack-zh-CN
Successfully installed jupyterlab-language-pack-zh-CN-3.5.post2
```

重启 JupyterLab 然后点 **Settings** → **Language** 选简体中文就好了。