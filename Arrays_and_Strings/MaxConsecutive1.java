import java.util.*;

//maximum consecutive 1's after flipping k number of 0's
//O(n) time

public class MaxConsecutive1 {
    public static void main(String[] args){
        int [] arr={1,1,1,0,1,1,0,0,1,0,1,1,0};
        int k=2;

        int maxOnes=Integer.MIN_VALUE;
        int numReplacements=0;
        int windowStart=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)numReplacements++;

            while(numReplacements>k){
                if(arr[windowStart]==0){
                    numReplacements--;
                }
                windowStart++;
            }
            maxOnes=Math.max(maxOnes,i-windowStart+1);
        }

        System.out.println(maxOnes);

    }
    
}
