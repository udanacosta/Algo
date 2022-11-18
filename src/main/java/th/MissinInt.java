package th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MissinInt {

    @Test
    public void testScenarioA() {
        int gap = solution(new int[] {1, 3, 6, 4, 1, 2});
        Assert.assertEquals(5 , gap);
//        int gap2 = solution(new int[] {-1,-3});
//        Assert.assertEquals(gap2 , 1);
        System.out.println(gap);
    }


    public int solution(int[] A)
    {
        int[] deduplicatedArray = Arrays.stream(A).distinct().toArray();
        int [] sortedArray = Arrays.stream(deduplicatedArray).sorted().toArray();
        int firstPositiveIndex = 0 ;
        boolean fistPositiveFound = false ;
        for (int i = 0 ; i<sortedArray.length ; i++)
        {
            if(sortedArray[i]<=0)
            {
                continue;
            }
            else
            {
                if(!fistPositiveFound)
                {
                    fistPositiveFound = true;
                    firstPositiveIndex = i;
                }

                if(sortedArray[i] != ((i-firstPositiveIndex) + 1))
                {
                    return ((i-firstPositiveIndex) + 1);
                }

                if(i== (sortedArray.length -1))
                {
                    return sortedArray[i] + 1;
                }
            }

        }
        return 1 ;
    }
}
