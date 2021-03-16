import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class CharSumAlter0314 {

    public static void main(String[] args) {
        System.out.println("出现最多的字符是："+getMost("get the teammates"));
    }

    private static char getMost(String str) {

        char most = ' ';
        int mostIndex = 0;
        int[] charTable = new int[128];

        for (char c : str.toCharArray()) {
            charTable[c]++;
            if (charTable[c] > charTable[mostIndex]) {
                most = c;
                mostIndex = c;
            }
        }


        return most;
    }

}
