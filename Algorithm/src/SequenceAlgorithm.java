import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceAlgorithm {

	public static void main(String[] args) {
		int position = 300;
		
		System.out.println(findPosition(position));
	}
	public static int findPosition(int position){
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(0);
	    
	    while(position>list.size()){
	    	
	    	Integer[] replacedArray = new Integer[list.size()];
	    	
	        for (int counter=0; counter<list.size(); counter++){
	           if (list.get(counter) == 0)
	            	replacedArray[counter]  = 1;
	           else if (list.get(counter) == 1)
	        	   replacedArray[counter] = 2;
	           else if (list.get(counter) == 2)
	        	   replacedArray[counter] = 0;
	        }
	        
	        list.addAll(Arrays.asList(replacedArray));
	    }
	    System.out.println(list);
	    return list.get(position);
	}
}



