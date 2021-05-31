package kodlama.io.hrms.core.adapters;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mernisService.FakeMernisService;

@Component
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPersonIs(long nationalityId, String firstName, String lastName, int yearOfBirth) {
		FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalityId, firstName, lastName, yearOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
