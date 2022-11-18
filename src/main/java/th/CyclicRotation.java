package th;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotation {

    @Test
    public void testScenarioA()
    {
        int [] gap = solution(new int[]{1,2,3} , 2);
        Assert.assertEquals(3 , gap.length);
        System.out.println(gap[0]+","+gap[1]+","+gap[2]);
    }

    public int[] solution(int[] A, int K){
        int[] rotated = new int[A.length];

            for (int i = 0 ; i<A.length ; i++)
            {
                if(K < A.length)
                {
                    if(i+K > ( A.length -1))
                    {
                        rotated[i+K-A.length] = A[i];
                    }
                    else
                    {
                        rotated[i+K] = A[i];
                    }

                }
                else
                {
                    int remainder = K%A.length ;
                    if(remainder == 0)
                    {
                        rotated[i] = A[i];
                    }
                    else
                    {
                        if(i+remainder > ( A.length -1))
                        {
                            rotated[i+remainder-A.length] = A[i];
                        }
                        else
                        {
                            rotated[i+remainder] = A[i];
                        }
                    }

                }

            }


        return rotated;
    }
}
