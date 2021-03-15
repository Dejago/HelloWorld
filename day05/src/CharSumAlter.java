import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class CharSumAlter {

    public static void main(String[] args) {
        System.out.println("出现最多的字符是："+getMost("get the teammates"));
    }

    private static char getMost(String str) {
        char most = ' ';
        char[] split = str.toCharArray();
        Arrays.sort(split);
        String sorted = new String(split);
        int len = sorted.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = sorted.charAt(i);
            int last = sorted.lastIndexOf(c);
            if (last - i > count || most == ' ' && c != ' ') {
                most = c;
                count = last - i;
            }else if (last - i == count) {
                if (str.indexOf(c) < str.indexOf(most)) {
                    most = c;
                }
            }
            i = last;
        }


        return most;
    }

}
