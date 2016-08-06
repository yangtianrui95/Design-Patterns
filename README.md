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
----------
## 4.代理模式
>**为其他对象提供一种代理以控制对这个对象的访问。**
>代理模式是常用的java设计模式，他的特征是代理类与委托类有同样的接口，
代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等。代理类与委托类之间通常会存在关联关系，
一个代理类的对象与一个委托类的对象关联，代理类的对象本身并不真正实现服务，而是通过调用委托类的对象的相关方法，来提供特定的服务。

### 使用场景:
1. 远程代理（Remote Proxy）：为一个对象在不同的地址空间提供局部代理。
2. 虚代理（Virtual Proxy）：根据需要创建开销很大的对象。
3. 保护代理（Protection Proxy）：控制对原始对象的访问。保护代理用于对象应该有不同的访问权限的时候。
4. 智能指引（Smart Reference）：取代了简单的指针，它在访问对象时执行一些附加操作。

代理分为**静态代理**和**动态代理**,下面先以静态代理为例.

UML类图
![代理UML](http://img.blog.csdn.net/20160725223655514)

### 定义代理类的规范,被代理类和代理类需实现此规范

```
/**
 * Created by yangtianrui on 16-7-25.
 * <p>
 * 通过接口定义一个被代理类的规范
 */
interface Subject {
    void request();     // do something...

    Subject getProxy(); // 获取自身代理的对象
}

```
### 实际的一个被代理类
```
/**
 * Created by yangtianrui on 16-7-25.
 * 被代理类
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject   --->   request() ");
    }

    @Override
    public Subject getProxy() {
        return null; // 没有代理任何对象
    }
}

```

### 代理类代理
```
/**
 * Created by yangtianrui on 16-7-25.
 * 代理类
 */
public class Proxy implements Subject {
    private Subject mSubject; // 被代理类


    /**
     * 必须传递被代理的对象
     */
    public Proxy(Subject subject) {
        this.mSubject = subject;
    }

    @Override
    public void request() {
        // 让代理类去执行
        mSubject.request();
    }

    @Override
    public Subject getProxy() {
        return mSubject;
    }
}
```

### main函数
```
 public static void main(String[] args) {
        // 代理一个RealSubject对象
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request(); // 实际上时RealSubject对象的request()执行
        // 输出:RealSubject   --->   request()
    }
```

##　动态代理模式
>当业务类很多时,使用静态代理需要写多个代理接口,这时可以通过反射实现动态代理.
>只需要写一个动态代理类即可

```

/**
 * Created by yangtianrui on 16-7-30.
 * 方法代理类,基于反射实现动态代理
 */
public class MethodProxy {

    private Class clazz;   // 对象所属的类
    private Object target; // 目标对象
    private Method method; // 目标方法
    private Object[] params; // 参数数组

    public MethodProxy(Object target, String methodName, Object... params) {
        rebindTarget(target, methodName, params);
    }

    /**
     * 设置目标对象与方法
     */
    private void rebindTarget(Object target, String methodName, Object... params) {
        this.target = target;
        this.clazz = target.getClass();
        // 设置目标方法
        rebindMethod(methodName, params);
    }

    /**
     * 设置目标方法
     */
    private void rebindMethod(String methodName, Object... params) {
        this.params = params;
        int paramsLength = params.length;
        Class[] paramsType = new Class[paramsLength];
        // 获取每个参数的类型
        for (int i = 0; i < paramsLength; i++) {
            paramsType[i] = params[i].getClass();
        }
        try {
            this.method = clazz.getMethod(methodName, paramsType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用已经绑定的方法
     */
    public void doMethod() {
        try {
            this.method.invoke(target, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

```

### 业务类
```
/**
 * Created by yangtianrui on 16-7-30.
 * 测试
 */
public class Person {
    public void say() {
        System.out.println("Say SomeThing...");
    }

    public void love(String name) {
        System.out.println("I love " + name);
    }
}

```

### 测试
```
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        // 代理无参数的方法
        MethodProxy methodProxy = new MethodProxy(person, "say");
        methodProxy.doMethod();
        // Say SomeThing...

        // 代理有参数的方法
        MethodProxy proxy2 = new MethodProxy(person, "love", "hehe");
        proxy2.doMethod();
        // I love hehe
    }
}

```
-----

## 装饰器模式
>装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，
同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。

**意图：** 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。

**主要解决：** 一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。

**何时使用：** 在不想增加很多子类的情况下扩展类。

**如何解决：** 将具体功能职责划分，同时继承装饰者模式。

**关键代码： **

1. Component 类充当抽象角色，不应该具体实现。
2. 修饰类引用和继承 Component 类，具体扩展类重写父类方法。

### 使用装饰器可以用来代替继承
![](http://www.runoob.com/wp-content/uploads/2014/08/decorator_pattern_uml_diagram.jpg)

### 业务接口

```
 * Created by yangtianrui on 16-8-7.
 * 代表一个业务
 */
interface Shape {

    void draw();
}

```

### 具体业务类
```
/**
 * Created by yangtianrui on 16-8-7.
 * 具体业务类
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape : Circle");
    }
}

```

### 抽象装饰器
```
/**
 * Created by yangtianrui on 16-8-7.
 * 抽象业务的装饰器类
 */
public abstract class DecoratorShape implements Shape {
    private Shape mShape; // 具体的业务对象

    public DecoratorShape(Shape shape) {
        mShape = shape;
    }

    @Override
    public void draw() {
        mShape.draw();
    }
}

```

### 实体装饰器对实体业务进行封装
```
/**
 * Created by yangtianrui on 16-8-7.
 * 具体业务的装饰器类
 */
public class RedBoundShape extends DecoratorShape {
    public RedBoundShape(Shape shape) {
        super(shape);
    }


    @Override
    public void draw() {
        super.draw();
        // 其他业务.....
        System.out.println("This shape is Red Bound");
    }
}

```


### 测试
```
public class Main {
    public static void main(String[] args) {
        Shape shape = new RedBoundShape(new Circle());
        Shape shape2 = new RedBoundShape(new Reac());
        shape.draw();
        shape2.draw();
        // 结果
//        Shape : Circle
//        This shape is Red Bound
//        Shape : Reac
//        This shape is Red Bound
    }
}
```