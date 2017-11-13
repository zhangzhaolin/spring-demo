# 装配Bean

[TOC]

-------

Spring装配bean的可选方案
==

装配：创建应用对象之间协作关系的行为通常称为装配，这这也是依赖注入的本质。

Spring装配bean的三种方案：

- 在XML中进行显示配置
- 在Java中进行显示配置
- 隐式的bean发现机制和自动装配

自动化装配bean
==

Spring有两种角度来实现自动化装配

- 组件扫描：Spring会自动发现应用上下文中所创建的bean
- 自动装配：Spring自动满足bean之间的依赖

## 创建可被发现的bean

CompactDisc.class - CD接口

```
package soundsystem.compactdisc;

public interface CompactDisc {
    void play();
}
```

SgtPeppers.class - CD接口实现类：一张专辑唱片

```
package soundsystem.compactdisc;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
```

`Component` 注解：表明该类会作为组件类，并告知Spring要为这个类创建bean。

除此之外，组件扫描默认是不启动的，我们需要显示配置Spring，从而命令它去寻找`Component`类：

### 通过Java注解的方式开启组件扫描

CDPlayerConfig.class - 定义Spring装配规则
```
package soundsystem.config;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"soundsystem"})
public class CDPlayerConfig {

}
```

在这个项目中，我的分包如下图所示：

![此处输入图片的描述][1]

如果没有其他配置的话，@ComponentScan 默认会扫描与配置类相同的包以及该包下所有的子包，查找带有@Component 注解的类，这样的话，Spring会自动为其创建bean。

CDPlayerTest.class - 测试文件

```
package soundsystem.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.config.CDPlayerConfig;
import soundsystem.mediaplayer.MediaPlayer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Autowired
    private MediaPlayer mediaPlayer;
    @Autowired
    private CompactDisc compactDisc;
    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(compactDisc);
    }
    @Test
    public void play(){
        mediaPlayer.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles",log.getLog());
    }
}
```

`SpringJUnit4ClassRunner` 可以在测试开始的时候自动创建Spring应用上下文，`@ContextConfiguration` 告诉测试类需要在`CDPlayerConfig` 中加载配置。

### 通过XML的方式开启组件扫描

spring-config.xml
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 使用XML开启组件扫描 -->
    <context:component-scan base-package="soundsystem"/>
</beans>
```

在这个项目中，我的分包如下图所示：

![此处输入图片的描述][2]

CDPlayerTest.class - 测试文件

```
package soundsystem.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.mediaplayer.MediaPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CDPlayerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Autowired
    private MediaPlayer mediaPlayer;
    @Autowired
    private CompactDisc compactDisc;
    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(compactDisc);
    }
    @Test
    public void play(){
        mediaPlayer.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles",log.getLog());
    }
}
```


### 给bean起一个不同的名称

```
@Component(value = "lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    // ...
}
```

@Component(value = "lonelyHeartsClub") : 给bean设置不同的ID

### 设置组件扫描的基础包

```
@ComponentScan(basePackages = {"soundsystem","video"})
public class CDPlayerConfig {
    // ...
}
```

@ComponentScan(basePackages = {"soundsystem","video"}) 可以扫描多个基础包；但是这样是类型不安全的。

除了将包设置为String之外，@ComponentScan 还提供了另一种格式，那就是将其指定为包中的类或者接口：

```
@ComponentScan(basePackageClasses = {CompactDisc.class, CDPlayer.class})
public class CDPlayerConfig {
}
```

这些类所在包将会作为组件扫描的基础包。

### 通过为bean添加注解实现自动装配

**自动装配：自动装配就是让Spring自动满足bean依赖的一种方法，在满足依赖的过程中，会在Spring应用上下文中寻找匹配某个bean需求的其他bean 。为了声明要进行自动匹配，我们可以借助Spring中的 `@Autowired` 注解 。**

```
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;
    @Autowired
    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }
    @Override
    public void play() {
        compactDisc.play();
    }
}

```

上段代码表明：当Spring创建CDPlayer bean的时候，会通过构造器来进行实例化并传入一个可设置给CompactDisc 类型的bean

@Autowired 不仅可以用在构造器上，还可以用在属性的Setter方法（或其他任何方法）上。

```
@Autowired
public void insertDisc(CompactDisc compactDisc){
    this.compactDisc = compactDisc;
}
```

假如有且只有一个bean匹配依赖需求的话，那么这个bean将会被匹配进来。

如果没有匹配的bean，那么在应用上下文创建的时候，Spring会抛出一个异常，为了避免异常的出现，可以将@Autowired的required属性设置为false

```
@Autowired(required = false)
public void insertDisc(CompactDisc compactDisc){
    this.compactDisc = compactDisc;
}
```

将@Autowired的required属性设置为false时，Spring会尝试自动匹配，如果匹配不到相应的bean，Spring会将这个bean处于未装配的状态。如果你的代码中没有进行null检查的话，这个处于未装配状态的属性可能会出现NullPointerException 。

如果有多个bean都能满足依赖关系的话，Spring将会抛出一个异常，表示没有明确指定要选择哪一个bean进行自动装配。

通过Java代码装配bean
==




  [1]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/CD%E6%92%AD%E6%94%BE%E5%99%A8-%E5%88%86%E5%8C%85%E6%88%AA%E5%9B%BE.png
  [2]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/CD%E6%92%AD%E6%94%BE%E5%99%A8-XML%E9%85%8D%E7%BD%AE-%E5%88%86%E5%8C%85%E6%88%AA%E5%9B%BE.png