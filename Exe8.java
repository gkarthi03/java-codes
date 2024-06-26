import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class Exe8 {

    public static void main(String[] args) throws Exception
    {
	        KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
		    keyPair.initialize(2048);
		
		    KeyPair key = keyPair.generateKeyPair();
		
		    Cipher cipher = Cipher.getInstance("RSA");
		
		    cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());

            String str = "";

           for(int i=0;i<args.length;i++)
           {
                if (i != args.length-1) {
                    str += args[i]+" ";
                }
                else
                {
                    str += args[i];
                }
           }
		
		    cipher.update(str.getBytes());
		
		    byte[] cipherText = cipher.doFinal();
		    System.out.println(new String(cipherText));
		
		    cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
		
		    byte[] decryptText = cipher.doFinal(cipherText);
		    System.out.println(new String(decryptText));
	}
}
