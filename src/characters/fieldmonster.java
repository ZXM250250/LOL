package characters;

public class fieldmonster extends Characters{                          //野怪类


    public fieldmonster(String name,String message,double x,double y,int...args) {
        this.name=name;
        this.attack=args[0];
        this.armature=args[1];
        this.attackrange=args[2];
        this.hp=args[3];
        this.x=x;
        this.y=y;
        Characters.typeset();
        System.out.println(message);
    }

    @Override
    public int attack(Characters character) {                                          //野怪的攻击手段
        character.setHp(character.hp+character.armature-this.attack);
        return character.hp+character.armature-this.attack;
    }
}
