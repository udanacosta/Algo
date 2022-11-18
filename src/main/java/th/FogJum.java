package th;

import org.junit.Assert;
import org.junit.Test;

public class FogJum {


    @Test
    public void testScenarioA()
    {
        int gap = minJumps(10 ,85 , 30);
        Assert.assertEquals(3 , gap);
        System.out.println(gap);
    }
    public static void main(String[] args)
    {
        int x= 10;
        int y= 85 ;
        int d = 30 ;
        System.out.println(minJumps(x,y,d));
        System.out.println(minJumps(x,y,d));
    }

    private static int minJumps(int x, int y, int d)
    {
        if (d>0)
        {
            int totalDistance = y-x ;
            if(d> totalDistance)
            {
                return 1;
            }
            else
            {
                int value = 0 ;
                if(totalDistance%d == 0)
                {
                    value  = totalDistance/d;
                }
                else
                {
                    value  = totalDistance/d + 1;
                }

                return  value  ;
            }
        }
        else
        {
            return 0;
        }


    }

}
