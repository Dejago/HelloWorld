public class BattleShip {

    //名库
    private static String[] battleshipNames = {"BB-1 January", "BB-2 February", "BB-3 March", "BB-4 April", "BB-5 May", "BB-6 June", "BB-7 July", "BB-8 August", "BB-9 September", "BB-10 October", "BB-11 November", "BB-12 December"};
    private static int nameIndex = 0; //用于记录已经被占用的名称

    private String name;    //战列舰名称
    private int hitpoint;  //生命值
    private int attackPower;  //攻击力
    private float hitChance;  //基础命中率
    private int attackSpeed;  //攻击速度，体现武器装填速度
    private boolean isCooling;  //判断武器是否正在装填
    private int coolingProcess;  //武器装填的进度，0-100，100为装填完成
    private int speed;    //当前航速
    private int maxSpeed;   //最大航速
    private String position;   //当前位置
    private boolean isAlive;   //判断是否存活

    BattleShip() {
        naming();
        hitpoint = 10000;
        attackPower = 3500;
        hitChance = 0.3f;
        attackSpeed = 35;
        isCooling = false;
        coolingProcess = 0;
        speed = 0;
        maxSpeed = 28;
        position = "Port";
        isAlive = true;
    }

    //舰艇命名方法
    protected void naming() {

        if (nameIndex < 12) {
            this.name = battleshipNames[nameIndex];  //从名库中取出新的名称
        } else {
            this.name = "BB-" + (nameIndex + 1);   //若名库用尽，则按照规律则自动命名
        }
        nameIndex++;
    }

    //模拟开火
    public void barrage(BattleShip target, float hitRate) {
        System.out.println(name + " 正在瞄准 " + target.getName());
        if (isCooling) { //判断武器是否可用，不可用时继续增加装填进度
            weaponCooling();
            return;
        }
        if (!target.isAlive) {  //判断目标是否存活，不能攻击已经在沉没的目标
            System.out.println(target.getName() + " 正在沉没，无法被选为目标");
            return;
        }

        //命中算法，目标血量约低，命中率越低，自身以及目标航速越快，命中率约低
        //只有当传入的hitRate小于等于最终命中率时才算命中
        if (hitRate > hitChance * (float) (target.getHitpoint() / 5000) * (float) (50 / (target.getSpeed() + 50)) * (float) (30 * (30 + speed))) {
            System.out.println(name + " 的攻击没有命中 " + target.getName() + " !");
        } else {
            System.out.println(name + " 对 " + target.getName() + " 一顿猛轰，造成了 " + attackPower + " 点伤害！");
            target.receiveDamage(attackPower);
        }
        isCooling = true;  //成功开火后武器开始冷却
    }

    //受到伤害
    public void receiveDamage(int damage) {
        hitpoint -= damage; //血量减少受到的伤害值
        System.out.println(name + " 受到了 " + damage + " 点伤害！");
        if (hitpoint <= 0) {  //判断是否被击沉
            hitpoint = 0;
            isAlive = false;
            speed = 0;
            System.out.println(name + " 被击沉！");
        }
    }

    //武器冷却方法
    private void weaponCooling() {
        if (isCooling) {
            System.out.println(name + " 的武器还不可用！");
            coolingProcess += attackSpeed;  //增加装填进度
            if (coolingProcess >= 100) {  //当装填大于等于100时，将转换为可用并可在下回合攻击
                coolingProcess = 0;
                isCooling = false;
                System.out.println(name + " 装填完成！");
            }
        }
    }

    public void acceleration() {
        if (!isAlive) {
            System.out.println(name + " 正在沉没，无法提速");
            return;
        }
        if (speed == maxSpeed) {   //判断速度是否已经是最大了，是则无法再提速
            System.out.println(name + " 已达到最大速度，无法继续提速！");
            return;
        }
        speed += 5;
        if (speed > maxSpeed) {   //判断提速后的航速是否超过最大航速，超过了则直接变为最大速度
            speed = maxSpeed;
        }
        System.out.println(name + " 正在提速，当前航速：" + speed + " 节");
    }

    public void deceleration() {
        if (!isAlive) {
            System.out.println(name + " 正在沉没，无法提速");
            return;
        }
        if (speed == 0) {  //判断航速是否已经是0，0则无法再减速
            System.out.println(name + " 已经停止，无法继续减速");
            return;
        }
        speed -= 5;
        if (speed < 0) {  //判断减速后是否低于0，速度不能为负数
            speed = 0;
        }
        System.out.println(name + " 正在减速，当前航速：" + speed + " 节");
    }

    public String getName() {
        return this.name;
    }

    public int getHitpoint() {
        return this.hitpoint;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void showStatus() {
        System.out.println(name + "：");
        System.out.println("状态：" + (isAlive ? "存活" : "沉没"));
        System.out.println("生命值：" + hitpoint);
        System.out.println("航速：" + speed);
        System.out.println();
    }


}
