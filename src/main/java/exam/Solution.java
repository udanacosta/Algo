package exam;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testScenarioA() {
        String gap = solution(5 , 3);
        Assert.assertEquals("aabaabab" , gap);
        System.out.println(gap);

    }

    @Test
    public void testScenarioB() {
        String gap = solution(3 , 3);
        Assert.assertEquals("ababab" , gap);
        System.out.println(gap);
    }

    @Test
    public void testScenarioC() {
        String gap = solution(1 , 4);
        Assert.assertEquals("bbabb" , gap);
        System.out.println(gap);
    }

    private String solution(int A , int B) {
        String stringA = "a" ;
        String stringB = "b" ;

        String stringAA = "aa" ;
        String stringBB = "bb" ;

        StringBuilder builder  = new StringBuilder();
        int countA = 0 ;
        int countB = 0;

        int TotalA = 0 ;
        int TotalB = 0;

        if(Math.abs(A-B) >= 3)
        {
            return "" ;
        }


        for (int i = 0; i < A; i++)
        {
            builder.append(stringA) ;
            countA ++ ;
            TotalA ++ ;
            for (int j = TotalB; j < B; j++)
            {
                builder.append(stringB) ;
                countB ++ ;
                if(countB == 3)
                {
                    countB=0;
                    continue;
                }
                TotalB ++ ;
                countA = 0;
            }
            if(countA == 3)
            {
                countA=0;
                continue;
            }

        }

        return builder.toString();
    }


}
