# IPv6

## 禁用 IPv6 内置内核模块（永久禁用）

> [How to Disable IPv6 on Ubuntu 22.04 LTS Jammy Jellyfish – The Geek Diary](https://www.thegeekdiary.com/how-to-disable-ipv6-on-ubuntu-22-04-lts-jammy-jellyfish/)

01. 修改 `/etc/default/grub` 文件：

    ```diff
    - GRUB_CMDLINE_LINUX_DEFAULT=""
    - GRUB_CMDLINE_LINUX=""
    + GRUB_CMDLINE_LINUX_DEFAULT="ipv6.disable=1"
    + GRUB_CMDLINE_LINUX="ipv6.disable=1"
    ```

02. 运行以下命令从新生成 `grub.cfg` 文件：

    ```shell
    sudo update-grub
    ```

03. 重启系统生效：

    ```shell
    sudo reboot
    ```
