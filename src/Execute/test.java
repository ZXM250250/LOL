package Execute;
import Layout.layout;
import characters.*;
import reflection.reflections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Thread.*;
public class test {
    public  static String string ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    static int time=0;
    static   Characters Hero = null;
    static Scanner inpput = new Scanner(System.in);
    public static void main(String[] args) {
        int number=0;//用来计算玩家击败敌方单位数量
                combat combat = new combat();

        warrior warrior;
        shooter shooter;
        reflections  reflections = new reflections();
           tools tools =new tools();
           tools.setReflections(reflections);
           tools.setCombat(combat);
        try {
            layout.printfgamechaet();                          //游戏界面开始的排版
            Hero=tools.choose();                               //主要是人物的选择
                tools.setHero(Hero);                           //工具拿到玩家召唤的英雄便于在工具里改变它的属性
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        if(Hero instanceof warrior){

             warrior = (characters.warrior) Hero;
             Characters.typeset();
             System.out.println("恭喜你！你成功召唤了"+warrior.getName()+"一名强悍的战士");
             System.out.println(warrior);
             tools.setWarrior((characters.warrior) Hero);

}else {

             shooter = (characters.shooter) Hero;
            Characters.typeset();
            System.out.println("恭喜你！你成功召唤了"+shooter.getName()+"一名流弊的射手");
            System.out.println(shooter);
            tools.setShooter((characters.shooter) Hero);

        }
        Characters.typeset();
        System.out.println(" 正在初始化游戏环境，请稍等...");
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.cotinue();
        DefensiveTower friendlydefensiveTower=new DefensiveTower("友方的1妖邪防御塔",45,15);//实例化友方防御塔
        DefensiveTower hostilelydefensiveTower=new DefensiveTower("敌方的妖邪防御塔",135,15);//实例化地方防御塔
        System.out.println(friendlydefensiveTower);
        System.out.println(hostilelydefensiveTower);
        System.out.println(string+"野怪们也即将出生！，，，");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fieldmonster 三狼 = new fieldmonster("狂野三狼","可爱三狼在峡谷诞生了",45,10,6,1,2,50);
        test.sleeps();
        fieldmonster 六小鸡 = new fieldmonster("六小鸡","疯狂六小鸡诞生了",135,10,7,0,2,50);
        test.sleeps();
        fieldmonster buff = new fieldmonster("buff","帅气buff诞生了，大家快来膜拜呀",89,5,8,1,2,50);
        test.sleeps();
        fieldmonster enemy = new fieldmonster("宙斯","宙斯在峡谷现身了：卑微的人类，接受正义的审判吧！",90,15,11,2,2,150);
        List<Characters> list = new ArrayList<>();                       //找个桶这些渣渣们全都装进去
        list.add(enemy);
        list.add(buff);
        list.add(三狼);
        list.add(六小鸡);
        list.add(hostilelydefensiveTower);

//        new Thread(){
//            @Override
//            public void run() {                     //自定义计时器    想设计一个时间复活线程和一个敌方角色的自动移动，未完成！！！  害害害！菜是原罪！
//                while (true){
//                    try {
//                        sleep(10000);
//                        Characters.typeset();
//                        System.out.println("是否需要查看敌方单位的位置信息yes/no");
//                        String s = inpput.nextLine();
//                        if(s.equals("yes")) reflections.show(list);
//                        else {
//                            Characters.typeset();
//                            System.out.println("继续前进吧勇士");
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }.start();

        new Thread(){                                 //第二个线程 始终进行玩家与其它角色之间的距离判断，距离足够则调用完整的战斗方法
            @Override
            public void run() {                                         //一直在进行距离的判断，在可攻击范围内就进行一对一的战斗
                while(true){
                        tools.judgedistance(Hero,list);
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                }
            }
        }.start();
                     while (true){
                         try {
                             sleep(10);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         for(int i= 0;i<list.size();i++){                    //检测是否有敌方单位死亡，并且计算击杀敌方单位数量
                             if(list.get(i).getHp()<0){
                                 list.remove(i);                               //将死亡的尸体扔出桶，避免造成干扰
                                 number++;
                                 Characters.typeset();
                                 System.out.println("你已经击败了敌方"+number+"个单位");
                                 Characters.typeset();
                                 System.out.println("努力吧！召唤师，击败敌方五个人");
                                 if(number==5){
                                     Characters.typeset();
                                     System.out.println("恭喜你召唤师，你已经击败了地方五名英雄");
                                     break;
                                 }
                             }
                         }
                         if(list.size()==0)
                             break;
                     }
                           list.add(GiantDragon.getInstance());
                          inpput.nextLine();
                          Characters.typeset();
                             System.out.println("未完待续。。。。。。。。。。。。");
                         Characters.typeset();
                         System.out.println("恭喜你已经获得了游戏的胜利，你实在是太厉害了！！！！！！！！");
                         Characters.typeset();
                         System.out.println("有空记得常来玩呀！！！！！！！");
                         Characters.typeset();
                         System.out.println("期待和你的下次见面");
    }
public static void cotinue(){
        Characters.typeset();
    System.out.println("请回车键继续");
    Object k = inpput.nextLine();
}
public static void sleeps(){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
