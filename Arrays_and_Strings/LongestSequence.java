import java.util.*;
/*
Find longest sequence of 1 after flipping one zero.
(Sliding window technique used)
*/
class LongestSequence{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter sequence length");
        int n=scanner.nextInt();
        System.out.println("Enter sequence of 1's and 0's");

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        
        int maxLength=0;
        int left=0;
        int zeroCount=0;
        int k=1; //keeps track of how many zeros we can flip (in this case 1)

        for(int right=0;right<n;right++){

            if(arr[right]==0){
                zeroCount++;
            }

            while(zeroCount>k){

                if(arr[left]==0){
                    zeroCount--;
                }
                left++;
            }

            maxLength=Math.max(maxLength,right-left+1);

        }
        System.out.println("Maximum length is "+maxLength);
    }
}