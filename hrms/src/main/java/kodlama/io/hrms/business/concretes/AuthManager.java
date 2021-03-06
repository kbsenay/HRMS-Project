
package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.adapters.UserCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.verification.VerificationService;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private UserCheckService userCheckService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, UserCheckService userCheckService,
			VerificationCodeService verificationCodeService) {
		
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.userCheckService = userCheckService;
		this.verificationCodeService = verificationCodeService;  
	}

	//Register Employer
	@Override 
	public Result registerEmployer(Employer employer, String confirmedPassword) { 
		if (!checkIfNullInfoForEmployer(employer, confirmedPassword)) {
			return new ErrorResult("Eksik giri?? yapt??n??z!");
		}else if (checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress()) 
				&& checkIfEmailExists(employer.getEmail()) 
				&& checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmedPassword)) {
			return new SuccessResult("????veren kayd?? ba??ar??l??!");
		}
		var result = this.employerService.add(employer);
		
		if (result.isSuccess()) {
			String code = this.verificationService.codeGenerator();
			this.verificationService.sendCode(code);
			verificationCodeRecord(code, employer.getId(), employer.getEmail());
			return new SuccessResult("Do??rulama ba??ar??l??");
		}
		return new ErrorResult("L??tfen tekrar deneyin!");
		}

	//Register Candidate
	@Override 
	public Result registerCandidate(Candidate candidate, String confirmedPassword) { 
		if (!checkIfNullInfoForCandidate(candidate, confirmedPassword)) {
			return new ErrorResult("Eksik giri?? yapt??n??z!");
		}else if (checkNationalIdentity(candidate.getIdentityNumber())
				&& checkIfIdentityNumberExists(0, confirmedPassword, confirmedPassword, 0)
				&& checkIfEmailExists(confirmedPassword)
				&& checkIfEqualPasswordAndConfirmPassword(candidate.getPassword(), confirmedPassword)) {
			return new SuccessResult("???? arayan kayd?? ba??ar??l??");
		}
		
		var result = this.candidateService.add(candidate);
		
		if (result.isSuccess()) {
			String code = this.verificationService.codeGenerator();
			this.verificationService.sendCode(code);
			verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
			return new SuccessResult("Do??rulama ba??ar??l??");
		}
		return new ErrorResult("L??tfen tekrar deneyin!"); 
	}

	// ----------- business rules -------------

	// rules for employers
	private boolean checkIfNullInfoForEmployer(Employer employer, String confirmPassword) {
		if (employer.getCompanyName() != null && employer.getWebAddress() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null && confirmPassword != null) {
			return true;
		}
		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String webAdress) {
		String[] emailArr = email.split("@", 2);
		String domain = webAdress.substring(4, webAdress.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// rules for candidates 
	private boolean checkIfNullInfoForCandidate(Candidate candidate, String confirmPassword)
	{
		if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getIdentityNumber() != null
				&& candidate.getBirthYear() != null && candidate.getEmail() != null && candidate.getPassword() != null
				&& confirmPassword != null) {
			return true;
		}
		return false;
	}

	private boolean checkNationalIdentity(String identityNumber) {
		if (this.candidateService.getByIdentityNumber(identityNumber).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfIdentityNumberExists(long identityNumber, String
					firstName, String lastName, int yearOfBirth) { if
				(userCheckService.checkIfRealPersonIs(identityNumber, firstName, lastName,yearOfBirth)) {
						return true; 
					} 
					return false; 
					}

	// Common Validation 
	private boolean checkIfEmailExists(String email) {

	if(this.userService.findByEmailIs(email).getData()==null)

	{

		return true;
	}

	return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

			if (!password.equals(confirmPassword)) { return false; }

			return true; }

	private void verificationCodeRecord(String code, int id, String email) {

			VerificationCode verificationCode = new VerificationCode(id, id, code, false,
					LocalDate.now()); this.verificationCodeService.add(verificationCode);
					System.out.println("Do??rulama kodu g??nderildi : " + email );

		}

}
