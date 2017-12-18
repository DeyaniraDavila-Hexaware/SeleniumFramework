package hex.selenium.execution;

import hex.selenium.testCases.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try{
			
			// Call DemoQARegistration script
			DemoQARegistration demoQARegistration = new DemoQARegistration("Chrome");
			GoogleSearch googleSearch = new GoogleSearch("Firefox");
			//.
			//.
			//.
			//.
			
		}catch(Exception e){
			System.out.println(e.getMessage() + "Main error.");
		}
	}

}
