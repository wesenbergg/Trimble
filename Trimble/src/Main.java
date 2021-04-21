
/**
 * Main tehtävä 1.
 * 
 * Tehtävä 2 maini löytyy Main2.java tiedostosta.
 * Tehtävä kolmen vastaus löytyy Kittens-projektista.
 * @author Boriss
 */
public class Main {
	
	/**
	 * Tehtävä 1. Anna ensimmäisellä rivillä n-määrä havaintoja,
	 * jossa 1 < n < 1000.
	 * Syötä sen jälkeen n kertaa rivejä siten, että yhdellä rivillä on kaksi lukua.
	 * Ensimmäinen luku x viittaa junan kellotaulun olevien minuuttien määrään (jäljellä oleva odotusaika),
	 * jossa 0 < x < 60 ja x kuuluu kokonaislukuihin.
	 * Toinen luku y viittaa, mikä oli todellinen odotusaika sekunteina,
	 * jossa 0 < y < 3600 ja y kuuluu kokonaislukuihin.
	 * Ohjelma printtaa ulos kellotaulun todellisen minuutin keskiarvon.
	 * Jos tulos jää kuitenkin alle ykkösen halutaan printata ulos
	 * "measurment error".
	 * @param args
	 */
	public static void main(String[] args) {
		DelayLag dl = new DelayLag();
		dl.run();
	}
}
