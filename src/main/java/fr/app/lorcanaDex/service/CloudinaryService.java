package fr.app.lorcanaDex.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    public CloudinaryService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String uploadImage(String imagePath) {
        try {
            // System.out.println("Uploading image with path: " + imagePath);
            Map uploadResult = cloudinary.uploader().upload(imagePath, ObjectUtils.asMap(
                    "transformation", new com.cloudinary.Transformation()
                            .width(300)
                            .height(400)
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