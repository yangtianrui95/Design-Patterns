package observer;

/**
 * 所有主题必须实现这个被观察者接口
 *
 */
public interface Observable {

	/**
	 * 注册一个观察者
	 */
	public void registerObserver(Observer observer);

	/**
	 * 移除一个观察者
	 */
	public void removeObserver(Observer observer);

	/**
	 * 通知所有观察者
	 */
	public void notifyObservers();
}
