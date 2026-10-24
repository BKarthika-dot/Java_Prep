import java.util.*;

class LevelSuccessor{

    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static Node root;
    LevelSuccessor(){
        root=null;
    }

    static void insertVal(int data){
        if(root==null){
            root=new Node(data);
            return;
        }

        Queue<Node>queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr=queue.poll();

            if(curr.left==null){
                curr.left=new Node(data);
                return;
            }

            else{
                queue.add(curr.left);
            }

            if(curr.right==null){
                curr.right=new Node(data);
                return;
            }

            else{
                queue.add(curr.right);
            }
        }
    }

    static int findSuccessor(int key){

        if(root==null) return -1;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr=queue.poll();

            if(curr.data==key){
                Node next=queue.peek();

                return (next!=null) ? next.data:-1;
            }
            if(curr.left!=null){
                queue.add(curr.left);
            }

            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        return -1;

    }

    public static void main(String[] args){

        int[] arr={7,8,9,2,16,5,11,6};
        for(int i:arr){
            insertVal(i);
        }

        System.out.println(findSuccessor(16));
    }
}