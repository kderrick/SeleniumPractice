package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	
	
	//Test Method
	@Test
	public void newAccountTest() {
		System.out.println("New Record : " + name + " " + email + "  "+ phone);
		if(phone.equals("7894561230")){
			Assert.fail();
		}
	}
	
	//This annotated method passes the data/parameters into the class via constructor below
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("/Users/kylederrick/Desktop/Software/UserAccounts.csv");
	}
	
	//Constructor that passes data to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password,
			String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}

}
