import java.util.Scanner;

public class Fruit0317 {

    String type;

    Fruit0317() {
        type = "水果";
    }

    void showInfo() {
        System.out.println("这是一个" + type);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要生成的水果编号");
        System.out.println("1：苹果");
        System.out.println("2：香蕉");
        System.out.println("3：西瓜");

        Fruit0317 fruit = FruitFactory0317.fruitGenerator(scanner.next());
        fruit.showInfo();
    }

}


class Apple extends Fruit0317 {

    Apple() {
        super.type = "苹果";
    }

}

class Banana extends Fruit0317 {

    Banana() {
        super.type = "香蕉";
    }
}

class WaterMelon extends Fruit0317 {

    WaterMelon() {
        super.type = "西瓜";
    }
}