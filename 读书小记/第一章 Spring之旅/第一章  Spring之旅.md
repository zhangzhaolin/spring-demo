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
- 
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

"灵活"的勇敢骑士：构造注入
==





![Wanted but not invoked][1]

  [1]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/69c58d49db159ae8f376b6c12e3db940b7664006/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%B8%80%E7%AB%A0/Wanted%20but%20not%20invoked.png
