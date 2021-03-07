package characters;
import java.util.ArrayList;
import java.util.List;
//小兵类
public class billet extends Characters {                  //小兵类实际没有用到此代码 时间不够用
    List<billet> billets = new ArrayList<>();
    // 小兵生产的模板
    public  billet(){                                    //小兵生产的模板
        setName("小兵");
        setHp(30);
        setAttack(2);
        setAttackrange(1);
        setArmature(0);
    }
    //小兵生产机器
    public void makebillets(){                            //小兵生产机器
        billets.add(new billet());
    }
    @Override
    public int attack(Characters character) {                                    //X攻击手段
        character.setHp(character.hp+character.armature-this.attack);
        return character.hp+character.armature-this.attack;
    }
}
