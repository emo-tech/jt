1、分布式锁
	Redission
	

2、jvm的图

2、mq保持一致性

3、乐观锁和悲观锁

cglib和jdk动态代理的区别


4、cglib和jdk动态代理的区别


mysql 索引 及其 优化

log4j log4j2 slf4j


线程锁 可重入锁  乐观锁/悲观锁  偏向锁  轻量级锁/重量级锁


Redis 缓存原理，对二级缓存搭建、 Redis 雪崩和击穿处理有一定了解

大数据 批量提交

Ehcache


Nacos 支持基于 DNS 和基于 RPC 的服务发现

RPC 的服务 是什么？

SpringBoot的自动装配原理 、  SpringBoot启动的原理

mysql 索引优化

mysql避免索引失效

b数 + b+数的区别

springcloud: nacos getway seata Sentinel openfeign


mysql索引优化
先存数据，在检索。 
数据里达到一定量以后在建索引

覆盖索引，

mysql索引失效

mybatis # $

mybatis-plus 如何进行mybatis的增强

spring openfein的协议

k8s管理docker的 好处

autowire为null时怎么排查

分布式事物 超卖

spring transactional 原理

spring aop 原理

spring ioc/di 的原理

ThreadLocal的实现原理

spring自己的容器里有哪些是aop的使用

mysql 锁多行数据（间隙锁）

vue react 区别

webpack好处， 

webpack vite 区别

docker

jvm classpath的原理

https://blog.csdn.net/zhinan11/article/details/120969042
https://www.runoob.com/w3cnote/mysql-index.html



SpringBoot的自动装配原理 、  SpringBoot启动的原理、



## SpringBoot

### SpringBoot的自动装配原理

> 自动装配主要是将第三方Bean装载到Spring IOC容器。 不需要开发人员再次手动写装配配置
>
> - 引入的starter组件的时候，这个组件需要包含一个@Configuration注解类，这个类中声明需要装配到 IOC 容器的对象
> - 这个第三方jar包，需要通过约定的配置，把配置类的全路径写到 spring.factories的文件中 () 。
>   springboot获取配置类的路径，主要是通过SpringFactoriesLoader
> - springboot拿到第三方jar声明的配置类后， 通过ImportSelector接口实现配置类的动态加载



### SpringBoot的 jar可以直接运行

> - 首先要一个插件spring-boot-maven-plugin， 打包成一个FAT-jar (jar包中有所有lib)
> - 通过java -jar 就会根据 manifest.mf 文件清单列表
> - 加载main-class指定的JarLauncher执行main方法，会创建lodaer（LaunchedURLClassLoader）加载jar包中的jar包
> - 开启一个新的线程 去加载Start-Class 运行





## JVM

### jvm classpath

> 是一个JVM环境变量，用来指示JVM如何找到class。
> 



### jvm classloader

> 111



### jvm 为什么有 栈内存和堆内存之分

> 111











## Mysql

### mysql 索引优化

>
> 
> 111
> 
> 
>  
> 
> 
> 
>



### 索引的优点

>



















## http有哪些特点

>- 灵活可扩展，可以添加头字段信息实现。 （传输的实体数据可缓存可压缩，可以分段获取数据）
>- 可靠协议传输，基于TCP/IP
>- 是应用层协议
>- 使用了请求 - 应答模式
>- 无状态， 每个请求相互独立
