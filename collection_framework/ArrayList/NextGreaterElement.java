import java.util.*;
public class NextGreaterElement {
    public static void main(String [] args){

        int [] arr={15,8,2,12,10,5,17,14};

        Stack<Integer> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();

        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                result.add(-1);
                stack.push(arr[i]);
            }
            else if(stack.peek()>arr[i]){
                result.add(stack.peek());
                stack.push(arr[i]);
            }
            else if(stack.peek()<arr[i]){
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) result.add(-1);
                else result.add(stack.peek());
                stack.push(arr[i]);

            }
            
        }
        Collections.reverse(result);
        System.out.println(result);
    }
}
