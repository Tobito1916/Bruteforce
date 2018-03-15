import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Body {
	static int merk;
	String pass;
	public Body (String a) {
		pass = a;
	}

	public String brute (int wortla, char einschr){
		merk =0;
		int wortl = wortla;
		Double mengedouble;
		int menge;
		char einsch = einschr;
		int anzahlzeichen = 0;
		String testwort;
		String ergebnis;

		if (einsch == 'a'){
			anzahlzeichen = 126 - 33;
		}
		if (einsch == 'b'){
			anzahlzeichen = (90 - 65) + (122 - 97);
		}
		if (einsch == 'z'){
			anzahlzeichen = 10;
		}

		for (int i = 1; i <= wortl; i++ ){

			mengedouble = Math.pow(anzahlzeichen, i);
			menge = mengedouble.intValue();

			for(int p = 1; p <= menge ; p++){
				if(vergleich(wortconst(i,einsch,p),pass)){
					return(wortconst(i,einsch,p));
				};
			}

		}

		return ("passwort nicht gefunden");

	}

	public String wortconst (int lang, char einschr, int posi){
		int pos = posi;
		if ((pos - (merk *122)) == 123){
			merk++;
		};
		char einsch = einschr;
		String ergebnis = "noch nix";
		if (einsch == 'a'){
			int[] erg = new int[lang];
			int s = pos - (merk*122);
			if (s == 1){
				erg[1] = 33 + merk;
				for (int o = 1; o < lang; o++ ){
					erg[o] = 33;
				}



			}else{

			}
		}
		if (einsch == 'b'){
			for (int i = 1; i <=lang; i++){
				int ascii = 64+posi;
				if (ascii == 91){
					ascii = 97;
				}
				ergebnis = ergebnis + Character.toString((char)(int)ascii);
			}
		}



		//ergebnis = ergebnis + ; //wort wird laenger;
		return ergebnis;
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
