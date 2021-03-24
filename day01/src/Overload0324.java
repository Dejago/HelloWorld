public class Overload0324 {

    public static void main(String[] args) {
        System.out.println(getValue("Value"));
        System.out.println(getValue(175));
        System.out.println(getValue(17,25,63));
        System.out.println(getValue("ABC",15));
        System.out.println(getValue(27,"STR"));
        System.out.println(new Overload0324().getValue(13));

    }

    //单一参数
    static String getValue(String value) {
        return value;
    }

    //无论静态还是非静态，传入参数类型都不能相同
/*    String getValue(String value) {

    }*/

    //重载方法，不同的参数类型
    static String getValue(int value) {

        return String.valueOf(value);

    }

    //重载方法，不同的参数数量
    static String getValue(int... values) {
        int value = 0;
        for (int i : values) {
            value += i;
        }
        return String.valueOf(value);
    }

    //重载方法，不同类型的多个参数
    static String getValue(String s, int i) {
        return new StringBuilder().append(s).append(i).toString();
    }

    //重载方法，相同的参数类型但顺序不同
    static String getValue(int i, String s) {
        return new StringBuilder().append(i).append(s).toString();
    }

    //相同参数但不同返回类型不同，不可行
/*    static int getValue(int... values) {

    }*/

    //重载方法，使用封装类作为参数时，会对传入的基本型自动装箱
    //若已存在其基本型的方法，则只有在传入参数为封装类时才会调用此方法，与先后顺序无关,与是静态调用还是实例调用无关
    String getValue(Integer value) {
        value += 1;
        return value.toString();
    }


}
