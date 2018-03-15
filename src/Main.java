import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	String pass ;
	String prob ;
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Body test = new Body("Hello");
		
		
		
			System.out.println(test.hash("hello"));
		
		
	}
 
 
}
