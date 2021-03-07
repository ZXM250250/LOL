package reflection;
import characters.Characters;
import characters.fieldmonster;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class reflections {                                      //查看敌方单位的位置信息
    public void show(List list){
        Characters.typeset();
        System.out.println("是否查看敌方角色的位置yes/no");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s.equals("yes")) {
            try {
                Class monster = Class.forName("characters.fieldmonster");
                Class Heros = Class.forName("characters.Characters");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof Characters) {
                        Field x = Heros.getDeclaredField("x");
                        Field y = Heros.getDeclaredField("y");
                        Field name = Heros.getDeclaredField("name");
                        x.setAccessible(true);
                        y.setAccessible(true);
                        name.setAccessible(true);
                        Characters.typeset();
                        System.out.println(name.get(list.get(i)) + "x:" + x.get(list.get(i)) + "\ty:" + y.get(list.get(i)));
                    } else if (list.get(i) instanceof fieldmonster) {
                        Field x = monster.getField("x");
                        Field y = monster.getField("y");
                        Field name = monster.getField("name");
                        Characters.typeset();
                        System.out.println(name.get(list.get(i)) + "x:" + x.get(list.get(i)) + "\ty:" + y.get(list.get(i)));
                    }
                }
            } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
