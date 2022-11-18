package th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solutio {


    @org.junit.Test
    public void testScenarioA()
    {
        int[]A =  new int[] {5,3,6,1,3};
        int gap = solution(A , 4);
        Assert.assertEquals(0 , gap);
    }

    @org.junit.Test
    public void testScenarioB()
    {
        //new int[] {1,5,2, -2}
        //String gap = solution("ABCBBCBA");
        //Assert.assertEquals("" , gap);
       // System.out.println(gap);
    }


    @Test
    public void testScenarioC()
    {
        //new int[] {1,5,2, -2}
       // String gap = solution("BABABA");
        //Assert.assertEquals("BABABA" , gap);
       // System.out.println(gap);
    }



    public int solution(int[] A, int K)
    {
        int size = A.length ;
        int minDiff = Integer.MAX_VALUE ;
        for(int i=0 ; i< size;i++ )
        {
            if(i < (size - (K-1)))
            {
                int[] consecativeArray = Arrays.copyOfRange(A , i , i+K );
                int[] consecativeArray1 = Arrays.copyOfRange(A , 0 , i) ;
                int[] consecativeArray2  = Arrays.copyOfRange(A , i+K , A.length) ;
                int min = 0;
                int max = 0;

                if(consecativeArray1.length > 0 && consecativeArray2.length > 0)
                {
                     min =  Math.min( Arrays.stream(consecativeArray1).min().getAsInt() ,  Arrays.stream(consecativeArray2).min().getAsInt()) ;
                     max = Math.max(Arrays.stream(consecativeArray1).max().getAsInt() , Arrays.stream(consecativeArray2).max().getAsInt());

                }
                else if(consecativeArray1.length > 0 && consecativeArray2.length == 0 )
                {
                    min = Arrays.stream(consecativeArray1).min().getAsInt() ;
                    max = Arrays.stream(consecativeArray1).max().getAsInt() ;
                }
                else if (consecativeArray1.length == 0 && consecativeArray2.length > 0)
                {
                    min = Arrays.stream(consecativeArray2).min().getAsInt() ;
                    max = Arrays.stream(consecativeArray2).max().getAsInt() ;
                }

                int diff = max - min ;

                if(diff < minDiff)
                {
                    minDiff = diff ;
                }
            }
            else
            {
                break;
            }
        }
       return minDiff ;
    }
}
