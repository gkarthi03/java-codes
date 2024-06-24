import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Exe8 {

    public static void main(String[] args) throws Exception
    {
        
	        Signature sign = Signature.getInstance("SHA256withDSA");
      
	        KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
		    keyPair.initialize(2048);
		
		    KeyPair key = keyPair.generateKeyPair();
		
		    Cipher cipher = Cipher.getInstance("RSA");
		
		    cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
		
		    Scanner sc = new Scanner(System.in);
		    String str = sc.nextLine();
		
		    cipher.update(str.getBytes());
		
		    byte[] cipherText = cipher.doFinal();
		    System.out.println(new String(cipherText));
		
		    cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
		
		    byte[] decryptText = cipher.doFinal(cipherText);
		    System.out.println(new String(decryptText));
	}
}
