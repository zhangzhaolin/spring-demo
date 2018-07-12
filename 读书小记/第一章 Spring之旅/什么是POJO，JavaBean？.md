# 什么是POJO，JavaBean？

## 总结：
POJO：

一个简单的Java类，这个类没有实现/继承任何特殊的java接口或者类，不遵循任何主要java模型，约定或者框架的java对象。在理想情况下，POJO不应该有注解。

JavaBean：

- JavaBean是可序列化的，实现了serializable接口
- 具有一个无参构造器
- 有按照命名规范的set和gett，is（可以用于访问布尔类型的属性）方法

## pojo

- 点击链接：[java对象 POJO和JavaBean的区别](http://www.jianshu.com/p/224489dfdec8)
- 点击链接：[Difference between DTO, VO, POJO, JavaBeans?](https://stackoverflow.com/questions/1612334/difference-between-dto-vo-pojo-javabeans)
- 点击链接：[维基百科：Plain old Java object](https://en.wikipedia.org/wiki/Plain_old_Java_object)

POJO的创始人([martinfowler](https://www.martinfowler.com/bliki/POJO.html))博客：
> The term was coined while Rebecca Parsons, Josh MacKenzie and I were preparing for a talk at a conference in September 2000. In the talk we were pointing out the many benefits of encoding business logic into regular java objects rather than using Entity Beans. We wondered why people were so against using regular objects in their systems and concluded that it was because simple objects lacked a fancy name. So we gave them one, and it's caught on very nicely.
...在谈话中我们指出，编写业务逻辑的时候，使用常规的java对象要比实体bean要好的多。我们怀疑为什么一些人极力反对在他们的代码中使用常规对象，还辩解称因为这些常规对象没有一个花哨的名字，所以我们给他们起了一个非常好听的名字。（Plain Old Java Object）

维基百科原文————（以下代码和示例均来源于此）
> The term "POJO" initially denoted a Java object which does not follow any of the major Java object models, conventions, or frameworks; nowadays "POJO" may be used as an acronym for "Plain Old JavaScript Object" as well, in which case the term denotes a JavaScript object of similar pedigree.[2]
术语POJO起初表示为不遵任何主要的java模型，约定或者框架的java对象，现在，pojo也可以用作'Plain Old JavaScript Object'的缩写，这样的话和javascript对象有着相似的渊源。

理想状态下，pojo应该是一个不受Java语言规范限制的java对象。换句话说，pojo<strong>不应该</strong>：

1.继承预先设定的类，如：
```
public class Foo extends javax.servlet.http.HttpServlet {
    // ...
}
```
2.实现预先设定的接口，如：
```
public class Bar implements javax.ejb.EntityBean {
    // ...
}
```
3.包含预先指定的注解，如：
```
@javax.persistence.Entity
public class Baz {
    // ...
}
```

>However, due to technical difficulties and other reasons, many software products or frameworks described as POJO-compliant actually still require the use of prespecified annotations for features such as persistence to work properly. The idea is that if the object (actually class) was a POJO before any annotations were added, and would return to POJO status if the annotations are removed then it can still be considered a POJO. Then the basic object remains a POJO in that it has no special characteristics (such as an implemented interface) that makes it a "Specialized Java Object" (SJO or (sic) SoJO).
然而，由于技术和其他原因，很多被称之为POJO标准的软件产品或框架仍然需要使用特定的注解来保证持久化等功能。这个想法是，如果对象（类）在任何注解添加之前是一个pojo的话，并且注解移除之后仍然是pojo。所以最基础的pojo解释是没有特别的特征（尤其是实现接口之类的），使其称之为“专用java对象”


## JavaBean

> 点此链接：[维基百科中JavaBeans的概念](https://en.wikipedia.org/wiki/JavaBeans)

>A JavaBean is a POJO that is serializable, has a no-argument constructor, and allows access to properties using getter and setter methods that follow a simple naming convention. Because of this convention, simple declarative references can be made to the properties of arbitrary JavaBeans. Code using such a declarative reference does not have to know anything about the type of the bean, and the bean can be used with many frameworks without these frameworks having to know the exact type of the bean. The JavaBeans specification, if fully implemented, slightly breaks the POJO model as the class must implement the Serializable interface to be a true JavaBean. Many POJO classes still called JavaBeans do not meet this requirement. Since Serializable is a marker (method-less) interface, this is not much of a burden.
JavaBean是一个可序列化的POJO，具有一个无参构造器，并且允许使用遵循简单命名约定的getter和setter方法来访问属性。由于这个惯例，可以对任意JavaBean属性进行简单的声明引用。使用这种声明引用的代码不需要知道bean的具体类型。并且，这个bean还可以被很多框架使用，这些java框架也不需要知道bean的类型。由于java.io.Serializable是一个标记接口（无方法），所以这并不是一个多大的负担。如果JavaBean完全实现的话，稍微打破了一些POJO模型。很多被称之为JavaBean的POJO类并不符合这个要求，因为JavaBean必须实现Serializable接口才能成为真正的JavaBean。

JavaBean的优点：

>The properties, events, and methods of a bean can be exposed to another application.
A bean may register to receive events from other objects and can generate events that are sent to those other objects.
Auxiliary software can be provided to help configure a bean.
The configuration settings of a bean can be saved to persistent storage and restored.
1. bean中的属性，事件和方法可以暴露给另一个应用程序
2. 一个bean可以注册来自于其他对象的事件，也可以产生事件并发送给其他对象
3. 辅助代码可以提供javabean的配置
4. 一个bean的配置设置可以永远被存储和恢复

## 一些疑问？

- 什么是事件？有什么作用？bean如何注册来自于其他对象的事件？
- 配置设置如何被存储和恢复？
- serializable接口是做什么的？
