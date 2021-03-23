package o0317;

public class Restrict {

    private String pv = "私有";  //private修饰的属性只能被本类访问
    String de = "默认";          //无修饰的属性只能被同一个包内的类访问
    protected String pt = "保护";  //protected修饰的属性只能被同包类或包外子类内访问
    public String pu = "公开";     //public修饰的属性可以被任何类访问

}
