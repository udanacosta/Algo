package th;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.Test;

public class MaxEvenSum {

    @Test
    public void testScenarioA() {
        int[] A = {4,9,8,2,6};
        
        int maxWait = solution(A,3);
        System.out.println(maxWait);
    }
    
    @Test
    public void testScenarioB() {
        int[] A = {2307, 9664, 9907, 1265, 5843, 8465, 9106, 432, 735, 3379, 1052, 8355, 1741, 3672,
            4514, 2126, 5565, 112, 6632, 7104, 1965, 2241, 5746, 4912, 5540, 6351, 7075, 8267, 6951,
            8422, 7441, 8832, 3790, 1950, 6210, 6624, 6378, 2949, 3880, 637, 2871, 3476, 2193, 3667,
            1834, 2842, 1779, 6391, 8057, 7899, 6892, 5531, 4967, 9156, 4328, 3099, 7571, 8346,
            7978, 1960, 1522, 3679, 7802, 154, 9009, 9608, 7542, 211, 9393, 581, 8765, 7949, 8550,
            43, 1361, 4187, 6761, 9118, 1611, 7963, 940, 7866, 9024, 286, 631, 2696, 1150, 585,
            3434, 7446, 1347, 2671, 6986, 5715, 9090, 9430, 778, 1155, 773, 4495, 3097, 1800, 1521,
            7529, 1595, 9232, 16, 3199, 4400, 4976, 8963, 3988, 7211, 8727, 8786, 2824, 21, 1357,
            4063, 8013, 7491, 7596, 6202, 1713, 8797, 7020, 7192, 7718, 6075, 7307, 3812, 4775,
            8556, 4501, 5725, 2928, 8796, 4476, 6525, 7591, 707, 1948, 9482, 784, 7900, 5350, 8230,
            1892, 1527, 9132, 7392, 8377, 5731, 6533, 5918, 9124, 5996, 4375, 4906, 1444, 1488,
            1488, 1741, 5393, 2742, 8893, 8945, 7420, 8085, 9506, 5310, 5718, 483, 9745, 9687, 4498,
            7385, 1364, 5086, 8108, 6724, 8342, 296, 5925, 3649, 329, 9013, 6198, 8290, 8875, 9251,
            6617, 9342, 6787, 369, 9181, 6781, 2917, 4549, 1691, 3218, 3208, 7114, 4841, 5243, 3304,
            6562, 2649, 5355, 7984, 9680, 6411, 9777, 8478, 7681, 448, 3170, 1192, 2828, 4552, 7153,
            5187, 5801, 9774, 1745, 156, 8137, 2398, 3779, 8171, 2564, 1892, 2810, 4346, 3875, 4082,
            7567, 7613, 8876, 8153, 8943, 9947, 74, 3360, 4733, 1751, 9844, 935, 4256, 8705, 4554,
            2250, 3053, 6926, 8431, 2481, 4587, 5143, 3285, 3361, 5499, 152, 7914, 3280, 1504, 5534,
            1486, 4988, 6621, 7725, 9641, 6661, 9950, 4862, 3444, 426, 6059, 9743, 4993, 8894, 1904,
            5495, 9771, 2642, 9486, 3195, 5882, 4581, 2161, 9458, 3610, 2047, 6955, 4164, 8382,
            6335, 5356, 5783, 3844, 3862, 5014, 1171, 533, 315, 7754, 741, 2166, 7137, 3246, 7409,
            1657, 5637, 4725, 2603, 6962, 715, 7671, 7596, 226, 2826, 5959, 3266, 1409, 2598, 6997,
            4947, 2260, 928, 1183, 1882, 7516, 1380, 1399, 3021, 7048, 3709, 7894, 8676, 8821, 2876,
            5741, 225, 9729, 4478, 7983, 9941, 7322, 51, 4356, 6929, 9417, 7566, 7144, 5549, 9968,
            7399, 6849, 9860, 770, 5875, 2142, 7869, 3761, 8494, 4240, 7588, 9291, 9278, 3400, 6705,
            2568, 7757, 3479, 3450, 2808, 153, 3798, 8067, 6748, 9756, 4506, 898, 2936, 6737, 216,
            2779, 7077, 3118, 5516, 6408, 7677, 7155, 1975, 6503, 775, 1020, 9947, 553, 8494, 4198,
            1084, 8807, 2548, 1272, 8585, 31, 380, 4341, 4172, 6379, 8482, 5219, 7997, 9342, 1098,
            2735, 977, 1629, 9907, 3769, 8214, 8401, 3079, 8329, 4189, 1346, 78, 7502, 3326, 127,
            5770, 2757, 8614, 9346, 9969, 4824, 6564, 893, 2598, 3863, 5807, 4590, 5142, 2149, 9645,
            946, 8578, 2143, 2427, 9499, 9464, 5100, 4305, 9360, 8749, 3272, 7800, 5922, 90, 8015,
            6100, 9856, 9644, 8569, 374, 9408, 6038, 9612, 4832, 1897, 8972, 1102, 6586, 6203, 1250,
            9953, 3481, 5381, 6625, 3463, 7798, 242, 1116, 8652, 556, 7346, 3768, 8923, 6805, 8455,
            3115, 9758, 1731, 1415, 5656, 4258, 5874, 3007, 6797, 3674, 1385, 4611, 6241, 6791,
            8996, 3374, 9046};
        
        int maxWait = solution(A,200);
        System.out.println(maxWait);
    }
    
    @Test
    public void testScenarioC() {
        int[] A = new int[1000000];
        Random random = new Random();
        for( int i = 0; i < 100000; i++){
           // A[i] = random.nextInt(1000);
            A[i] = (int) (Math.random()*(10000-1+1)+1);
        }
        
        int maxWait = solution(A,60000);
        System.out.println(maxWait);
    }
    
    @Test
    public void testScenarioD() {
        int[] A = {1,1,1};
        
        int maxWait = solution(A,2);
        System.out.println(maxWait);
    }
    
    public int solution(int[] A, int K) {
      
        //if K is greater than length of array
        if( K > A.length )
        {
            return -1;
        }
        
        //split into even and odd
        final Map<Boolean, List<Integer>> lists = Arrays.stream(A).boxed().collect( Collectors.partitioningBy( n -> n % 2 == 0) );
        List<Integer> evenList = lists.get( Boolean.TRUE );
        List<Integer> oddList = lists.get( Boolean.FALSE );
    
        //sort in descending order
        Collections.sort( evenList, Collections.reverseOrder() );
        Collections.sort( oddList, Collections.reverseOrder() );
        
        int evenIndex = 0;
        int oddIndex = 0;
        int maxEvenSum = 0;
        
        while( K > 0 )
        {
            if( K % 2 == 1 )
            {
                //If K odd we need to get the next max even
                if( evenIndex < evenList.size() )
                {
                    maxEvenSum += evenList.get(evenIndex);
                    evenIndex++;
                    K--;
                }
                else
                {
                    //K is odd and there is no even numbers initially means no solution
                    maxEvenSum = -1;
                    break;
                }
            }
            else if ( evenIndex < ( evenList.size() - 1 ) && oddIndex < ( oddList.size() -1 ) )
            {
                //if both even and odd options available get max of next two even or odd
                if ( getListNextTwoSum(evenList, evenIndex) <= getListNextTwoSum(oddList, oddIndex))
                {
                    maxEvenSum += getListNextTwoSum(oddList, oddIndex);
                    oddIndex += 2;
                }
                else
                {
                    maxEvenSum += getListNextTwoSum(evenList, evenIndex);
                    evenIndex += 2;
                }
                K -= 2;
            }
            else if ( evenIndex < ( evenList.size() - 1 ) )
            {
                //get max of next two even
                maxEvenSum += getListNextTwoSum(evenList, evenIndex);
                evenIndex += 2;
                K -= 2;
            }
            else if (oddIndex < ( oddList.size() -1 ) )
            {
                //get max of next two odd
                maxEvenSum += getListNextTwoSum(oddList, oddIndex);
                oddIndex += 2;
                K -= 2;
            }
            else if ( evenIndex >= ( evenList.size() - 1 ) && oddIndex >= ( oddList.size() -1 ) )
            {
                //no even or odd numbers available to get an even sum
                maxEvenSum = -1;
                break;
            }
        }
        
        return maxEvenSum;
    }
    
    /**
     * Return sum of the values of given and next indexes of the list
     * @param numberList List for sum calculation
     * @param startIndex start index
     * @return
     */
    private int getListNextTwoSum(List<Integer> numberList, int startIndex) {
        return numberList.get(startIndex) + numberList.get(startIndex + 1);
    }
    
    
}
