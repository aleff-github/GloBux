package s3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

// classe per gestione s3 -> singleton
public class ServiceAmazonS3 {

	private static ServiceAmazonS3 instance = null;

    private AmazonS3 s3Client;
    
    //@Value ("${amazonProperties.s3AccessKey}") 
    private String accessKey = "AKIARWHZ6IWN75SOFCOD";
    //@Value ("${amazonProperties.s3SecretKey}") 
    private String secretKey = "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";
    //@Value("${amazonProperties.s3Region}")
    private String region = "eu-central-1";
    //@Value ("${amazonProperties.s3Bucket}") 
    private String bucketName = "glo-2020";
	    
    private String FOLDER_IMAGE = "image/";
    private String FOLDER_EBOOK = "ebook/";
    
    private void initializeAmazon() { 

       AWSCredentials credentials = new BasicAWSCredentials (this.accessKey, this.secretKey); 
       this.s3Client = AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
	}

	
	public static ServiceAmazonS3 getInstance() {
		if(instance == null) {
			instance = new ServiceAmazonS3();
		}
		return instance;
	}
	
	private ServiceAmazonS3() { this.initializeAmazon(); }
	
	
	// upload file image
	public String uploadFileImage(MultipartFile file1) throws IOException { 
		File file = this.convertMultiPartToFile(file1);
		PutObjectRequest request = new PutObjectRequest(bucketName, this.FOLDER_IMAGE + file.getName(), file)
				.withCannedAcl(CannedAccessControlList.PublicRead);
		s3Client.putObject(request); 
		
		return file.getName();
	} 
	// upload file ebook
	public String uploadFileEbook(MultipartFile file1) throws IOException { 
		File file = this.convertMultiPartToFile(file1);
		PutObjectRequest request = new PutObjectRequest(bucketName, this.FOLDER_EBOOK + generateFileName(file.getName()), file)
				.withCannedAcl(CannedAccessControlList.PublicRead);
		s3Client.putObject(request);
		
		return file.getName();
	} 
	
	
	
	 @SuppressWarnings("unused")
    // converti multipartfile in file
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    
    // genera un nome univoco per ogni file
    @SuppressWarnings("unused")
	private String generateFileName(String name) {
        String nome = new Date().getTime() + "-" + name;
        
        return nome;
    }
    
    
    
//	// racchiude tutti i metodi per la memorizzazione del file nel bicket
//	public void uploadFile(MultipartFile multipartFile) {
//	    try {
//	        File file = convertMultiPartToFile(multipartFile);
//	        String fileName = generateFileName(multipartFile);
//	        uploadFileTos3bucket(fileName, file);
//	        file.delete();
//	    } catch (Exception e) {
//	       e.printStackTrace();
//	    }
//	}
	
	    
	    
	    
}
