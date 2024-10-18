package fr.app.lorcanaDex.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;
    private String cloudName;
    private String apiKey;
    private String apiSecret;

    public CloudinaryService(Environment env) {
        this.cloudName = env.getProperty("cloudinary.cloud_name");
        this.apiKey = env.getProperty("cloudinary.api_key");
        this.apiSecret = env.getProperty("cloudinary.api_secret");
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", this.cloudName,
                "api_key", this.apiKey,
                "api_secret", this.apiSecret));
    }

    public String uploadImage(String imagePath) {
        try {
            Map uploadResult = cloudinary.uploader().upload(imagePath, ObjectUtils.asMap(
                    "transformation", new com.cloudinary.Transformation()
                            .width(300)
                            .height(418)
                            .crop("fill"),
                    "format", "avif"));
            // System.out.println("Upload result: " + uploadResult);
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image: " + e.getMessage(), e);
        }
    };
}