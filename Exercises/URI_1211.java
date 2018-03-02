package uri_1211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI_1211 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = br.readLine();
            int[][] numbers;
            int cases;

            while (!input.equals("") && !input.equals("0")) {
                cases = Integer.parseInt(input);
                input = br.readLine();
                numbers = new int[cases][input.length()];

                for (int j = 0; j < input.length(); j++) 
                    numbers[0][j] = Integer.parseInt(input.substring(j, j + 1));
                

                for (int i = 1; i < cases; i++) {
                    input = br.readLine();
                    for (int j = 0; j < input.length(); j++) 
                        numbers[i][j] = Integer.parseInt(input.substring(j, j + 1));
                    
                }
                
                numbers = radixSort(numbers);

                int counter = 0;
                for (int i = 1; i < cases; i++) {
                    for (int j = 0; j < input.length(); j++) {
                        if (numbers[i - 1][j] == numbers[i - 1][j]) 
                            counter += 1;
                        else 
                            break;
                        
                    }

                }
                System.out.println(counter);
                input = br.readLine();
            }
        } catch (Exception ex) {}
    }

    public static int[][] radixSort(int[][] numbers) {
        for (int j = numbers[0].length - 1; j >= 0; j--) 
            sort(numbers, j);
        
        return numbers;
    }

    public static int[] sort(int[][] array, int column) {
        if (array.length > 1) //Condition to end recursive: If array is of size equal to 1, no more calls are necessary
        {
            int n = array.length / 2; //Get half size of the array
            int[][] array_left = new int[n][array[0].length]; //Create array of the left side of n size
            int[][] array_right = new int[array.length - n][array[0].length]; //Create array of the right side 

            for (int i = 0; i < n; i++) //Copy first half of the array inside left array
            {
                array_left[i] = array[i]; //Copy data
            }
            for (int i = 0; i < array_right.length; i++) //Copy second half of the array inside right array      
            {
                array_right[i] = array[n + i]; //Copy data
            }
            array_left = sort(array_left, column); //Call recursive to order array of left size
            array_right = sort(array_right, column); //Call recursive to order array of left size

            return merge(array_left, array_right); //Merge order arrays of both left and right size
        } else {
            return array; //Return array if his size is 1 
        }
    }

    public static int[][] merge(int[][] array_left, int[][] array_right, int column) {
        int[] temp = new int[array_left.length + array_right[0].length]; //Create array of complete size, i.e. size of left array plus size of right array
        int left = 0, right = 0, index = 0; //Index for: left array, right array, and temp array. All must start in zero.

        while (left < array_left.length && right < array_right.length) //While are still elements inside left array or right array, we can made comparisons
        {
            if (array_left[left] <= array_right[right]) //If element in left array is minor or equal to element in right array
            {
                temp[index] = array_left[left]; //Add element of left array
                left += 1; //Because we add an element of left array, index that control left array must increase
            } else {
                temp[index] = array_right[right]; //Add element of right array
                right += 1; //Because we add an element of right array, index that control right array must increase
            }

            index += 1; //Increase index of complete array
        }

        if (left < array_left.length) //If there are still element in left array
        {
            for (int i = left; i < array_left.length; i++) //Add all elements of left array
            {
                temp[index] = array_left[left]; //Add element
                left += 1; //Increase index over left array
                index += 1; //Increase index over complete array
            }
        } else //If there are still element in left array
        {
            for (int i = right; i < array_right.length; i++) //Add all elements of right array
            {
                temp[index] = array_right[right]; //Add element
                right += 1; //Increase index over right array
                index += 1;  //Increase index over complete array
            }
        }

        return temp; //Return complete array 
    }
}
