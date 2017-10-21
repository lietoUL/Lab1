package guiex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Song Hang
 * @author LuoWei
 */
public class TextClass {
  /**
  * @author Song Hang
  * @author LuoWei
  * @versionVersion 1.00
  * @versionVersion 2.00
  */
  private static final int MAX = Integer.MAX_VALUE;
  /**
 *
 */
private static final int SIZE = 128;
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static Araph graph; //����һ���洢����ͼ�����ȫ�ֱ���
/**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static String strle;
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static String sureth;
/**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static Stack<String> stack;               //����һ��ջ�������洢һ�����·��
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static String fileName = "";
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static List<String> liste0 = new ArrayList<String>(); //���������������洢ͼƬ������
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static int count1 = 0;

  /**
 * @param pictureName pic
 */
public static void createPicture(final String pictureName) {   //�������·���ĺ���
    // create colored Path Picture
    final GraphViz picr = new GraphViz("dot.exe");
    //Short_path tmpPath = spath.clone();
    Stack tmpPath;
    tmpPath = (Stack<String>) stack.clone(); //��ջ��ȫ�����tmpPath
    picr.clearTmpDotFile(pictureName + ".dot");
    //while (tmpPath != null) {
    picr.setColorForPath(tmpPath,
        GraphViz.color[count1 % GraphViz.color.length], pictureName + ".dot");
    count1++;                   //�ı��������ɫ
    picr.runAfterSetColor(pictureName, pictureName + ".dot");  //���·����ɫͼƬ������
  }
  /**
   * @author Song Hang
   * @author LuoWei
   * @throws IOException
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  public static void readfiles() throws IOException {           //��ȡ�ļ�����
    final File file = new File(fileName);       //�����ļ���������Ӧ���ļ�

      //System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
      final FileReader fileReaderme = new FileReader(file);    //�����ļ����ַ�������
      String[] strarray = new String[SIZE];
      final List<String> list = new ArrayList<String>();    //����������װ�����
      Arrays.fill(strarray, "");
      char[] data = new char[SIZE];                    //�ַ�����װ���ļ��ж�ȡ���ַ�
      Arrays.fill(data, ' ');
      int bics = 0;
      int rics;
      int cics = 0;
      while ((rics = fileReaderme.read()) != -1) {              //�ж��Ƿ��ȡ�����
        if (Character.isLetter((char) rics)) {  //�ж��Ƿ���26��Ӣ������ĸ������ַ�
          data[bics] = (char) rics;                    //ǿתΪ�ַ�
          bics++;
        } else {
          if (Character.compare(data[0], ' ') != 0) {
            strarray[cics] = new String(data).trim(); //ȥ���ַ��������˵Ŀո�
            strarray[cics] = strarray[cics].toLowerCase(); //�������ڵ���ĸȫ����С��
            if (list.indexOf(strarray[cics]) == -1) {   //�жϼ������Ƿ��и��ַ�
              list.add(strarray[cics]);
            }
            //System.out.println(strarray[cs].length());
            Arrays.fill(data, ' ');                //ˢ���ַ�����
            cics++;
            bics = 0;
          }
        }
        //System.out.print((char)rs);
      }
      fileReaderme.close();
      final String[] str2 = list.toArray(new String[list.size()]); //��������ת��Ϊ����
      /*for(String z:strarray) {
                    if(z != null) {
                        System.out.println(z);
                    }
                }*/
      //for (final String cstr:str2) {
        //System.out.println(cstr);
      //}
      //System.out.println(cs);
      //System.out.println(str2.length);
      graph = new Araph(str2, strarray, cics); //�洢������ͼ���ڽӾ�����
    //Araph graph = new Araph(str2,strarray,cs);
  }

  /**
 * @param newGraph show
 */
/**
 * @param newGraph
 * @throws IOException describe
 */
public static void showDirectedGraph(final Araph newGraph) throws IOException { 
	    //��������ͼ��ͼƬ�����Ҵ洢��Ӳ����
    String curWord = "";
    String word = null;
    //Node tmp_node=null;
    final GraphViz graphViz = new GraphViz("dot.exe");
    graphViz.start_graph();                  //.dot�ļ��Ŀ���
    for (int num = 0; num < newGraph.getNumVertex(); num++) {     //.dot����׫д
      for (int num1 = 0; num1 < newGraph.getNumVertex(); num1++) {
        if (newGraph.getEdge(num, num1) != 0) {
          word = newGraph.getVertex(num);
          curWord = newGraph.getVertex(num1);
          graphViz.addln("\"" + word + "\"->\"" + curWord + "\"",
                  newGraph.getEdge(num, num1));
        }
      }
    }
    graphViz.end_graph();            //.dot�ļ��Ľ�β

    graphViz.run();                  //���������
  }

  /**
 * @param word1 word 1
 * @param word2 word 2
 * @return String
 */
public static String queryBridgeWords(final String word1, final String word2) {
    final String strcct = "The bridge words from \"" + word1
            + "\" to " + word2 + " are:";
    final StringBuffer strbuffer = new StringBuffer(strcct);
    //������Ϊ����ֵ���ַ���
    String tsstr;
    //���������ŽӴ�ʱ���ַ���
    final List<Integer> list1 = new ArrayList<Integer>();
    final int rum1 = Arrays.binarySearch(graph.getVertexArray(), word1);
    //���Ҹ��ַ����������ڵ��±�ֵ
    final int rum2 = Arrays.binarySearch(graph.getVertexArray(), word2);
    if (rum1 < 0 || rum2 < 0) {
      if (rum1 < 0 && rum2 < 0) {     //�������ʶ�������
        tsstr = "No \"" + word1 + "\" and \"" + word2 + "\" in the graph!";
        //return tsstr;
      } else if (rum1 < 0) {          //����һ�����ʲ�����
        tsstr = "No \"" + word1 + "\" in the graph!";
        //return tsstr;
      } else {
        tsstr = "No \"" + word2 + "\" in the graph!";
        //return tsstr;
      }
    } else {
      int zum = 0; //������������ַ���֮���Ƿ�����ŽӴ�
      for (int cum = 0; cum < graph.getNumVertex(); cum++) {
        if (graph.getEdge(rum1, cum) != 0 && graph.getEdge(cum, rum2) != 0) {
          zum  = zum + 1;
          list1.add(cum);     //��ӽ��ַ�����
        }
      }
      if (zum == 0) {
        tsstr = "No bridge words from \"" + word1 + "\" to \"" + word2 + "\"!";
        //return tsstr;
      } else {
        for (int zc = 0; zc < list1.size(); zc++) {
          final int tics = list1.get(zc);
          strle = graph.getVertex(tics);     //��¼��������֮����ŽӴʣ�������һ���������ı��ĺ���
          strbuffer.append(graph.getVertex(tics));
          strbuffer.append('.');
        }
        zum = 0;
        tsstr = strbuffer.toString();
      }
    }
    return tsstr;
  }

  /**
 * @param rawInputText input
 * @return String
 */
public static String generateNewText(final String rawInputText) { //�������ı�
    final String inputText = rawInputText + ' ';
    String opq;
    int zuc = 0;
    int zmc = 0;
    //zmc������¼��һ�����ʵ���ʼ�㣬���ڴ��ַ���������ȡ���ϳ�һ���ַ�����zuc������¼���ʵĳ���
    final List<String> list2 = new ArrayList<String>();
    char[] exstr = new char[SIZE];
    final char[] exstr1 = new char[SIZE];
    Arrays.fill(exstr, ' ');
    Arrays.fill(exstr1, ' ');
    exstr = inputText.toCharArray();
    //System.out.println(inputText.length());
    for (int cus = 0; cus < inputText.length(); cus++) {
      if (!Character.isLetter(exstr[cus])) {
        //�ж��Ƿ��ַ�����ȫ������26��Ӣ����ĸ
        if (zuc == 0) {
          zmc = zmc + 1;
        } else {
          System.arraycopy(exstr, zmc, exstr1, 0, zuc);
          //��ֵһ�������������һ������
          zmc = zmc + zuc + 1;
          //��ȡ��һ������ĳ���
          zuc = 0;
          list2.add(new String(exstr1).trim());
          //����ַ����������൱��ȥ
          Arrays.fill(exstr1, ' ');
        }
      } else {
        zuc = zuc + 1;
      }
    }
    final String[] str3 = list2.toArray(new String[list2.size()]);
    //��������ת��������
    final StringBuffer stresult = new StringBuffer(str3[0]);
    //System.out.println(list2.size());
    for (zuc = 0; zuc < list2.size() - 1; zuc++) {
      opq = queryBridgeWords(str3[zuc], str3[zuc + 1]);
      if (strle.equals("")) {      //�������ŽӴ�
        stresult.append(' ' + str3[zuc + 1]);
      } else {              //�����ŽӴʵ����
        stresult.append(' ' + strle + ' ' + str3[zuc + 1]);
        strle = "";
      }
    }
    return stresult.toString();
  }

  /**
 * @param word1 word1
 * @param word2 word2
 * @return String
 */
public static String calcShortestPath(final String word1, final String word2) {
    //�������·��
    final Floyd fly = new Floyd(graph.getEdgeArray());
    final StringBuffer cureof = new StringBuffer(""); //��󷵻����·�����ַ���
    final int row = Arrays.binarySearch(graph.getVertexArray(), word1);
    final int cro = Arrays.binarySearch(graph.getVertexArray(), word2);
    if (row < 0 || cro < 0) {           //���ʲ����ڵ����
      if (row < 0 && cro < 0) {       //ֻ��һ�����ʵĴ��ڵ����
        cureof.append("No" + "\"" + word1 + "\"" + "and\"" + word2 + "\"") ;
      } else if (row < 0) {
        cureof.append("No" + "\"" + word1);
      } else {
        cureof.append("No" + "\"" + word2);
      }
    } else {
      stack = new Stack();     //����һ��ջ�������洢���·��
      stack.push(word1);
      fly.findCheapestPath(row, cro, graph.getEdgeArray());
      cureof.append(graph.getVertex(row) + "-->" +
          graph.getVertex(cro) + "�����·����");
      final List<Integer> listTemp = fly.getList(); //�����������洢���·���ϵĵ����������е��±�
      int index = listTemp.get(0);
      final String temp = graph.getVertex(index);
      cureof.append(temp);
      sureth = temp + "-"
        + graph.getVertex(listTemp.get(listTemp.size() - 1));
      if (fly.getDist(row, cro) == MAX) {
        cureof.delete(0, cureof.length());
        cureof.append("֮��û�����·��");
      } else {
        for (int cms = 1; cms < listTemp.size(); cms++) {
          cureof.append("->");
          cureof.append(graph.getVertex(listTemp.get(cms)));
          stack.add(graph.getVertex(listTemp.get(cms)));
        }
        liste0.add(sureth);
        createPicture(sureth);
        //cureof = cureof + '\n';
        cureof.append(" ·�����ȣ�");
        cureof.append(fly.getDist(row, cro));
        /*System.out.println("�����·���ǣ�");
        System.out.print(listTemp.toString() + " ");
        System.out.println("·������:" + fly.getDist(row, cro));
        System.out.println();*/
      }
    }
    return cureof.toString();
  }

  /**
 * @param word1 word
 * @return List<String>
 */
public static List<String> oneCalcShortestPath(final String word1) {
    //����һ������ʱ�����·��
    final List<String> list3 = new ArrayList<String>();
    //int m = Arrays.binarySearch(graph.vertex, word1);
    for (int cus = 0; cus < graph.getNumVertex(); cus++) {
      if (graph.getVertex(cus).equals(word1)) {
        final String zuli = calcShortestPath(word1, graph.getVertex(cus));
        list3.add(zuli);
      }
    }
    return list3;
  }

  /**
 * @return String
 */
public static String randomWalk() {
    //������ߺ���
    final StringBuffer random = new StringBuffer("");
    final String space = " ";
    final List<Integer> list0 = new ArrayList<Integer>();
    int[]arrty = new int[graph.getNumVertex()];
    int[][]stereArray = new int[graph.getNumVertex()][graph.getNumVertex()];
    Arrays.fill(arrty, 0);
    for (int zr = 0; zr < graph.getNumVertex(); zr++) {
      Arrays.fill(stereArray[zr], 0);
    }
    final int index = (int) (Math.random() * graph.getNumVertex());
    random.append(graph.getVertex(index));
    arrty[index] = 1;
    int cav = 0;
    int can = 0;
    int duo;
    duo = index;
    while (cav != 1 && can != 1) {
      int tuo;
      list0.clear();             //��ռ������ڵ�����
      for (tuo = 0; tuo < graph.getNumVertex(); tuo++) {
        if (graph.getEdge(duo, tuo) != 0) {
          list0.add(tuo);
        }
      }
      if (list0.isEmpty()) {
        can = 1;
      } else {
        final int index1 = (int) (Math.random() * list0.size());
        if (stereArray[duo][index1] == 1) {
          cav = 1;
        } else {
          stereArray[duo][list0.get(index1)] = 1;
          random.append(space);
          random.append(graph.getVertex(list0.get(index1)));
          duo = list0.get(index1);
        }
      }
    }
    return random.toString();
  }

/**
 * @return string
 */
public static String getSureth() {
    return sureth;
}
/**
 * @param newsureth n
 */
public static void setSureth(final String newsureth) {
    TextClass.sureth = newsureth;
}
/**
 * @return string
 */
public static String getFileName() {
    return fileName;
}
/**
 * @param newfileName n
 */
public static void setFileName(final String newfileName) {
    TextClass.fileName = newfileName;
}
/**
 * @return list
 */
public static List<String> getListe0() {
    return liste0;
}
/**
 * @param newliste0 n
 */
public static void setListe0(final List<String> newliste0) {
    TextClass.liste0 = newliste0;
}
/**
 * @return a
 */
public Araph getGraph() {
    return graph;
}
/**
 * @param ngraph g
 */
public static void setGraph(final Araph ngraph) {
    TextClass.graph = ngraph;
}
}
