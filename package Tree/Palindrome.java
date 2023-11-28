package Tree;

/**
 * Tests whether the given string is a palindrome
 * Parsed & analyzed by the parser class
 */

public class Palindrome
{
    public static void main(String[] args)
    {
        // sample string
        String str = "tacocat";

        // converts string to lowercase, for palindromian purposes
        str = str.toLowerCase();

        // checks if the string is a palindrome, stores result in ans
        boolean ans = isPalindrome(str);

        // prints result
        System.out.println(ans);
    }

    public static boolean isPalindrome(String str)
    {
        // stores reversed version of the string
        String rev = "";

        // initializes palindrome truth value to false
        boolean ans = false;

        // iterates through string in reversed order
        for (int i = str.length() - 1; i >= 0; i--) {
            // creates reversed string
            rev = rev + str.charAt(i);
        }

        // checks if original string and reversed string are equivalent
        if (str.equals(rev)) {
            // if palindrome, sets ans to true
            ans = true;
        }

        return ans;
    }
}
