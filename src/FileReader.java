import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	private String fileName;
	private int maxTimeOfVehicle;
	private int velocityOfVehicle;
	private int numberOfVehicles;
	private int numberOfNodes;
	private int numberOfAttributes;
	private int[][] coordinates;
	private int[][] attributes;

	public FileReader(String fileName) {
		this.fileName = fileName;
	}

	public void readFile() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(new File(fileName));
		maxTimeOfVehicle = fileScanner.nextInt();
		numberOfVehicles = fileScanner.nextInt();
		numberOfNodes = fileScanner.nextInt();
		numberOfAttributes = fileScanner.nextInt();
		
		coordinates = new int[numberOfNodes + 1][2]; // +1 is for depot
		attributes = new int[numberOfNodes + 1][ numberOfAttributes]; // +1 is for depot
		
		int itemIndex = 0; 
		while (fileScanner.hasNextInt()) {
			// First getting the coordinates of current indexed item
			int x = fileScanner.nextInt();
			int y = fileScanner.nextInt();
			
			//Putting coordinates to array
			coordinates[itemIndex][0] = x;
			coordinates[itemIndex][1] = y;			

			// Second getting the attributes of current indexed item and putting to array
			for (int i = 0; i < numberOfAttributes; i++) {
				attributes[itemIndex][i]= fileScanner.nextInt();
			}
			
			itemIndex++;
		}		
	}

	public int getMaxTimeOfVehicle() {
		return maxTimeOfVehicle;
	}

	public int getVelocityOfVehicle() {
		return velocityOfVehicle;
	}

	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public int[][] getCoordinates() {
		return coordinates;
	}

	public int[][] getAttributes() {
		return attributes;
	}
	
	public int getNumberOfAttributes() {
		return numberOfAttributes;
	}

	@Override
	public String toString() {
		return "FileReader [fileName=" + fileName + ", maxTimeOfVehicle="
				+ maxTimeOfVehicle + ", velocityOfVehicle=" + velocityOfVehicle
				+ ", numberOfVehicles=" + numberOfVehicles + ", numberOfNodes="
				+ numberOfNodes + ", numberOfAttributes=" + numberOfAttributes
				+ "]";
	}

}
