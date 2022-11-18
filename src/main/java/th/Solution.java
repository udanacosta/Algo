package th;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

public class Solution {

    @Test
    public void testScenarioA() {
        int gap = gap(getBinary(529));
        Assert.assertEquals(gap , 4);
        System.out.println(gap);
    }
    public static void main(String[] args)
    {
        System.out.println(getBinary(529));
        System.out.println(gap(getBinary(529)));
    }

    private static String  getBinary (int k)
    {
        String nir =  Integer.toBinaryString(k);
        return nir ;
    }

    private static int gap(String binaryRepresentation)
    {
        char [] array = binaryRepresentation.toCharArray();
        int maxGap = 0;
        boolean foundone = false ;
        int foundOneIndex = 0 ;

        for(int i=0 ; i< array.length ; i++)
        {
            if(array [i] == '1')
            {
                if(!foundone)
                {
                    foundone = true;
                    foundOneIndex = i;
                }
                else
                {
                    if(maxGap < ( (i-foundOneIndex)-1) )
                    {
                        maxGap = (i-foundOneIndex)-1 ;
                        foundOneIndex = i;
                    }
                    else
                    {
                        foundOneIndex = i;
                    }

                }

            }
            else
            {
                continue;
            }
        }
        return  maxGap ;
    }

}
