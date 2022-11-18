package th;

public class Solutions {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length-1;
        int n = nums2.length-1;

        //as these are ordered arrays , 4 senarios
        // [-n--] [--m--]

        if(nums2[n] <= nums1[0] )
        {
            int k = (n+m)%2;
            if(k==0)
            {
                
            }
            else
            {

            }

        }
        //  [--m--] [-n--]
        else if(nums2[0] >= nums1[m])
        {

        }
        //  [--m--]
        //[-n--]
        else if(nums2[n] > nums1[0])
        {
            //  [--m--]
            //[-n------]
            if(nums2[n] > nums1[m])
            {

            }
            ////  [--m--]
            //  [-n--]
            else
            {

            }
        }
        //  [--m--]
        //   [-n-]
        else if (nums2[0] > nums1[0])
        {
            //  [--m--]
            //   [-n------]
            if(nums2[n] > nums1[m])
            {

            }
        }

        return 0 ;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3} ;
        int[] nums2 = new int[]{1,3} ;
        Solutions s = new Solutions() ;
        System.out.println(s.findMedianSortedArrays(nums1 , nums2)); // should be 2

    }

}
