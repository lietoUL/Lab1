package guiex;

import java.util.*;
import java.lang.*;

public class AMWGraph {
	public String[] vertex;
	public int numvertex;//�洢��ĸ���
	public int[][] edges;//�ڽӾ��������洢��
	public int numOfEdges;//�ߵ���Ŀ

    public AMWGraph() {
    	
    }
    
    public AMWGraph(String[] array1,String[] array2,int n) {
        //��ʼ������һά���飬�ͱߵ���Ŀ
    	vertex=new String[array1.length];
    	//System.arraycopy(array1, 0, vertex, 0, array1.length);
        edges=new int[array1.length][array1.length];
        numOfEdges=0;
        numvertex=array1.length;
        for(int i=0;i<array1.length;i++) {
        	Arrays.fill(edges[i], 0);    //�������
        }
        Arrays.sort(array1);         //����������������ں��������ڵĲ���
        System.arraycopy(array1, 0, vertex, 0, array1.length);
        for(int i=0;i<n-1;i++) {
        	int x=Arrays.binarySearch(array1, array2[i]);  //�����������ڵ�λ��
        	int c=Arrays.binarySearch(array1, array2[i+1]);
        	//System.out.println(x);
        	//System.out.println(c);
        	edges[x][c]=edges[x][c]+1;    //�ı�Ȩֵ
        	numOfEdges++;
        }
    }
    
   
}
