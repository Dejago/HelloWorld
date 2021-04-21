package FruitFactory0317;

public class Fruit0317 {

    FruitType type;

    Fruit0317() {
        type = FruitType.FRUIT;
    }

    void showInfo() {
        System.out.println("这是一个" + type.getType());
    }

    public static void main(String[] args) {

        Fruit0317 fruit = FruitFactory0317.fruitGenerator(FruitType.APPLE);
        fruit.showInfo();
    }

}

enum FruitType {

    FRUIT("水果"), APPLE("苹果"), BANANA("香蕉"), WATERMELON("西瓜");

    private String type;
    FruitType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}


