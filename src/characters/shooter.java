package characters;
import java.util.HashMap;
//射手类英雄制造
public class shooter extends Characters {
    public shooter() {
    }
    //构造射手英雄池
    public HashMap<Integer,shooter> shooters=new HashMap<Integer,shooter>();
     //射手构造信息
        public shooter(String name,int...args) {
        this.name=name;
        this.attack=args[0];
        this.armature=args[1];
        this.attackrange=args[2];
        this.hp=args[3];
        this.x=args[4];
        this.y=args[5];
    }
    //填充射手英雄池
    public Characters makeshoters(){                                                          //填充射手英雄池
        shooters.put(1, new shooter("寒冰", 16, 4, 5,  80, 0, 0));
        shooters.put(2, new shooter("嘴炮", 14, 2, 5, 100, 0, 0));
        shooters.put(3, new shooter("抚琴", 15, 1, 5, 100, 0, 0));
        shooters.put(4, new shooter("唐僧", 13, 1, 5, 100,0, 0));
        shooters.put(5, new shooter("玉帝", 14, 1, 5, 100, 0, 0));
        shooters.put(6, new shooter("纳兰嫣然", 15, 1, 5, 100, 0, 0));
        shooters.put(7, new shooter("白菜", 14, 1, 5, 100, 0, 0));
        shooter.printCharactersmessage(shooters);
        shooter.typeset();
        System.out.println("请选择你想要召唤的英雄：");
        return shooter.chooseHero(shooters);
    }

    public void printshootermessage(){                       //调用可以打印射手的信息
        shooter.printCharactersmessage(this.shooters);
    }

    //射手攻击手段
    @Override
    public int attack(Characters character) {                                          //射手攻击手段
        character.setHp(character.hp+character.armature-this.attack);
        return character.hp+character.armature-this.attack;
    }

}
