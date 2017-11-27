package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class generateNewText {
    private static int max=Integer.MAX_VALUE;        //整数的最大值
    public static AMWGraph graph ;                   //声明一个存储有向图的类的全局变量
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //声明一个栈，用来存储一个最短路径
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//声明一个集合类用来存储图片的命名
    public static int i = 0;
    
    public static String generateNewText(String inputText) {    //生成新文本
        inputText = inputText + ' ';
        String stresult = new String();
        String opq;
        int zuc = 0 , zmc = 0;            
        //zmc用来记录下一个单词的起始点，便于从字符和数组中取出合成一个字符串，zuc用来记录单词的长度
        List<String>list2 = new ArrayList<String>();
        char[] exstr = new char[128];
        char[] exstr1 = new char[128];
        Arrays.fill(exstr, ' ');
        Arrays.fill(exstr1, ' ');
        exstr = inputText.toCharArray();
        //System.out.println(inputText.length());
        for(int cus = 0;cus < inputText.length(); cus++) {
            if(Character.isLetter(exstr[cus])==false) {
                //判断是否字符串内全部都是26个英文字母
                if(zuc!=0) {
                    System.arraycopy(exstr, zmc , exstr1, 0, zuc);
                    //赋值一定长度数组给另一个数组
                    zmc = zmc + zuc + 1;
                    //获取下一个数组的长度
                    zuc = 0;
                    list2.add(new String(exstr1).trim());
                    //添加字符串进集合类当中去
                    Arrays.fill(exstr1, ' ');
                }
                else {
                    zmc = zmc +1;
                }
            }
            else {
                zuc = zuc + 1;
            }
        }
        String[] str3 = list2.toArray(new String[list2.size()]);
        //将集合类转换成数组
        stresult = str3[0];
        //System.out.println(list2.size());
        for(zuc = 0;zuc<list2.size()-1;zuc++) {
            opq = queryBridgeWords(str3[zuc],str3[zuc+1]);
            if(strle==null) {      //不存在桥接词
                stresult = stresult+' '+str3[zuc+1];
            }
            else {              //加入桥接词的情况
                stresult = stresult+' '+strle+' '+str3[zuc+1];
                strle = null;
            }
        }
        return stresult;
    }

}
