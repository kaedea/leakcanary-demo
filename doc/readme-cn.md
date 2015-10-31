## LeakCanary Demo
Square 今年年初开源了一个用于检测应用内存泄露的工具库 LeakCanary，方便开发者尽早发现项目里出现内存泄露的地方，能有效地减少OOM。

本项目是 LeakCanary 的一个 Demo 项目，包含了 LeakCanary 的用法，也展示了一种常见的内存泄露的“坏味道”的代码。

### 项目结构
项目包结构请参考以下表格

| 包名 | 描述 | 
| :------- | :------ | 
| home | 总列表，可以不用关心这里的代码 |
| localvariable | 局部变量泄露的情形 |
| activityleak | Activity泄露的情形 |
| fragmentleak | Fragment泄露的情形 |
| viewleak | View泄露的情形 |
| singleton | 会引起内存泄露的单例的写法 |
| application | 会引起内存泄露的Application的用法 |

### 预览
![](preview.jpg)

