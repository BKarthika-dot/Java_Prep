import java.util.*;


class Searching{



    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    Node root;
    Searching(){
        root=null;
    }

    //tree level order insertion
    private void insertVal(int data){
        if(root==null){
            root=new Node(data);
            return;
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr=queue.poll();

            if(curr.left==null){
                curr.left=new Node(data);
                return;
            }
            else queue.add(curr.left);


            if(curr.right==null){
                curr.right=new Node(data);
                return;
            }
            else queue.add(curr.right);
        }
    }

    private void BFS(Node root,int key){
        if(root==null) return;
        Queue<Node> queue=new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            if(curr.data==key){
                System.out.println("Found element "+key);
                return;
            }

            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }

    public static void main(String[] args){

        int[] arr={9,6,13,12,5,2,11,3,14,7};

        Searching tree=new Searching();
        for(int i:arr){
            tree.insertVal(i);
        }

        tree.BFS(tree.root,11);
    }
}