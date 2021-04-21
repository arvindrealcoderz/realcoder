package com.realcoderz.tax;

public class TaxCalculator {

	// creating instance variable
	private float basicSalary;
	private boolean citizenship;
	private float tax;
	private int nettSalary;

	public float getBasicSalary() {
		return basicSalary;
	}

	public boolean isCitizenship() {
		return citizenship;
	}

	public float getTax() {
		return tax;
	}

	public int getNettSalary() {
		return nettSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setCitizenship(boolean citizenship) {
		this.citizenship = citizenship;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public void setNettSalary(int nettSalary) {
		this.nettSalary = nettSalary;
	}

	// create a methods with calculateTax
	void calculateTax() {
		// calculate tax and store in the tax varible which is instance[non static
		// variable]
		tax = 30 * basicSalary / 100;
		// print basicSalary and Tax
		System.out.println("The Tax of the employee for the " + (int)basicSalary + " is  " + (int)tax);
	}// colse calculateTax

	// create a methods with deduct Tax
	void deductTax() {
		nettSalary = (int) (basicSalary-tax);
		// Display messgae in the consiole
		System.out.println("The nett salary of the employee " + nettSalary);
	} // close deductTax
		// Use realtionship operator
		// create a methods with validateSalary

	void validateSalary() {
		// basic salary is greater than 1 lakh
		if (basicSalary > 100000.0 && citizenship == true)
			System.out.println("The salary and citizenship eligiblity:"+ true);
		else
			System.out.println("The salary and citizenship eligiblity:"+ false);

	}// validateSalary
}
