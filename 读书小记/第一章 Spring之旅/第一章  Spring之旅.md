第一章  Spring之旅
--
总结
==

前言
==

在诞生之初，创建spring的主要目的就是用来**替代更加基重量级的企业级Java技术**，尤其是EJB,相对于EJB，Spring提供了更加轻量级和简单的编程模型。

为降低java开发的复杂性，spring采取的四种策略
==

- 基于[POJO](http://www.jianshu.com/p/6f3e2bd50cb1)的轻量级和最小侵入性编程
- 通过[依赖注入](http://www.jianshu.com/p/9ea1a9bce19f)和面向接口实现松耦合
- 基于切面和管理进行声明式编程
- 通过切面和模板减少样板式代码

什么是最小侵入性编程？
==

一些框架要求继承他们提供的类或现他们的接口儿导致应用和框架绑死，这是侵入性编程。而具有最小侵入性编程的框架不会强迫这些，最坏的情况是需要使用注解。
```
public class HelloWorld{
    public void sayHello(){
        System.out.println("Hello World!");
    }
}
```
这是一个非常简单的Java类（POJO），Spring赋予POJO魔力的方式之一就是**通过DI（依赖注入）来装配他们，帮助应用对象之间保持低耦合**。

一个简单的勇者骑士类
==

BraveKnight.class
```
public class BraveKnight implements Knight {
   
    //拯救少女任务
    private RescueDamselQuest quest;
    
    public BraveKnight(){
        this.quest = new RescueDamselQuest();
    }
    
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
```
BraveKnight和RescueDamselQuest紧密的耦合在一起。

耦合具有两面性，一方面，高耦合度代码难以复用·难以测试·难以理解，当修复一个bug时，将会出现一个或更多bug。另一方面，一定程度的耦合度是必须的 —— 完全没有耦合的代码什么也做不了。

对象的依赖关系将由**系统中负责协调对象的第三方组件**在创建对象的时候进行设定，对象无需自行创建或管理他们的依赖关系。

![第三方组件][1]

"灵活"的勇敢骑士：构造注入
==

BraveKnight.class
```
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
```

`BraveKnight` 没有自行创建探险任务，而是在构造的时候把`Quest`作为构造器参数传入，这是依赖注入的方式之一：**构造器注入**

如果一个对象只通过接口（而不是具体实现或者初始化过程）来表明依赖关系，那么这种依赖关系就能够在对象本身毫不知情的情况下，用不同的具体实现进行替换。

测试：
BraveKnightTest.class
```
public class BraveKnightTest{
    @Test
    public void knightShouldEmbarkQuest(){
        // 创建 mock Quest
        // 在测试对象BraveKnight时候 我们构造一个假的Quest对象来与BraveKnight交互
        Quest mockQuest = mock(Quest.class);
        // 注入 mock Quest
        BraveKnight braveKnight = new BraveKnight(mockQuest);
        braveKnight.embarkOnQuest();
        // 验证Quest中的embark()方法是否被调用 且 仅被调用1次
        verify(mockQuest,times(1)).embark();
    }
}
```

其中：
```
verify(mockQuest,times(1)).embark();
```
可以验证`Quest`的`embark()`方法被调用且仅仅被调用一次。
如果注释掉```BraveKnight```类中的如下代码：
```
// ... ...
@Override
    public void embarkOnQuest() {
        // unless console :
        // quest.embark();  
    }
```

控制台中将会出现以下提示：
![Wanted but not invoked][2]

下面写一个新的Quest实现：
SlayDragonQuest.class

```
public class SlayDragonQuest implements Quest {
    private PrintStream printStream;
    public SlayDragonQuest(PrintStream printStream){
        this.printStream = printStream;
    }
    @Override
    public void embark() {
        printStream.println("勇士.请和恶龙争斗吧!");
    }
}

```

构建应用组件之间的协作的行为通常称为**装配**。Spring有多种装配bean的方式，采用XML是很常见的一种装配方式。

构造器注入：基于XML进行装配
==

knights.xml

```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    
    <bean id="knight" class="com.springinaction.knights.BraveKnight">
        <constructor-arg ref="slayDragonQuest"/>
    </bean>

    <bean id="slayDragonQuest" class="com.springinaction.quest.SlayDragonQuest">
        <constructor-arg value="#{T(System).out}"/>
    </bean>

    <bean id="rescueDamselQuest" class="com.springinaction.quest.RescueDamselQuest">
        <constructor-arg value="#{T(System).out}"/>
    </bean>

</beans>
```

其中，`BraveKnight` . `SlayDragonQuest` . `RescueDamselQuest` 被声明为Spring中的bean。就`BraveKnight`来讲，它在构造时传入了对`SlayDragonQuest`的引用，将其作为构造器参数。同时，`SlayDragonQuest` bean 的声明使用了spring表达式语言，将System.out（这是一个PrintStream）传入到了`SlayDragonQuest`的构造器中。

加载XML文件：
```
public class KnightMain {
    public static void main(String []args){
        // 通过xml的方式 加载spring上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights.xml");
        // 获取 knight bean
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
```

Spring通过**应用上下文（Application Context）**装配bean的定义并把它们组装起来，Spring应用上下文全权负责对象的创建和组装，Spring自带了多种应用上下文的实现，它们之间主要的区别仅仅在于**如何加载配置**

`KnightMain.class`过程：
1. 基于knights.xml创建Spring应用上下文
2. 调用应用上下文获取一个ID为knight的bean
3. 简单调用`embarkOnQuest()`方法执行探险任务

构造器注入：基于Java文件
==

Spring还支持基于Java的配置：

KnightConfig.class
```
@Configuration
public class KnightConfig {
    @Bean
    public Knight braveKnight(){
        return new BraveKnight(rescueDamselQuest());
    }
    @Bean
    public Quest rescueDamselQuest(){
        return new RescueDamselQuest(System.out);
    }
    @Bean
    public Quest slayDragonQuest(){
        return new SlayDragonQuest(System.out);
    }
}
```
KnightMain.class
```
public class KnightMain {
    public static void main(String []args){
        // 通过java配置的方式 加载spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        // 获取 knight bean
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
```

基于切面进行声明式编程
==

DI（依赖注入）可以让**互相协作的软件保持松散耦合**，而面向切面编程（AOP）允许你**把遍布应用各处的功能分离出来形成可重用的组件**。

**横切关注点**：除了实现自身核心功能之外，一些组件还经常承担着额外的职责，诸如日志、事务管理和安全这样的系统服务经常融入到自身具有核心业务逻辑的组件中去，这些系统服务通常被称为横向关注点。

如果将这些关注点分散到多个组件中，代码将会带来双重复杂性：

- 实现系统关注点功能的代码将会分散到多个组件中去；即使把关注点抽象成独立的模块，其他模块仍然需要调用其方法。
- 组件会因为那些与自身核心业务无关的代码而变得混乱。例如一个向地址簿增加地址条目的方法不应该关注它是否是安全的或者是否支持事务。


AOP能够使这些服务模块化（比如说课程服务、学生服务...），并以声明的方式将横切关注点（例如日志模块、安全模块、事务管理模块...）应用到它们需要影响的组件中去。所造成的结果就是这些组件**会具有更高的内聚性**并且**会更加关注自身的业务**，完全不需要了解涉及系统服务


AOP应用
==








  [1]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%B8%80%E7%AB%A0/%E7%AC%AC%E4%B8%89%E6%96%B9%E7%BB%84%E4%BB%B6.png
  [2]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/69c58d49db159ae8f376b6c12e3db940b7664006/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%B8%80%E7%AB%A0/Wanted%20but%20not%20invoked.png