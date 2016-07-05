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


### 适用情况
* 许多相关的类仅仅是行为有异。
 “策略”提供了一种用多个行为中的一个行为来配置一个类的方法。即一个系统需要动态地在几种算法中选择一种。

* 需要使用一个算法的不同变体。
 例如，你可能会定义一些反映不同的空间 /时间权衡的算法。当这些变体实现为一个算法的类层次时 ,可以使用策略模式。

* 算法使用客户不应该知道的数据。可使用策略模式以避免暴露复杂的、与算法相关的数据结构。

* 一个类定义了多种行为 , 并且这些行为在这个类的操作中以多个条件语句的形式出现。
 将相关的条件分支移入它们各自的Strategy类中以代替这些条件语句。