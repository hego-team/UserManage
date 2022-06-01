## 初始化

1. 改application.yml配置。

2. 运行sql文件初始化数据库数据。

   

## 备注

1. webapp不知道是干啥生成的，没用上好像。

2. 测试文件没做好，只能检测返回的报文格式，具体内容手动检查。

3.参考https://github.com/laolunsi/SsmDemo2.0

   

## 请求接口

### 用户相关请求：

1. 使用session控制用户登录状态。
2. 通过对用户表操作实现登录，登出，注册，注销（删号），改密，改信息。

##### 打开页面

GET http://localhost:8080/api/

没有前端，未实现。

##### 进入已登录界面？

GET http://localhost:8080/api/admin

没有前端，未实现。



##### 登录

POST http://localhost:8080/api/login?name=Default&password=Default

- 参数：用户名、密码。

返回的json示例：（登录用户的全部的用户信息，role表示用户权限等级，目前没有用；lastLoginTime是上次登录时间，目前没有用；）

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": {
        "user": {
            "id": 1,
            "name": "Default",
            "password": "Default",
            "role": 1,
            "email": "1111111111@qq.com",
            "lastLoginTime": 1653955582967
        }
    }
}
```

其他示例：

http://localhost:8080/api/login?name=John&password=111111



##### 登出

GET http://localhost:8080/api/logout

- 无参数。
- 退出当前账户。

json示例：返回成功或错误信息。

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```





##### 注册

POST http://localhost:8080/api/register?name=John&password=111111&rePassword=111111&email=john@163.com

- 参数：用户名、密码、重复密码、邮箱信息（可选）

json示例：

（目前不能检查email格式；目前密码只有位数限制；用户名有非重复限制；成功返回用户信息；失败返回错误类型提示；通过注册只能添加0级普通账户；）

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": {
        "user": {
            "id": 2,
            "name": "John",
            "password": "111111",
            "role": 0,
            "email": "john@163.com",
            "lastLoginTime": 1653956412000
        }
    }
}
```



##### 注销（删除）账户

DELETE http://localhost:8080/api/user/delete

- /

- 无参数，注销当前用户。

json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```





##### 改信息

POST http://localhost:8080/api/user/save?name=John&email=11111@qq.com

- 根据当前session中用户id查找，修改名称、邮箱个人信息。

json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```





##### 改密

PUT http://localhost:8080/api/user/change_password?oldPass=111111&newPass=222222&reNewPass=222222

- 参数：旧密、新密、重复新密。

json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```





### 收藏夹相关请求。 TAGS:

1. 对数据表操作实现了收藏夹的增删改查。
2. 条目有name不能重复限制，方便不根据id（主键）而根据name修改删除。
3. 无用户登录状态不提供收藏功能。（如果意外发出收藏请求，返回信息”请先登录”）。

##### 添加条目

POST http://localhost:8080/api/tags/add?newname=1111&newurl=xxxxx

- 参数：新条目名称、新条目url。

返回json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": "已添加到收藏夹",
    "data": null
}
```



##### 获得当前用户的收藏夹

GET http://localhost:8080/api/tags/list

- 无参数。

返回json示例：返回当前用户（owner）的所有收藏条目。

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": {
        "tagsList": [
            {
                "id": 2,
                "owner": "John",
                "name": "1111",
                "url": "xxxxx"
            },
            {
                "id": 3,
                "owner": "John",
                "name": "2222",
                "url": "yyyyy"
            }
        ]
    }
}
```



##### 删除条目

DELETE http://localhost:8080/api/tags/delete?name=1111
//按名称删除收藏夹项。

返回json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```



##### 编辑收藏夹项

POST http://localhost:8080/api/tags/save?oldname=百度一下，也不知道&newname=百度一下，你就知道&newurl=https://www.baidu.com

- 按名称编辑收藏夹项。

- 此示例的数据是由sql脚本生成的初始数据，在Default用户的收藏夹内。

返回json示例：返回成功或失败信息

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```





### 历史记录相关请求。HIS：

1. 通过操作数据库实现历史记录的增删查（两种）。
2. 条目添加无限制。
3. 无登录状态不保存历史记录。

##### 搜索时自动触发添加

POST http://localhost:8080/api/his/add?newcontent=1111

- 可多次添加相同项通过times++计频数。
- 添加条目到当前用户历史记录中。

返回json示例：返回成功或失败（当前无用户登录），均无提示信息。

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```

其他示例：

http://localhost:8080/api/his/add?newcontent=2222

http://localhost:8080/api/his/add?newcontent=3333



##### 删除

DELETE http://localhost:8080/api/his/delete?content=1111

- 通过content项查询当前用户历史并删除。

返回json示例：返回成功或失败提示信息。

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": null
}
```



##### 时间排序查看

GET http://localhost:8080/api/his/list/default

- 返回按加入顺序（从早到晚，前端展示可能要逆序）排列的搜索历史记录。
- 无参数，default表示默认顺序。
- 只能查看当前用户的历史记录。

返回json示例：

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": {
        "hisList": [
            {
                "id": 1,
                "owner": "Default",
                "content": "1111",
                "times": 2
            },
            {
                "id": 3,
                "owner": "Default",
                "content": "2222",
                "times": 1
            },
            {
                "id": 4,
                "owner": "Default",
                "content": "3333",
                "times": 3
            }
        ]
    }
}
```



##### 频度排序查看

GET http://localhost:8080/api/his/list/sort

- 返回按频度顺序（从高频到低频）排列的搜索历史记录。
- 无参数，sort表示频度顺序。
- 只能查看当前用户的历史记录。

返回json示例：

```json
{
    "code": null,
    "success": true,
    "msg": null,
    "data": {
        "hisList": [
            {
                "id": 4,
                "owner": "Default",
                "content": "3333",
                "times": 3
            },
            {
                "id": 1,
                "owner": "Default",
                "content": "1111",
                "times": 2
            },
            {
                "id": 3,
                "owner": "Default",
                "content": "2222",
                "times": 1
            }
        ]
    }
}
```



