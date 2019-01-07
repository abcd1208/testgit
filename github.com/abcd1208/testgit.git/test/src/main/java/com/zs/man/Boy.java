package com.zs.man;

import com.zs.girlbav.GilrBav;

public class Boy {

	private GilrBav girl;

	public GilrBav getGirl() {
		return girl;
	}

	public void setGirl(GilrBav girl) {
		this.girl = girl;
	}

	public void makeFriend() {
		girl.talk();
		girl.hobby();
		girl.cook();
	};

}
