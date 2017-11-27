package guiex;

import java.util.*;

public class Floyd {
	 /*
	  * ����һ������n������Ĵ�Ȩ����ͼ��Ҫ����ÿһ�Զ���֮������·����
	  * ������÷�������(Floyd)���·���㷨��
	  */

	 private static int max=Integer.MAX_VALUE;
	 public static int [][]dist;          //�洢���·���ĳ���
	 public static int [][]path;          //�洢���·�����м��
	 public static ArrayList list=new ArrayList<Integer>();
	 
	 public Floyd(int Arrey[][]) {        //��ʼ����ά����
		 int amn = Arrey.length;
		 dist = new int[amn][amn];
		 path = new int[amn][amn];
	 }

	 public void findCheapestPath(int begin,int end,int Arcs[][]){   //Ѱ�����·��
	  floyd(Arcs);
	  list.clear();
	  list.add(begin);
	  findPath(begin,end);
	  list.add(end);
	 }

	 public void findPath(int i,int j){           //Ѱ������֮���Ƿ�����м��
	  int k=path[i][j];
	  if(k==-1)
	   return ;
	  findPath(i,k);
	  list.add(k);                        //���м����ӵ��������У��������
	  findPath(k,j);
	 }
	 public void floyd(int [][] Arcs){    //Floyd�㷨
	  int n=Arcs.length;
	  for(int i=0;i<n;i++) {
	   for(int j=0;j<n;j++){
	    path[i][j]=-1;                 //��ʼ����ǰ��·���м���
	    if(Arcs[i][j]!=0) {
	            dist[i][j]=Arcs[i][j];         //��ʼ����ǰ��·�����ȱ�
	    }
	    else {
	    	dist[i][j]=max;
	    }
	   }
	  }

	  for(int k=0;k<n;k++)
	   for(int i=0;i<n;i++)
	    for(int j=0;j<n;j++){
	    if(dist[i][k]!=max && dist[k][j]!=max && dist[i][k]+dist[k][j]<=dist[i][j]){
	     dist[i][j]=dist[i][k]+dist[k][j];
	     path[i][j]=k;
	    }
	   }
	 }
}