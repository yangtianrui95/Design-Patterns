package simple_factory;

/**
 * 工厂模式 实现
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Driver driver = new BenzDriver();
		Car1 car = driver.getCar();
		car.drive();
	}
}

/**
 * 用于抽象的接口
 */
 interface Car1 {
	void drive();
}


////////////////////////产品类/////////////
 class Benz1 implements Car1 {

	@Override
	public void drive() {
		System.out.println("benz drive");
	}
}

class Audi1 implements Car1 {

	@Override
	public void drive() {
		System.out.println("audi drive");
	}

}

class BMW1 implements Car1 {

	@Override
	public void drive() {
		System.out.println("BMW drive");
	}
}
/////////////////////抽象工厂类//////////////////
// 每一个实体类对应一个工厂
interface Driver{
	Car1 getCar();
}

class BenzDriver implements Driver{

	@Override
	public Car1 getCar() {
		return new Benz1();
	}
}

class BMWDriver implements Driver{

	@Override
	public Car1 getCar() {
		return new BMW1();
	}
}



class AudiDriver implements Driver{

	@Override
	public Car1 getCar() {
		return new Audi1();
	}
	
}