package OverrideAndOverload0324;

public class Override0324 {
    public static void main(String[] args) {

        Father father = new Father();
        System.out.println(father.printValue(20));
        Child child = new Child();
        System.out.println(child.printValue(45));

    }

}

class Father {

    Object printValue(int i) {
        System.out.println("向父类传入了参数" + i +"，并将其乘以2");
        i *= 2;
        return i;
    }
}

class Child extends Father {

    //重写要求方法名和传入参数完全一样，返回类型可以不同但必须是被重写方法返回类型的子类
    @Override
    String printValue(int i) {
        System.out.println("向子类传入了参数" + i +"，再加15");
        i += 15;
        return String.valueOf(i);
    }
}