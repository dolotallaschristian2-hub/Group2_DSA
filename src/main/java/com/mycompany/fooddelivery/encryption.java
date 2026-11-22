package com.mycompany.fooddelivery;
import java.util.*;
import java.security.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;

public class encryption {
    public static String hash(String pass)throws Exception{
        byte[] salt = new byte[16];
        SecureRandom encrypt = new SecureRandom();
        encrypt.nextBytes(salt);
        
        PBEKeySpec key = new PBEKeySpec(pass.toCharArray(), salt, 10000, 256);
        SecretKeyFactory fact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        
        byte[] sha = fact.generateSecret(key).getEncoded();
        
        
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(sha);
        
    }
    public static boolean Password(String password, String hashs)throws Exception{
        
        String[] parts = hashs.split(":");
        if(parts.length != 2){
        return false;    
        }
        
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storeshash = Base64.getDecoder().decode(parts[1]);
        
        PBEKeySpec pec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        
        SecretKeyFactory facts = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        
        byte [] newhash = facts.generateSecret(pec).getEncoded();

        return MessageDigest.isEqual(storeshash, newhash);
    }
}
