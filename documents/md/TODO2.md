关于Spring的transactional  - done
A、B分别被transactional修饰，A catch住了异常，B抛异常了，B会回滚，A不会回滚；-  will demo to try
关于数据库
在设计/创建一张表时需要注意哪些方面？- done
如何查询1千万后面的数据？ - limit - done
SpringBoot的自动化配置如何实现？怎么不自动加载某个配置项？如何引入自定义的配置项？- done
A、B、C系统如何达到事务一致？A、B都同步成功了，C没有同步成功，A、B如何回滚？
如何控制MQ里面数据的顺序性？- done
线程池里有依赖的任务，如果被依赖的任务时间有延迟，怎么办？- done
根据业务，加上对应的等待时间；feture.get(time, time单位)
2022.6.16 德意志银行
问了自己觉得最有挑战性的项目
然后结合自己说的项目问了问题：
设计模式的应用和举例，举了模板和装饰
j.u.c下有哪些类？
ReentranctLock如何实现的？
ReentranctLock是默认的是非公平锁
synchronized有几种锁?他想问的是锁的升级问题
偏、轻、重，(自旋到一定次数，并发高就升级到重量级锁了)
软件设计中如何高内聚低耦合
如何做测试用例？
SpringCloud有哪些组件？
是用maven部署测试的么？
项目有涉及到黑客攻击么？或者数据库攻击？
JWTS有用过么？
保费计算的规则是什么？如何利用了你的设计模式？怎么实现不同的parameter拿到不同的factor？
多线程处理共享变量时怎么做到线程安全的？
2022.6.17 大摩（全程英语2.5小时）
Linux命令知道么？ls -ltr 中的ltr分别表示什么意思？
Linux查看当前Linux容量的命令是什么？
Linux更改文件权限命令？
你们平时怎么部署的？怎么解决production问题的？（被问了3次）
tricky的问题最长多久就要fix？1h or others？（被问了2次）
Integer 、int的区别？为什么要有Integer？面试官想问的是装箱和拆箱
说一下static ，具体点，存在jvm哪里
一个static修饰的方法可以被override么？
如何让一个class不能被其他class继承
你怎么用一个static的方法，举例说明
说一下volatile
创建一个线程有几种方式？我说了Thread、Runnable、Callable
Runnable和Callable有什么区别
synchronized是什么？jdk1.6版本前后有什么区别？为什么之后的版本性能优化了？前后版本的一个线程和2个线程抢锁的时候有什么区别？
lock是什么？和synchronized的区别是什么？cas是什么？cas具体怎么比较的？你们平时用cas要注意什么？
rabbitmq怎么用的？怎么解决message missing的问题？（被问了2次）
rabbitmq和activemq有什么区别？和kafaka有什么区别，这个kafaka怪我自己，我自己提出来的；
rabbitmq的流程是什么？
Redis是怎么持久化数据的？你用来存储messageid的数据类型是什么？我说了用String。
Redis的每个broker是备份了所有机器的数据？还是备份了其中一台机器的数据？
Redis挂了怎么办？我说用了哨兵模式，客户端连接哨兵Sentinel, 再选举新的redis主节点
Do you know BlockingQueue? How does it work ?
我说了BlockingQueue利用lock来限制同一时刻只能input或者output
算法题，总体不算难，怪我自己算法不行，继续加油
题1： 需要先把TreeNode转一下序，只能有next指针，不能有previous指针，单向链表
题2： 实现一个BlockingQueue 或者下面的题，我选择了下面的题



英文自我介绍、项目介绍 (英文)
结合项目问的问题 (英文)
你怎么开会分配前端和后端的开发工作的？(英文) *


jdk1.8的新特性，我说了lamda，判空，接口的default，然后问了都怎么用的，判空我没有回答上来；*-done
你们code里面有很多try catch么？不觉得不优雅么？有没有什么更好的方式在一个地方统一处理异常？* -done
项目比如保单系统是怎么design的？*
我说了核心系统，外围还有外围系统
遇到一个产品线上的问题你是怎么解决的？你一个人解决的么还是跟同事一起解决的？
你平时是怎么针对这个技术问题的？是自己研究一些东西呢，还是通过项目来学习一些东西呢？
你怎么解决OOM问题的？有没有更好的优化思路？
你怎么想起来用线程池的呢？为什么要这么用？有没有更好的优化方式？
你用了SpringCloud的什么组件？
你们系统间是rpc调用么？说一下这个调用过程 *
你对你未来的职业规划是什么？



pwc技术栈？