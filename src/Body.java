import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Body {
	String pass;
	public Body (String a) {
		pass = a;
	}
	public  boolean vergleich (String a, String b) {
		 if (a == b) {
			 return true;
		 }
		 return false;
		 
	 }
	 public String hash (String m) throws NoSuchAlgorithmException {
		 
		 //hashen
		 MessageDigest digest = MessageDigest.getInstance("SHA-256");
		 byte[] encodedhash = digest.digest(
		   m.getBytes(StandardCharsets.UTF_8));
		 
		 
		 //zu String wandeln
		 
		 StringBuffer hexString = new StringBuffer();
		    for (int i = 0; i < encodedhash.length; i++) {
		    String hex = Integer.toHexString(0xff & encodedhash[i]);
		    if(hex.length() == 1) hexString.append('0');
		        hexString.append(hex);
		 
		 
	 }
		    return hexString.toString();
	 }
}
