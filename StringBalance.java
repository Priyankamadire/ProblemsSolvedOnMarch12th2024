/*Scott is a sweet lover and eats sweets daily. His father is worried about his health 
and gives a task to Scott. If Scott solves the task then he is allowed to eat the sweets.

His task is as follows

Scott is given a word 'W'. Now he is supposed to see, the word is a Balanced Word or Not .

A word is said to be Balanced word if it contains all characters same number of times. 
He can also make the word Balanced by removing  only one occurence of a character at any index in the word. 

If he is able to do so print "true" else print "false"


Sample Test Case-1

input = xyz
output = true

This is Balanced because (x-1,y-1,z-1)

Sample Test Case-2

input = xyzz
output = true

This is Balanced because (x-1,y-1,z-2)
He can remove one occurence of z, It results in (x-1,y-1,z-1)

Sample Test Case-3

input = xxyyzzzz
output = false

This is not Balanced because (x-2,y-2,z-4)
By removing once occurence of z, It results in (x-2,y-2,z-3)
So this is not Balanced

Sample Test Case-4

input = xzxyzxz
output = true

This is Balanced because (x-3,y-1,z-3)
By removing once occurence of y, It results in (x-3,z-3)
So this is  Balanced
 */
import java.util.*;
public class StringBalance{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.print(solve(s));
    }
    public static boolean solve(String s){
        int x=0,y=0,z=0;
        for(char c:s.toCharArray()){
            if(c=='x'){
                x++;
            }
            
            if(c=='y'){
                y++;
            }
            if(c=='z'){
                z++;
            }
            
        }
        
        if((x==y && y==z) || (x==y && y==z-1) || (x==z && z==y-1) || (y==z && z==x-1) ){
            return true;
        }
        return false;
       
    }
}