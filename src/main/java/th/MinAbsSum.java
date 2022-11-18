package th;

import org.junit.Assert;
import org.junit.Test;

public class MinAbsSum {

    @Test
    public void testScenarioA()
    {
        int gap = getMinSum( new int[] {1,5,2, -2});
        Assert.assertEquals(0 , gap);
        System.out.println(gap);
    }

    private static int getMinSum(int[] ints) {

        int sum = 0 ;
        for (int i=0 ; i< ints.length ;i++)
        {
            sum = sum + getMinVlaue( ints[i]);
        }

        return sum;
    }

    private static int getMinVlaue(int anInt) {
        if(anInt > 0)
        {
            return anInt * -1;
        }
        else if( anInt < 0)
        {
            return  anInt * 1 ;
        }
        else
        {
            return  0 ;
        }

    }

    public static void main(String[] args)
    {
        System.out.println(getMinSum(new int[] {1,2,3}));
        System.out.println(getMinSum(new int[] {1,2,3}));
    }
}
