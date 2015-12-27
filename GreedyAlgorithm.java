import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GreedyAlgorithm 
{

	private static int sourceCity = 0;
	private static int citiesCount = 0;

	public static void setValues(int source, int cities)
	{
		citiesCount = cities;
		sourceCity = source;
	}
	
	public static void search(DistanceMatrix distanceMatrix) {
		// TODO Auto-generated method stub
		ArrayList<Integer> visited = new ArrayList<Integer>(citiesCount);
		ArrayList<City> children = new ArrayList<City>(citiesCount);
		int cost = 0;	
		int currentCity = 0;
		
		
		long startTime = System.currentTimeMillis();
		
		currentCity = sourceCity;
		while (visited.size() != citiesCount && citiesCount != 1)
		{		
			visited.add(currentCity);

			for (int i = 0; i < citiesCount; i++)
			{
				if (currentCity != i && !visited.contains(i))
				{
					// tree construction not required so avoiding level and parent pointer.
					children.add(new City(i, distanceMatrix.distance_matrix[currentCity][i], -1, null)); 
				}
					
			}
			
			children.sort(new Comparator<City>() {

				@Override
				public int compare(City a, City b) {
					// TODO Auto-generated method stub
					return a.cost - b.cost;
				}
			});
			
			if (!children.isEmpty())
			{
				currentCity = children.get(0).number;
				cost = cost + children.get(0).cost;
				children.clear();
			}
		}
		
		if (citiesCount != 1)
			cost = cost + distanceMatrix.distance_matrix[visited.get(visited.size() - 1)][sourceCity];
		
		visited.add(sourceCity);
		
        long endTime = System.currentTimeMillis();
        
        System.out.println("Shortest Route : " + visited);
    	System.out.println("Tour Cost : " + cost);
    	System.out.println("Tour Time : " + (endTime - startTime) + " ms");
	}

}
