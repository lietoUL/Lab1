package guiex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class generateNewText {
    private static int max=Integer.MAX_VALUE;        //���������ֵ
    public static AMWGraph graph ;                   //����һ���洢����ͼ�����ȫ�ֱ���
    public static String strle;
    public static String sureth;
    public static Stack <String>stack;               //����һ��ջ�������洢һ�����·��
    public static String fileName = new String();
    public static List<String> liste0 = new ArrayList<String>();//����һ�������������洢ͼƬ������
    public static int i = 0;
    
    public static String generateNewText(String inputText) {    //�������ı�
        inputText = inputText + ' ';
        String stresult = new String();
        String opq;
        int zuc = 0 , zmc = 0;            
        //zmc������¼��һ�����ʵ���ʼ�㣬���ڴ��ַ���������ȡ���ϳ�һ���ַ�����zuc������¼���ʵĳ���
        List<String>list2 = new ArrayList<String>();
        char[] exstr = new char[128];
        char[] exstr1 = new char[128];
        Arrays.fill(exstr, ' ');
        Arrays.fill(exstr1, ' ');
        exstr = inputText.toCharArray();
        //System.out.println(inputText.length());
        for(int cus = 0;cus < inputText.length(); cus++) {
            if(Character.isLetter(exstr[cus])==false) {
                //�ж��Ƿ��ַ�����ȫ������26��Ӣ����ĸ
                if(zuc!=0) {
                    System.arraycopy(exstr, zmc , exstr1, 0, zuc);
                    //��ֵһ�������������һ������
                    zmc = zmc + zuc + 1;
                    //��ȡ��һ������ĳ���
                    zuc = 0;
                    list2.add(new String(exstr1).trim());
                    //����ַ����������൱��ȥ
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
        //��������ת��������
        stresult = str3[0];
        //System.out.println(list2.size());
        for(zuc = 0;zuc<list2.size()-1;zuc++) {
            opq = queryBridgeWords(str3[zuc],str3[zuc+1]);
            if(strle==null) {      //�������ŽӴ�
                stresult = stresult+' '+str3[zuc+1];
            }
            else {              //�����ŽӴʵ����
                stresult = stresult+' '+strle+' '+str3[zuc+1];
                strle = null;
            }
        }
        return stresult;
    }

}
