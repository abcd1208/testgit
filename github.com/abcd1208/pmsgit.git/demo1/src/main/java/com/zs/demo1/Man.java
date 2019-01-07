package com.zs.demo1;

public class Man {
private Tansport tp;


public Tansport getTp() {
	return tp;
}


public void setTp(Tansport tp) {
	this.tp = tp;
}


public void drive() {
	tp.start();
	tp.add(100);
	tp.stop();
};
}
