package observer;

public class Main {
	public static void main(String[] args) {
		// 两个彩民
		Observer p1 = new Person1();
		Observer p2 = new Person2();

		// 订阅彩票号
		ObjectFor3D s = new ObjectFor3D();
		s.registerObserver(p1);
		s.registerObserver(p2);

		// 彩票号发布信息
		s.setMsg("1001");
		//输出：
		//彩民1  得到彩票号码: 1001
		//彩民2  得到彩票号码: 1001
	}
}
