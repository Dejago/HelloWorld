import java.util.LinkedHashMap;
import java.util.Set;

public class CharSumAlter {

    public static void main(String[] args) {
        System.out.println("出现最多的字符是："+getMost("get the teammates"));
    }

    private static char getMost(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();  //用于存储每个字符与其数量
        int len = str.length();  //获取字符串长度以用于遍历
        char c;
        int n;

        //遍历并接收字符串中每一个字符及其数量
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (map.containsKey(c)) { //判断map中是否已存入过该字符，如果已经存在，则数量加一，不存在则设置为1
                n = map.get(c) + 1;
            }else {
                n = 1;
            }
            map.put(c, n);
        }

        //判断map是否为空
        if(map.isEmpty()) {
            System.out.println("输入的内容不能为空");
            return ' ';
        }

        //获取keyset用于遍历
        Set<Character> set = map.keySet();
        char most = ' ';
        int last = 0;
        for (char ch : set) {
            int i = map.get(ch);
            if (i > last) {        //如果当前字符的数量比上一次记录的大
                most = ch;        //则记录当前为数量最大的字符
                last = i;         //并记录这次数量用于下次检测
            }
        }
        return most;
    }

}
