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

## 通过Java注解的方式开启组件扫描

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

## 通过XML的方式开启组件扫描

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


## 给bean起一个不同的名称

```
@Component(value = "lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    // ...
}
```

@Component(value = "lonelyHeartsClub") : 给bean设置不同的ID

## 设置组件扫描的基础包

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

## 通过为bean添加注解实现自动装配

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

当你需要将第三方库组件装配到你的应用中，是没有办法在它的类上加@Component和@Autowired注解的，这时候我们就需要显示的装配了。有两种可选方案：Java和XML 。

## 创建配置类

```
@Configuration
public class CDPlayerConfig {

}
```

@Configuration 注解表明这个类是一个配置类，该类应该包含在Spring应用上下文如何创建bean的细节。

## 声明简单的bean

```
@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
```

**@Bean 注解会告诉Spring这个方法将会返回一个对象，该对象要注册为Spring应用上下文中的bean 。**

默认情况下，bean的ID与带有@Bean注解的方法名是一样的，但是，你也可以指定一个不同的名字：
```
@Bean(name = "lonelyHeartsClubBand")
public CompactDisc sgtPeppers(){
    return new SgtPeppers();
}
```

## 借助JavaConfig实现注入

CDPlayerConfig.class - JavaConfig 类

```
@Configuration
public class CDPlayerConfig {
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }
}
```

看起来，CompactDisc是通过调用 `sgtPeppers()` 得到的，但情况并非完全如此，因为 `sgtPeppers()` 方法上添加了@Bean注解，Spring 将会拦截所有对它的调用，并确保直接返回该方法所创建的bean ， 而不是每一次都对其进行实际的调用。

假设你引入了其他的CDPlayer的bean：

```
@Bean
public CDPlayer cdPlayer(CompactDisc compactDisc){
    return new CDPlayer(sgtPeppers());
}
@Bean
public CDPlayer anthorCDPlayer(CompactDisc compactDisc){
    return new CDPlayer(sgtPeppers());
}
```

默认情况下，SPirng中的bean都是单例的，所以，Spring会拦截对sgtPeppers()的调用并确保返回的是Sprring所创建的bean ， 在这里，bean就是Spirng在调用sgtPeppers()时所创建的CompactDisc bean 。 

还有另一种写法：
```
@Configuration
public class CDPlayerConfig {
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
```

在Spring调用cdPlayer() 创建 CDPlayer bean 的时候，会自动装配一个CompactDisc 到配置方法中。不管CompactDisc是通过什么方式创建出来的，SPring都会将其传入到配置方法中，并用来创建CDPlyaer bean

通过XML装配bean
==

spring-config.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="sgtPeppers" class="soundsystem.compactdisc.SgtPeppers"/>

</beans>
```

当spring发现<bean...>元素时，会调用SgtPeppers的默认构造器来创建bean 。 

## 借助构造器初始化bean

有两种基本方案可供选择：

- `<constructor-arg>` 元素
- 使用Spring3.0 引入的 c-命名空间

有些事情`<constructor-arg>`可以做到，但是使用c-命名空间却无法实现

### 构造器注入bean的引用

使用`<constructor-arg>`元素：

```
<bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer">
	<constructor-arg ref="sgtPeppers"/>
</bean>
```

使用c-命名空间的方案：

```
<bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer" c:compactDisc-ref="sgtPeppers"/>
```

![此处输入图片的描述][3]

属性名以c: 开头，也就是命名空间的前缀，表示是构造器初始化。 接下来是要装配的构造器参数名称，-ref表正在装配的是一个bean的引用，这个bean的名称是compactDisc（以图为例）

代替方案如下：

```
<bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer" c:_0-ref="sgtPeppers"/>
```

c:_0-ref 中的 _0 表示参数的索引 , 使用索引来识别会比使用名称识别构造器参数更好一些。

### 将字面量（字符串）注入到构造器中

BlankDisc.class 
```
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
```

spring-config.xml
```
<bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc">
	<constructor-arg value="Sgt. Pepper's Lonely Hearts Club Band"/>
	<constructor-arg value="The Beatles"/>
</bean>
```

`<constructor-arg>` 标签中的ref属性表示引用了其他的bean，而value属性表明给定的值要以字符串的形式注入到构造器中 

更为简单的写法：

spring-config.xml ————  通过索引
```
<bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc" c:_0="Sgt. Pepper's Lonely Hearts Club Band" c:_1="The Beatles"/>
```

### 装配集合

在装配bean引用或者字符串的方面，`<constructor-arg>` 和 c-命名空间的功能是相同的，但有一种情况是 `<constructor-arg>` 能够实现，但是c-命名空间不能实现的 ： 那就是 **集合的装配**

BlankDisc.class ———— 引入磁道的概念

```
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    /**
     *  磁道
     */
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
        for(String track:tracks){
            System.out.println("-Track : " +track);
        }
    }
}
```

spring-config.xml
```
<bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc">
		<constructor-arg value="Sgt. Pepper's Lonely Hearts Club Band"/>
		<constructor-arg value="The Beatles"/>
		<constructor-arg>
			<list>
				<value>track1</value>
				<value>track2</value>
				<value>track3</value>
				<value>track4</value>
			</list>
		</constructor-arg>
	</bean>
```

与之类似的，我们也可以使用`<ref>` 代替 `<value>` ， 来实现bean引用列表的装配

当磁道为set 类型的时候，我们可以使用`<set>` 而非 `<list>` :
```
<bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc">
		<constructor-arg value="Sgt. Pepper's Lonely Hearts Club Band"/>
		<constructor-arg value="The Beatles"/>
		<constructor-arg>
			<set>
				<value>track1</value>
				<value>track2</value>
				<value>track3</value>
				<value>track4</value>
			</set>
		</constructor-arg>
	</bean>
```

## 借助setter初始化bean

CDPlayer.class
```
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }
    @Override
    public void play() {
        compactDisc.play();
    }
}
```

spring-config.xml
```
<bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer">
		<property name="compactDisc" ref="sgtPeppers"/>
	</bean>

	<bean id="sgtPeppers" class="soundsystem.compactdisc.SgtPeppers">

	</bean>
```

Spring中 `<constructor-arg>` 元素提供了 c-命名空间作为替代方案，与之类似，Spring提供了更加简洁的p-命名空间，作为 `<property>`元素的替代方案。

spring-config.xml
```
<bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer" p:compactDisc-ref="sgtPeppers"/>
```

### 将字面值注入到属性中

BlankDisc.class
```
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
        for (String track:tracks){
            System.out.println("- Track : " + track);
        }
    }
}
```

spring-config.xml
```
<bean id="sgtPeppers" class="soundsystem.compactdisc.BlankDisc">
		<property name="title" value="Sgt. Pepper's Lonely Hearts Club Band"/>
		<property name="artist" value="The Beatles"/>
		<property name="tracks">
			<list>
				<value>track1</value>
				<value>track2</value>
				<value>track3</value>
			</list>
		</property>
	</bean>
```

同样的，也可以使用p-命名空间的方式：
```
<bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc" p:title="Sgt. Pepper's Lonely Hearts Club Band" p:artist="The Beatles">
		<property name="tracks">
			<list>
				<value>track1</value>
				<value>track2</value>
				<value>track3</value>
			</list>
		</property>
	</bean>
```

我们可以使用util-命名空间的方式来简化bean：
我们可以把磁道列表转移到`blankDisc bean` 之外，并将其声明到单独的bean 之中，如下所示：
```
<util:list id="tracks">
		<value>track1</value>
		<value>track2</value>
	</util:list>
```

这样，我们就可以简化blankDisc bean的定义了：
```
<bean id="sgtPeppers" class="soundsystem.compactdisc.BlankDisc" p:title="Sgt. Pepper's Lonely Hearts Club Band" p:artist="The Beatles" p:tracks-ref="tracks">
	</bean>
```

![util-命名空间中的元素][4]

导入和混合配置
==

## 在JavaConfig中引用XML配置

我们假设CDPlayerConfig有一些笨重，需要将`blankDisc` 从`CDPlayerConfig` 中拆分出来。定义到它自己的`CDConfig`类中：

CDConfig.class
```
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
}
```

CDPlayerConfig.class
```
@Configuration
public class CDPlayerConfig {
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
```

我们需要将这两个config类组合到一起，第一种方法是直接在`CDPlayerConfig.class`使用@Import注解导入`CDConfgi.class`

```
@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig{
    // ...
}
```

更高级的办法是创建一个新的Config，将两个配置类组合到一起：
```
@Configuration
@Import({CDConfig.class,CDPlayerConfig.class})
public class SoundSystemConfig {

}
```

假设我们通过XML的方式配置BlankDisc：

spring-config.xml

```
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="blankDisc" class="soundsystem.compactdisc.BlankDisc" p:title="Sgt. Pepper's Lonely Hearts Club Band" p:artist="The Beatles">
        <property name="tracks">
            <list>
                <value>track1</value>
                <value>track2</value>
                <value>track3</value>
            </list>
        </property>
    </bean>
</beans>
```

使用@ImportResource注解，加载XML文件
```
@Configuration
@Import({CDConfig.class,CDPlayerConfig.class})
@ImportResource({"classpath:spring-context.xml"})
public class SoundSystemConfig {

}
```

## 在XML配置中引用JavaConfig

cd-config.xml
```
<bean id="compactDisc" class="soundsystem.compactdisc.BlankDisc" p:title="Sgt. Pepper's Lonely Hearts Club Band" p:artist="The Beatles">
        <property name="tracks">
            <list>
                <value>track1</value>
                <value>track2</value>
                <value>track3</value>
            </list>
        </property>
    </bean>
```

spring-context.xml
```
<import resource="cd-config.xml"/>

    <bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer" c:_0-ref="compactDisc">

    </bean>
```


`<import>` 元素可以导入其他的XML配置文件，但是不可以导入JavaConfig类

所以，我们可以使用下面的方法引用：
```
<bean class="soundsystem.config.CDConfig"/>

    <bean id="cdPlayer" class="soundsystem.mediaplayer.CDPlayer" c:_0-ref="compactDisc"/>
```

小结
==

Spring中装配bean的三种主要方式：自动化配置，基于Java的显示配置，以及基于XML的显示配置






  [1]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/CD%E6%92%AD%E6%94%BE%E5%99%A8-%E5%88%86%E5%8C%85%E6%88%AA%E5%9B%BE.png
  [2]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/master/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/CD%E6%92%AD%E6%94%BE%E5%99%A8-XML%E9%85%8D%E7%BD%AE-%E5%88%86%E5%8C%85%E6%88%AA%E5%9B%BE.png
  [3]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/eb651a2a72cf4334139144270f2a5d453f77656d/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/c-%E5%91%BD%E5%90%8D%E7%A9%BA%E9%97%B4.png
  [4]: https://raw.githubusercontent.com/zhangzhaolin/spring-demo/812e95487fcbdc68d715759d33861c9ebab25555/%E5%9B%BE%E7%89%87/%E7%AC%AC%E4%BA%8C%E7%AB%A0/Spring%20util-%E5%91%BD%E5%90%8D%E7%A9%BA%E9%97%B4%E4%B8%AD%E7%9A%84%E5%85%83%E7%B4%A0.png