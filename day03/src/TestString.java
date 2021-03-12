import java.util.Arrays;

public class TestString {
    public static void main(String[] args) {

        //由于字符串不可变的特性，以下对字符串的所有修改操作实际上都是返回了一个新的字符串
        String str = "HelloWorld";
        char[] chars = str.toCharArray(); //将字符串变成字符数组
        System.out.println(Arrays.toString(chars));
        str = str.concat("!");  //用concat进行字符串拼接
        System.out.println(str);
        String str1 = str.substring(5,10);//根据索引截取字符串，截取的字符包含开始的索引，不包含结束的索引
        System.out.println(str1);
        String[] strs = str.split("W"); //以W为分隔符将str分割成由多个字符串组成的字符串数组
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        str = str.replace('W','w'); //将大写的W替换成小写的w
        System.out.println(str);
        str = str.toUpperCase(); //转换为全大写
        System.out.println(str);
        str = str.toLowerCase(); //转换为全小写
        System.out.println(str);
        str = " Hello World ! ";
        System.out.println(str);
        str = str.trim(); //去除字符串头尾的空格
        System.out.println(str);
        str = String.join("-","Hello","World","!"); //使用特定分隔符拼接字符串
        System.out.println(str);
        String f = String.valueOf(3.141559f); //把基本类型或对象转化为字符串，如果传入的是对象则直接调用toString方法，对象可以为null
        System.out.println(f);
        boolean b = str.contains("or"); //判断字符串中是否包含特定的内容
        System.out.println(b);
        b = str.matches("[a-zA-Z-!]+"); //判断字符串是否符合给出的正则表达式的规律
        System.out.println(b);
        b = str.startsWith("Hel"); //匹配字符串开头
        System.out.println(b);
        b = str.endsWith("-!"); //匹配字符串结尾
        System.out.println(b);

        String str2 = "RangerChallenger";
        int n = str2.indexOf("ger"); //获取传入的字符串片段在字符串中第一次出现位置的索引（首字母位置），不存在则返回-1
        System.out.println(n);
        n = str2.lastIndexOf("ger"); //获取传入的字符串片段在字符串中最后一次出现位置的索引（首字母位置），不存在则返回-1
        System.out.println(n);

        String str3 = "RanGer";
        n = str3.compareTo(str2); //根据字典序对比两个字符串，会根据出现的第一个不同的字符在字典上的索引差返回数字，负数表示调用此方法的字符串靠前。
        System.out.println(n);
        str3 = "Ranger";
        n = str3.compareTo(str2); //当两个字符串前面的字符完全相同，则返回的数字是字符长度差，负数表示调用此方法的字符串更短。
        System.out.println(n);


        System.out.println("--------我是可爱的分割线--------");


        String abc1 = new String(new char[]{'a','b','c'});
        String abc2 = new StringBuilder().append("a").append("b").append("c").toString();
        //String abc3 = "a"+"b"+"c";  //如果将abc3的赋值移到这里，则下面的结果大部分会变为false
        System.out.println(abc1.intern() == abc1);
        System.out.println(abc1 == "abc");
        String abc3 = "a"+"b"+"c";
        System.out.println(abc3 == "abc");
        System.out.println(abc1 == abc3);
        System.out.println(abc2 == abc3);
        System.out.println(abc2.intern() == abc2);
        System.out.println(abc2.intern() == abc1);
    }
}
