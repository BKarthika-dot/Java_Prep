//print all subsets that sum upto a target value
import java.util.*;

class Main{

    private static boolean isValid(List<Integer> path,int target){
        int sum=0;
        for(int i:path){
            sum+=i;
        }
        if(sum==target) return true;

        return false;
    }
    private static void backtrack(List<List<Integer>> result,List<Integer>path,int [] nums,int target,int start){

        if(isValid(path,target)){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++){

            path.add(nums[i]);
            backtrack(result,path,nums,target,i+1);
            path.remove(path.size()-1);
        }

    }
    public static void main(String [] args){

        int [] nums={1,2,3,4,};
        int target=5;

        List<List<Integer>> result=new ArrayList<>();

        List<Integer> path=new ArrayList<>();

        backtrack(result,path,nums,target,0);

        for(List<Integer> list:result){
            System.out.println(list);
        }
    }
}