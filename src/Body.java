import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Body {
	public Body() {


	}

	public String brute(int wortla, char einschr, String testpass) throws NoSuchAlgorithmException {

		int wortl = wortla;
		Double mengedouble;
		int menge;
		char einsch = einschr;
		int anzahlzeichen = 0;
		String testwort = testpass;
		String ergebnis;

		if (einsch == 'a') {
			anzahlzeichen = 126 - 33;
		}
		if (einsch == 'b') {
			anzahlzeichen = (90 - 65) + (122 - 97);
		}
		if (einsch == 'z') {
			anzahlzeichen = 10;
		}

		for (int i = 1; i <= wortl; i++) {

			mengedouble = Math.pow(anzahlzeichen, i);
			menge = mengedouble.intValue();

			ergebnis = wortconst(wortl, einsch, menge, testwort);
			if (ergebnis != "") {
				return ergebnis;
			}
			;

		}

		return ("passwort nicht gefunden");

	}

	public String wortconst(int lang, char einschr, int meng, String testw) throws NoSuchAlgorithmException {
		int menge = meng;
		char einsch = einschr;
		int[] wort = new int[lang];
		String ergebnis = "";
		String ergebnishash = "";
		String testwort = testw;
		if (einsch == 'a') {
			for (int o = 0; o < wort.length; o++) {
				wort[o] = 33;
			}
			for (int q = 0; q <= menge; q++) {

				if (wort[0] == 127) {

					for (int i = 1; i < wort.length; i++) {
						if (wort[i - 1] == 127) {
							wort[i]++;
							wort[i - 1] = 33;
						}
					}
				}
				for (int p = 0; p < wort.length; p++) {
					ergebnis = ergebnis + Character.toString((char) (int) wort[p]);
				}

				ergebnishash = hash(ergebnis);
				//System.out.println(ergebnis +": "+ergebnishash+testw);
				if (ergebnishash.equals(testw)) {

					return ergebnis;
				}
				ergebnis = "";
				wort[0]++;
			}
		}

		if (einsch == 'b') {
			for (int o = 0; o < wort.length; o++) {
				wort[o] = 65;
			}
			for (int q = 0; q <= menge; q++) {
				if (wort[0] == 91) {
					wort[0] = 97;
				}
				if (wort[0] == 123) {
					for (int i = 1; i < wort.length; i++) {
						if (wort[i - 1] == 123) {
							wort[i]++;
							if (wort[i] == 91) {
								wort[i] = 97;
							}
							wort[i - 1] = 65;
						}
					}
				}
				for (int p = 0; p < wort.length; p++) {
					ergebnis = ergebnis + Character.toString((char)(int) wort[p]);
				}

				ergebnishash = hash(ergebnis);
				//System.out.println(ergebnis +": "+ergebnishash+testw);
				if (ergebnishash.equals(testw)) {

					return ergebnis;
				}
				ergebnis = "";
				wort[0]++;
			}

		}
		return "";
	}
		public String hash(String m) throws NoSuchAlgorithmException {

			//hashen
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(
					m.getBytes(StandardCharsets.UTF_8));


			//zu String wandeln

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < encodedhash.length; i++) {
				String hex = Integer.toHexString(0xff & encodedhash[i]);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);


			}
			return hexString.toString();
		}
}
