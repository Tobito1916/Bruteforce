import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Body test = new Body();
		
		System.out.println(test.brute(4,'z',test.hash("1337")));
	}
 
 
}
