public class FruitFactory0317 {

    public static Fruit0317 fruitGenerator(String type) {

        switch (type) {
            case "1" :
                return new Apple();
            case "2" :
                return new Banana();
            case "3" :
                return new WaterMelon();
            default:
                System.out.println("输入错误！");
                return new Fruit0317();
        }
    }
}
