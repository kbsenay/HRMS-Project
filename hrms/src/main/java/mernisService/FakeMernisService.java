package mernisService;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " geçerli kişi!" );
		return true;
	}

}
