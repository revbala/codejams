import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewYearParty {

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=10) {

	        for(int i=1; i<=T; i++) {
	        	int N= Integer.parseInt(scanner.nextLine().trim()); ///number of Players
	        	
	        	String[] tickets = scanner.nextLine().split(" ");
	        	boolean invalidTicketNumber = false;
	        	if(N>=1 && N<=10000 && tickets.length == N) {
	        		List<Integer> ticketsList = new ArrayList<Integer>();
	        		
	        		boolean allnegatives = true;
	        		
	        		for (int counter=0; counter<N; counter++) {
	        			int ticketInt = Integer.parseInt(tickets[counter]);
	        			if(ticketInt<-1000 || ticketInt >1000) {
	        				invalidTicketNumber = true;
	        				break;
	        			}
	        			if(ticketInt>0) {
	        				allnegatives = false;
	        			}
	        			ticketsList.add(ticketInt);
	        		}
	        		if (invalidTicketNumber) {
	        			continue;
	        		}
	        		if(allnegatives == true) {
	        			continue;
	        		}
	        		System.out.println(maxSum(ticketsList));
	        	}
	        }
        
        }
        scanner.close();
  
	}
	
	public static String maxSum(List<Integer> tickets){
		
		List<Integer> selectedList = new ArrayList<Integer>();
		int maxSum = 0;
		if(tickets.size() == 1){
			return tickets.toString();
		}
		
		int counter=0;
		
		while (counter<2) {
			int sum=0;
			List<Integer> innerList = new ArrayList<Integer>();
			for(int j=tickets.size()-1-counter; j>=0; j=j-2)
			{
				
				if(tickets.get(j)<=0) {
					//if atleast one positive number then do not process the negative number
					continue;					
				}
				sum = sum + tickets.get(j);
				innerList.add(tickets.get(j));
				
			}
			if(sum > maxSum)	{
				maxSum = sum;
				selectedList = innerList;
			}
			else if(sum == maxSum)	{
				int i=0;
				while(i<innerList.size() && i<selectedList.size()) {
					if(innerList.get(i) > selectedList.get(i)) {
						selectedList = innerList;
					}else if(innerList.get(i) < selectedList.get(i)){
						break;
					}
					i++;
				}
			}

			counter++;
			
		}
		

		StringBuilder builder = new StringBuilder();
		for(int item: selectedList) {
			builder.append(item);
		}
		return builder.toString();
	}
	
	
}



