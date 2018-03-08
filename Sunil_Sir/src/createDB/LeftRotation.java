package createDB;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    static void leftRotation(int[] a, int d) {
        // Complete this function
    	int shift=0,i;
    	int b= a.length;
    	
    	while(shift<d)
    	{
    		int temp=a[0];
    	for ( i = 0; i <b-1;i++) 
    	{
    		a[i]=a[i+1];
    		System.out.println(a[i] + " "+i);
         }
    	a[b-1]=temp;
    	//System.out.println(a[i] + " "+i);
    	shift++;
    	System.out.println(a[i] + " "+i);
    	}
    	
    //return leftRotation(a,d);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of d array ");
        int n = in.nextInt();
        System.out.println("Enter the number of places to be shifted");
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
       /* int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }*/
        System.out.println("");
        leftRotation(a, d);

        in.close();
    }
}