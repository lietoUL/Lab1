package guiex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CreatPicture {
    private static int max=Integer.MAX_VALUE;        //整数的最大值
    public static AMWGraph graph ;                   //声明一个存储有向图的类的全局变量
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //声明一个栈，用来存储一个最短路径
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//声明一个集合类用来存储图片的命名
    public static int i = 0;
    
    public static void CreatePicture(String pictureName) {   //生成最短路径的函数
        // create colored Path Picture
        GraphViz pr = new GraphViz("dot.exe");
        //Short_path tmpPath = spath.clone();
        Stack tmpPath;
        tmpPath = (Stack<String>)stack.clone();         //将栈完全赋予给tmpPath 
        //int i = 0;
        pr.clearTmpDotFile( pictureName + ".dot");//
        //while (tmpPath != null) {
            pr.setColorForPath(tmpPath,
                    GraphViz.color[i % GraphViz.color.length], pictureName + ".dot");
            i++;                   //改变事物的颜色
            //tmpPath = tmpPath.next;
        //}
        pr.runAfterSetColor(pictureName, pictureName + ".dot");  //最短路径有色图片的生成
    }

}
