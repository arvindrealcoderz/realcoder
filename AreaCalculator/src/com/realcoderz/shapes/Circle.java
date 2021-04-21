package com.realcoderz.shapes;

public class Circle {

	private float radius = 1.5f;
	private float pi = 3.5f;

	// Problem statement4::: option a
	/*
	 * //this is not default constructor user define 0 parameter constructor private
	 * Circle() { super();//to call super class constructor }
	 * 
	 * 
	 * //one parameter constructor private Circle(float radius) { super();//call
	 * super class zero parameter constructor this.radius = radius; }//close
	 * constructor
	 * 
	 * 
	 * private Circle(float radius, float pi) { super(); this.radius = radius; //
	 * this.pi = pi; }
	 * 
	 */

	// Problem statement4::: option b [package level]

	// this is not default constructor user define 0 parameter constructor
	Circle() {
		super();// to call super class constructor
	}

	// one parameter constructor
	Circle(float radius) {
		super();// call super class zero parameter constructor
		this.radius = radius;
	}// close constructor

	Circle(float radius, float pi) {
		super();
		this.radius = radius;
		// this.pi = pi;
	}

	// create two methods
	float calculateCircleArea(float radius) {
		return (pi * radius * radius);
	}

	// calculateCircumference
	float calculateCircumference(float radius) {
		return (2 * this.pi * radius);
	}

	// create methods
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.calculateCircleArea(100));
		System.out.println(c.calculateCircumference(100));

		System.out.println();

		Circle c1 = new Circle(10.0f);
		System.out.println(c1.calculateCircleArea(100));
		System.out.println(c1.calculateCircumference(100));

	}

}// class
