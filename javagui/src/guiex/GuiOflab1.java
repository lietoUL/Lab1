package guiex;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.log4j.*;



/**

* @author Song Hang

* @author LuoWei

*/

/**
 * @author Administrator
 *
 */
public class GuiOflab1 extends TextClass {
/**
 * @author Song Hang
 * @author LuoWei
 * @see bala
 */
  private static int num = 0;
  /**
 *
 */
private transient int csize = 0;
/**
 * @author Song Hang
 */
private final transient TextClass textTemp = new TextClass();
  /**
   * @author Song Hang
   */
  private List<String> liste1 = new ArrayList<String>();
  /**
   * @author Song Hang
   */
  private final transient JFrame frame;
  /**
 *
 */
private final transient JPanel function1;
  /**
 *
 */
private final transient JPanel function2;
  /**
 *
 */
private final transient JPanel function3;
  /**
 *
 */
private final transient JPanel function4;
  /**
 *
 */
private final transient JPanel function5;
  /**
 *
 */
private final transient JPanel function6;

  //定义内容面

  /**
 *
 */
private final transient JButton button1;
  /**
 *
 */
private final transient JButton button2;
  /**
 *
 */
private final transient JButton button3;
  /**
 *
 */
private final transient JButton button4;
  /**
 *
 */
private final transient JButton button5;
  /**
 *
 */
private final transient JButton button6;
  /**
 *
 */
private final transient JButton button7;
  /**
 *
 */
private final transient JButton button8;
  /**
 *
 */
private final transient JTextField textField;
  /**
 *
 */
private final transient JTextField textField2;
  /**
 *
 */
private final transient JTextField textField3;
  /**
 *
 */
private final transient JTextArea textField4;
  /**
 *
 */
private final transient JTextField textField5;
  /**
 *
 */
private final transient JTextField textField6;
  /**
 *
 */
private final transient JTextField function4Word1;
  /**
 *
 */
private final transient JTextField function4Word2;
/**
 *
 */
private static final int NUM200 = 200;
/**
 *
 */
private static final int NUM100 = 100;
/**
 *
 */
private static final int NUM300 = 300;
/**
 *
 */
private static final int NUM400 = 400;
/**
 *
 */
private static final int NUM500 = 500;
/**
 *
 */
private static final int NUM40 = 40;
/**
 *
 */
private static final int NUM80 = 80;
/**
 *
 */
private static final int NUM20 = 20;
/**
 *
 */
private static final int NUM50 = 50;
/**
 *
 */
private static final int NUM60 = 60;
/**
 *
 */
private static final int NUM90 = 90;
/**
 *
 */
private static final int NUM190 = 190;
/**
 *
 */
private static final int NUM150 = 150;
/**
 *
 */
private static final int NUM3 = 3;
/**
 *
 */
private static final int NUM10 = 10;
/**
 *
 */
private static final int NUM640 = 640;
/**
 *
 */
private static final int NUM320 = 320;
/**
 *
 */
private static final int NUM750 = 750;
/**
 *
 */
private static final int NUM650 = 650;
/**
 *
 */
private static final int NUM680 = 680;
/**
 *
 */
private static final int NUM120 = 120;
  /**
 * @author song hang
 */
/**
 *
 */
GuiOflab1() {
    super();
    frame = new JFrame("lab1");
    frame.setLayout(null);
    function1  = new JPanel();
    function1.setLayout(null);
    function1.setBounds(0, 0, NUM300, NUM100);
    function1.setBorder(BorderFactory.createRaisedBevelBorder());
    function2  = new JPanel();
    function2.setLayout(null);
    function2.setBounds(0, NUM100, NUM300, NUM100);
    function2.setBorder(BorderFactory.createRaisedBevelBorder());

    function3  = new JPanel();
    function3.setLayout(null);
    function3.setBounds(0, NUM200, NUM300, NUM100);
    function3.setBorder(BorderFactory.createRaisedBevelBorder());

    function4 = new JPanel();
    function4.setLayout(null);
    function4.setBounds(0, NUM300, NUM300, NUM100);
    function4.setBorder(BorderFactory.createRaisedBevelBorder());

    function5 = new JPanel();
    function5.setLayout(null);
    function5.setBounds(0, NUM400, NUM300, NUM100);
    function5.setBorder(BorderFactory.createRaisedBevelBorder());

    function6 = new JPanel();
    function6.setLayout(null);
    function6.setBounds(0, NUM500, NUM300, NUM100);
    function6.setBorder(BorderFactory.createRaisedBevelBorder());

    button1 = new JButton("确认");
    textField = new JTextField("请输入地址");
    button1.setBounds(NUM80, NUM40, NUM100, NUM20);
    textField.setBounds(0, 0, NUM300, NUM20);

    textField2 = new JTextField();
    textField3 = new JTextField();
    textField4 = new JTextArea(NUM3, NUM10);
    textField4.setEditable(false);
    textField4.setBorder(BorderFactory.createEtchedBorder());
    button2 = new JButton("桥接词");
    button2.setBounds(NUM80, NUM40, NUM100, NUM20);
    textField2.setBounds(NUM10, NUM60, NUM50, NUM20);
    textField3.setBounds(NUM10, NUM20, NUM50, NUM20);
    textField4.setBounds(NUM190, NUM20, NUM100, NUM60);

    textField5 = new JTextField();
    textField5.setBounds(0, NUM20, NUM300, NUM20);
    button3 = new JButton("生成新文本");
    button3.setBounds(NUM80, NUM60, NUM100, NUM20);

    button4 = new JButton("查询最短路径");
    button4.setBounds(NUM90, NUM50, NUM120, NUM20);
    function4Word1 = new JTextField();
    function4Word2 = new JTextField();
    function4Word1.setBounds(NUM190, NUM20, NUM100, NUM20);
    function4Word2.setBounds(NUM10, NUM20, NUM100, NUM20);

    button5 = new JButton("随机游走");
    button5.setBounds(NUM80, NUM40, NUM120, NUM20);

    textField6 = new JTextField();
    textField6.setBounds(0, NUM20, NUM300, NUM20);
    button6 = new JButton("单个单词最短路径");
    button6.setBounds(NUM80, NUM50, NUM150, NUM20);

    button7 = new JButton("显示最短路径");
    button7.setBounds(NUM90, NUM80, NUM120, NUM20);

    button8 = new JButton("查看图片");
    button8.setBounds(NUM80, NUM80, NUM150, NUM20);

    final SimpleListener ourListener = new SimpleListener();
    button1.addActionListener(ourListener);
    button2.addActionListener(ourListener);
    button3.addActionListener(ourListener);
    button4.addActionListener(ourListener);
    button5.addActionListener(ourListener);
    button6.addActionListener(ourListener);
    button7.addActionListener(ourListener);
    button8.addActionListener(ourListener);

    textField4.setLineWrap(true);
  }
  /**
   * @author Song Hang
   * @param str a string
   */
  private void func(final String str) {
    final JFrame frameNewtext = new JFrame("生成结果");
    final JLabel label1 = new JLabel(str);
    frameNewtext.getContentPane().add(label1, BorderLayout.CENTER);
    frameNewtext.setBounds(NUM500, NUM300, NUM400, NUM200);
    frameNewtext.setResizable(true);
    frameNewtext.setVisible(true);
  }

  /**
 * @param list6 a string
 */
private void func2(final List<String> list6) {
    final JTextArea text4 = new JTextArea(NUM3, NUM10);
    final JScrollPane scroll = new JScrollPane(text4);
    text4.setBounds(0, 0, NUM500, NUM100);
    text4.setLineWrap(true);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    final JFrame frameNewtext = new JFrame("生成结果");
    frameNewtext.add(scroll);
    frameNewtext.setBounds(NUM500, NUM300, NUM500, NUM200);
    frameNewtext.setResizable(true);
    frameNewtext.setVisible(true);
    for (int c = 0; c < list6.size(); c++) {
      text4.append(list6.get(c) + '\n');
    }
  }

  /**
 *
 */
private void grap() {
    JPanel picture;
    picture = new JPanel();
    picture.setLayout(null);
    picture.setBounds(NUM300, 0, NUM300, NUM500);
    picture.setBorder(BorderFactory.createRaisedBevelBorder());
    JLabel lblImage;
    lblImage = new JLabel(new ImageIcon("E:/软件工程/实验/实验4/Lab4/javagui/graph.jpg"));
    lblImage.setBounds(0, 0, NUM750, NUM650);
    picture.add(lblImage);
    final JFrame frameNew = new JFrame("图片显示");
    frameNew.add(picture);
    frameNew.setBounds(0, 0, NUM750, NUM680);
    frameNew.setResizable(true);
    frameNew.setVisible(true);
  }

  /**
 *
 */
/**
 * @throws ImagingOpException detail:....
 */
private void grap2() throws ImagingOpException {
    final ImageIcon pic2 = new ImageIcon("E:/软件工程/实验/实验4/Lab4/javagui/"
+ getSureth() + ".jpg/");
    final JLabel lbl = new JLabel(pic2);
    lbl.setIcon(pic2);
    lbl.setBounds(0, 0, NUM750, NUM650);

    JPanel picture2;
    picture2 = new JPanel();
    picture2.setLayout(null);
    picture2.setBounds(NUM300, 0, NUM300, NUM500);
    picture2.setBorder(BorderFactory.createRaisedBevelBorder());
    picture2.add(lbl);

    final JFrame frameN = new JFrame("图片显示");
    frameN.add(picture2);
    frameN.setBounds(0, 0, NUM750, NUM680);
    frameN.setResizable(true);
    frameN.setVisible(true);
    //pic2 = null;
    num = num + 1;

  }

  /**
 * @param picn a pic
 */
private void grap3(final ImageIcon picn) {
    JPanel picture2;
    final JLabel lbl = new JLabel(picn);
    lbl.setIcon(picn);
    lbl.setBounds(0, 0, NUM750, NUM650);

    picture2 = new JPanel();
    picture2.setLayout(null);
    picture2.setBounds(NUM300, 0, NUM300, NUM500);
    picture2.setBorder(BorderFactory.createRaisedBevelBorder());
    picture2.add(lbl);

    final JFrame frameN = new JFrame("图片显示");
    frameN.add(picture2);
    frameN.setBounds(0, 0, NUM750, NUM680);
    frameN.setResizable(true);
    frameN.setVisible(true);
    num = num + 1;
  }

  /**
 * @author Administrator
 *
 */
private class SimpleListener implements ActionListener {
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(
     * java.awt.event.ActionEvent)
     */
	  /**
	 * @author Administrator
	 * @param actione detail:..
	 */
	
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(final ActionEvent actione) {
      // 利用getActionCommand获得按钮名称
      // 也可以利用getSource()来实现
      // if (e.getSource() ==button1)
      final String buttonName = actione.getActionCommand();
      if ("确认".equals(buttonName)) {
          textTemp.setFileName(textField.getText());
          try {
			textTemp.readfiles();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
          try {
			textTemp.showDirectedGraph(textTemp.getGraph());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        grap();
      } else if ("桥接词".equals(buttonName)) {
        final String fie2 = textField2.getText();
        final String fie3 = textField3.getText();
        textField4.setText(textTemp.queryBridgeWords(fie2, fie3));
      } else if ("生成新文本".equals(buttonName)) {
        String  str1;
        str1 = textTemp.generateNewText(textField5.getText());
        func(str1);
      } else if ("查询最短路径".equals(buttonName)) {
        final String fie4 = function4Word2.getText();
        final String fie5 = function4Word1.getText();
        String str2;
        str2 = textTemp.calcShortestPath(fie4, fie5);
        func(str2);
      } else if ("显示最短路径".equals(buttonName)){
        grap2();
      } else if ("随机游走".equals(buttonName)) {
        String str3;
        str3 = textTemp.randomWalk();
        func(str3);
      } else if ("单个单词最短路径".equals(buttonName)) {
        List<String> list6 = new ArrayList<String>();
        list6 = oneCalcShortestPath(textField6.getText());
        func2(list6);
      }
      if (csize < textTemp.getListe0().size()&&buttonName.equals("查看图片")) 
         {
          ImageIcon picNew = new ImageIcon();
          picNew = new ImageIcon("E:/软件工程/实验/实验4/Lab4/javagui/"
              + textTemp.getListe0().get(csize++) + ".jpg/");
          grap3(picNew);
        }
      
    }
  }

  /**
 * @author pppppp
 */
private void createandshowgui() {
    /*JPanel function4  = new JPanel(new BorderLayout());
    JPanel function5  = new JPanel(new BorderLayout());
    JPanel function6  = new JPanel(new BorderLayout());
    JPanel picture  = new JPanel(new BorderLayout());*/
    function1.add(textField);
    function1.add(button1);
    frame.add(function1); //功能一的各项组件

    function2.add(textField2);
    function2.add(textField3);
    function2.add(textField4);
    function2.add(button2);

    frame.add(function2); //功能二的各项组件及内容面板

    function3.add(textField5);
    function3.add(button3);
    frame.add(function3); //功能三得各项组件及内容面板

    function4.add(button4);
    function4.add(button7);
    function4.add(function4Word1);
    function4.add(function4Word2);
    frame.add(function4); //功能四的各项组件及内容面板

    function5.add(button5);

    frame.add(function5); //功能五的各项组件及内容面板

    function6.add(button6);
    function6.add(button8);
    function6.add(textField6);
    frame.add(function6); //功能五的各项组件及内容面板

    frame.setBounds(NUM400, NUM50, NUM320, NUM640);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /**
 * @param args describe args
 */
public static final void main(final String[] args) {
    final GuiOflab1 mam = new GuiOflab1();
    mam.createandshowgui();
  }
}
