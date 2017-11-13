package guiex;

import java.io.*;
import java.lang.*;
import java.util.*;

public class text {
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
	
	public static void readfiles() {           //��ȡ�ļ�����
		//InputStreamReader rin = new InputStreamReader(System.in);     //��ÿ���̨��������
		//System.out.println("��������Ҫ�������ļ�·����");
		//String fileName = new String();//����һ���ַ���
		//Scanner scr = new Scanner(System.in);
		//fileName = scr.nextLine();
		/*try {
			char[] cs = new char[50];
			rin.read(cs);                                             //����������ȡ���ݵ��ֽ�����
		    fileName = new String(cs).trim();
			rin.close();
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		//String fileName = "D:/workspace/test.txt/";
		//System.out.println(fileName);
		File file = new File(fileName);       //�����ļ���������Ӧ���ļ�
		
		
		//AMWGraph graph = new AMWGraph();
		try {
			//System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
			FileReader fReader = new FileReader(file);    //�����ļ����ַ�������
			String[] strarray = new String[128];
			List<String> list = new ArrayList<String>();    //����������װ�����
			Arrays.fill(strarray,"");
			char[] data = new char[128];                    //�ַ�����װ���ļ��ж�ȡ���ַ�
			Arrays.fill(data, ' ');
			int rs = 0 , bs = 0 , cs = 0;
			while((rs=fReader.read()) != -1) {              //�ж��Ƿ��ȡ�����
				if(Character.isLetter((char)rs) == true) {  //�ж��Ƿ���26��Ӣ������ĸ������ַ�
					data[bs] = (char)rs;                    //ǿתΪ�ַ�
					bs = bs + 1;
				}
				else {
					if(data[0]!=' ') {
						strarray[cs] = new String(data).trim();//ȥ���ַ��������˵Ŀո�
						strarray[cs] = strarray[cs].toLowerCase();//�������ڵ���ĸȫ����С��
						if(list.indexOf(strarray[cs])==-1) {   //�жϼ������Ƿ��и��ַ�
							list.add(strarray[cs]);
						}
						//System.out.println(strarray[cs].length());
						Arrays.fill(data, ' ');                //ˢ���ַ�����
						cs = cs + 1;
						bs = 0;
					}
				}
				//System.out.print((char)rs);
				}fReader.close();
				String[] str2 = list.toArray(new String[list.size()]);//��������ת��Ϊ����
				/*for(String z:strarray) {
					if(z != null) {
						System.out.println(z);
					}
				}*/
				for(String c:str2) {
					System.out.println(c);
				}
				//System.out.println(cs);
				System.out.println(str2.length);
				graph = new AMWGraph(str2,strarray,cs);     //�洢������ͼ���ڽӾ�����
			}catch (Exception e){
				e.printStackTrace();
		}
		//AMWGraph graph = new AMWGraph(str2,strarray,cs);
	}
	
	public static void showDirectedGraph(AMWGraph G) {    //��������ͼ��ͼƬ�����Ҵ洢��Ӳ����
		String cur_word=null;
		String word=null;
		//Node tmp_node=null;
		GraphViz gViz = new GraphViz("dot.exe");
		gViz.start_graph();                  //.dot�ļ��Ŀ���
		for(int num = 0;num < G.numvertex;num ++) {     //.dot����׫д
			for(int num1 = 0;num1 < G.numvertex;num1 ++) {
				if(G.edges[num][num1]!=0) {
					word = G.vertex[num];
					cur_word = G.vertex[num1];
					gViz.addln("\"" + word + "\"->\"" + cur_word + "\"",
							G.edges[num][num1]);
				}
			}
		}
		/*for (String word : G.keySet()) {
			tmp_node=G.get(word).links;
			while (tmp_node != null) {
				cur_word = tmp_node.link_vertex.word;
				gViz.addln("\"" + word + "\"->\"" + cur_word + "\"",
						tmp_node.weight);
				tmp_node = tmp_node.next;
			}
		}*/
		gViz.end_graph();            //.dot�ļ��Ľ�β
		try {
		gViz.run();                  //���������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	
	public static ArrayList<String> OnecalcShortestPath(String word1) {
		//����һ������ʱ�����·��
		ArrayList<String>list3 =new ArrayList<String>(); 
		int m = Arrays.binarySearch(graph.vertex, word1);
		for(int cus = 0;cus < graph.numvertex;cus++) {
			if(graph.vertex[cus]!=word1) {
				String zuli = calcShortestPath(word1,graph.vertex[cus]);
				list3.add(zuli);
			}
		}
		return list3;
	}
	
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
