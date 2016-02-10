package com.example.by.catchcrazycat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * @author: by
 * @time: 2016/2/10.12:35
 */
public class Playground extends SurfaceView implements View.OnTouchListener{
    private SurfaceHolder.Callback callback;
    private Dot matrix[][];//声明二维数组来存放点元素
    private Dot cat;//声明猫这个点
    private static  int WIDTH = 40;//元素的
    private static final int ROW = 10;//行高：每行储存10个元素
    private static final int COL = 10;//列宽：每列储存10个元素
    private static final int BLOCKS = 15;//默认添加的路障数量
    public Playground(Context context) {
        super(context);
        getHolder().addCallback(callback);//将Callback对象指定给getholder
        matrix = new Dot[ROW][COL];//将行高，列宽传递进去，指定数组大小
        for (int i = 0; i < ROW; i++) {//循环添加数据
            for (int j = 0; j < COL; j++) {
                matrix[i][j] = new Dot(j, i);/*X，Y坐标值和行列值是相反的。
				即通过查找列值获得X坐标，查找行值获得Y坐标*/
            }
        }
        setOnTouchListener(this);//设定为自己的触摸监听器
        initGame();//调用游戏初始化
    }

    private void initGame() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                matrix[i][j].setStatus(Dot.STATUS_OFF);
            }
        }
        cat = new Dot(4, 5);//设置猫的起始点
        getDot(4, 5).setStatus(Dot.STATUS_IN);//把猫的起始点的状态设置为STATUS_IN，才能记录猫的位置
        //用for循环随机的指定10个点的坐标作为路障
        for (int i = 0; i < BLOCKS;) {
            int x = (int) ((Math.random()*1000)%COL);
            int y = (int) ((Math.random()*1000)%ROW);//随机获取1对坐标点
            if (getDot(x, y).getStatus() == Dot.STATUS_OFF) {//对当前可用路径点进行选择
                getDot(x, y).setStatus(Dot.STATUS_ON);//并把这个点设置为路障
                i++;//循环内自加避免当前路障被重复添加
                //System.out.println("Block:"+i);
            }
        }
    }

    private Dot getDot(int x,int y) {
        return matrix[y][x];
    }

    public Playground(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Playground(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void myDraw(Canvas canvas){

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
