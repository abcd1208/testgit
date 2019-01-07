package com.zs.demo1;

public class CarBean1 implements Tansport {
	private int speed;
	private String brand;
	public CarBean1(String bname) {
		brand = bname;
	}
	public int getSpeed() {
		System.out.println(brand);
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void addSpeed(int s) {

		speed += s;
	};
public void start () {
	System.out.println("启动");
};
public void stop() {
	System.out.println("停止");
}
@Override
public void add(int speed) {
	// TODO Auto-generated method stub
	System.out.println("加速:"+speed);
};
	

}