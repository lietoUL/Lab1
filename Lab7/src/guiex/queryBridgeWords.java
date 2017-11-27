package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class queryBridgeWords {
    private static int max=Integer.MAX_VALUE;        //���������ֵ
    public static AMWGraph graph ;                   //����һ���洢����ͼ�����ȫ�ֱ���
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //����һ��ջ�������洢һ�����·��
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//����һ�������������洢ͼƬ������
    public static int i = 0;
    
    public static String queryBridgeWords(String word1, String word2) {     //�����ŽӴ�
        String strcct = "The bridge words from \""+word1+"\" to "+word2+" are:";
        //������Ϊ����ֵ���ַ���
        String tsstr;
        //���������ŽӴ�ʱ���ַ���
        List<Integer> list1 = new ArrayList<Integer>();
        int rum1 = Arrays.binarySearch(graph.vertex, word1);
        //���Ҹ��ַ����������ڵ��±�ֵ
        int rum2 = Arrays.binarySearch(graph.vertex, word2);
        if(rum1 < 0||rum2 < 0) {
            if(rum1 < 0&&rum2 < 0) {     //�������ʶ�������
                tsstr = "No \""+word1+"\" and \""+word2+"\" in the graph!";
                return tsstr;
            }
            else if(rum1<0) {          //����һ�����ʲ�����
                tsstr = "No \""+word1+"\" in the graph!";
                return tsstr;
            }
            else {
                tsstr = "No \""+word2+"\" in the graph!";
                return tsstr;
            }
        }
        else {
            int zum=0;            //������������ַ���֮���Ƿ�����ŽӴ�
            for(int cum = 0;cum<graph.numvertex;cum++) {
                if(graph.edges[rum1][cum]!=0&&graph.edges[cum][rum2]!=0) {
                    zum  = zum + 1;
                    list1.add(cum);     //��ӽ��ַ�����
                }
            }
            if(zum==0) {
                tsstr = "No bridge words from \""+word1+"\" to \""+word2+"\"!";
                return tsstr;
            }
            else {
                for(int zc = 0;zc<list1.size();zc++) {
                    int ts = list1.get(zc);
                    strle = graph.vertex[ts];     //��¼��������֮����ŽӴʣ�������һ���������ı��ĺ���
                    strcct = strcct + graph.vertex[ts] + '.';
                }
                zum = 0;
                return strcct;
            }
        }
    }

}
