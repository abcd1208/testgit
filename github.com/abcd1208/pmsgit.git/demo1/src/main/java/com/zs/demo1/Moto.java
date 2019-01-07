package com.zs.demo1;

public class Moto implements Tansport {

   private 	int speed;
	public Moto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("启动");
	}

	@Override
	public void add(int speed) {
		// TODO Auto-generated method stub
		System.out.println("加速:"+speed);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("停止");
	}

}
