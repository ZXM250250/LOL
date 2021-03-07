package Execute;
import characters.Characters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;
public class combat {                                                    //在执行位置判断的线程中执行角色的战斗
    int skillnumber = 4;                            //技能和装备伤害的加成值
    Scanner input = new Scanner(System.in);
    static   List<String > s = new ArrayList<>();
    static List<String > skills = new ArrayList<>();
    static    List<String > equipments = new ArrayList<>();
    public Characters battle(Characters character1, Characters character2) {  //第一个参数是玩家的英雄，第二个是攻击的角色 三种方式战斗最后返回胜利者

        combat.typeset();
        System.out.println("你找到了一只"+character2.getName()+"敌方单位");
        combat.typeset();
        System.out.println("战斗即将打响，做好准备消灭他们！");
        combat.ranmdskills();              //三个导入技能 语音  装备
        combat.ranmdequip();
        combat.ranmdommessage();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        combat.typeset();
        System.out.println("玩家获得优先权，由你先展开攻击");

        while (true) {
            int number1 = (int) (Math.random()*7+1);                      //定义随机数字1.角色随机语音包2.角色随机技能包3.角色随机装备包
            int number2 = (int) (Math.random()*2+1);
            int number3 = (int) (Math.random()*3+1);
            combat.typeset();
            System.out.println("请选择你的攻击方式：");
            combat.typeset();
            System.out.println("1.普通攻击");
            combat.typeset();
            System.out.println("2.使用技能");
            combat.typeset();
            System.out.println("3.穿戴装备");
            int num = input.nextInt();
//            if (num >= 1 && num <= 3) {
                switch (num) {
                    case 1:               //普通攻击的方法
                        Characters.typeset();
                        System.out.println("你对敌方英雄进行了一次普通攻击");
                        character1.attack(character2);
                        Characters.typeset();
                        int n = character1.getAttack()-character2.getArmature();
                        System.out.println("你对敌方单位造成了"+n+"点伤害");
                        break;
                    case 2:               //使用技能攻击的方法
                        Characters.typeset();
                        System.out.println(character1.getName()+"施展了");
                        Characters.typeset();
                        System.out.println(skills.get(number2));
                        character2.setHp(character2.getHp()+character2.getArmature()-skillnumber-character1.getAttack());
                        Characters.typeset();
                        int j = character1.getAttack()+4-character2.getArmature();
                        System.out.println("你对敌方单位造成了"+j+"点伤害");
                        break;
                    case 3:               //穿戴装备的攻击方法
                        Characters.typeset();
                        System.out.println("你的英雄暂时穿上了");
                        Characters.typeset();
                        System.out.println(equipments.get(number3));
                        character2.setHp(character2.getHp()+character2.getArmature()-skillnumber-character1.getAttack());
                        Characters.typeset();
                        int k = character1.getAttack()+4-character2.getArmature();
                        System.out.println("你对敌方单位造成了"+k+"点伤害");
                        break;
                    default:
                        combat.typeset();
                        System.out.println("亲爱的召唤师，请重新作出选择");
                        continue;

                }
                Characters.typeset();
                System.out.println(s.get(number1));                  //说出随机的语音
                character2.attack(character1);                      //电脑角色攻击玩家角色
                Characters.typeset();
                System.out.println("电脑也疯狂！QAQ");
                Characters.typeset();
                System.out.println("敌方单位对你造成了"+character2.getAttack()+"点伤害");
                combat.showmessage(character1,character2);               //打印战斗的结束的信息
                Characters.typeset();
                System.out.println("按任意键盘加回车继续。。。");
                if (character1.getHp() <= 0) {
                    combat.typeset();
                    System.out.println("你被电脑玩家打败了");
                    combat.typeset();
                    System.out.println("是否想要重生yes/no");
                    input.nextLine();                                 //清空缓存区，防止前面的输入造成干扰，从而影响判断结果
                    String s = input.nextLine();
                    if(s.equals("yes")){
                        character1.setHp(100);
                        Characters.typeset();
                        System.out.println("你已经站起来了，冲啊！");
                        continue;
                    }else if(s.equals("no")){
                        Characters.typeset();
                        System.out.println("gameover");
                        exit(0);
                    }else {
                        Characters.typeset();
                        System.out.println("请重新输入：");
                    }
                    return character2;
                } else if(character2.getHp()<=0) {
                    combat.typeset();
                    System.out.println("恭喜你击败了敌方角色");
                    return character1;
                }else {
                    combat.typeset();
                    System.out.println("经过激烈战斗，先冷静下，没有一方倒下战斗继续进行");
                    continue;
                }
//            } else {
//                combat.typeset();
//                System.out.println("亲爱的召唤师，请重新作出选择");
//                continue;
//            }
        }
    }
public static void showmessage(Characters character1,Characters character2){
        Characters.typeset();
        System.out.println("你的玩家信息\n"+character1);
        Characters.typeset();
        System.out.println("电脑的玩家信息\n"+character2);
}
    public static void typeset() {                 //排版的方法
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    }
    public static void ranmdskills(){

        String a = "r法突袭";
        String  b= "英雄的荣耀";
        String c = "穿心刺";
        skills.add(a);
        skills.add(b);
        skills.add(c);
    }
    public static void ranmdommessage() {                         //语音包类
        String a = "悠悠小贼吃俺一击！";
        String b = "无敌是多么的寂寞啊！";
        String c = "长路漫漫，惟剑做伴\n" +
                "\n" +
                string+"吾之荣耀，离别已久\n" +
                string+"宁日安在，无人能云\n" +
                string+"此剑之势，愈斩愈烈";
        String d = "我于杀戮之中盛放，亦如黎明中的花朵";
        String e = "死亡如风，常伴吾身\n" +
                string+ "长路漫漫，唯剑做伴\n" +
                string+ "吾虽浪迹天涯， 却未迷失本心";
        String f = "断剑重铸之日 骑士归来之时!";
        String  o= "如果暴力不是为了杀戮 那将毫无意义了";
        String g = "我的刀不会放弃对你们心脏的追求，最终它们会如愿以偿的";
        s.add(a);
        s.add(b);
        s.add(c);
        s.add(d);
        s.add(e);
        s.add(f);
        s.add(o);
        s.add(g);
    }
    public static void ranmdequip() {
        String a ="三圣之力";
        String  b="激光枪";
        String c="无尽之刃";
        String d ="鬼刀";
      equipments.add(a);
      equipments.add(b);
      equipments.add(c);
      equipments.add(d);
    }
    public static String string ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
}