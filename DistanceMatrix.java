import java.awt.Point;

public class DistanceMatrix 
{

	public int distance_matrix[][];
	public int citiesCount = 0;
	
	public static int x[] = {34,47,5,93,91,57,55,2,46,32,99,8,87,92,39,72,66,5,44,18,59,88,75,64,49,23,77,92,11,70,39,32,79,54,
			90,70,39,72,77,3,80,74,63,66,94,78,14,17,65,52,36,73,4,76,12,54,33,53,77,36,14,75,49,51,90,30,29,
			85,11,73,29,49,77,55,32,59,86,18,48,0,9,69,57,80,30,59,47,75,23,7,28,78,37,7,3,76,86,45,
			43,58,75,58,12,28,55,37,23,6,61,14,29,95,22,63,29,78,29,50,86,84};
	
	public static int y[] = {63,1,31,9,64,45,44,40,3,29,83,27,93,38,83,2,86,70,73,43,76,80,13,
			11,20,9,94,5,91,0,42,61,90,53,89,47,70,95,61,41,19,83,61,88,60,63,25,86,16,89,40,21,10,
			29,93,86,93,56,61,39,6,94,32,9,0,76,3,1,88,37,48,22,8,67,12,43,73,26,74,32,98,40,1,94,
			50,32,19,71,71,94,79,59,19,85,12,44,64,55,27,37,67,79,39,39,68,88,2,21,35,89,62,34,26,22,58,61,96,5,47,1};
	
	
	public DistanceMatrix(int citiesnum)
	{
		this.citiesCount = citiesnum;
		distance_matrix = new int[citiesCount][citiesCount];
		
		// create the distance matrix from coordinates of the cities.
		for (int i = 0; i < citiesCount; i ++)
		{
			for (int j = 0; j < citiesCount; j ++)
			{
				if (i == j)
				{
					distance_matrix[i][j] = 0;
				}
				else
				{
					distance_matrix[i][j] = (int) Math.hypot((x[j] - x[i]),(y[j] - y[i]));
					distance_matrix[j][i] = distance_matrix[i][j];
				}
				//System.out.print(distance_matrix[i][j] + " ");
			}
			//System.out.print("\n");
		}
		//System.out.print("\n");
	}
	
	public static Point getCityPosition(int cityNumber)
	{
		Point point = new Point(x[cityNumber], y[cityNumber]);
		return point;
	}
	
}
