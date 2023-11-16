# 控制台

```text
=============================================================================================
Welcome to FISCO BCOS console(2.9.2)!
Type 'help' or 'h' for help. Type 'quit' or 'q' to quit console.
 ________ ______  ______   ______   ______       _______   ______   ______   ______
|        |      \/      \ /      \ /      \     |       \ /      \ /      \ /      \
| $$$$$$$$\$$$$$|  $$$$$$|  $$$$$$|  $$$$$$\    | $$$$$$$|  $$$$$$|  $$$$$$|  $$$$$$\
| $$__     | $$ | $$___\$| $$   \$| $$  | $$    | $$__/ $| $$   \$| $$  | $| $$___\$$
| $$  \    | $$  \$$    \| $$     | $$  | $$    | $$    $| $$     | $$  | $$\$$    \
| $$$$$    | $$  _\$$$$$$| $$   __| $$  | $$    | $$$$$$$| $$   __| $$  | $$_\$$$$$$\
| $$      _| $$_|  \__| $| $$__/  | $$__/ $$    | $$__/ $| $$__/  | $$__/ $|  \__| $$
| $$     |   $$ \\$$    $$\$$    $$\$$    $$    | $$    $$\$$    $$\$$    $$\$$    $$
 \$$      \$$$$$$ \$$$$$$  \$$$$$$  \$$$$$$      \$$$$$$$  \$$$$$$  \$$$$$$  \$$$$$$

=============================================================================================
```

## 指令

### `help([-h, -help, --h, --H, --help, -H, h])`

- 提供帮助信息
- Provide help information

### `addObserver`

- 添加观察者节点
- Add an observer node

### `addPeers`

- 将更多连接的对等体添加到节点p2p网络
- Add more connected peers to the node p2p network

### `addSealer`

- 添加密封器节点
- Add a sealer node

### `call`

- 通过函数和参数调用合约
- Call a contract by a function and parameters

### `callByCNS`

- 通过函数调用合同，通过CNS调用参数
- Call a contract by a function and parameters by CNS

### `chargeGas`

- 为指定帐户收取指定的气体
- Charge specified gas for the given account

### `create`

- 通过sql创建表
- Create table by sql

### `deductGas`

- 从给定的帐户中扣除指定的气体
- Deduct specified gas from the given account

### `delete`

- 按sql删除记录
- Remove records by sql

### `deploy`

- 在区块链上部署合同
- Deploy a contract on blockchain

### `deployByCNS`

- 通过CNS在区块链上部署合同
- Deploy a contract on blockchain by CNS

### `desc`

- 描述表信息
- Description table information

### `erasePeers`

- 删除节点p2p网络的连接对等端
- Remove connected peers of the node p2p network

### `quit([quit, q, exit])`

- 退出控制台
- Quit console

### `freezeAccount`

- 冻结帐户
- Freeze the account

### `freezeContract`

- 冻结合同
- Freeze the contract

### `generateGroup`

- 为指定节点生成组
- Generate a group for the specified node

### `generateGroupFromFile`

- 根据指定文件生成组
- Generate group according to the specified file

### `getAccountStatus`

- 帐户的GetAccountStatus
- GetAccountStatus of the account

### `getAvailableConnections`

- 获取与sdk连接的节点的连接信息
- Get the connection information of the nodes connected with the sdk

### `getBatchReceiptsByBlockHashAndRange`

- 根据区块哈希和交易范围获取批量交易收款
- Get batched transaction receipts according to block hash and the transaction range

### `getBatchReceiptsByBlockNumberAndRange`

- 根据区块号和交易范围获取批量交易单据
- Get batched transaction receipts according to block number and the transaction range

### `getBlockByHash`

- 通过哈希查询有关块的信息
- Query information about a block by hash

### `getBlockByNumber`

- 按编号查询块的信息
- Query information about a block by number

### `getBlockHashByNumber`

- 按块号查询块哈希
- Query block hash by block number

### `getBlockHeaderByHash`

- 通过哈希查询有关块标头的信息
- Query information about a block header by hash

### `getBlockHeaderByNumber`

- 按块号查询块标头的信息
- Query information about a block header by block number

### `getBlockNumber`

- 查询最近区块的数量
- Query the number of most recent block

### `getCode`

- 在给定地址查询代码
- Query code at a given address

### `getConsensusStatus`

- 查询共识状态
- Query consensus status

### `getContractStatus`

- 获取合同状态
- Get the status of the contract

### `getCryptoType`

- 获取当前加密类型
- Get the current crypto type

### `getCurrentAccount`

- 获取当前帐户信息
- Get the current account info

### `getDeployLog`

- 查询已部署合同的日志
- Query the log of deployed contracts

### `getGroupConnections`

- 获取连接到SDK的组的节点信息
- Get the node information of the group connected to the SDK

### `getGroupList`

- 查询组列表
- Query group list

### `getGroupPeers`

- 查询密封器和观察员节点的nodeId列表
- Query nodeId list for sealer and observer nodes

### `getNodeIDList`

- 查询所有连接节点的nodeId列表
- Query nodeId list for all connected nodes

### `getNodeInfo`

- 查询指定的节点信息。
- Query the specified node information.

### `getNodeVersion`

- 查询当前节点版本
- Query the current node version

### `getObserverList`

- 查询观察者节点的nodeId列表。
- Query nodeId list for observer nodes.

### `getPbftView`

- 查询节点的pbft视图
- Query the pbft view of node

### `getPeers`

- 查询当前连接到客户端的对等端
- Query peers currently connected to the client

### `getPendingTransactions`

- 查询挂起的交易记录
- Query pending transactions

### `getPendingTxSize`

- 查询待处理事务大小
- Query pending transactions size

### `getSealerList`

- 查询密封器节点的nodeId列表
- Query nodeId list for sealer nodes

### `getSyncStatus`

- 查询同步状态
- Query sync status

### `getSystemConfigByKey`

- 按键查询系统配置值
- Query a system config value by key

### `getTotalTransactionCount`

- 查询交易总数
- Query total transaction count

### `getTransactionByBlockHashAndIndex`

- 通过块哈希和事务索引位置查询有关事务的信息
- Query information about a transaction by block hash and transaction index position

### `getTransactionByBlockNumberAndIndex`

- 按块号和交易索引位置查询交易信息
- Query information about a transaction by block number and transaction index position

### `getTransactionByHash`

- 查询事务哈希请求的事务信息
- Query information about a transaction requested by transaction hash

### `getTransactionByHashWithProof`

- 通过交易哈希查询交易和交易凭证
- Query the transaction and transaction proof by transaction hash

### `getTransactionReceipt`

- 按交易哈希查询交易收据
- Query the receipt of a transaction by transaction hash

### `getTransactionReceiptByHashWithProof`

- 通过交易哈希查询收据和交易收据凭证
- Query the receipt and transaction receipt proof by transaction hash

### `grantCNSManager`

- 按地址授予CNS权限
- Grant permission for CNS by address

### `grantCharger`

- 授予给定帐户的收费权限
- Grant the charge permission for the given account

### `grantCommitteeMember`

- 授予账户委员会成员
- Grant the account committee member

### `grantContractStatusManager`

- 向用户授予合同授权
- Grant contract authorization to the user

### `grantContractWritePermission`

- 授予帐户合同写入权限。
- Grant the account the contract write permission.

### `grantDeployAndCreateManager`

- 授予部署协定的权限并按地址创建用户表
- Grant permission for deploy contract and create user table by address

### `grantNodeManager`

- 按地址授予节点配置权限
- Grant permission for node configuration by address

### `grantOperator`

- 授予帐户操作员
- Grant the account operator

### `grantSysConfigManager`

- 按地址授予系统配置权限
- Grant permission for system configuration by address

### `grantUserTableManager`

- 按表名和地址授予用户表的权限
- Grant permission for user table by table name and address

### `insert`

- 按sql插入记录
- Insert records by sql

### `listAbi`

- 列出合同的功能和事件信息。
- List functions and events info of the contract.

### `listAccount`

- 列出当前保存的帐户列表
- List the current saved account list

### `listCNSManager`

- 查询CNS的权限信息
- Query permission information for CNS

### `listChargers`

- 列出有权收取/扣除汽油的账户
- List the accounts that have the permission to charge/deduct gas

### `listCommitteeMembers`

- 列出所有委员会成员
- List all committee members

### `listContractStatusManager`

- 列出合同授权
- List the authorization of the contract

### `listContractWritePermission`

- 查询具有合同写入权限的账户列表。
- Query the account list which have write permission of the contract.

### `listDeployAndCreateManager`

- 查询部署合约的权限信息并创建用户表
- Query permission information for deploy contract and create user table

### `listDeployContractAddress`

- 列出指定合同的合同地址
- List the contractAddress for the specified contract

### `listNodeManager`

- 查询节点配置的权限信息
- Query permission information for node configuration

### `listOperators`

- 列出所有操作员
- List all operators

### `listSysConfigManager`

- 查询系统配置的权限信息
- Query permission information for system configuration

### `listUserTableManager`

- 用户表信息的查询权限
- Query permission for user table information

### `loadAccount`

- 交易记录签名的加载帐户
- Load account for the transaction signature

### `newAccount`

- 创建帐户
- Create account

### `queryCNS`

- 按合同名称和合同版本查询CNS信息
- Query CNS information by contract name and contract version

### `queryCommitteeMemberWeight`

- 查询委员权重
- Query the committee member weight

### `queryGroupStatus`

- 查询指定节点的指定组的状态
- Query the status of the specified group of the specified node

### `queryPeers`

- 查询配置的p2p网络连接节点列表
- Query the configured connected node list of the p2p network

### `queryRemainGas`

- 查询给定帐户的剩余气体
- Query remain gas for the given account

### `queryThreshold`

- 查询阈值
- Query the threshold

### `queryVotesOfMember`

- 查询委员会成员的投票。
- Query votes of a committee member.

### `queryVotesOfThreshold`

- updateThreshold操作的查询投票
- Query votes of updateThreshold operation

### `recoverGroup`

- 恢复指定节点的指定组
- Recover the specified group of the specified node

### `registerCNS`

- 注册给定合同的CNS信息
- RegisterCNS information for the given contract

### `removeGroup`

- 删除指定节点的指定组
- Remove the specified group of the specified node

### `removeNode`

- 删除节点
- Remove a node

### `revokeCNSManager`

- 按地址吊销CNS的权限
- Revoke permission for CNS by address

### `revokeCharger`

- 撤消给定帐户的收费权限
- Revoke the charge permission from the given account

### `revokeCommitteeMember`

- 撤销委员会成员的账户
- Revoke the account from committee member

### `revokeContractStatusManager`

- 撤销对用户的合同授权
- Revoke contract authorization to the user

### `revokeContractWritePermission`

- 撤销账户合同写入权限
- Revoke the account the contract write permission

### `revokeDeployAndCreateManager`

- 吊销部署合约的权限并按地址创建用户表
- Revoke permission for deploy contract and create user table by address

### `revokeNodeManager`

- 按地址吊销节点配置的权限
- Revoke permission for node configuration by address

### `revokeOperator`

- 吊销操作员
- Revoke the operator

### `revokeSysConfigManager`

- 按地址吊销系统配置权限
- Revoke permission for system configuration by address

### `revokeUserTableManager`

- 根据表名和地址吊销用户表的权限
- Revoke permission for user table by table name and address

### `switch([s])`

- 按组ID切换到特定组
- Switch to a specific group by group ID

### `select`

- 按sql选择记录
- Select records by sql

### `setSystemConfigByKey`

- 按键设置系统配置值
- Set a system config value by key

### `startGroup`

- 启动指定节点的指定组
- Start the specified group of the specified node

### `stopGroup`

- 停止指定节点的指定组
- Stop the specified group of the specified node

### `unfreezeAccount`

- 解冻帐户
- Unfreeze the account

### `unfreezeContract`

- 解除合同冻结
- Unfreeze the contract

### `update`

- 通过sql更新记录
- Update records by sql

### `updateCommitteeMemberWeight`

- 更新委员会成员权重
- Update the committee member weight

### `updateThreshold`

- 更新阈值
- Update the threshold
