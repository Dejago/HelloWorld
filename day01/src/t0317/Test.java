package t0317;

import o0317.Restrict;

public class Test extends Restrict {


    public static void main(String[] args) {

        //同包内直接调用
        Restrict r = new Restrict();
        //System.out.println(r.pv);   //private无法调用
        //System.out.println(r.de); //默认的无法调用
        //System.out.println(r.pt); //protected无法调用
        System.out.println(r.pu);  //public可以调用

        //子类调用
        Test test = new Test();
        //System.out.println(test.pv);//private修饰的无法调用
        //System.out.println(test.de); //无法的可以
        System.out.println(test.pt); //protected可以
        System.out.println(test.pu); //public可以

    }
}

