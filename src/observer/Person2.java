package observer;

/**
 * 彩民1 注册观察者
 * 
 * @author TerryYang
 *
 */
public class Person2 implements Observer {

	private Observable mSubject;

	// 在构造函数中注册观察者
	public Person2() {
		mSubject = new ObjectFor3D();
		mSubject.registerObserver(this);
	}

	
	
	// 此方法会在被观察者的notifyAll方法中被回调
	@Override
	public void update(String msg) {
		System.out.println("彩民2  得到彩票号码: " + msg);
	}

}
