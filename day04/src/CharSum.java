import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class CharSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("字符统计程序已启动，请输入想要统计的字符串：");
        HashMap<Character, Integer> map = charsum(scanner.next());

        //遍历并打印
        Set<Character> characterSet = map.keySet();
        for (Character character : characterSet) {
            System.out.println(character + ":" + map.get(character));
        }
    }

    //统计字符串中的每一个字符的数量
    private static HashMap<Character, Integer> charsum(String str) {

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
        return map;
    }
}
