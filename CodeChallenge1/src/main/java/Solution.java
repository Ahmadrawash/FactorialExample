import java.util.ArrayList;
import java.util.List;

public class Solution {
 public static void main(String arg[])
 {
      Result r = new Result();
      r.StairCase(10);

          //System.out.println("max is: " + r.hourglassSum(arraylist));

 }
}

class Result
{
     public void StairCase(int n)
     {
          if ( n >= 1 && n <= 100)
          {
           for (int i = 0 ; i < n ; i++) //4.
           {
            //print spaces (indentation)
             for (int j = 0; j < n-i-1; j++)
             {
              System.out.print(" ");

             }
             //print hash
             for (int j = n-i-1; j< n ; j++)
             {
              System.out.print("#");
             }

            System.out.println();
           }
          }
     }

   public String caesarCipher(String s, int k) {
    // Write your code here
    String newStr = "";
    if (s.length() >= 1 && s.length() <= 100)
     if (k >= 0 && k <= 100)
     {
      int i =0;
      while (i < s.length())
      {
       if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
       {
        if (((int)(s.charAt(i) + k) < (int)('z')) || ((int)(s.charAt(i) + k ) < (int)('Z')))
         newStr += (char)(s.charAt(i) + k);
        else
         newStr += (char)((int)('a') + (int)('z') - (int)(s.charAt(i)) + k-1);
       }
       else if ( (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
       {
        if (((int)(s.charAt(i) + k) < (int)('Z')) || ((int)(s.charAt(i) + k ) < (int)('Z')))
         newStr += (char)(s.charAt(i) + k);
        else
         newStr += (char)((int)('A') + (int)('Z') - (int)(s.charAt(i)) + k-1);
       }
       else
        newStr += s.charAt(i);

       //increment to next character in string s
       if (i < s.length())
        i++;
       else
        i = 0;
      }
     }
    return newStr;
   }

   public void printarray(int[][] array){
       for (int i = 0 ; i < 6 ; i++){
           for(int j = 0 ; j < 6 ; j++)
           {
               System.out.println(array[i][j] + ", ");
           }
           System.out.println();
       }

   }
    public int hourglassSum(List<List<Integer>> arr) {
     // Write your code here

        int[][] array = new int[6][6];
        for (int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 6 ; j++)
            {
                array[i][j] = arr.get(i).get(j);
                }
            }
        /*
        int id = 0, jd = 0;
        for(List<Integer> l : arr) {
            for (int e : l) {
                array[id++][jd] = e;
                if (id > 3) id = 0;
                if (jd > 3) jd = 0;
            }

        }
        */

         //printarray(array);

     int[] sums = new int[16];
     int c = 0;
     for (int i = 0 ; i <= 3 ; i++)
      for(int j = 0 ; j <= 3 ; j++)
      {
          if (c < 16)
             sums[c++] =
                     (array[i][j] + array[i][j+1] + array[i][j+2] + array[i+1][j+1] +
                             array[i+2][j] + array[i+2][j+1] + array[i+2][j+2]);
      }

     for(int[] i : array)
     {
      for(int j : i)
       System.out.print(j + " ");
      System.out.println();
     }
     int max = sums[0];
     for(int i = 0 ; i < 16 ; i++)
      if (sums[i] > max)
       max = sums[i];
     return max;
     }

}


