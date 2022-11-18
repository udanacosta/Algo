package th;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
  
  public static void main(String[] args) {
    
    System.out.println("test");
  
    List<String> words = Arrays.asList(new String[]{"the", "bats", "tabs", "in", "cat", "act"});
    List<String> sev = Arrays.asList(new String[]{"in the act"});
  
    
    System.out.println(countSentences(words, sev));
  
    //https://www.geeksforgeeks.org/length-of-the-longest-subsequence-such-that-xor-of-adjacent-elements-is-equal-to-k/
    List<Integer> asd =  Arrays.asList( new Integer[]{1, 1, 1} );
    //System.out.println(maxSubsequenceLength(0, asd) );
    
  }
  
  public static int maxSubsequenceLength(int k, List<Integer> arr) {
    
    int maxSeqLength = 0;
    HashMap<Integer, Integer> seqSizeMap = new HashMap<>();
  
    int lenghtHoldArr[] = new int[arr.size()];
  
    seqSizeMap.put(arr.get(0), 1);
    lenghtHoldArr[0] = 1;
  
    for (int i = 1; i < arr.size(); i++) {
      Integer currentValSize = seqSizeMap.get(arr.get(i) ^ k);
      if (currentValSize != null) {
        lenghtHoldArr[i] = Math.max(lenghtHoldArr[i], currentValSize + 1);
      }
      
      int updatedVal = 1;
      if(seqSizeMap.get(arr.get(i)) != null){
        updatedVal = seqSizeMap.get(arr.get(i));
      }
      seqSizeMap.put( arr.get(i), Math.max(updatedVal, lenghtHoldArr[i]));
      maxSeqLength = Math.max(maxSeqLength, lenghtHoldArr[i]);
    }
    
    return maxSeqLength >= 2 ? maxSeqLength : 1;
  }
  
  public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
    
    Map<String, Integer> anagramWordMap = new HashMap<>(wordSet.size());
    
    for (int i = 0; i < wordSet.size(); i++) {
      for (int j = 0; j < wordSet.size(); j++) {
        if (isAnagram(wordSet.get(i), wordSet.get(j))) {
          Integer anagramCount = anagramWordMap.get(wordSet.get(i));
          anagramWordMap.put(wordSet.get(i),
              anagramCount == null ? 1 : anagramCount.intValue() + 1);
        }
      }
    }
    
    List<Long> newSentenceCountList = sentences.stream().mapToLong(sentence -> {
      long sentenceCount = 1;
      String[] wordArr = sentence.split(" ");
      for (String word : wordArr) {
        sentenceCount *= ( anagramWordMap.containsKey(word) ? anagramWordMap.get(word) : 1 );
      }
      return sentenceCount;
    }).boxed().collect(Collectors.toList());
    
    return newSentenceCountList;
  }
  
  public static boolean isAnagram(String word1, String word2) {
    
    if (word1.length() != word2.length()) {
      return false;
    }
    char[] charArr1 = word1.toCharArray();
    char[] charArr2= word2.toCharArray();
    Arrays.sort(charArr1);
    Arrays.sort(charArr2);
    
    for( int i =0; i < charArr1.length ; i++){
      if (charArr1[i] != charArr2[i]) {
        return false;
      }
    }
    
    return true;
  }
  
  
  public static String newPassword(String a, String b) {
    StringBuilder pwdString = new StringBuilder();
    int minLength = Math.min(a.length(), b.length());
    
    for (int i = 0; i < minLength; i++) {
      pwdString.append(a.charAt(i)).append(b.charAt(i));
    }
    
    if (a.length() > minLength) {
      pwdString.append(a.substring(minLength));
    } else {
      pwdString.append(b.substring(minLength));
    }
  
    return pwdString.toString();
  }
  
  
  
}
