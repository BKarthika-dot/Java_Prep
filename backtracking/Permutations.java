//find all possible permutations of a given array
//no duplicates in the array
import java.util.*;
class Permutations{
    private static void backtrack(List<List<Integer>> result,List<Integer> path,int [] nums){

        //base case
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            
            //constraint
            if(path.contains(nums[i])) continue;

            //make choice
            path.add(nums[i]);

            //recurse
            backtrack(result,path,nums);

            path.remove(path.size()-1);

        }
    }
    public static void main(String[] args){
        int [] nums={1,2,3};

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        backtrack(result,path,nums);

        for(List<Integer> list:result){
            System.out.println(list);
        }

    }
}