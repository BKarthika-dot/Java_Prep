import java.util.*;

public class ArrayTraversal{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter array size");
        int n=scanner.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Created Array");

        //finding max element
        int max=arr[0];

        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        System.out.println("Maximum Element: "+max);

        //frequency array for each element
        int[] freq=new int[n];
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }

            for(int k=0;k<n;k++){
                if(arr[k]==arr[i]){
                    freq[k]=count;
                    visited[k]=true;
                }
            }
        }

        System.out.println("Frequency of numbers:");
        for(int i:freq){
            System.out.print(i+" ");
        }

        //leaders in array- find elements greater than all on their right
        System.out.println();
        System.out.println("Leaders in the array: ");
        ArrayList<Integer> leaders=new ArrayList<Integer>();

        int currLeader=arr[n-1];
        leaders.add(currLeader);

        for(int i=n-2;i>=0;i--){
            if(arr[i]>currLeader){
                leaders.add(arr[i]);
                currLeader=arr[i];
            }
        }

        Collections.reverse(leaders);

        for(int i:leaders){
            System.out.print(i+" ");
        }

        //finding majority element  (Boyer Moore Majority Vote Algorithm)
        System.out.println();
        int count=1;
        int candidate=arr[0];

        for(int i=1;i<n;i++){
            if(candidate==arr[i]){
                count++;
            }
            else if(candidate!=arr[i] && count==0){
                candidate=arr[i];
            }
            else if(candidate!=arr[i] && count!=0){
                count--;
            }
        }

        int actualCount=0;

        for(int i:arr){
            if(i==candidate){
                actualCount++;
            }
        }
        if(actualCount>n/2){
            System.out.println("Majority Element: "+candidate);
        }else{
            System.out.println("No majority element");
        }

        //finding maximum product subarray
        int currMax=arr[0];
        int currMin=arr[0];

        int globalMax=arr[0];

        for(int i=1;i<n;i++){

            int temp=currMax;

            currMax=Math.max(arr[i],Math.max(arr[i]*temp,arr[i]*currMin));
            currMin=Math.min(arr[i],Math.min(arr[i]*temp,arr[i]*currMin));

            globalMax=Math.max(globalMax,currMax);
        }

        System.out.println("Maximum product of subarray is "+globalMax);

        //split array into 2 subarrays with the same sum
        int totalSum=0;
        int leftSum=0;
        int left=-1;
        for(int i:arr){
            totalSum+=i;
        }

        if(totalSum%2!=0){
            System.out.println("Can't split into equal halves");
        }else{
            for(int i=0;i<n;i++){
                leftSum+=arr[i];
                if(leftSum==(totalSum/2)){
                    left=i;
                    break;
                }
            }
            if(left!=-1){
                System.out.println("Left subarray: ");
                for(int i=0;i<=left;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                System.out.println("Right subarray: ");
                for(int i=left+1;i<n;i++){
                    System.out.print(arr[i]+" ");
                }
            }
        }
        
        //prefix sum array
        System.out.println();
        System.out.println("Prefix sum array");
        ArrayList<Integer> prefix=new ArrayList<>();
        int PrefixSum=0;
        for(int i=0;i<n;i++){
            PrefixSum+=arr[i];
            prefix.add(PrefixSum);
        }
        for(int i:prefix){
            System.out.print(i+" ");
        }
        System.out.println();
        //finding pivot index using prefix array
        // (pivot index -> sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right of the index)
        boolean found=false;
        for(int i=0;i<n;i++){
            int left_sum= (i==0) ? 0 : prefix.get(i-1);

            int right_sum= prefix.get(n-1)-prefix.get(i);

            if(left_sum==right_sum){
                System.out.println("Pivot element in the array is "+arr[i]);
                found=true;
                break;
            }

        }
        if(!found){
            System.out.println("Pivot element not found");
        }
        scanner.close();
    }
}
