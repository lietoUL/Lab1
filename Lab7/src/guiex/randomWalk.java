package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class randomWalk {
    private static int max=Integer.MAX_VALUE;        //���������ֵ
    public static AMWGraph graph ;                   //����һ���洢����ͼ�����ȫ�ֱ���
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //����һ��ջ�������洢һ�����·��
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//����һ�������������洢ͼƬ������
    public static int i = 0;
    
    public static String randomWalk() {
        //������ߺ���
        String random = "";
        int cav = 0 , can = 0 , duo;
        ArrayList<Integer>list0 = new ArrayList<Integer>();
        int []arrty = new int[graph.numvertex];
        int [][]Sterearray = new int[graph.numvertex][graph.numvertex];
        Arrays.fill(arrty, 0);
        for(int zr = 0;zr<graph.numvertex;zr++) {
            Arrays.fill(Sterearray[zr], 0);
        }
        int index = (int) (Math.random() * graph.numvertex);
        random = graph.vertex[index];
        arrty[index] = 1;
        duo = index;
        while(cav!=1 && can!=1) {
            int tuo ;
            list0.clear();             //��ռ������ڵ�����
            for(tuo = 0;tuo < graph.numvertex;tuo++) {
                if(graph.edges[duo][tuo]!=0) {
                    list0.add(tuo);
                }
            }
            if(list0.size()==0) {
                can = 1;
            }
            else {
                int index1 = (int) (Math.random() * list0.size());
                if(Sterearray[duo][index1]==1) {
                    cav = 1;
                }
                else {
                    Sterearray[duo][list0.get(index1)]=1;
                    random = random + " " + graph.vertex[list0.get(index1)];
                    duo = list0.get(index1);
                }
            }
        }
        return random;
    }

}
