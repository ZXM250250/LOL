package characters;
public  class DefensiveTower extends Characters {

                                                             //角色信息模板
   protected int attack=10;
    protected int armature=2;                               //护甲值
   protected int attackrange=4;                             //攻击范围
   protected int hp=200;
    public DefensiveTower(String name,double...args) {
        this.name=name;
        this.x=args[0];
        this.y=args[1];
        Characters.typeset();
        System.out.println("峡谷神塔：你们的保护神又回来了！哈哈哈哈哈哈哈");
    }
    @Override
    public int attack(Characters character) {                 //防御塔得攻击手段
        character.setHp(character.hp-this.attack);
        return character.hp-this.attack;
    }
    @Override
    public String toString() {             //重写打印防御塔信息
        return  string+"***"+this.name+"hp信息***\n"+
                string+"hp="+this.hp +"\n"+
                string +"*************";

    }

}
