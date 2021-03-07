package Execute;

public class abnormal extends Exception {                    //自定游戏义异常类，时间不够，未能在程序当中运用


    public abnormal(String message) {
        super("英雄手太短，不能打到地方英雄哦");
    }
}
