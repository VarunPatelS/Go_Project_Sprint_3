package createDB;

class Distinct{
	 
    public static void prgm(int[] arr){
         
        for(int i=0;i<arr.length;i++){
            boolean found = false;
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print(arr[i]+" ");
            }
            for(int k=arr.length;i<=0;i--)
    		{
    		    System.out.println("Reverse is"+k);
    		    k--;
    		}
        }
    }
     
    public static void main(String a[]){
         
        int[] num = {1,2,1,5,7,9,9,8};
        Distinct.prgm(num);
    	
    
    
    }
}
