package th;

import java.util.Arrays;
import org.junit.Test;

public class CommonAlgos {
  
    @Test
    public void checkPalindromTest() {
    
      System.out.println(isPalindrom("ABCDDCXA"));
      System.out.println(isPalindromRec("ABCDDCXA"));
    
    }
  
    public boolean isPalindrom(String str) {
    
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
          return false;
        }
      }
    
      return true;
    }
  
    public boolean isPalindromRec(String str) {
      if (str.length() <= 1) {
        return true;
      } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
        return isPalindromRec(str.substring(1, str.length() - 1));
      }
    
      return false;
    
    }
  
  

    @Test
    public void reverseNumTest(){
      System.out.println(reversNumber(15));
    }
    
    public int reversNumber(int number){
      int returnNum = 0;
      
      while( number > 0 ){
        int remainder = number % 10;
        number = number / 10;
        returnNum = returnNum * 10 + remainder;
      }
      return returnNum;
      
    }
    
    @Test
    public void testBubbleSort(){
      int arr[] =new int[]{7,5,4,8,1};
      bubbleSort(arr);
      System.out.println(Arrays.toString(arr));
    }
    
    public void bubbleSort(int[] arr){
      
      for(int i = 0; i < arr.length; i++ ){
        for(int j = 0; j < arr.length -1; j++ ){
          if(arr[j]>arr[j+1]){
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
          }
        }
      }
      
    }
  
    @Test
    public void testAnagram(){
      System.out.println(isAnagram( "booadd", "doobaa"));
    }
    
    public boolean isAnagram(String str1, String str2){
      int[] charArr = new int[256];
      
      if( str1.length() != str2.length() ){
        return false;
      }
      
      for( int i = 0; i < str1.length(); i++){
          charArr[str1.charAt(i) - 'a'] +=  1;
          charArr[str2.charAt(i) - 'a'] -=  1;
      }
      
      boolean isAnagram = true;
      for( int num : charArr){
        if(num != 0){
          isAnagram = false;
          break;
        }
      }
      return isAnagram;
    }
}

class A{
  public void Tep() throws Exception{}
  
}
class B extends A{
  
  @Override
  public void Tep() throws Exception {
    super.Tep();
  }
}