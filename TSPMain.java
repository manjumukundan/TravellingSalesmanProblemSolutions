import java.util.Scanner;

public class TSPMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Algorithms\n");
		System.out.print("1) Uniform Cost Search\n");
		System.out.print("2) Greedy Algorithm\n");
		System.out.print("Choose the number: ");
		int algorithm = scan.nextInt();
		System.out.print("Enter the no of cities : ");
		int citiesCount = scan.nextInt();
		System.out.print("Enter the source city : ");
		int sourceCity = scan.nextInt();
		
		DistanceMatrix matrix = new DistanceMatrix(citiesCount);
		
		switch (algorithm) {
		case 1:
			UniformCostTSP.setValues(sourceCity, citiesCount);
			UniformCostTSP.search(matrix);
			break;
			
		case 2:
			GreedyAlgorithm.setValues(sourceCity, citiesCount);
			GreedyAlgorithm.search(matrix);
			break;

		default:
			break;
		}
		scan.close();
	}

}
