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
        // 获取 knight bea
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
```

Spring通过应用上下文（Application Context）装配bean的定义并把它们组装起来，Spring应用上下文全权负责对象的创建和组装，Spring自带了多种应用上下文的实现，它们之间主要的区别仅仅在于**如何加载配置**


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









  [1]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%B8%80%E7%AB%A0/%E7%AC%AC%E4%B8%89%E6%96%B9%E7%BB%84%E4%BB%B6.png
  [2]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/69c58d49db159ae8f376b6c12e3db940b7664006/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%B8%80%E7%AB%A0/Wanted%20but%20not%20invoked.png