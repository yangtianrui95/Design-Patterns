package simple_factory;

public class Main {
	public static void main(String[] args) throws Exception {
		Car car = CarFactory.driveCar("Benz");
		car.drive();
	}
}

/**
 * 用于抽象的接口
 */
interface Car {
	void drive();
}


////////////////////////产品类/////////////
class Benz implements Car {

	@Override
	public void drive() {
		System.out.println("benz drive");
	}
}

class Audi implements Car {

	@Override
	public void drive() {
		System.out.println("audi drive");
	}

}

class BMW implements Car {

	@Override
	public void drive() {
		System.out.println("BMW drive");
	}
}
///////////////////////////////////////////
/**
 * 工厂类
 */
class CarFactory {
	public static Car driveCar(String s) throws Exception {
		// 根据参数创建不同的对象
		if (s.equals("Benz")) {
			return new Benz();
		} else if (s.equals("Audi")) {
			return new Audi();
		} else if (s.equals("BMW")) {
			return new BMW();
		} else {
			// 没有对应的对象时，抛出异常
			throw new Exception();
		}
	}
}
