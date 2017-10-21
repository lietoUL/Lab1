package guiex;

import java.util.Arrays;
 /**
 * @author Song Hang
 * @author LuoWei
 */
/**
 * @author leno
 *
 */
public class Araph {
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient String[] vertex;
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient int numVertex; //�洢��ĸ���
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient int[][] edges;
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient int numOfEdges; //�ߵ���Ŀ

  /**
 * @param array1 array1
 * @param array2 array2
 * @param size size
 */
 public Araph(final String[] array1, final String[] array2, final int size) {
    //��ʼ������һά���飬�ͱߵ���Ŀ
    vertex = new String[array1.length];
    //System.arraycopy(array1, 0, vertex, 0, array1.length);
    edges = new int[array1.length][array1.length];
    numOfEdges = 0;
    setNumVertex(array1.length);
    for (int i = 0; i < array1.length; i++) {
      Arrays.fill(edges[i], 0);  //�������
    }
    Arrays.sort(array1);     //����������������ں��������ڵĲ���
    System.arraycopy(array1, 0, vertex, 0, array1.length);
    for (int i = 0; i < size - 1; i++) {
      final int row = Arrays.binarySearch(array1, array2[i]);  //�����������ڵ�λ��
      final int cro = Arrays.binarySearch(array1, array2[i + 1]);
      //System.out.println(x);
      //System.out.println(c);
      edges[row][cro] = edges[row][cro] + 1;  //�ı�Ȩֵ
      numOfEdges++;
    }
  }

/**
 * @return num
 */
public int getNumVertex() {
    return numVertex;
}

/**
 * @param newNumVertex num
 */
public void setNumVertex(final int newNumVertex) {
    this.numVertex = newNumVertex;
}

/**
 * @return integer
 */
public int getNumOfEdges() {
    return numOfEdges;
}

/**
 * @param newNumOfEdges integer
 */
public void setNumOfEdges(final int newNumOfEdges) {
    this.numOfEdges = newNumOfEdges;
}
/**
 * @param index index
 * @return Srtring
 */
public String getVertex(final int index) {
    return this.vertex[index];
}

/**
 * @param index index
 * @param str str
 */
public void setVertex(final int index, final String str) {
    this.vertex[index] = str;
}
/**
 * @param index1 row
 * @param index2 cro
 * @return integer
 */
public int getEdge(final int index1, final int index2) {
    return this.edges[index1][index2];
}

/**
 * @param index1 row
 * @param index2 cro
 * @param num number
 */
public void setEdge(final int index1, final int index2, final int num) {
    this.edges[index1][index2] = num;
}

/**
 * @return vertex
 */
public String[] getVertexArray() {
    return this.vertex;
}

/**
 * @return edges
 */
public int[][] getEdgeArray() {
    return this.edges;
}
}
