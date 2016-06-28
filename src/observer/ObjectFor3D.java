package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者的实现类
 * 
 * @author TerryYang
 *
 */
public class ObjectFor3D implements Observable {

	// 所有注册在此的观察者
	private List<Observer> mObservers = new ArrayList<>();

	// 3D彩票号码
	private String mMsg;

	@Override
	public void registerObserver(Observer observer) {
		mObservers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		mObservers.remove(observer);

	}

	// 通知所有观察者
	@Override
	public void notifyObservers() {
		for (Observer o : mObservers) {
			o.update(mMsg);
		}
	}

	// 发布彩票号
	public void setMsg(String msg) {
		mMsg = msg;
		notifyObservers();
	}

}
