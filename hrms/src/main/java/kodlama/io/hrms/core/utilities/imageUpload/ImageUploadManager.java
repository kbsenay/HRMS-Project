package kodlama.io.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService {
	
	private Cloudinary cloudinary;

	@Autowired
	public ImageUploadManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "kbsenay",
			"api_key", "472292949116992",
			"api_secret", "MfOoGYsahCe3HOJg1ObePOaXQhM"
			));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imagefile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imagefile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>("Resim eklenemedi");
	}

}
