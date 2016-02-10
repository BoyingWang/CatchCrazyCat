package com.example.by.catchcrazycat;

/**
 * @author: by
 * @time: 2016/2/10.12:34
 */
public class Dot {
    //记录每个场景中的元素它的X,Y坐标点的状态。并不会直接参与界面的响应和界面的绘制
    int x,y;//当前点的X，Y坐标
    int status;//记录这个点的状态
    //三个表征圆点状态静态常量
    public static final int STATUS_ON = 1;//已经开启路障的状态
    public static final int STATUS_OFF = 0;//代表灰色可走路径
    public static final int STATUS_IN = 2;//猫当前的位置
    //三个数字不同即可，具体用哪个数字无所谓

    //指定X，Y坐标
    public Dot(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        status = STATUS_OFF;//当前状态为STATUS_OFF
    }
    //指定geter和sette方法
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    //同时设置X，Y坐标的方法
    public void setXY(int x,int y) {
        this.y = y;
        this.x = x;
    }


}
