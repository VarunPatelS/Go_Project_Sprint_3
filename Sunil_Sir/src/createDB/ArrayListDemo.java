package createDB;

import java.util.*;

public class ArrayListDemo {
	public static void main(String[] args) 
	{
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(10);
		l1.add(11);
		l1.add(12);
		l1.add(13);
		l1.add(14);
		l1.add(23);
		System.out.println(l1.size());
		for(int x: l1)
		{
			System.out.println(x);
		}
		
	}

}
