package characters;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public abstract class Characters implements Attackable{//第一泛型控制x，y的类型
    protected String name;                   //角色信息模板
    protected int attack;
    protected int armature;                 //护甲值
    protected double attackrange;               //攻击范围
    protected int hp;
    protected double x;                          //位置信息
    protected double y;
    public  String string ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    Scanner input=new Scanner(System.in);
    //迭代器打印角色信息供玩家选择
    public static void printCharactersmessage(Map hashMap){                   //迭代器打印角色信息供玩家选择
        Iterator<Map> iterator = hashMap.keySet().iterator();
        int i=0;
        while (iterator.hasNext()){
            Object key =iterator.next();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                           i++;
            Characters.typeset();
            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+i+"号英雄信息如下\n"+hashMap.get(key));
        }
    }
    //角色打印信息的重写
    public String toString() {
        return  string+"***该英雄信息***\n"+
                string+"姓名："+this.name+"\n"+
                string+"血量："+this.hp +"\n"+
                string+"攻击力："+this.attack +"\n"+
                string+ "护甲值"+this.armature +"\n"+
                string+"位置:"+ "x:"+this.x+"\ty:"+this.y +"\n"+
                string+""+"*************";
    }
    //排版的方法:让内容都显示在屏幕的中间
    public static void typeset(){                 //排版的方法:让内容都显示在屏幕的中间
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    }
    //展示信息以后的英雄选取并且赋值给真正的主函数英雄
    public static Characters chooseHero(HashMap hashMap) {                     //展示信息以后的英雄选取并且赋值给真正的主函数英雄
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        Object key;
        while (true) {
              if(choice >=1 && choice <=7) {
                  switch (choice) {
                      case 1:
                           key = 1;
                          return (Characters) hashMap.get(key);
                      case 2:
                           key = 2;
                          return (Characters) hashMap.get(key);
                      case 3:
                           key = 3;
                          return (Characters) hashMap.get(key);
                      case 4:
                          key = 4;
                          return (Characters) hashMap.get(key);
                      case 5:
                          key = 5;
                          return (Characters) hashMap.get(key);
                      case 6:
                          key = 6;
                          return (Characters) hashMap.get(key);
                      case 7:
                           key = 7;
                          return (Characters) hashMap.get(key);
                  }
              }
            System.out.println("请重新作出你的选择1-7：");
            choice = input.nextInt();
            continue;
        }

    }
    public void showlocation(Characters characters){                    //打印角色当前位置的方法
        Characters.typeset();
        System.out.println("下面来移动你的英雄吧！");
        Characters.typeset();
    }
    public void move() {                                        //角色的移动方法
        Characters.typeset();
        System.out.println("下面来移动的你的英雄");
        String foots = input.nextLine();
        for(int i=0;i<foots.length();i++){
            if('w'==foots.charAt(i)){
                this.y=this.y+1;
                System.out.println(string+"你将"+this.getName()+"向上移动了一格");
            }else if('s'==foots.charAt(i)){
                this.y=this.y-1;
                System.out.println(string+"你将"+this.getName()+"向下移动了一格");
            }
            else if('a'==foots.charAt(i)){
                this.x=this.x-1;
                System.out.println(string+"你将"+this.getName()+"向左移动了一格");
            }
            else if('d'==foots.charAt(i)){
                this.x=this.x+1;
                System.out.println(string+"你将"+this.getName()+"向右移动了一格");
            }

        }
    }
    public void showlocation() {              //展现角色当前位置的方法
        warrior.typeset();
        System.out.println("当前战士的位置是:");
        warrior.typeset();
        System.out.println("X:"+this.x+"\tY:"+this.y);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAttackrange(int attackrange) {
        this.attackrange = attackrange;
    }

    public void setArmature(int armature) {
        this.armature = armature;
    }

    public int getArmature() {
        return armature;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public double getAttackrange() {
        return attackrange;
    }

    public int getHp() {
        return hp;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Scanner getInput() {
        return input;
    }
}
