import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
//  In TestDemoTest.java, add a private instance variable of 
//	type TestDemo named testDemo.

TestDemo testDemo;
// In the setUp method, create the TestDemo object. This will 
// ensure that a new TestDemo object is created before each test.
	@BeforeEach
	void setUp() throws Exception {
/// Starting a test demo
		testDemo = new TestDemo();
//step70: Change "@Test" to "@ParameterizedTest". Add the import 
//			statement for org.junit.jupiter.params.ParameterizedTest.	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//PORTAL
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//STEP 76 Just below the @ParameterizedTest annotation, add the annotation @MethodSource. Pass a single parameter to @MethodSource. It must be 
//			the fully-qualified (includes package) class name of the test followed by a # sign followed by the name of the method that supplies the 
//				parameters. Since the test is in the default package, there is no package in the fully-qualified class name

	//@Test
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	
// STEP 71:	Change the name of method "test" to "assertThatTwoPositiveNumbersAreAddedCorrectly".
//			Add four parameters to assertThatTwoPositiveNumbersAreAddedCorrectly 

	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, 
			int expected, boolean expectException) {  //test() {
		
//STEP 72: Write the test. Remove the "fail" line. 	Test the value of exceptionException. 
// 			if it is false, assert that when TestDemo.addPositive is called with values a and b, that
// 				the result is the same as the parameter expected.		
		
		if(!expectException) { //fail("Not yet implemented");
// STEP 73: Add the test for the thrown exception in an else clause. Use assertThatThrown
//				for this. Add the static import org.assertj.core.api.Assertions.assertThatThrownBy;
//					Use the assertion isInstanceOf(IllegalArgumentException.class) to ensure that the correct exception is thrown.	
	assertThat(testDemo.addPositive(a,  b)).isEqualTo(expected);
		
// STEP 74: as a parameter to asserThatThrownBy, add a lambDa expression with no parametera. 
//				The lambda body should be the method call to testDemo.addPositive.
		} else 
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);			
	}
//STEP 75:	add the parameter source method.Create a static method named argumentsForPositive. it should not have any parameters
// 				and it should return a stream of arguments. imports!
//                Each parameter set should be wrapped in an arguments() method call. Add the static import for arguments 
//					Each parameter set should be wrapped in an arguments() method call. Add the static import for arguments
//So, if you are adding 2 and 4 to get the value of 6 and are not expecting an exception, you need to do:
//arguments(2, 4, 6, false)Add as many arguments lines as needed to test the addPositive method thoroughly. Make sure to add some zero or negative arguments.

	static Stream<Arguments> argumentsForAddPositive() {
			return Stream.of(Arguments.of(1,2,3,false), 
					Arguments.of(2, 4, 6, false), 
					Arguments.of(4, 4, 8, false), 
					Arguments.of(0, -4, 0, true));
		}
	@Test
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//PORTAL
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//STEP 79: 	Write a test for randomNumberSquared in TestDemoTest.java. Since you don't know what getRandomInt will return (that's the point of random, after all), you will 
//			need to mock it out and supply a known value.Create a method annotated with @Test named assertThatNumberSquaredIsCorrect. The method must have package visibility (not public!) 
//			or JUnit won't find it. The annotation @Test is in the org.junit.jupiter.api package.
void assertthatNumberSquaredIsCorrect() {
//Step 80:      To mock the TestDemo class, use Mockito.spy. The spy method can be imported with a static import of org.mockito.Mockito.spy.
	TestDemo mockDemo = spy(testDemo);

// STEP 81: Program the mocked TestDemo object to return 5 when the getRandomInt method is called. Remember to use the form: 
doReturn(5).when(mockDemo).getRandomInt(); 
 
//Step 82: Call the method randomNumberSquared on the mocked TestDemo object. This will call the stubbed out (mocked)
//			method getRandomInt, which now should return the value 5.
int fiveSquared = mockDemo.randomNumberSquared(); 

// STEP 82: Use assertThat to test that the value returned from randomNumberSquared is equal to 5 squared.
assertThat(fiveSquared).isEqualTo(25); 
	
	}
}
