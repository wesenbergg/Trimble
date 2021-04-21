import java.util.Arrays;

public class BinaryImage {
	static final String ERROR_MESSAGE = "Error decoding image";

	private int numberOfLines;
	private String[] lines;
	private int lineValidator;
	private boolean isValid;
	
	public BinaryImage(int numberOfLines) {
		this.numberOfLines = numberOfLines;
		this.lines = new String[numberOfLines];
		this.isValid = true;
	}
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
	
	public void setLine(String line, int index) {
		if(lines[0] == null) setLineValidator(line);
		this.lines[index] = line;
	}
	
	private void setLineValidator(String line) {
		lineValidator = Arrays.stream(line.substring(1).trim()
				.split(" ")).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
	}
	
	private String handleLine(int index) {
		String result = "";
		String line = lines[index];
		int lineLength = 0;
		char firstChar = line.charAt(0);
		int[] lineArray = Arrays.stream(line.substring(1).trim()
				.split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < lineArray.length; i++) {
			lineLength += lineArray[i];
			for (int j = 0; j < lineArray[i]; j++) {
				result += firstChar;
			}
			firstChar = switchChar(firstChar);
		}
		isValid = (isValid && lineLength == lineValidator);
		return result + "\r\n";
	}
	
	private char switchChar(char currentChar) {
		return currentChar == '#' ? '.': '#';
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < lines.length; i++) {
			str += handleLine(i);
		}
		if(!isValid) str += ERROR_MESSAGE + "\r\n";
		isValid = true;
		return str;
	}
	
	public static final class BinaryImageBuilder {
		
		public static BinaryImage build(int lines) {
	        if(lines < 1 || lines > 100)
	        	throw new IllegalArgumentException(
	        			"The lines argument must be an integer between 1 and 100");

	        return new BinaryImage(lines);
	    }
	}
}
