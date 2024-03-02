package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	/**
	 * Multiplies two binary variables
	 *
	 * @param num1 the first addend object
	 * @param num2 the second addend object
	 * @return A binary variable with a value of <i>num1xnum2</i>
	 */
	public static Binary multiply(Binary num1, Binary num2)
	{
		// Takes string containing bits for num1, parses the string into an integer.
		// Converts from binary to decimal for num1 and num2
		int val1 = Integer.parseInt(num1.number, 2);
		int val2 = Integer.parseInt(num2.number, 2);

		// Integer multiplication
		int product = val1 * val2;

		// Creates a binary object with value of previous calculation
		// Value if converted to binary before passing to constructor
		Binary result = new Binary(Integer.toBinaryString(product));
		return result;

	}

	/**
	 * Does a logical AND operation on two binary variables.
	 *
	 * @param num1 the first addened object
	 * @param num2 the second addened object
	 * @return A binary variable with a value of <i>num1 & num2</i>
	 */

	public static Binary and(Binary num1, Binary num2)
	{
		//Index of the first digit of each number
		int indx1 = num1.number.length()-1;
		int indx2 = num2.number.length()-1;

		//Variable Initialization
		String final_value = ""; //Used to store final value
		int x, y; //temp variables

		// A while loop which loops as long as either variable is larger than 0
		while(indx1 >= 0 || indx2 >= 0)
		{

			x = 0;
			y = 0;

			//Checking if any digits remain
			if(indx1 >= 0){
				// Checking if the digit at the current loop interation's index is a 1
				// If 1 then var x = 1, else var x = 0
				x = (num1.number.charAt(indx1)== '1')? 1:0;
				indx1--;
			}
			if(indx2 >= 0){
				// Checking if the digit at current loop iteration's index is a 1
				// If 1 then var y = 1, else var y = 0
				y = (num2.number.charAt(indx2)=='1')? 1:0;
				indx2--;
			}

			//final_value = 1 if both var x and y = 1, else final_value=0
			final_value = ((x==1 && y==1)? "1":"0") + final_value;
		}

		Binary result = new Binary(final_value); //Binary object with the calculated value
		return result;

	}

	/**
	 * Does a logical OR operation on two binary variables
	 *
	 * @param num1  the first addened object
	 * @param num2 the second addened object
	 * @return A binary variable with a value of <i>num1 || num2</i>
	 */
	public static Binary or(Binary num1, Binary num2){

		//Index of the first digit of each number
		int indx1 = num1.number.length()-1;
		int indx2 = num2.number.length()-1;

		//Variable Initialization
		String final_value = ""; //Used to carry the final value
		int x; //temp variable


		//Loops as long as either variable is larger than 0
		//Loops until all digits are processed
		while(indx1>=0 || indx2>=0){

			x = 0; // temp variable is 0 at the beginning

			//Checking if digit at current loops iteration's index is 1
			// if 1 then x = 1, else x = 0
			if(indx1 >= 0){
				x = (num1.number.charAt(indx1) == '1')? 1:x;
				indx1--;
			}

			//Checking if digit at current loops iteration's index is 1
			//if 1 then x = 1, else x = 0
			if(indx2 >= 0){
				x = (num2.number.charAt(indx2) == '1') ? 1:x;
				indx2--;
			}

			// If x = 1 then final_value = 1, else final_value = 0
			final_value = ((x==1)? "1":"0") + final_value;


		}

		Binary result = new Binary(final_value); //Binary object with the final value
		return result;
	}

}
