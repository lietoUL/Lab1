package guiex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CreatPicture {
    private static int max=Integer.MAX_VALUE;        //���������ֵ
    public static AMWGraph graph ;                   //����һ���洢����ͼ�����ȫ�ֱ���
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //����һ��ջ�������洢һ�����·��
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//����һ�������������洢ͼƬ������
    public static int i = 0;
    
    public static void CreatePicture(String pictureName) {   //�������·���ĺ���
        // create colored Path Picture
        GraphViz pr = new GraphViz("dot.exe");
        //Short_path tmpPath = spath.clone();
        Stack tmpPath;
        tmpPath = (Stack<String>)stack.clone();         //��ջ��ȫ�����tmpPath 
        //int i = 0;
        pr.clearTmpDotFile( pictureName + ".dot");//
        //while (tmpPath != null) {
            pr.setColorForPath(tmpPath,
                    GraphViz.color[i % GraphViz.color.length], pictureName + ".dot");
            i++;                   //�ı��������ɫ
            //tmpPath = tmpPath.next;
        //}
        pr.runAfterSetColor(pictureName, pictureName + ".dot");  //���·����ɫͼƬ������
    }

}
