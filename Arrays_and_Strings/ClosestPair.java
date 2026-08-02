//given 2 sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array
//given arr1[0...m-1] and arr2[0...n-1], find a pair arr1[i]+arr2[j] such that abslute value of (arr1[i]+arr2[j]-x) is minimum
import java.util.*;
public class ClosestPair {

    public static void main(String[] args){
        int[] arr1={1,4,5,7};
        int[] arr2={10,20,30,40};
        int x=32;

        int n=arr1.length;
        int m=arr2.length;

        //naive approach O(nxm)
        int minm=Integer.MAX_VALUE;
        int n1=0;
        int n2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int curr=Math.abs(arr1[i]+arr2[j]-x);
                if(minm>curr){
                    minm=curr;
                    n1=arr1[i];
                    n2=arr2[j];
                }
            }
        }
        System.out.println(n1+" "+n2);

        //optimised solution O(n+m)
        int diff=Integer.MAX_VALUE;
        int l=0; //first element of first array
        int r=m-1; //last element of second array;
        int num1=-1,num2=-1;
        while(l<m && r>=0){
            if(Math.abs((arr1[l]+arr2[r])-x)<diff){
                diff=Math.abs((arr1[l]+arr2[r])-x);
                num1=arr1[l];
                num2=arr2[r];
            }
            if(arr1[l]+arr2[r]>x){
                r--;
            }
            else l++;
        }
        System.out.println(num1+" "+num2);
        

    }
    
}
