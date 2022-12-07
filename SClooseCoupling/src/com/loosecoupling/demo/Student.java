package com.loosecoupling.demo;

public class Student {

	// Mathcheat mathcheat = new Mathcheat(); //tight coupling (we can achieve loose
	// coupling by using interface and spring)

	private Cheat cheat;       //Cheat cheat = new Sciencecheat(); or  Cheat cheat = new Mathcheat(); 

	public void setCheat(Cheat cheat) {
		this.cheat = cheat;
	}

	public void cheating() {

		cheat.cheat();
		// System.out.println("my id is "+ id + " take and do whatever you wnat to do");
	}

}
