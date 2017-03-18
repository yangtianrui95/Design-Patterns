# Java--Design_Pattern
常用的Java设计模式


-----
博客地址:http://blog.csdn.net/y874961524

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

## 状态模式
> **状态模式**：允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。

在很多情况下，一个对象的行为取决于一个或多个**动态变化**的属性，这样的属性叫做**状态**，这样的对象叫做有状态的(stateful)对象，这样的对象状态是从事先定义好的一系列值中取出的。**当一个这样的对象与外部事件产生互动时，其内部状态就会改变，从而使得系统的行为也随之发生变化。**

### 在下面的两种情况下均可使用**State**模式:
1.  一个对象的行为取决于它的状态, 并且它必须在**运行**时刻根据状态改变它的行为。

2.  代码中包含大量与对象状态有关的条件语句:**一个操作中含有庞大的多分支的条件（if else或switch case)语句，且这些分支依赖于该对象的状态。这个状态通常用一个或多个枚举常量表示。**通常 , 有多个操作包含这一相同的条件结构。**State模式将每一个条件分支放入一个独立的类中。这使得你可以根据对象自身的情况将对象的状态作为一个对象，这一对象可以不依赖于其他对象而独立变化。**
![这里写图片描述](http://my.csdn.net/uploads/201205/11/1336719144_5496.jpg)

## 模式的组成
* 环境类（Context）:  定义客户感兴趣的接口。维护一个ConcreteState子类的实例，这个实例定义当前状态。

* 抽象状态类（State）:  定义一个接口以封装与Context的一个特定状态相关的行为。

* 具体状态类（ConcreteState）:  每一子类实现一个与Context的一个状态相关的行为。


## State模式有下面一些好处:

###状态模式的优点：
1.  它将与特定状态相关的行为局部化，并且将不同状态的行为分割开来: State模式将所有与一个特定的状态相关的行为都放入一个对象中。因为所有与状态相关的代码都存在于某一个`State`子类中, 所以通过定义新的子类可以很容易的增加新的状态和转换。另一个方法是使用数据值定义内部状态并且让 `Context`操作来显式地检查这些数据。但这样将会使整个`Context`的实现中遍布看起来很相似的条件if else语句或switch case语句。增加一个新的状态可能需要改变若干个操作, 这就使得维护变得复杂了。State模式避免了这个问题, 但可能会引入另一个问题, 因为该模式将不同状态的行为分布在多个State子类中。这就增加了子类的数目，相对于单个类的实现来说不够紧凑。但是如果有许多状态时这样的分布实际上更好一些, 否则需要使用巨大的条件语句。正如很长的过程一样，巨大的条件语句是不受欢迎的。它们形成一大整块并且使得代码不够清晰，这又使得它们难以修改和扩展。 State模式提供了一个更好的方法来组织与特定状态相关的代码。决定状态转移的逻辑不在单块的 i f或s w i t c h语句中, 而是分布在State子类之间。将每一个状态转换和动作封装到一个类中，就把着眼点从执行状态提高到整个对象的状态。这将使代码结构化并使其意图更加清晰。

2. 它使得状态转换显式化: 当一个对象仅以内部数据值来定义当前状态时 , 其状态仅表现为对一些变量的赋值，这不够明确。为不同的状态引入独立的对象使得转换变得更加明确。而且, State对象可保证Context不会发生内部状态不一致的情况，因为从 Context的角度看，状态转换是原子的—只需重新绑定一个变量(即Context的State对象变量)，而无需为多个变量赋值

3. State对象可被共享 如果State对象没有实例变量—即它们表示的状态完全以它们的类型来编码—那么各Context对象可以共享一个State对象。当状态以这种方式被共享时, 它们必然是没有内部状态, 只有行为的轻量级对象。

### 状态模式的缺点:
1.  状态模式的使用必然会增加系统类和对象的个数。

2. 状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱。

###模式总结
1. 状态模式允许一个对象基于内部状态而拥有不同的行为。
2. Context会将行为委托给当前状态对象。
3. 状态模式对“开闭原则”支持不是很好。

### 实例: 使用宾馆管理模拟状态对象
#### 通用状态类

```
/**
 * Created by yangtianrui on 16-11-25.
 * 表示宾馆管理的三个状态
 */

public interface State {

    // 进入宾馆
    void checkInState();

    // 有人入住
    void usingState();

    // 离开宾馆
    void checkoutState();

}

```

#### 具体状态类

```
/**
 * Created by yangtianrui on 16-11-25.
 * 尚未预订的状态
 */
public class FreeState implements State {

    @Override
    public void checkInState() {
        System.out.println("尚未预订");
    }

    @Override
    public void usingState() {
        System.out.println("尚未预订");
    }

    @Override
    public void checkoutState() {
        System.out.println("房间还未时使用");
    }
}

```

```
/**
 * Created by yangtianrui on 16-11-25.
 * 已经有人预订的状态
 */
public class BookState implements State {
    @Override
    public void checkInState() {
        System.out.println("已经有人预订了");
    }

    @Override
    public void usingState() {
        System.out.println("开始使用");
    }

    @Override
    public void checkoutState() {
        System.out.println("退房成功");
    }
}

```
#### Context对象,酒店管理类

```
/**
 * Created by yangtianrui on 16-11-25.
 * Context for State interface.
 */
public class HotelManager {
    private State mCurState = new FreeState(); // 当前的状态值

    // 预订一个宾馆,设置对应的状态值
    // 此处为改变状态对象,具体操作委托给状态对象执行
    public void bookHotel() {
        mCurState = new BookState();
        mCurState.usingState();
    }

    public void checkInHotel() {
        mCurState.checkInState();
    }

    public void checkoutHotel() {
        mCurState.checkoutState();
    }


    public State getState() {
        return mCurState;
    }


    public void setState(State mCurState) {
        this.mCurState = mCurState;
    }


}
```

#### 测试

```
public class Main {

    public static void main(String[] args) {
        HotelManager manager = new HotelManager();
        // 此处为预订
        manager.checkInHotel();

        // 预订宾馆, Manager 会切换不同的State对象
        manager.bookHotel();

        // 再次预订宾馆
        manager.checkInHotel();

        // 结果:
        // 尚未预订
        // 开始使用
        // 已经有人预订了
    }
}

```

> 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于**结构型模式**，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
**这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。**


###**桥接模式**: 将抽象与实现分离,使他们能够独立的进行变化.

我们通过下面的实例来演示桥接模式（Bridge Pattern）的用法。其中，可以使用相同的抽象类方法但是不同的桥接实现类，来画出不同颜色的圆。

####**优点**：
 1. 抽象和实现的分离。
 2. 优秀的扩展能力。
 3.   实现细节对客户透明。

####**缺点**：
桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。

####**使用场景**：
 1. 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系。
 2.  对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
 3.   一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。

**注意事项**：对于两个独立变化的维度，使用桥接模式再适合不过了。

### 桥接模式的应用
#### 进行桥接的类
![这里写图片描述](http://img.blog.csdn.net/20161128141936009)
```
/**
 * Created by yangtianrui on 16-11-28.
 * 这个类既包含抽象又包含具体实现,使用DisplayImpl对象进行桥接,实现解偶
 */
public class Display {
    // 使用桥接,将抽象与具体实现解偶
    private DisplayImpl mDisplay = new ContreteDisplay();

    public void open() {
        System.out.println("Display #open()");
        mDisplay.rawOpen();
    }

    public void print() {
        System.out.println("Display #print()");
        mDisplay.rawPrint();
    }

    public void close() {
        System.out.println("Display #close()");
        mDisplay.rawClose();
    }

}
```

##### 具体实现的类

```
/**
 * Created by yangtianrui on 16-11-28.
 * 具体实现类的接口
 */
public interface DisplayImpl {
    void rawOpen();

    void rawPrint();

    void rawClose();
}

/**
 * Created by yangtianrui on 16-11-28.
 * 具体实现类
 */
public class ContreteDisplay implements DisplayImpl {
    @Override
    public void rawOpen() {
        System.out.println("ContreteDisplay #rawOpen()");
    }

    @Override
    public void rawPrint() {
        System.out.println("ContreteDisplay #rawPrint()");
    }

    @Override
    public void rawClose() {
        System.out.println("ContreteDisplay #rawClose()");
    }
}

```

测试类

```
public class Main {

    public static void main(String[] args) {
        Display display = new Display();

        // 这里调用impl具体对象的实现
        display.open();
        display.print();
        display.close();
//        Display #open()
//        ContreteDisplay #rawOpen()
//        Display #print()
//        ContreteDisplay #rawPrint()
//        Display #close()
//        ContreteDisplay #rawClose()
    }
}

```
## 职责链模式

>使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

### 适用场景:

1. 有多个的对象可以处理一个请求，**哪个对象处理该请求运行时刻自动确定**；

2. 在不明确指定接收者的情况下，向多个对象中的一个提交一个请求；

3. **处理一个请求的对象集合应被动态指定。**

### 通用类图
![这里写图片描述](http://img.blog.csdn.net/20161219235658522?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveTg3NDk2MTUyNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 职责链模式说明
> 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。

1. 客户端发送一个请求，有多个对象都有机会来处理这个请求，但客户端不知道究竟谁来处理。

2. 客户端只知道他提交请求的第一个对象，从第一个对象开始处理，整个职责链中的对象要么处理请求，要么转发给下一个接受者。
在标准的职责链模式中，只要有对象处理了请求，这个请求就到此为止，不再被传递和处理了。

3. 在职责链模式中，请求不一定会被处理，因为可能没有合适的处理者。请求在职责链中从头到尾，每个处理对象都判断不属于自己处理，最后请求就没有对象来处理。

4. 在实际开发中，经常会遇到把职责链稍稍变形的用法。**一个请求在职责链中传递，每个对象处理完后不是停止，而是继续向下传递请求，当请求通过所有对象处理后，功能也就处理完成了，这样的职责链称为功能链。**

### 场景分析

在大学里面当班干部，时常要向上级申请各方面的东西。譬如申请全班外出秋游，普通同学将申请表交给班长，班长签字之后交给辅导员，辅导员批准之后上交到主任办公室…就是这样，一个请求（这里是一份申请表）有时候需要经过好几个级别的处理者（这里是辅导员、主任）的审查才能够最终被确定可行与否。

在这里表现出来的是一个职责链，**即不同的处理者对同一个请求可能担负着不同的处理方式、权限**，但是我们希望这个请求必须到达最终拍板的处理者（否则秋游就没戏了）。这种关系就很适合使用职责链模式了。

![这里写图片描述](http://img.blog.csdn.net/20161219235952808?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveTg3NDk2MTUyNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


### 代码实现
设置处理级别

```
/**
 * Created by yangtianrui on 16-12-20.
 * 处理级别
 */
public interface Level {
    int LEVEL1 = 1;
    int LEVEL2 = 2;
    int LEVEL3 = 3;
}

```
封装各种请求

```

/**
 * Created by yangtianrui on 16-12-20.
 * 模拟各种请求
 */
public abstract class BaseRequest {

    private String content; // 要传递修改的内容

    public BaseRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 根据级别进行判断
    abstract public int getLevel();
}

public class Request1 extends BaseRequest {


    public Request1(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL1;
    }
}


public class Request2 extends BaseRequest {


    public Request2(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL2;
    }
}


public class Request3 extends BaseRequest {


    public Request3(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL3;
    }
}

```

请求处理类

```

/**
 * Created by yangtianrui on 16-12-20.
 * 请求处理类
 */
public abstract class AbsHandler {
    // 指向职责链的下一个引用
    private AbsHandler mNextHandler;

    public final void handleRequest(BaseRequest request) {
        // 可以处理
        if (getHandleLevel() >= request.getLevel()) {
            // 在当前处理
            handle(request);
        } else {
            System.out.println(getClass().getSimpleName() + " can 't handle this request!");
            // 无法处理时
            // 向下传递处理
            mNextHandler.handleRequest(request);
        }
    }

    public void setNextHandler(AbsHandler nextHandler) {
        mNextHandler = nextHandler;
    }

    abstract public int getHandleLevel();

    abstract protected void handle(BaseRequest request);
}

```

具体的一些处理

```
public class ContreteHandler1 extends AbsHandler {
    @Override
    public int getHandleLevel() {
        return Level.LEVEL2;
    }

    @Override
    public void handle(BaseRequest request) {
        System.out.println("ContreteHandler1 #handle()");
    }
}


public class ContreteHandler2 extends AbsHandler {
    @Override
    public int getHandleLevel() {
        return Level.LEVEL3;
    }

    @Override
    public void handle(BaseRequest request) {
        String content = request.getContent();
    }
}

```

代码测试

```
public class Main {

    public static void main(String[] args) {
        AbsHandler handler = new ContreteHandler1();
        AbsHandler handler2 = new ContreteHandler2();

        Request1 request1 = new Request1("request1 ");
        Request2 request2 = new Request2("request2 ");
        Request3 request3 = new Request3("request3 ");

        handler.setNextHandler(handler2);

        handler.handleRequest(request1);
        handler.handleRequest(request2);
        // 让下级进行处理
        handler.handleRequest(request3);

        /*
            结果
            ContreteHandler1 #handle()
            ContreteHandler1 #handle()
            ContreteHandler1 can 't handle this request!
            ContreteHandler2 #handle()
        */
    }
}

```

### 职责链模式优缺点

####请求者和接收者松耦合
在职责链模式中，请求者并不知道接收者是谁，也不知道具体如何处理，请求者只是负责向职责链发送请求就可以了。而每个职责对象也不用管请求者或者是其他的职责对象，只负责处理自己的部分，其他的就交给其他的职责对象去处理。也就是说，请求者和接受者是完全解耦的。

####动态组合职责
职责链模式会把功能处理分散到单独的职责对象中，然后再使用的时候，可以动态组合职责形成职责链，从而可以灵活地给对象分配职责，也可以灵活地实现和改变对象的职责。

#### 产生很多细粒度对象
职责链模式会把功能处理分散到单独的职责对象中，也就是每个职责对象只处理一个方面的功能，要把整个业务处理完，需要很多职责对象的组合，这样会产生大量的细粒度职责对象。

#### 不一定能被处理
职责链模式的每个职责对象只负责自己处理的那一部分，因此可能会出现某个请求把整个链传递完了都没有职责对象处理它。这就需要使用职责链模式的时候，需要提供默认的处理，并且注意构造的链的有效性。

-----
## 基于InvocationHandler创建动态代理

> 动态代理是代理模式的一种,而代理模式又是一种非常有用的模式之一.下面介绍下通过InvocatonHandler实现动态代理

## InvocationHandler接口

InvocationHandler 是代理实例的调用处理程序 实现的接口。
每个代理实例都具有一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法。

### 关键方法
Object invoke(Object proxy,Method method,Object[] args) throws Throwable

在代理实例上处理方法调用并返回结果。在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。

####参数：
**proxy** - 在其上调用方法的代理实例

**method** - 对应于在代理实例上调用的接口方法的 Method 实例。Method 对象的声明类将是在其中声明方法的接口，该接口可以是代理类赖以继承方法的代理接口的超接口。

**args** - 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null。基本类型的参数被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。

####返回：
从代理实例的方法调用返回的值。如果接口方法的声明返回类型是基本类型，则此方法返回的值一定是相应基本包装对象类的实例；否则，它一定是可分配到声明返回类型的类型。如果此方法返回的值为 null 并且接口方法的返回类型是基本类型，则代理实例上的方法调用将抛出 NullPointerException。否则，如果此方法返回的值与上述接口方法的声明返回类型不兼容，则代理实例上的方法调用将抛出 ClassCastException。

####抛出：
Throwable - 从代理实例上的方法调用抛出的异常。该异常的类型必须可以分配到在接口方法的 throws 子句中声明的任一异常类型或未经检查的异常类型 java.lang.RuntimeException 或 java.lang.Error。如果此方法抛出经过检查的异常，该异常不可分配到在接口方法的 throws 子句中声明的任一异常类型，代理实例的方法调用将抛出包含此方法曾抛出的异常的 UndeclaredThrowableException。


## 场景分析

现在需要对一个`setHotRating()` 方法进行保护,所以提供两个代理类,一个能够访问,另一个不能访问.

### 定义通用接口
```

/**
 * Created by yangtianrui on 16-12-31.
 */
public interface IPersonBean {

    String getName();

    String getGender();

    int getHotRating();

    void setName(String name);

    void setGender(String name);

    // 将使用代理限制这个方法的访问
    void setHotRating(int rating);

}

```
### 接口实现

```
/**
 * Created by yangtianrui on 16-12-31.
 */
public class PersonImpl implements IPersonBean {

    private String name;
    private String gender;
    private int hotRating;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getHotRating() {
        return hotRating;
    }

    @Override
    public void setHotRating(int hotRating) {
        this.hotRating = hotRating;
    }
}

```

对其中的setHotRating提供保护

### 实现Handler,用于创建动态代理

```

/**
 * Created by yangtianrui on 16-12-31.
 * 使用JDK提供的方法实现动态代理
 * 对真实调用对象提供保护
 */
public class ProtectInvocationHandler implements InvocationHandler {
    private IPersonBean person;

    public ProtectInvocationHandler(IPersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            // 执行所有getter
            if (method.getName().startsWith("get")) {
                method.invoke(person, args);
                // 对setHotRating进行权限管理
            } else if (method.getName().equals("setHotRating")) {
                System.out.println("yon don't have permission to invoke this method!!");
            } else if (method.getName().startsWith("set")) {
                method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            // 真正的主题抛出异常,在此处进行处理
            e.printStackTrace();
        }
        return null;
    }
}

```

创建不提供保护的代理

```

/**
 * Created by yangtianrui on 16-12-31.
 * 这个代理类对执行的方法不做任何保护
 */
public class PubInvocationHandler implements InvocationHandler {

    private IPersonBean person;

    public PubInvocationHandler(IPersonBean person) {
        this.person = person;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            method.invoke(person, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

```
### 创建动态代理
使用JDK中的`Proxy.newInstance()`创建一样的代理对象
```
**
     * 创建保护的动态代理
     *
     * @param protectPerson
     */
    private static IPersonBean getProtectProxy(IPersonBean protectPerson) {
        return (IPersonBean) Proxy.newProxyInstance(protectPerson.getClass().getClassLoader()
                , protectPerson.getClass().getInterfaces(), new ProtectInvocationHandler(protectPerson));
    }


    /**
     * 创建公共的动态代理
     */
    private static IPersonBean getPubProxy(IPersonBean pubPerson) {
        return (IPersonBean) Proxy.newProxyInstance(pubPerson.getClass().getClassLoader()
                , pubPerson.getClass().getInterfaces(), new PubInvocationHandler(pubPerson));
    }
```

### 测试

```

/**
 * Created by yangtianrui on 16-12-31.
 */
public class Main {

    public static void main(String[] args) {
        // 保护的代理对象
        IPersonBean protectPerson = new PersonImpl();
        IPersonBean protectProxy = getProtectProxy(protectPerson);

        // 普通代理对象
        IPersonBean pubPerson = new PersonImpl();
        IPersonBean pubProxy = getPubProxy(pubPerson);


        // 访问受保护的代理对象
        protectProxy.setName("AAA");
        protectProxy.setHotRating(100);
        // yon don't have permission to invoke this method!!


        // 访问普通代理对象
        pubProxy.setName("BBB");
        pubProxy.setHotRating(90);


    }

    /**
     * 创建保护的动态代理
     *
     * @param protectPerson
     */
    private static IPersonBean getProtectProxy(IPersonBean protectPerson) {
        return (IPersonBean) Proxy.newProxyInstance(protectPerson.getClass().getClassLoader()
                , protectPerson.getClass().getInterfaces(), new ProtectInvocationHandler(protectPerson));
    }


    /**
     * 创建公共的动态代理
     */
    private static IPersonBean getPubProxy(IPersonBean pubPerson) {
        return (IPersonBean) Proxy.newProxyInstance(pubPerson.getClass().getClassLoader()
                , pubPerson.getClass().getInterfaces(), new PubInvocationHandler(pubPerson));
    }

}

```
-----
## 备忘录模式
>备忘录模式又叫做**快照模式(Snapshot Pattern)**或**Token模式**，是**对象的行为**模式。

>**备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。备忘录模式的用意是在不破坏封装的条件下，将一个对象的状态捕捉(Capture)住，并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起来的状态。备忘录模式常常与命令模式和迭代子模式一同使用。**

##备忘录模式的结构

备忘录模式的结构图如下所示
![这里写图片描述](http://img.blog.csdn.net/20170318120250301?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveTg3NDk2MTUyNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


备忘录模式所涉及的角色有三个：**备忘录(Memento)角色**、**发起人(Originator)角色**、**负责人(Caretaker)角色**。

##备忘录(Memento)角色

###**备忘录角色又如下责任：**
　1. 将发起人（Originator）对象的内部状态存储起来。备忘录可以根据发起人对象的判断来决定存储多少发起人（Originator）对象的内部状态。
　
　2. 备忘录可以保护其内容不被发起人（Originator）对象之外的任何对象所读取。

### **备忘录有两个等效的接口：**

- **窄接口：**负责人（Caretaker）对象（和其他除发起人对象之外的任何对象）看到的是备忘录的窄接口(narrow interface)，这个窄接口只允许它把备忘录对象传给其他的对象。

- **宽接口：**与负责人对象看到的窄接口相反的是，发起人对象可以看到一个宽接口(wide interface)，这个宽接口允许它读取所有的数据，以便根据这些数据恢复这个发起人对象的内部状态。

##发起人(Originator)角色

###**发起人(Originator)角色有如下责任：**
1. 创建一个含有当前的内部状态的备忘录对象。

2. 使用备忘录对象存储其内部状态。



##负责人(Caretaker)角色
###**负责人(Caretaker)角色有如下责任：**
1. 负责保存备忘录对象。

2. 不检查备忘录对象的内容。



## **“白箱”备忘录模式的实现**

备忘录角色对任何对象都提供一个接口，即宽接口，备忘录角色的内部所存储的状态就对所有对象公开。因此这个实现又叫做“白箱实现”。


    “白箱”实现将发起人角色的状态存储在一个大家都看得到的地方，因此是破坏封装性的。但是通过程序员自律，同样可以在一定程度上实现模式的大部分用意。因此白箱实现仍然是有意义的。
![这里写图片描述](http://img.blog.csdn.net/20170318144515959?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveTg3NDk2MTUyNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### Originator角色

```

/**
 * Created by yangtianrui on 17-3-18.
 * 发起人角色
 */
public class Originator {

    // 模拟一个状态
    private String mState;

    public Originator(String state) {
        mState = state;
    }


    public void setState(String state) {
        mState = state;
    }

    public Memento createMemento() {
        return new Memento(mState);
    }

    // 输出状态
    public void printState() {
        System.out.println(mState);
    }
}

```

### Memento角色

```
/**
 * Created by yangtianrui on 17-3-18.
 * 备忘录对象,用来存储Originator的状态
 */
public class Memento {

    private String mState;

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Memento(String state) {
        mState = state;
    }
}

```

###CareTaker角色

```
/**
 * Created by yangtianrui on 17-3-18.
 * 负责人角色,负责人保存对象状态
 */
public class CareTaker {

    private Memento mMemento;


    public CareTaker(Memento memento) {
        mMemento = memento;
    }

    /**
     * 获取状态
     */
    public String retrieveState() {
        return mMemento.getState();
    }

    /**
     * 存入状态
     */
    public void saveState(Memento memento) {
        mMemento = memento;
    }
}

```

###测试类

```
public class Main {

    public static void main(String[] args) {
        // 初始化状态
        final Originator originator = new Originator("Initial state.");

        originator.printState();
        // 使用CareTaker保存状态

        final CareTaker careTaker = new CareTaker(originator.createMemento());

        // 修改状态
        originator.setState("Modify this state.");

        // 输出修改后的状态
        originator.printState();

        // 使用Memento恢复状态
        originator.setState(careTaker.retrieveState());

        // 输出恢复的状态
        originator.printState();

        /*结果
          Initial state.
          Modify this state.
          Initial state.
         */
    }
}

```


##“黑箱”备忘录模式的实现
在Java语言中，实现双重接口的办法就是将备忘录角色类设计成发起人角色类的内部成员类。

将Memento设成Originator类的内部类，从而将Memento对象封装在Originator里面；
在外部提供一个标识接口MementoIF给Caretaker以及其他对象。

**这样，Originator类看到的是Menmento的所有接口，而Caretaker以及其他对象看到的仅仅是标识接口MementoIF所暴露出来的接口。**

宽窄接口的设计
![这里写图片描述](http://img.blog.csdn.net/20170318151348175?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveTg3NDk2MTUyNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## IMemento
对外仅提供简单的接口

```
/**
 * Created by yangtianrui on 17-3-18.
 * 对外提供的备忘录接口
 */
public interface IMemento {
}

```

## Originator角色,通过内部类,对备忘录进行封装

```
public class Originator {

    // 模拟保存的状态
    private String mState;

    public Originator(String state) {
        mState = state;
    }

    public void setState(String state) {
        mState = state;
    }

    public void printState() {
        System.out.println(mState);
    }


    // 创建备忘录保存对象
    public IMemento createMemento() {
        // 保存对象
        return new OriginMemento(mState);
    }

    // 从备忘录中恢复状态
    public void restoreMemento(IMemento memento) {
        if (memento instanceof OriginMemento) {
            mState = ((OriginMemento) memento).getState();
        }
    }


    /**
     * 通过内部类,将对象状态进行封装
     */
    private class OriginMemento implements IMemento {
        private String mState;

        public OriginMemento(String state) {
            mState = state;
        }

        public String getState() {
            return mState;
        }

        public void setState(String state) {
            mState = state;
        }
    }
}

```

## CareTaker角色,对备忘录进行管理

```
public class CareTaker {

    // 对外部只是表现为接口,体现了封装性
    private IMemento mMemento;

    public void setMemento(IMemento memento) {
        mMemento = memento;
    }


    public IMemento getMemento() {
        return mMemento;
    }


}

```

## 测试类

```
public class Main {

    public static void main(String[] args) {

        // 初始状态
        final Originator originator = new Originator("Initial state.");
        originator.printState();

        // 存储状态到备忘录
        final CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());

        // 更改状态
        originator.setState("Modified state.");
        originator.printState();

        // 恢复状态
        originator.restoreMemento(careTaker.getMemento());
        originator.printState();


        /*
          结果
         *Initial state.
         *Modified state.
         *Initial state.
         */
    }
}

```
