package guiex;

import java.util.ArrayList;

/**
 * @author Song Hang
 * @author LuoWei
 */
public class Floyd {
  /**
  * @author Song Hang
  * @author LuoWei
  * @versionVersion 1.00
  * @versionVersion 2.00
  */
  private static final int MAX = Integer.MAX_VALUE;
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient int[][]dist;  //�洢���·���ĳ���
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private transient int[][]path; //�洢���·�����м��
  /**
   * @author Song Hang
   * @author LuoWei
   * @versionVersion 1.00
   * @versionVersion 2.00
   */
  private static ArrayList list = new ArrayList<Integer>();

  /**
 * @param array array
 */
public Floyd(final int[][]array) {  //��ʼ����ά����
    final int amn = array.length;
    dist = new int[amn][amn];
    path = new int[amn][amn];
  }

  /**
 * @param begin begin
 * @param end end
 * @param arcs arcs
 */
public void findCheapestPath(final int begin, final int end,
        final int[][]arcs) {
    floyd(arcs);
    list.clear();
    list.add(begin);
    findPath(begin, end);
    list.add(end);
  }


  //Ѱ������֮���Ƿ�����м��
  /**
 * @param row row
 * @param cro cro
 */
public void findPath(final int row, final int cro) {
    final int temp = path[row][cro];
    if (temp == -1) {
      return;
    }
    findPath(row, temp);
    list.add(temp);                        //���м����ӵ��������У��������
    findPath(temp, cro);
  }

  //Floyd�㷨
  /**
 * @param arcs arcs
 */
public void floyd(final int[][] arcs) {
    final int size = arcs.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        path[i][j] = -1;                 //��ʼ����ǰ��·���м���
        if (arcs[i][j] == 0) {
          dist[i][j] = MAX;
        } else {
          dist[i][j] = arcs[i][j];         //��ʼ����ǰ��·�����ȱ�
        }
      }
    }

    for (int k = 0; k < size; k++) {
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (dist[i][k] != MAX && dist[k][j] != MAX && dist[i][k]
                  + dist[k][j] <= dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            path[i][j] = k;
          }
        }
      }
    }
  }

/**
 * @return ArrayList
 */
public ArrayList getList() {
    return this.list;
}

/**
 * @param index1 i
 * @param index2 j
 * @return integer
 */
public int getDist(final int index1, final int index2) {
    return this.dist[index1][index2];
}
}
