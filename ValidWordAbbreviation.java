/*/*Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.

Example 2:
Given s = "apple", abbr = "a2e":

Return false.*/
import java.util.*;
public class ValidWordAbbreviation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String k = sc.next();
        System.out.print(solve(s,k));
    }
    public static boolean solve(String s,String k){
        int n = s.length();
        int m = k.length();
        int i=0,j=0;
        while(i<n && j <m){
            if(Character.isDigit(k.charAt(j))){
                if(k.charAt(j)=='0'){
                    return false;
                }
                int p=0;
                while(j<m && Character.isDigit(k.charAt(j))){
                    p=p*10+(k.charAt(j)-'0');
                    j++;
                }
                i=i+p;
            }
            else{
                if(s.charAt(i)!=k.charAt(j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        return i==n && j==m;
    }
} 