import java.util.Scanner;

public class DelayLag {

	private int nOfObservations;
	private int sumMinutes;
	private int sumSeconds;
	
	private Scanner lukija;
	
	public DelayLag() {
		this.sumMinutes = 0;
		this.sumSeconds = 0;
		this.lukija = new Scanner(System.in);
	}
	
	public int[] readNLine() {
		int[] result = new int[2];
		for (int i = 0; i < result.length; i++) {
	        if (lukija.hasNextInt()) {
	            result[i] = lukija.nextInt();
	            if(result[i] < 0)
	            	throw new IllegalArgumentException();
	        }
	        else
	        	throw new IllegalArgumentException();
	    }
		if(result[0] > 60)
			throw new IllegalArgumentException();
		if(result[1] > 3600)
			throw new IllegalArgumentException();
		return result;
	}
	
	public void run() {
		nOfObservations = lukija.nextInt();
		if(nOfObservations < 1 || nOfObservations > 1000)
			throw new IllegalArgumentException();
		for (int i = 0; i < nOfObservations; i++) {
			int[] nLine = readNLine();

			sumMinutes += nLine[0];
			sumSeconds += nLine[1];
		}
		
		double res = sumSeconds / (double) (sumMinutes * 60);
		if(res <= 1)
			System.out.println("measurment error");
		else 
			System.out.printf("Value: %.9f", res);
	}
}
