package kodlama.io.hrms.core.utilities.verification;

public class VerificationManager implements VerificationService {

	@Override
	public void sendCode(String email) {
		System.out.println(email + " adresine doğrulama kodu gönderildi!");
		
	}

	@Override
	public String codeGenerator() {
		String verificationCode = "abcd";
		return verificationCode;
	}

}
