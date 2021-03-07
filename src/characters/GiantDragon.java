package characters;

public class GiantDragon extends Characters implements Attackable{         //单例模式的大龙，只在最后实例化，战斗程序未完成，头发要紧！！！
    private  String name = "纳什男爵";
    private  int attack = 17;
    private  int hp = 3000;
    private  int  armature= 3;
    private  double x = 89;
    private  double y= 15;
    private GiantDragon(){
        Characters.typeset();
        System.out.println("峡谷之主！！纳什男爵降临了！颤抖吧！召唤师！");
    }
private static GiantDragon getInstance;
    public static Characters getInstance(){
        if(null==getInstance){
            getInstance = new GiantDragon();
        }
        return getInstance;
    }
    @Override
    public int attack(Characters character) {                                    //战士攻击手段
        character.setHp(character.hp+character.armature-this.attack);
        return character.hp+character.armature-this.attack;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public int getArmature() {
        return armature;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
