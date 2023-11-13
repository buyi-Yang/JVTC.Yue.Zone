# Vue

:::info
Vue (发音为 /vjuː/，类似 view) 是一款用于构建用户界面的 JavaScript 框架。它基于标准 HTML、CSS 和 JavaScript 构建，并提供了一套声明式的、组件化的编程模型，帮助你高效地开发用户界面。无论是简单还是复杂的界面，Vue 都可以胜任。

[Vue3](https://cn.vuejs.org/)
| [Vue2](https://v2.cn.vuejs.org/)
| [工具链](https://cn.vuejs.org/guide/scaling-up/tooling.html)
:::

## 开始使用 Vue 

请先安装：[Node.js](https://nodejs.org/en)

安装vue脚手架:
```sh
npm install - g @vue/cli
```

查看是否成功：
```sh
vue -version
```

创建项目
```sh
npm create vue@latest
```

切换项目目录：
```sh
cd <项目名称>
```

下载依赖包：
```sh
npm install
```

#### 注意：element2和3有区别，vue2不能用element-plus！
下载插件：
```sh
npm install -s element-ui       --element2
npm install -s element-plus     --element3
```

运行项目：
```sh
npm run dev
```

## 项目结构

```text
Node_modules       = 用来存放包管理工具下载安装的包的文件夹
Public             = 公共资源
Src                = 源文件夹
browerslistrc      = 项目配置工具
.gitignore  	   = git配置
Babel.Config.js	   = 转码器
Package.json	   = 项目依赖文件
Readme.md 	       = 说明文档
Yarn.lock	       = 文件备件及避免意外修改
```
## 创建实例项
```text
data      =   提供数据
methods   =   提供方法

```

### 指令
```text
v-show 底层逻辑：切换css的display: none 来控制显示隐藏      简单显示隐藏，适用于频繁显示的场景
v-if   底层逻辑：根据 判断条件控制元素的创建和移除           条件渲染，适用于很少显示的场景
v-if-else   底层逻辑：条件判断渲染  需要是或否的场景使用，且必须有v-if才能使用v-else
v-else-if   底层逻辑：条件判断渲染  需要判断多数的场景使用，
``` sh 
语法：
<div v-if="Math.random() > 0.5">是</div><div v-else>否</div>
<div v-if="yes === yes"></div><div v-else-if="表达式"></div>
```
v-on        底层逻辑：注册事件 = 添加监听 + 提供处理逻辑    缩写：@
``` sh
语法：
v-on: 事件名 = "内联语句"
v-on: 事件名 = "methods中的函数名"
@click="函数名(参数1, 参数2)"   
```
v-bind      底层逻辑：动态设置标签属性                      缩写： [:]
```sh
语法：
v-bind: 属性名="表达式"
进阶语法：
:class = "对象/数组"    对象是类名，值是布尔值，true有，否则无，数组中所有的类都会被添加
```
v-for       底层逻辑： 基于数据循环，多次渲染整个元素
```sh
语法：
v-for = "(item, index) in 数据"
item = 每一项， index = 下标
```
v-key      给列表添加唯一标识，便于vue进行表项的正确排序服用。
```sh
:key = "唯一标识"
```
v-model     底层逻辑：给表单元素使用，双向数据绑定，可以快速获取或设置表单元素内容
```sh
语法：
v-model = "变量"
```


``` 
# 指令修饰符
::: info
    @keyup.enter        =   键盘回车监听
    v-model.trim        =   去除首尾空格
    v-model.number      =   转数字
    @事件名.stop        =   阻止冒泡
    @事件名.prevent     =   阻止默认行为
:::

