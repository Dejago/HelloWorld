import java.util.Random;

public class SeaBattle0316 {

    //海战模拟
    public static void main(String[] args) {
        Random hitRate = new Random();  //用于生成随机命中的随机数

        BattleShip bb1 = new BattleShip();
        BattleShip bb2 = new BattleShip();
        BattleShip bb3 = new BattleShip();

        bb3.naming(); //给bb3分配一个新编号，测试命名方法


        //以下战斗部分测试了攻击、命中、受到伤害、提速、减速
        System.out.println("==================第一回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.acceleration();
        System.out.println();

        System.out.println();
        System.out.println("==================第二回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.acceleration();

        System.out.println();
        System.out.println("==================第三回合==================");
        bb1.acceleration();
        bb2.deceleration();
        bb3.acceleration();

        System.out.println();
        System.out.println("==================第四回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.acceleration();

        System.out.println();
        System.out.println("==================第五回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.acceleration();

        System.out.println();
        System.out.println("==================第六回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.acceleration();

        System.out.println();
        System.out.println("==================第七回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.barrage(bb2, hitRate.nextFloat());

        System.out.println();
        System.out.println("==================第八回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.barrage(bb2, hitRate.nextFloat());

        System.out.println();
        System.out.println("==================第八回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.barrage(bb2, hitRate.nextFloat());

        System.out.println();
        System.out.println("==================第九回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.barrage(bb2, hitRate.nextFloat());
        bb2.receiveDamage(10000);  //强制击沉

        System.out.println();
        System.out.println("==================第十回合==================");
        bb1.barrage(bb2, hitRate.nextFloat());
        bb2.barrage(bb1, hitRate.nextFloat());
        bb3.barrage(bb2, hitRate.nextFloat());

        System.out.println();
        System.out.println("==================战斗结束==================");
        bb1.showStatus();
        bb2.showStatus();
        bb3.showStatus();
        for (int i = 0; i < 20; i++) {  //再建造20艘战列舰测试命名方法
            new BattleShip().showStatus();
        }


    }
}
