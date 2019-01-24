/*package com.connectivity.vikray.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.connectivity.vikray.entity.UserDetails;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtUtil {
	
	public static String genarateJwtToken (UserDetails userDetails) {
		 //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	    long expiMillis = System.currentTimeMillis() + (2 * 3600000);
	    Date expiration = new Date(expiMillis);
	    Map<String, Object> userMap = new HashMap<String, Object>();
	    userMap.put("id", userDetails.getId());
	    userMap.put("FullName", userDetails.getFirstName()+" "+userDetails.getLastName());
	    userMap.put("userId", userDetails.getUserLoginId());
	   // userMap.put("UserType", userDetails.get);
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("MyKey");
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setSubject("JWT Token")
	                                .claim("token", userMap)
	                                .setIssuer("vikraypmo.com")
	                                .setIssuedAt(now)
	                                .setExpiration(expiration)
	                                .signWith(signatureAlgorithm, signingKey);
	    parseJWT(builder.compact());
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}

	public static  void parseJWT(String jwt) {
		 
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary("MyKey"))
	       .parseClaimsJws(jwt).getBody();
	    System.out.println("ID: " + claims.getId());
	    System.out.println("Subject: " + claims.getSubject());
	    System.out.println("Issuer: " + claims.getIssuer());
	    System.out.println("token: " + claims.get("token"));
	    System.out.println("issue at: " + claims.getIssuedAt());
	    System.out.println("Expiration: " + claims.getExpiration());
	    if (claims.getExpiration().getTime() >  claims.getIssuedAt().getTime()) {
	    	System.out.println("Active");
	    } else {
	    	System.out.println("Expired");
	    }
	}
}
*/