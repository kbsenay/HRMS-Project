package kodlama.io.hrms.core.utilities.verification;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class VerificationManager implements VerificationService {

	@Override
	public void sendCode(String email) {   //email'e göndermeyi simule ediyor
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Doğrulama kodu"+ email + " adresine gönderildi");
		System.out.println("Lütfen bağlantıya tıklayarak hesabınızı doğrulayın: " + verificationLink);
		
	}

	@Override
	public String codeGenerator() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Etkinleştirme kodunuz:  " + verificationCode );
		return verificationCode;
	}

}
