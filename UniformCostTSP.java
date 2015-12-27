import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class UniformCostTSP 
{
	private static PriorityQueue<City> pQueue;
	private static ArrayList<Integer> optimalRoute;
	private static int sourceCity = 0;
	private static int citiesCount = 0;
	private static int optimalCost = Integer.MAX_VALUE;
	
	public static void setValues(int source, int cities)
	{
		citiesCount = cities;
		sourceCity = source;
	}
	
	public static void search(DistanceMatrix matrix)
	{		
		pQueue = new PriorityQueue<City>(citiesCount, new Comparator<City>() 
		{
			@Override
			public int compare(City a, City b) {
				// TODO Auto-generated method stub
				return a.cost - b.cost;
			}
			
		});
		optimalRoute = new ArrayList<Integer>(citiesCount);
		boolean solution = false;
		
		// start timer
        long startTime = System.currentTimeMillis();
        
        pQueue.add(new City(sourceCity, 0, 0, null));
        
        while (!pQueue.isEmpty() && !solution)
        {
        	optimalRoute.clear();
        	City visitedCity = pQueue.poll();
        	optimalRoute.add(visitedCity.number);
        	
        	City tempCity = visitedCity;
        	while(tempCity.level != 0)
        	{
        		tempCity = tempCity.parent;
        		optimalRoute.add(tempCity.number);
        	}
        	
        	if (visitedCity.level != citiesCount && citiesCount != 1)
        	{
        		for (int i = 0; i < citiesCount; i++)
            	{
            		boolean visited = optimalRoute.contains(i);
            		boolean isSolution = (optimalRoute.size() == citiesCount)&&(i == sourceCity);
            		
            		if (!visited || isSolution)
            		{
            			City neighbourCity = new City(i, visitedCity.cost + matrix.distance_matrix[visitedCity.number][i],
            					visitedCity.level + 1, visitedCity);
            			pQueue.add(neighbourCity);
            		}
            	}
        	}
        	else
        	{
        		solution = true;
        		optimalCost = visitedCity.cost;
        	}  	
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Shortest Route : " + optimalRoute);
    	System.out.println("Tour Cost : " + optimalCost);
    	System.out.println("Tour Time : " + (endTime - startTime) + " ms");
		
	}
}
