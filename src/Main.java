import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	String pass ;
	String prob ;
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Body test = new Body("abc");
		
		System.out.println(test.brute(4,'a',test.hash("D9o!")));
	}
 
 
}
