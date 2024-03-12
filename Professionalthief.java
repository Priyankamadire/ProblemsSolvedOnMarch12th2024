/*A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3

 */
import java.util.*;
public class Professionalthief{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(solve(n,m,arr,0,0));
    }
    public static boolean isSafe(int n,int m,int arr[][],int i,int j){
        
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]==1){
            return false;
        }
        
        return true;
    }
    public static int solve(int n,int m,int arr[][],int i,int j){
        if(!isSafe(n,m,arr,i,j)){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        int cnt =0;
        cnt+=solve(n,m,arr,i+1,j);
        cnt+=solve(n,m,arr,i,j+1);
        return cnt;
    }
}