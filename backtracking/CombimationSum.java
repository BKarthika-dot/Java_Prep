// find all combination of numbers from given array that add up to give the target
// Example:
// [2,3,6,7] 
// target: 7
// solutions: [2,2,3] & [7]
import java.util.*;
public class CombimationSum {
    private static void backtrack(List<List<Integer>> result,List<Integer> path,int[] nums,int target,int start){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        else if(target<0) return;

        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(result,path,nums,target-nums[i],i);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args){

        int [] nums={2,3,6,7};
        int target=7;

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        backtrack(result,path,nums,target,0);

        for(List<Integer> list:result){
            System.out.println(list);
        }

    }
}
