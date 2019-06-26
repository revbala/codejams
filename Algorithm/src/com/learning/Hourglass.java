package com.learning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Hourglass {


    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int maxSum=0;
    	int interimSum=0;
    	for (int i = 0; i < arr.length-2; i++) {
			for (int j = 0; j < arr.length-2; j++) {
				interimSum=findSumOfHourglass(i, j, arr);
				if(i==0&&j==0) maxSum = interimSum;
				else if(interimSum > maxSum) maxSum = interimSum;
			}
		}
    	return maxSum;
    }
    
    static int findSumOfHourglass(int row, int column, int[][] arr) {
    	int sum=0;
    	for (int i = row; i <= row+2; i++) {
    		for (int j = column; j <= column+2; j++) {
    			//skip for 1,0 & 1,2
    			if(i==row+1 && (j==column+2 || j==column)) continue;
    			sum = sum + arr[i][j];
			}
			
		}
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                if (arrItem>9) return;
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
