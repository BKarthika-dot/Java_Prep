// Program to count the number of distinct elements in every sliding window of size k.
// For each window, we use a HashMap to store the frequency of elements.
// The size of the HashMap represents the count of distinct elements in that window.

import java.util.*;

class count_unique_sliding_window {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();  //no of elements
        int k=sc.nextInt();  //size of window
        int [] arr=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<i+k;j++){
                if(!map.containsKey(arr[j])){
                    map.put(arr[j],1);
                }
                else{
                    map.put(arr[j],map.get(arr[j])+1);
                }
            }
            result.add(map.size());
        }

        for(int num: result){
            System.out.print(num+" ");
        }
    }
}
