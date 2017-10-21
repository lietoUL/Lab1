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
  private static Araph graph; //声明一个存储有向图的类的全局变量
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
  private static Stack<String> stack;               //声明一个栈，用来存储一个最短路径
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
  private static List<String> liste0 = new ArrayList<String>(); //声明集合类用来存储图片的命名
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
public static void createPicture(final String pictureName) {   //生成最短路径的函数
    // create colored Path Picture
    final GraphViz picr = new GraphViz("dot.exe");
    //Short_path tmpPath = spath.clone();
    Stack tmpPath;
    tmpPath = (Stack<String>) stack.clone(); //将栈完全赋予给tmpPath
    picr.clearTmpDotFile(pictureName + ".dot");
    //while (tmpPath != null) {
    picr.setColorForPath(tmpPath,
        GraphViz.color[count1 % GraphViz.color.length], pictureName + ".dot");
    count1++;                   //改变事物的颜色
    picr.runAfterSetColor(pictureName, pictureName + ".dot");  //最短路径有色图片的生成
  }
  /**
   * @author Song Hang
   * @author LuoWei
   * @throws IOException
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  public static void readfiles() throws IOException {           //读取文件函数
    final File file = new File(fileName);       //根据文件名建立相应的文件

      //System.out.println("以字符为单位读取文件内容，一次读一个字节：");
      final FileReader fileReaderme = new FileReader(file);    //建立文件的字符输入流
      String[] strarray = new String[SIZE];
      final List<String> list = new ArrayList<String>();    //集合类用来装顶点的
      Arrays.fill(strarray, "");
      char[] data = new char[SIZE];                    //字符数组装从文件中读取的字符
      Arrays.fill(data, ' ');
      int bics = 0;
      int rics;
      int cics = 0;
      while ((rics = fileReaderme.read()) != -1) {              //判断是否读取到最后
        if (Character.isLetter((char) rics)) {  //判断是否是26个英文呢字母以外的字符
          data[bics] = (char) rics;                    //强转为字符
          bics++;
        } else {
          if (Character.compare(data[0], ' ') != 0) {
            strarray[cics] = new String(data).trim(); //去掉字符数组两端的空格
            strarray[cics] = strarray[cics].toLowerCase(); //将数组内的字母全部最小化
            if (list.indexOf(strarray[cics]) == -1) {   //判断集合内是否有该字符
              list.add(strarray[cics]);
            }
            //System.out.println(strarray[cs].length());
            Arrays.fill(data, ' ');                //刷新字符数组
            cics++;
            bics = 0;
          }
        }
        //System.out.print((char)rs);
      }
      fileReaderme.close();
      final String[] str2 = list.toArray(new String[list.size()]); //将集合类转换为数组
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
      graph = new Araph(str2, strarray, cics); //存储进有向图的邻接矩阵中
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
	    //生成有向图的图片，并且存储进硬盘中
    String curWord = "";
    String word = null;
    //Node tmp_node=null;
    final GraphViz graphViz = new GraphViz("dot.exe");
    graphViz.start_graph();                  //.dot文件的开端
    for (int num = 0; num < newGraph.getNumVertex(); num++) {     //.dot内容撰写
      for (int num1 = 0; num1 < newGraph.getNumVertex(); num1++) {
        if (newGraph.getEdge(num, num1) != 0) {
          word = newGraph.getVertex(num);
          curWord = newGraph.getVertex(num1);
          graphViz.addln("\"" + word + "\"->\"" + curWord + "\"",
                  newGraph.getEdge(num, num1));
        }
      }
    }
    graphViz.end_graph();            //.dot文件的结尾

    graphViz.run();                  //运行这个类
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
    //用来作为返回值的字符串
    String tsstr;
    //用来做无桥接词时的字符串
    final List<Integer> list1 = new ArrayList<Integer>();
    final int rum1 = Arrays.binarySearch(graph.getVertexArray(), word1);
    //查找该字符串在数组内的下标值
    final int rum2 = Arrays.binarySearch(graph.getVertexArray(), word2);
    if (rum1 < 0 || rum2 < 0) {
      if (rum1 < 0 && rum2 < 0) {     //两个单词都不存在
        tsstr = "No \"" + word1 + "\" and \"" + word2 + "\" in the graph!";
        //return tsstr;
      } else if (rum1 < 0) {          //其中一个单词不存在
        tsstr = "No \"" + word1 + "\" in the graph!";
        //return tsstr;
      } else {
        tsstr = "No \"" + word2 + "\" in the graph!";
        //return tsstr;
      }
    } else {
      int zum = 0; //用来标记两个字符串之间是否存在桥接词
      for (int cum = 0; cum < graph.getNumVertex(); cum++) {
        if (graph.getEdge(rum1, cum) != 0 && graph.getEdge(cum, rum2) != 0) {
          zum  = zum + 1;
          list1.add(cum);     //添加进字符类中
        }
      }
      if (zum == 0) {
        tsstr = "No bridge words from \"" + word1 + "\" to \"" + word2 + "\"!";
        //return tsstr;
      } else {
        for (int zc = 0; zc < list1.size(); zc++) {
          final int tics = list1.get(zc);
          strle = graph.getVertex(tics);     //记录两个单词之间的桥接词，用于下一个生成新文本的函数
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
public static String generateNewText(final String rawInputText) { //生成新文本
    final String inputText = rawInputText + ' ';
    String opq;
    int zuc = 0;
    int zmc = 0;
    //zmc用来记录下一个单词的起始点，便于从字符和数组中取出合成一个字符串，zuc用来记录单词的长度
    final List<String> list2 = new ArrayList<String>();
    char[] exstr = new char[SIZE];
    final char[] exstr1 = new char[SIZE];
    Arrays.fill(exstr, ' ');
    Arrays.fill(exstr1, ' ');
    exstr = inputText.toCharArray();
    //System.out.println(inputText.length());
    for (int cus = 0; cus < inputText.length(); cus++) {
      if (!Character.isLetter(exstr[cus])) {
        //判断是否字符串内全部都是26个英文字母
        if (zuc == 0) {
          zmc = zmc + 1;
        } else {
          System.arraycopy(exstr, zmc, exstr1, 0, zuc);
          //赋值一定长度数组给另一个数组
          zmc = zmc + zuc + 1;
          //获取下一个数组的长度
          zuc = 0;
          list2.add(new String(exstr1).trim());
          //添加字符串进集合类当中去
          Arrays.fill(exstr1, ' ');
        }
      } else {
        zuc = zuc + 1;
      }
    }
    final String[] str3 = list2.toArray(new String[list2.size()]);
    //将集合类转换成数组
    final StringBuffer stresult = new StringBuffer(str3[0]);
    //System.out.println(list2.size());
    for (zuc = 0; zuc < list2.size() - 1; zuc++) {
      opq = queryBridgeWords(str3[zuc], str3[zuc + 1]);
      if (strle.equals("")) {      //不存在桥接词
        stresult.append(' ' + str3[zuc + 1]);
      } else {              //加入桥接词的情况
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
    //查找最短路径
    final Floyd fly = new Floyd(graph.getEdgeArray());
    final StringBuffer cureof = new StringBuffer(""); //最后返回最短路径的字符串
    final int row = Arrays.binarySearch(graph.getVertexArray(), word1);
    final int cro = Arrays.binarySearch(graph.getVertexArray(), word2);
    if (row < 0 || cro < 0) {           //单词不存在的情况
      if (row < 0 && cro < 0) {       //只有一个单词的存在的情况
        cureof.append("No" + "\"" + word1 + "\"" + "and\"" + word2 + "\"") ;
      } else if (row < 0) {
        cureof.append("No" + "\"" + word1);
      } else {
        cureof.append("No" + "\"" + word2);
      }
    } else {
      stack = new Stack();     //创立一个栈，用来存储最短路径
      stack.push(word1);
      fly.findCheapestPath(row, cro, graph.getEdgeArray());
      cureof.append(graph.getVertex(row) + "-->" +
          graph.getVertex(cro) + "的最短路径：");
      final List<Integer> listTemp = fly.getList(); //集合类用来存储最短路径上的单词在数组中的下标
      int index = listTemp.get(0);
      final String temp = graph.getVertex(index);
      cureof.append(temp);
      sureth = temp + "-"
        + graph.getVertex(listTemp.get(listTemp.size() - 1));
      if (fly.getDist(row, cro) == MAX) {
        cureof.delete(0, cureof.length());
        cureof.append("之间没有最短路径");
      } else {
        for (int cms = 1; cms < listTemp.size(); cms++) {
          cureof.append("->");
          cureof.append(graph.getVertex(listTemp.get(cms)));
          stack.add(graph.getVertex(listTemp.get(cms)));
        }
        liste0.add(sureth);
        createPicture(sureth);
        //cureof = cureof + '\n';
        cureof.append(" 路径长度：");
        cureof.append(fly.getDist(row, cro));
        /*System.out.println("的最短路径是：");
        System.out.print(listTemp.toString() + " ");
        System.out.println("路径长度:" + fly.getDist(row, cro));
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
    //输入一个单词时的最短路径
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
    //随机游走函数
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
      list0.clear();             //清空集合类内的内容
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
