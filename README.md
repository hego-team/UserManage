# 用户管理系统（未测试）

##  表设计
### 用户表

这里为了简洁，用户模块只设计了账号和密码

```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

### 收藏夹表

相关的收藏价信息

```sql
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

## 插件
### 逆向工程

用于快速生成开发中不断重复的代码，比如说实体类，映射层接口，以及Mybatis XML文件的编写，只需要提供数据库连接的jar地址，数据库名称，账号密码即可一键生成：实体类，Mapper接口，Mapper映射文件。

例如生成的映射文件：

其中已经帮我们生成了基本的增加、删除、更新方法。

|方法名称| 方法作用 | 方法说明 |
|:--|:--|:--|
| selectByPrimaryKey | 根据主键查询 | 主键是必须的参数 |
| deleteByPrimaryKey | 根据主键删除 | 主键是必须的参数 |
| insert | 插入一条数据，| **除了id之外，必须要有每个字段值** |
| insertSelective | 插入一条数据 | **只会插入不为空的字段** |
| updateByPrimaryKeySelective | 根据主键更新数据 | **更新的是传入参数不为空的字段** |
| updateByPrimaryKey | 根据主键更新数据 | **更新所有字段** |

### Lombok 插件

lombok 提供了简单的注解的形式来帮助我们简化消除一些必须有但显得很臃肿的 java 代码。通过使用对应的注解，可以在编译源码的时候生成对应的方法，所以不会影响任何运行效率。

```java
import lombok.Data;

@Data 
public class Star {
   private Long id;
    private String name;
    private String url;
}
```

**常用Lombok注解**

|注解名称| 注解使用位置以及作用 |
|:--|:--|
| @Data |  注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法 |
| @Setter |  注解在属性上；为属性提供 setting 方法 |
| @Setter |  注解在属性上；为属性提供 getting 方法 |
| @Log4j | 注解在类上；为类提供一个 属性名为log 的 log4j 日志对象 |
| @NoArgsConstructor | 注解在类上；为类提供一个无参的构造方法 |
| @AllArgsConstructor  | 注解在类上；为类提供一个全参的构造方法 |
| @Cleanup  | 可以关闭流 |
| @Builder  | 被注解的类加个构造者模式 |
| @Synchronized  | 加个同步锁 |
| @SneakyThrows  | 等同于try/catch 捕获异常 |
| @NonNull  | 如果给参数加个这个注解 参数为null会抛出空指针异常 |
| @Value  | 注解和@Data类似，区别在于它会把所有成员变量默认定义为private final修饰，并且不会生成set方法 |

## 项目启动

是后台使用的端口是8080，要是端口被占用的话，修改 application.yml 文件中的 server.port 即可
