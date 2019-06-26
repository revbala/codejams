import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPyramid {

	public static void main(String[] args) {
		int depth = 5;
		
		printPyramid(depth);
	}
	public static void printPyramid(int depth){
	    
			int rowLength = 2*depth -1;
			int printnum = depth*2-1;
			
			for(int row=depth; row>=1; row--){
				StringBuilder builder = new StringBuilder("");
				int spacecount = depth-row;
				int numbercolumns = rowLength - 2*spacecount ;
				for(int col=1; col<=rowLength; col++) {
					if(col<=spacecount) builder.append(" ");
					else if (col>spacecount && col< spacecount + numbercolumns+1) {
						builder.append(printnum);					
					}
					else {
						builder.append(" ");
					}
				}
				printnum-=2;
				System.out.println(builder.toString());
				
			}
		}
	
//public static void printPyramid(int depth){
//	    
//		int rowLength = 2*depth -1;
//		int median = depth;
//		
//		for(int row=1; row<=depth; row++){
//			StringBuilder builder = new StringBuilder("");
//			int printnum = 1;
//			int spacecount = depth-row;
//			int numbercolumns = rowLength - 2*spacecount ;
//			for(int col=1; col<=rowLength; col++) {
//				if(col<=spacecount) builder.append(" ");
//				else if (col>spacecount && col< spacecount + numbercolumns+1) {
//					if(col < median) builder.append(printnum++);
//					else if(col >= median) builder.append(printnum--);
//				}
//				else {
//					builder.append(" ");
//				}
//			}
//			System.out.println(builder.toString());
//			
//		}
//	}
//	
}



