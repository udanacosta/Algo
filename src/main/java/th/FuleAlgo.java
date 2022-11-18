package th;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

public class FuleAlgo {
  
  public static void main(String[] args) {
  }
  
  @Test
  public void testScenarioA() {
    int[] A = {2, 8, 4, 3, 2};
    int X = 7;
    int Y = 11;
    int Z = 3;
    
    int maxWait = getMaxWaitSlide(A, X, Y, Z);
    System.out.println(maxWait);
    Assert.assertEquals(8, maxWait);
    
  }
  
  @Test
  public void testScenarioB() {
    int[] A = {2, 2, 4, 3, 1};
    int X = 1;
    int Y = 5;
    int Z = 3;
    
    int maxWait = getMaxWaitSlide(A, X, Y, Z);
    System.out.println(maxWait);
    Assert.assertEquals(-1, maxWait);
    
  }
  
  @Test
  public void testScenarioC() {
//    int[] A = {20, 20, 20, 5, 5, 5};
//    int X = 10;
//    int Y = 200;
//    int Z = 10;
  
    int[] A = {10, 10, 10, 3,3,3};
    int X = 6;
    int Y = 100;
    int Z = 6;
    
    int maxWait = getMaxWaitSlide(A, X, Y, Z);
    System.out.println(maxWait);
    //Assert.assertEquals(8, maxWait);
    
  }
  
  @Test
  public void testScenarioD() {
    
    int[] A = { 3,3,3};
    int X = 6;
    int Y = 1;
    int Z = 6;
    
    int maxWait = getMaxWait(A, X, Y, Z);
    System.out.println(maxWait);
    //Assert.assertEquals(8, maxWait);
    
  }
  
  public static Integer solution2(int[] A, int X, int Y, int Z) {
    int maxX = 0; // The maximum time X is occupied
    int maxY = 0; // Maximum time occupied by Y
    int maxZ = 0; // The maximum time that Z is occupied
    int max = 0; // current time value
    
    // find out the maximum refueling time
    int maxM = (X >= Y ? X : Y) >= Z ? (X >= Y ? X : Y) : Z;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    while (true) {
      for (int i = 0; i < A.length; i++) {
        if (A[i] != 0 && A[i] <= X && max >= maxX) {
          X -= A[i];
          map.put(i, max);
          maxX += A[i];
          A[i] = 0;
          break;
        }
      }
      for (int i = 0; i < A.length; i++) {
        if (A[i] != 0 && A[i] <= Y && max >= maxY) {
          Y -= A[i];
          map.put(i, max);
          maxY += A[i];
          A[i] = 0;
          break;
        }
      }
      for (int i = 0; i < A.length; i++) {
        if (A[i] != 0 && A[i] <= Z && max >= maxZ) {
          Z -= A[i];
          map.put(i, max);
          maxZ += A[i];
          A[i] = 0;
          break;
        }
      }
      // X, Y, and Z are selected once, then the time is +1
      max++;
      // Exceeding the maximum time, indicating that there are vehicles in a blocked queue
      if (max > maxM) {
        break;
      }
    }
    System.out.println(map);
    if (map.size() != A.length) {
      // Indicates that there are vehicles that cannot be refueled
      return -1;
    } else {
      // Vehicles can refuel and return to the largest
      return map.get(A.length - 1);
    }
  }
  
  public static Integer getMaxWaitSlide(int[] A, int X, int Y, int Z) {
    
    final int totalTimePossible = Math.max(X, Math.max(Y, Z));
    
    int timer = 0;
    
    //to hold allocation of fuel pumps in each time iteration
    int xTimeHolder = 0;
    int yTimeHolder = 0;
    int zTimeHolder = 0;
    
    int maxWaitTime = -1;
    int fueledCars = 0;
    
    //window to consider
    int windowStartIndex = 0;
    int windowEndIndex = 3;
    
    int[] processingIndexes = {-1,-1,-1};
    int startAdd = 0, endAdd = 0;
    
    while (timer <= totalTimePossible) {
      
      //get match car for X
      if( xTimeHolder <= timer ) {
        for (int i = windowStartIndex; i < windowEndIndex; i++) {
          if (A[i] > 0 && X >= A[i]) {
            X -= A[i];
            xTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
            
            if( processingIndexes[0] > -1){
              int minProcessing = processingIndexes[0];
              if( processingIndexes[1] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[1] );
              }
              if( processingIndexes[2] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[2] );
              }
              if( processingIndexes[0] == minProcessing ){
                startAdd++;
              }else {
                endAdd++;
              }
            }
            processingIndexes[0] = i;
            
            break;
          }
        }
      }
      
      //get match car for Y
      if( yTimeHolder <= timer ) {
        for (int i = windowStartIndex; i < windowEndIndex; i++) {
          if (A[i] > 0 && Y >= A[i] ) {
            Y -= A[i];
            yTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
  
            if( processingIndexes[1] > -1){
              int minProcessing = processingIndexes[1];
              if( processingIndexes[0] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[0] );
              }
              if( processingIndexes[2] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[2] );
              }
              if( processingIndexes[1] == minProcessing ){
                startAdd++;
              }else {
                endAdd++;
              }
            }
            processingIndexes[1] = i;
            
            break;
          }
        }
      }
      
      //get match car for Z
      if( zTimeHolder <= timer ) {
        for (int i = windowStartIndex; i < windowEndIndex; i++) {
          if (A[i] > 0 && Z >= A[i]) {
            Z -= A[i];
            zTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
  
            if( processingIndexes[2] > -1){
              int minProcessing = processingIndexes[1];
              if( processingIndexes[0] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[0] );
              }
              if( processingIndexes[1] > -1 ){
                minProcessing = Math.min( minProcessing, processingIndexes[1] );
              }
              if( processingIndexes[2] == minProcessing ){
                startAdd++;
              }else {
                endAdd++;
              }
            }
            processingIndexes[2] = i;
            break;
          }
        }
      }
  
      windowStartIndex += startAdd;
      windowEndIndex += (startAdd + endAdd);
      windowEndIndex = Math.min(windowEndIndex, A.length);
  
      startAdd = 0;
      endAdd = 0;
      
      //if all filled then break
      if( fueledCars == A.length ){
        break;
      }
      
      timer++;
    }
    
    return (fueledCars < A.length) ? -1 : maxWaitTime;
    
  }
  
  public static Integer getMaxWait(int[] A, int X, int Y, int Z) {
    
    final int totalTimePossible = Math.max(X, Math.max(Y, Z));
    
    int timer = 0;
    
    //to hold allocation of fuel pumps in each time iteration
    int xTimeHolder = 0;
    int yTimeHolder = 0;
    int zTimeHolder = 0;
    
    int maxWaitTime = -1;
    int fueledCars = 0;
    
    while (timer <= totalTimePossible) {
      
      //get match car for X
      if( xTimeHolder <= timer ) {
        for (int i = 0; i < A.length; i++) {
          if (A[i] > 0 && X >= A[i] ) {
            X -= A[i];
            xTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
            break;
          }
        }
      }
      
      //get match car for Y
      if( yTimeHolder <= timer ) {
        for (int i = 0; i < A.length; i++) {
          if (A[i] > 0 && Y >= A[i] ) {
            Y -= A[i];
            yTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
            break;
          }
        }
      }
      
      //get match car for Z
      if( zTimeHolder <= timer ) {
        for (int i = 0; i < A.length; i++) {
          if (A[i] > 0 && Z >= A[i] ) {
            Z -= A[i];
            zTimeHolder += A[i];
            A[i] = 0;
            maxWaitTime = maxWaitTime < timer ? timer : maxWaitTime;
            fueledCars++;
            break;
          }
        }
      }
  
      //if all filled then break
      if( fueledCars == A.length ){
        break;
      }
      
      timer++;
    }
    
    return (fueledCars < A.length) ? -1 : maxWaitTime;
    
  }
  
  
  
  public static Integer getMaxWaitObj(int[] A, int X, int Y, int Z) {
    
    final int totalTimePossible = Math.max(X, Math.max(Y, Z));
    AtomicInteger timer = new AtomicInteger();
    AtomicInteger xTimeHolder = new AtomicInteger();
    AtomicInteger yTimeHolder = new AtomicInteger();
    AtomicInteger zTimeHolder = new AtomicInteger();
    AtomicInteger maxWaitTime = new AtomicInteger(-1);
    AtomicInteger fuledCars = new AtomicInteger();
    
    while (timer.get() <= totalTimePossible) {
      
      //get match car for X
      X = updateAndGetValuesForX(A, X, timer, xTimeHolder, maxWaitTime, fuledCars);
      
      //get match car for Y
      Y = updateAndGetValuesForX(A, Y, timer, yTimeHolder, maxWaitTime, fuledCars);
      
      //get match car for Z
      Z = updateAndGetValuesForX(A, Z, timer, zTimeHolder, maxWaitTime, fuledCars);
      
      timer.incrementAndGet();
    }
    
    return (fuledCars.get() < A.length) ? -1 : maxWaitTime.get();
    
  }
  
  private static int updateAndGetValuesForX(int[] A, int X, AtomicInteger timer,
      AtomicInteger xTimeHolder,
      AtomicInteger maxWaitTime, AtomicInteger fuledCars) {
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0 && X >= A[i] && xTimeHolder.get() <= timer.get()) {
        X -= A[i];
        xTimeHolder.addAndGet(A[i]);
        A[i] = 0;
        if (maxWaitTime.get() < timer.get()) {
          maxWaitTime.set(maxWaitTime.get() < timer.get() ? timer.get() : maxWaitTime.get());
        }
        fuledCars.incrementAndGet();
        break;
      }
    }
    return X;
  }
}
