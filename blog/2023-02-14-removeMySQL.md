# Windows 卸载 MySQL

01. 在控制面版中删除。
02. 检查目录：
    - `C:\Program Files\MySQL`
    - `C:\Program Files (x86)\MySQL`
    - `C:\ProgramData\MySQL`
03. 删除服务：
    
    ```shell
    sc delect MYSQL80
    ```

<!-- truncate -->