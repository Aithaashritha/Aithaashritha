package com.animal;

class Animal    //parent class
{
	void shout()
	{
		System.out.println("Dog barks");
	}
	void sleep()
	{
		System.out.println("Dog sleeps");
	}
}

class Dog extends Animal  //child class
{
	void eat()
	{
		System.out.println("Dog Starts eating");
	}
}

public class Inheritance
{
	public static void main(String[]args)
	{
	Dog dog = new Dog();
	dog.shout();
	dog.eat();
	dog.sleep();
	
}
	
}