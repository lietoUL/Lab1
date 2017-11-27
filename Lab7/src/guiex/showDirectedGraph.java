package guiex;

public class showDirectedGraph {
    
    
    
    public static void showDirectedGraph(AMWGraph G) {    //生成有向图的图片，并且存储进硬盘中
        String cur_word=null;
        String word=null;
        //Node tmp_node=null;
        GraphViz gViz = new GraphViz("dot.exe");
        gViz.start_graph();                  //.dot文件的开端
        for(int num = 0;num < G.numvertex;num ++) {     //.dot内容撰写
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
        gViz.end_graph();            //.dot文件的结尾
        try {
        gViz.run();                  //运行这个类
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
