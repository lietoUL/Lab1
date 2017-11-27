package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class calcShortestPath {
    private static int max=Integer.MAX_VALUE;        //整数的最大值
    public static AMWGraph graph ;                   //声明一个存储有向图的类的全局变量
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //声明一个栈，用来存储一个最短路径
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//声明一个集合类用来存储图片的命名
    public static int i = 0;
    
    public static String calcShortestPath(String word1, String word2) {
        //查找最短路径
        Floyd f = new Floyd(graph.edges);
        String cureof ;          //最后返回最短路径的字符串
        int i = Arrays.binarySearch(graph.vertex, word1);
        int j = Arrays.binarySearch(graph.vertex, word2);
        if(i<0||j<0) {           //单词不存在的情况
            if(i<0&&j<0) {       //只有一个单词的存在的情况
                cureof = "No" + "\"" + word1 + "\"" + "and\"" + word2 +"\"";
            }
            else if(i<0) {
                cureof = "No" + "\"" + word1;
            }
            else {
                cureof = "No" + "\"" + word2;
            }
        }
        else {
            stack =new Stack();     //创立一个栈，用来存储最短路径
            stack.push(word1);
            f.findCheapestPath(i, j, graph.edges);
            /*for(int n = 0;n<10;n++) {
                for(int m = 0;m<10;m++) {
                    System.out.print(f.dist[n][m]+":");
                    System.out.print(f.path[n][m]+":");
                }
                System.out.println();
            }*/
            cureof = graph.vertex[i]+"-->"+graph.vertex[j]+"的最短路径：";
            ArrayList<Integer>L=f.list;    //集合类用来存储最短路径上的单词在数组中的下标
            cureof = cureof + graph.vertex[L.get(0)];
            sureth = graph.vertex[L.get(0)] + "-" + graph.vertex[L.get(L.size() - 1)];
            System.out.print(graph.vertex[i]+"-->"+graph.vertex[j]+":");
            if(f.dist[i][j]==max){
                cureof = "之间没有最短路径";
             System.out.println("之间没有最短路径");
            System.out.println();
            }
            else{
                for(int cms = 1;cms < L.size(); cms++) {
                    cureof = cureof + "->" + graph.vertex[L.get(cms)];
                    stack.add(graph.vertex[L.get(cms)]);
                }
                liste0.add(sureth);
                CreatePicture(sureth);
                //cureof = cureof + '\n';
                cureof = cureof + " 路径长度：" + f.dist[i][j];
             System.out.println("的最短路径是：");
             System.out.print(L.toString()+" ");
             System.out.println("路径长度:"+f.dist[i][j]);
             System.out.println();              
           }
        }
    return cureof;
    }

}
