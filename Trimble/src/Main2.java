import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main tehtävä 2
 * @author Boriss
 *
 */
public class Main2 {
	/**
	 * Tehtävä 2. Halutaan printata ulos kuvia.
	 * Kuvat muodostuvat '.' ja '#' merkeistä.
	 * Kuvan algoritmi toimii siten, että kuvan ensimmäiselle
	 * riville syötetään n-luku eli kuvan rivien määrä. Sen jälkeen kuvalle
	 * syötetään n riviä syötettä. Jokainen rivi näistä n-riveistä
	 * alkaa joko '.' tai '#', tämä siis osoittaa, millä
	 * merkillä rivin tulostus pitäisi aloittaa.
	 * Aloitusmerkin jälkeen lisätään jono lukuja.
	 * Luvut osoittavat montako kertaa kirjoitetaan tämä merkki,
	 * ennenkuin merkkiä tulisi vaihtaa.
	 * Ohjelmassa halutaan lukea enintään 10 kuvaa kerralla
	 * ja jokainen kuva tulisi erotella ylimääräisellä rivillä.
	 * Jokaisen kuvan rivillä tulisi olla saman verran,
	 * rivejä. Jos tämä ei ehto täyty, tulostetaan kuvan
	 * perään virheviesti "Error decoding image".
	 * n=0 lopettaa syötteen lukemisen ja tulostaa kuvat.
	 * 
Esimerkkisyöte:
2
. 1 3 4
# 2 1 2 3
3
. 1 2 1
# 1 2 1
. 1 2 1
0
  
	 * Tulostus:
	 * .###....
	 * ##.##...
	 * 
	 * .##.
	 * #..#
	 * .##.
	 * 
	 */
	static final int MAX_IMAGE_COUNT = 10;
	static Scanner lukija = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<BinaryImage> images = new ArrayList<>();
		
		for (int i = 0; i < MAX_IMAGE_COUNT; i++) {
			int imageLength = Integer.parseInt(lukija.nextLine());
			if(imageLength == 0) break;
			images.add(
					BinaryImage.BinaryImageBuilder.build(imageLength));
			for (int j = 0; j < imageLength; j++) {
				images.get(i).setLine(lukija.nextLine(), j);
			}
		}
		
		for (BinaryImage binaryImage : images) {
			System.out.println(binaryImage);
		}
	}
}
