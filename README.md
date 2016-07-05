# Java--Design_Pattern
常用的Java设计模式

## 1. 简单工厂模式


## 2. 观察者模式
使用彩票公众号和彩民的关系模拟实现了观察者模式


参照以下博客:

[http://blog.csdn.net/y874961524/article/details/51777695]
(http://blog.csdn.net/y874961524/article/details/51777695)

## 3.策略模式
>定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。

### 使用策略模式的好处
策略模式的好处在于你可以动态的改变对象的行为。

### 适用情况
* 许多相关的类仅仅是行为有异。
 “策略”提供了一种用多个行为中的一个行为来配置一个类的方法。即一个系统需要动态地在几种算法中选择一种。

* 需要使用一个算法的不同变体。
 例如，你可能会定义一些反映不同的空间 /时间权衡的算法。当这些变体实现为一个算法的类层次时 ,可以使用策略模式。

* 算法使用客户不应该知道的数据。可使用策略模式以避免暴露复杂的、与算法相关的数据结构。

* 一个类定义了多种行为 , 并且这些行为在这个类的操作中以多个条件语句的形式出现。
 将相关的条件分支移入它们各自的Strategy类中以代替这些条件语句。


### 策略模式的组成
1. 环境类(Context):用一个ConcreteStrategy对象来配置。
维护一个对Strategy对象的引用。可定义一个接口来让Strategy访问它的数据。

2. 抽象策略类(Strategy):定义所有支持的算法的公共接口。
Context使用这个接口来调用某ConcreteStrategy定义的算法。
这个抽象策略类即为算法簇

3. 具体策略类(ConcreteStrategy):以Strategy接口实现某具体算法。

### 以三国演义的方式的方式描述该策略模式

#### 根据OO的设计规范
1. 封装变化（把可能变化的代码封装起来）

2. 多用组合，少用继承（我们使用组合的方式，为客户设置了算法）

3. 针对接口编程，不针对实现（对于Role类的设计完全的针对角色，和技能的实现没有关系）
#### 场景分析
刘备要到江东娶老婆了，走之前诸葛亮给赵云（伴郎）三个锦囊妙计
，说是按天机拆开能解决棘手问题，嘿，还别说，真解决了大问题，搞到最后是周瑜陪了夫人又折兵，那咱们先看看这个场景是什么样子的。

先说说这个场景中的要素：三个妙计，一个锦囊，一个赵云，妙计是亮哥给的，妙计放在锦囊里，俗称就是锦囊妙计嘛
，那赵云就是一个干活的人，从锦囊取出妙计，执行，然后获胜。用java程序怎么表现这些呢？
#### 设计出UML类图如下
![UML](http://dl.iteye.com/upload/attachment/350678/06a4b9d7-a392-3a49-a1ff-6b1c2342acdb.jpg)

###代码结构

#### 算法簇（所有策略的接口）
```
public interface IStrategy {
    void operate();
}

```
#### 具体算法实现通过类单独实现
```
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备...");
    }
}

```

#### 通过容器类持有接口
```
public class Context {
    private IStrategy mStrategy;


    public Context(IStrategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    public void operate() {
        mStrategy.operate();
    }
}

```

#### 角色持有容器类
```
public class Zhaoyun {

    private Context mContext;

    public Zhaoyun(Context mContext) {
        this.mContext = mContext;
    }

    public Zhaoyun() {
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 赵云执行锦囊
     */
    public void operate() {
        mContext.operate();
    }
}

```