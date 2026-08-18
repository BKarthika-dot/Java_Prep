import java.util.*;

//an island is vertically or horizontally connected land cells 
//input is a grid with 0s and 1s where 0-water and 1-land
public class IslandCount {

    public static void dfs(int [][] grid,int r,int c,boolean[][] visited){
        int n=grid.length;
        int m=grid[0].length;

        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || visited[r][c]){
            return;
        }
        visited[r][c]=true;
        dfs(grid,r-1,c,visited);
        dfs(grid,r,c-1,visited);
        dfs(grid,r+1,c,visited);
        dfs(grid,r,c+1,visited);
    }

    public static int islandSize(int[][] grid,int r,int c,boolean[][] visited){
        int n=grid.length;
        int m=grid[0].length;
        int size=1;

        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || visited[r][c]){
            return 0;
        }

        visited[r][c]=true;

        size+=islandSize(grid,r-1,c,visited);
        size+=islandSize(grid,r,c-1,visited);
        size+=islandSize(grid,r+1,c,visited);
        size+=islandSize(grid,r,c+1,visited);

        return size;
    }

    public static int islandCount(int[][] grid){
        //use DFS to find neighbours
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited=new boolean[n][m];

        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                    continue;
                }
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                    //need to check neighbours of this element grid[i-1][j], grid[i][j-1],grid[i+1][j],grid[i][j+1]
                    //then we need to check the neighbours of those neighbours
                    //update all of those cells in visited
                    dfs(grid,i,j,visited);


                }
            }
        }
        return count;

    }

    public static int minimumIslandSize(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];

        int minSize=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                    continue;
                }
                if(grid[i][j]==1 && !visited[i][j]){
                    minSize=Math.min(minSize,islandSize(grid,i,j,visited));
                }

            }
        }
        return minSize;
    }
    public static void main(String[] args){
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };

        System.out.println("Number of islands: " + islandCount(grid));
        System.out.println("Minimum Island Size: "+minimumIslandSize(grid));
    }
}
