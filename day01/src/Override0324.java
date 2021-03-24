public class Override0324 extends Overload0324{
    public static void main(String[] args) {

        System.out.println(getValue("KFC"));
        System.out.println(new Override0324().getValue(new Integer(25)));
    }



    //静态方法无法重写，添加@Override注解会报错
    //而且由于静态方法是通过类名调用的，会根据调用的类来区分方法，即使重写也达不到多态的目的
    static String getValue(String s) {
        return new StringBuilder().append("--").append(s).toString();
    }

    @Override
    String getValue(Integer value) {
        value *= 10;
        return value.toString();
    }
}
