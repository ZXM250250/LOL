package Execute;
import Layout.layout;
import characters.Characters;
import characters.shooter;
import characters.warrior;
import reflection.reflections;

import java.util.List;
import java.util.Scanner;
public class tools {                     //此类主要实现英雄奔跑 攻击距离判断
    private combat combat;
    private warrior warrior;
    private shooter shooter;
    private Characters Hero;
    private reflections reflections;
    //实例化角色方便调用角色的方法
    Scanner input =new Scanner(System.in);
    //角色的移动方法
    public void move(Characters characters){                     //废弃的移动代码块
        System.out.println("请选择你想要移动的方法");
    }
    //计算角色之间的距离
    public static Double calculatedistance(Characters character1, Characters character2){
        return  Math.sqrt(((Math.pow(character1.getX()-character2.getX(),2.0)+Math.pow(character1.getY()-character2.getY(),2.0))));
    }
    //是否可攻击判断
    public  void judgedistance(Characters character1, List list){
        for(int i = 0;i<list.size();i++){
            Double ditance =  tools.calculatedistance( character1, (Characters) list.get(i));
            if (ditance <= character1.getArmature()){
                combat.battle(character1, (Characters) list.get(i));
                //废弃的战斗代码   character1.attack(character2);                        //调用角色攻击方法攻击
//       }else if (character2.getAttackrange()>=ditance){
//           //废弃的战斗代码character2.attack(character1);                       //调用角色攻击方法
            }
            }
            tools.typeset();
            System.out.println("没有激烈的战斗发生呀，召唤师快点啊加入激情的战斗吧,试着移动你的英雄去激情吧");
            Hero.move();                                                         //进行玩家角色的移动
            Hero.showlocation();

          reflections.show(list);

    }
           //游戏界面的选择1.开始游戏2.游戏说明
    protected   Characters choose(){
        tools tools = new tools();
        boolean judge=true;
        while(judge){
            int choice=input.nextInt();
            if(choice==1){
                //执行开始游戏的方法 也就是调用了选择人物的方法
                tools.typeset();
                System.out.println("那么你想选择战士还是射手呀?");
                tools.typeset();
                System.out.println("1.选择战士");
                tools.typeset();
                System.out.println("2.选择射手");
                try {
                   return tools.choosegame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                judge=false;
            }else if(choice==2){
                System.out.println("\n\n\n"+string+"游戏移动方法为w a s d 四个英文字母，通关条件为消灭所有存在的敌人");

                try {
                    layout.printfgamechaet();
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                judge=false;
            }else {
                tools.typeset();
                System.out.println("请输入1-2之间的数字");
            }
        }
        return null;
    }
    //选择人物的方法1.选择一个战士2.选择一个射手 并且将选择的英雄返回主函数接受
    public  Characters choosegame()throws InterruptedException{

        while(true){
            int choice2=input.nextInt();
            tools.typeset();
            System.out.println("正在为你准备英雄信息...");
            Thread.sleep(2000);
            if(choice2==1){
                warrior warrior = new warrior();
                //1.打印战士信息的方法2.调用选择战士的方法
                return warrior.makewarriors();

            }else if(choice2==2){              //后面补齐射手的内容
                shooter shooter = new shooter();
                return shooter.makeshoters();
            }else {
                tools.typeset();
                System.out.println("请输入1-2之间的数字");
            }
        }

        }
    public  String string ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        public  static void typeset(){                 //排版的方法

            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        }

    public void setWarrior(warrior warrior) {
        this.warrior = warrior;
    }
    public void setShooter(shooter shooter) {
        this.shooter = shooter;
    }

    public void setHero(Characters hero) {
        Hero = hero;
    }

    public characters.warrior getWarrior() {
        return warrior;
    }

    public characters.shooter getShooter() {
        return shooter;
    }

    public void setCombat(Execute.combat combat) {
        this.combat = combat;
    }

    public void setReflections(reflection.reflections reflections) {
        this.reflections = reflections;
    }
}

