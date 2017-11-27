package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class queryBridgeWords {
    private static int max=Integer.MAX_VALUE;        //整数的最大值
    public static AMWGraph graph ;                   //声明一个存储有向图的类的全局变量
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //声明一个栈，用来存储一个最短路径
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//声明一个集合类用来存储图片的命名
    public static int i = 0;
    
    public static String queryBridgeWords(String word1, String word2) {     //查找桥接词
        String strcct = "The bridge words from \""+word1+"\" to "+word2+" are:";
        //用来作为返回值的字符串
        String tsstr;
        //用来做无桥接词时的字符串
        List<Integer> list1 = new ArrayList<Integer>();
        int rum1 = Arrays.binarySearch(graph.vertex, word1);
        //查找该字符串在数组内的下标值
        int rum2 = Arrays.binarySearch(graph.vertex, word2);
        if(rum1 < 0||rum2 < 0) {
            if(rum1 < 0&&rum2 < 0) {     //两个单词都不存在
                tsstr = "No \""+word1+"\" and \""+word2+"\" in the graph!";
                return tsstr;
            }
            else if(rum1<0) {          //其中一个单词不存在
                tsstr = "No \""+word1+"\" in the graph!";
                return tsstr;
            }
            else {
                tsstr = "No \""+word2+"\" in the graph!";
                return tsstr;
            }
        }
        else {
            int zum=0;            //用来标记两个字符串之间是否存在桥接词
            for(int cum = 0;cum<graph.numvertex;cum++) {
                if(graph.edges[rum1][cum]!=0&&graph.edges[cum][rum2]!=0) {
                    zum  = zum + 1;
                    list1.add(cum);     //添加进字符类中
                }
            }
            if(zum==0) {
                tsstr = "No bridge words from \""+word1+"\" to \""+word2+"\"!";
                return tsstr;
            }
            else {
                for(int zc = 0;zc<list1.size();zc++) {
                    int ts = list1.get(zc);
                    strle = graph.vertex[ts];     //记录两个单词之间的桥接词，用于下一个生成新文本的函数
                    strcct = strcct + graph.vertex[ts] + '.';
                }
                zum = 0;
                return strcct;
            }
        }
    }

}
