package kodlama.io.hrms.core.utilities.verification;

public interface VerificationService {
	void sendCode(String email);
	String codeGenerator();

}
