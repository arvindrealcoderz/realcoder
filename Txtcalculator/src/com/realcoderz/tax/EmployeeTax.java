package com.realcoderz.tax;

public class EmployeeTax {

	//create mian methods 
	public static void main(String[] args) {
		//create TaxCalculator object
		TaxCalculator tax=new TaxCalculator();
		
		//Testcase1
		//set the values of the citizenship as true and basicSalary is 25000 
		//We have to ways to set value in instance variable
		//1 . by using constructor 
		//2. by using setter methods
		
		//setting value to instance variable by using setter methodsa
		tax.setCitizenship(true);
		tax.setBasicSalary(25000);
		
		//invoke methods calculateTax
		tax.calculateTax();
		
		//invoke methods deductTax
		tax.deductTax();
		
		//invoke methods validateSalary
		tax.validateSalary();
		System.out.println("=====================Testcase2::===========================\n");
		
		//Testcase::2
		//setting value to instance variable by using setter methodsa
		
		tax.setCitizenship(true);
		tax.setBasicSalary(125000);
		
		//invoke methods calculateTax
		tax.calculateTax();
		
		//invoke methods deductTax
		tax.deductTax();
		
		//invoke methods validateSalary
		tax.validateSalary();
		
		
		
	}//main
}
