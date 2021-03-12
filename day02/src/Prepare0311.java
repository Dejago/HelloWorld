public class Prepare0311 {
    public static void main(String[] args) {

        //基本数据类型

        //整数类型
        byte b = 256/2-1;//字面数字的默认类型为int，在其大小不超过声明类型的上限时可以直接赋值
        short s = 256*256/2-1;
        int i = 256*256*256/2*256-1;//字面值为int类型，4个256叠乘会超过int能储存的上限造成溢出，故提前除2
        long l = 256L*256*256*256*256*256*256/2*256-1; //由于运算中涉及了一个long类型，参与运算的数字会被自动提升，否则会因为超出int类型的上限造成溢出

        System.out.println("整数类型byte的最大值为"+b);
        System.out.println("整数类型short的最大值为"+s);
        System.out.println("整数类型int的最大值为"+i);
        System.out.println("整数类型long的最大值为"+l);


        //递增与递减
        Integer x = 1;
        Integer y = x++; //++在后修饰会先把x的值复制给y再自增
        Integer z = ++x; //++在前修饰会先让x自增再把值复制给z
        System.out.println(String.join(" ",x.toString(),y.toString(),z.toString()));
        System.out.println("--------我是可爱的分割线--------");
        System.out.println();

        //浮点类型
        float f = 2.5f;//字面的小数默认类型为double，不能直接赋值给float类型；
        double d = 2.5;

        float f1 = 1;
        f1 /= 3; //相当于 f1 = f1/3 ，其他符号同理
        System.out.println("float类型1除以3的值为"+f1);
        f1 += f1;
        System.out.println("在于自身相加值为"+f1);
        f1 *= 1.5f;//float类型与字面为double类型相乘会自动提升为double，无法再赋予float类型变量，故只能与float类型相乘
        System.out.println("再乘3除以2值为"+f1);

        System.out.println("--------我是可爱的分割线--------");
        System.out.println();

        //布尔类型
        boolean bl = true;
        System.out.println(bl);
        bl = f == d;
        System.out.println(bl);
        bl = new Float(f).equals(new Double(d));
        System.out.println(bl);

        System.out.println("--------我是可爱的分割线--------");
        System.out.println();

        //字符与字符串
        char c = 'v';//
        String str = "HelloWorld";
        //字符串拼接的N种方法
        String str1 = "Hello";
        String str2 = "World";
        System.out.println(str1+str2); //本质上是StringBuilder的append方法，但每个加号都会创建一个新的StringBuilder对象，会大大浪费资源和性能
        System.out.println(new StringBuilder().append(str1).append(str2));
        System.out.println(str1.concat(str2));
        System.out.println(String.join("-",str1,str2,"!"));//可加带特定分隔符的拼接

        String strn = null;
        System.out.println(new StringBuilder().append("abc").append(strn).toString());//append方法传入对象如果是null会直接把null字符拼接进去

    }

}
