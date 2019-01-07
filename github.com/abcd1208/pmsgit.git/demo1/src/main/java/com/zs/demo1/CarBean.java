package com.zs.demo1;

public class CarBean {
	private int speed;
	private String brand;
	
public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
public void addSpeed(int s) {
	
	speed+=s;
	
	
};
}
