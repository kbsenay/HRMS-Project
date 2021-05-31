package kodlama.io.hrms.core.adapters;


public interface UserCheckService {
	boolean checkIfRealPersonIs(long nationalityId, 
			String firstName, 
			String lastName, 
			int yearOfBirth);

}
