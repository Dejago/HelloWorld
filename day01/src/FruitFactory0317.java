public class FruitFactory0317 {

    public static Fruit0317 fruitGenerator(FruitType type) {

        switch (type) {
            case APPLE:
                return new Apple();
            case BANANA:
                return new Banana();
            case WATERMELON:
                return new WaterMelon();
            default:
                System.out.println("输入错误！");
                return new Fruit0317();
        }
    }
}
