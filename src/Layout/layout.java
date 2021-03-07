package Layout;

public class layout {                         //游戏图形界面设计



   public static void printfgamechaet() throws InterruptedException{                         //游戏开局界面设计
       System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t游戏加载中...请稍等");
       for (int i=0;i<40;i++){
           System.out.print(" ");
       }
       for(int i=0;i<100;i++){
           Thread.sleep(10);
           System.out.print("*");
       }
       System.out.println("\n\n\n\n");
       System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t亲爱的召唤师欢迎来到英雄联盟...");
       System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t我正在期待你的选择");
       System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1.开始游戏");
       System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2.游戏说明");
   }

}
