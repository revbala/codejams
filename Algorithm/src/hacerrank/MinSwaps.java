package hacerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinSwaps {
	 // Complete the minimumSwaps function below.
	
    static int minimumSwaps(int[] arr) {
        int link=0;
        int nextItem=0;
        Map< Integer,Integer> visitedMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
			if(i+1 == arr[i] ) continue;//no swap needed move on continue;
			else {
				nextItem = arr[i];
				if(visitedMap.get(nextItem)!=null) continue; //already visited
				while(visitedMap.get(nextItem)==null) {
					
					visitedMap.put(nextItem,nextItem);
					nextItem = arr[nextItem-1];
					link++;
				}
				link--;
			}
				
		}
		
		return link;

    }
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
