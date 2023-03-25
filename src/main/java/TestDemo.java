import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b)
	{
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//week 12 : create an instance method (not static) named addPositive. it should take two int parameters and return an int.
//0	If both parameters are positive (greater than zero) return the sum of the parameters. If either parameter is zero or negative, throw an IllegalArgumentException with the message "Both parameters must be positive!". 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		if(a>=0 && b>=0) {
		int sum = a + b;
		System.out.println(sum);
		return sum;
		}else{
		throw new IllegalArgumentException("Both parameters must be positive");

		}
	}	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//WEEK12:	
//Step 77: In TestDemo.java, add another method named randomNumberSquared. This method obtains a random int between 1 and 10 and then returns the square of the number.
//It should call another method in the same class named getRandomInt. This method takes no parameters and must be package visibility so that the test can see it.
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
//Step 78:	randomNumberSquared should return the value obtained from getRandomInt multiplied by itself.
	 public int randomNumberSquared() {
	 int randomNumber = getRandomInt(); 
	 int randomNumberSquared = randomNumber * randomNumber; 
	return randomNumberSquared;
}
	
	
	
	}
	
