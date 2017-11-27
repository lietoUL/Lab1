package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class calcShortestPath {
    private static int max=Integer.MAX_VALUE;        //���������ֵ
    public static AMWGraph graph ;                   //����һ���洢����ͼ�����ȫ�ֱ���
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //����һ��ջ�������洢һ�����·��
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//����һ�������������洢ͼƬ������
    public static int i = 0;
    
    public static String calcShortestPath(String word1, String word2) {
        //�������·��
        Floyd f = new Floyd(graph.edges);
        String cureof ;          //��󷵻����·�����ַ���
        int i = Arrays.binarySearch(graph.vertex, word1);
        int j = Arrays.binarySearch(graph.vertex, word2);
        if(i<0||j<0) {           //���ʲ����ڵ����
            if(i<0&&j<0) {       //ֻ��һ�����ʵĴ��ڵ����
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
            stack =new Stack();     //����һ��ջ�������洢���·��
            stack.push(word1);
            f.findCheapestPath(i, j, graph.edges);
            /*for(int n = 0;n<10;n++) {
                for(int m = 0;m<10;m++) {
                    System.out.print(f.dist[n][m]+":");
                    System.out.print(f.path[n][m]+":");
                }
                System.out.println();
            }*/
            cureof = graph.vertex[i]+"-->"+graph.vertex[j]+"�����·����";
            ArrayList<Integer>L=f.list;    //�����������洢���·���ϵĵ����������е��±�
            cureof = cureof + graph.vertex[L.get(0)];
            sureth = graph.vertex[L.get(0)] + "-" + graph.vertex[L.get(L.size() - 1)];
            System.out.print(graph.vertex[i]+"-->"+graph.vertex[j]+":");
            if(f.dist[i][j]==max){
                cureof = "֮��û�����·��";
             System.out.println("֮��û�����·��");
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
                cureof = cureof + " ·�����ȣ�" + f.dist[i][j];
             System.out.println("�����·���ǣ�");
             System.out.print(L.toString()+" ");
             System.out.println("·������:"+f.dist[i][j]);
             System.out.println();              
           }
        }
    return cureof;
    }

}
