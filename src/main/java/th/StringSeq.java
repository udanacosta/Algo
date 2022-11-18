package th;

import org.junit.Assert;
import org.junit.Test;

public class StringSeq {

    @Test
    public void testScenarioA()
    {
        String gap = transformString("ACCAABBC");
        Assert.assertEquals("AC" , gap);
        System.out.println(gap);
    }

    @Test
    public void testScenarioB()
    {
        String gap = transformString("ABCBBCBA");
        Assert.assertEquals("" , gap);
        System.out.println(gap);
    }


    @Test
    public void testScenarioC()
    {
        String gap = transformString("BABABA");
        Assert.assertEquals("BABABA" , gap);
        System.out.println(gap);
    }
    public static void main(String[] args)
    {
        System.out.println(transformString("AA"));
        System.out.println(transformString("AB"));
    }

    private static String transformString(String S)
    {

        String aaReplased ="";
        String bbReplased ="" ;
        String ccReplaysed ="";
        String startingString = S;
        while (startingString.contains("AA") || startingString.contains("BB") || startingString.contains("CC"))
        {
             aaReplased = startingString.replaceAll("AA", "");
             bbReplased = aaReplased.replaceAll("BB", "");
             ccReplaysed = bbReplased.replaceAll("CC", "");

             startingString = ccReplaysed;
        }
        return startingString;
    }

}
