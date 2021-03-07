package characters;
import java.util.HashMap;
public class warrior extends Characters  {
    HashMap<Integer,warrior> warriors= new HashMap<Integer, warrior>();
                      //构造战士英雄制造
                      //打造战士英雄池
    public warrior() { }
    public warrior(String name,int...args) {                                                    //战士英雄得构造信息
        this.name=name;
        this.attack=args[0];
        this.armature=args[1];
        this.attackrange=args[2];
        this.hp=args[3];
        this.x=args[4];
        this.y=args[5];
    }
    public Characters makewarriors() {             //返回玩家所选择的英雄                            //填充战士英雄池
        warriors.put(1, new warrior("盖伦", 8,  4,  5,  150, 0, 0));
        warriors.put(2, new warrior("唐三", 13, 2, 5, 100, 0, 0));
        warriors.put(3, new warrior("石昊", 14, 1, 5, 108, 0, 0));
        warriors.put(4, new warrior("迪迦", 13, 2, 5, 117, 0, 0));
        warriors.put(5, new warrior("金刚", 10, 1, 5, 102, 0, 0));
        warriors.put(6, new warrior("赛斯", 11, 1, 5, 120, 0, 0));
        warriors.put(7, new warrior("武庚", 12, 1, 5, 110, 0, 0));
        warrior.printCharactersmessage(warriors);
        warrior.typeset();
        System.out.println("请选择你想要召唤的英雄：");
       return warrior.chooseHero(warriors);
    }
    //调用可以打印战士的信息
//    public void printwarriormessage(){                       //调用可以打印战士的信息
//        warrior warrior = new warrior();
//        warrior.makewarriors();
//        warrior.printCharactersmessage(this.warriors);
//    }
    @Override
    public int attack(Characters character) {                                    //战士攻击手段
        character.setHp(character.hp+character.armature-this.attack);
        return character.hp+character.armature-this.attack;
    }







}
