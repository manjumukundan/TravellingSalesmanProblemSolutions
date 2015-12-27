import java.awt.Point;
import java.util.ArrayList;

public class City 
{
	public int number = -1;
	public int cost = 0;
	public int level = 0;
	public City parent = null;
	public Point points = null;
	
	public City(int number, int cost, int level, City parent)
	{
		this.number = number;
		this.cost = cost;
		this.level = level;
		this.parent = parent;
	}
	
}
