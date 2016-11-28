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
