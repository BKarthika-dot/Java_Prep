import java.util.*;

class Main{
    private static List<List<String>> NQueens(int n){
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> result=new ArrayList<>();
        backtrack(board,result,0);

        return result;

    }
    private static void backtrack(char[][]board,List<List<String>> result,int row){

        //base case
        if(row==board.length){
            List<String> solution=new ArrayList<>();
            for(char [] r:board){
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        //try every column
        for(int col=0;col<board.length;col++){
            //check constraint
            if(!isSafe(board,row,col)) continue;

            board[row][col]='Q';
            backtrack(board,result,row+1);
            board[row][col]='.';
        }
    }
    private static boolean isSafe(char[][]board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of queens: ");
        int n=sc.nextInt();

        List<List<String>>result= new ArrayList<>();
        result=NQueens(n);

        for(List<String> solution:result){
            System.out.println(solution);
        }
    }
}