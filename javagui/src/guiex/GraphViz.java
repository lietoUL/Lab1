package guiex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GraphViz {
	private String runPath = "";                      //�ļ���·��
	private String dotPath = "";
	private String runOrder = "";
	private String dotCodeFile = "graph.dot";
	private String resultGra = "graph";
	private StringBuilder graph = new StringBuilder();     //�ɱ���ַ���������
	public static final String[] color = {"red", "chartreuse", "blue", "gold",
	"darkgoldenrod", "fuchsia", "hotpink", "cadetblue", "green", "cyan",
	"yellow"};

	Runtime runtime = Runtime.getRuntime();     //��ȡ��ǰRuntime����ʱ���������
                                              //Runtimeʹ�ó����������еĻ���������
	public void run() {
		File file = new File(runPath);
		file.mkdirs();                     //�����༶Ŀ¼���ļ���
		writeGraphToFile(graph.toString(), runPath);
		creatOrder();
		try {
			runtime.exec(runOrder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void creatOrder() {             //�ϳ��ļ���һ��·��
		runOrder += dotPath + " ";
		runOrder += runPath;
		runOrder += "\\" + dotCodeFile + " ";
		runOrder += "-T jpg ";
		runOrder += "-o ";
		runOrder += runPath;
		runOrder += "\\" + resultGra + ".jpg";
		//System.out.println(dotCodeFile);
		// System.out.println(runOrder);
	}

	public void writeGraphToFile(String dotcode, String filename) {   //��ͼд���ļ���
		try {
			File file = new File(filename + "\\" + dotCodeFile);//dot�ı����ļ�
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(dotcode.getBytes());
			fos.close();
		} catch (java.io.IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public GraphViz(String dotPath) {
		File f = new File("");
		try {
			this.runPath = f.getCanonicalPath();   //��������ȫ������·��
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		this.dotPath = dotPath;
	}

	public void add(String line) {
		graph.append("\t" + line);
	}

	public void addln(String line) {
		graph.append("\t" + line + "\n");
	}

	public void addln(String line, int label) {
		graph.append(
				"\t" + line + "[label=" + String.valueOf(label) + "]\n");
	}

	public void addln() {
		graph.append('\n');
	}

	public void start_graph() {
		graph.append("digraph G {\n");
	}

	public void setColorForPath(Stack<String> path_Stack, String color,
			String dotName) {
		
		// ������ǵ�ÿ���߼���Set��
		Set<String> path_Set = new HashSet<String>();
		Stack<String> tmpStack = (Stack<String>) path_Stack.clone();
		String str1 = "";
		String str2 = tmpStack.peek();
		tmpStack.pop();
		while (!tmpStack.isEmpty()) {
			str1 = tmpStack.peek();
			tmpStack.pop();
			path_Set.add("\"" + str1 + "\"->\"" + str2 + "\"");
			str2 = str1;
		}

		String targetFile = runPath + "\\" + dotName;
		File outpuFile = new File(targetFile);
		if (!outpuFile.exists()) {
			try {
				Files.copy(new File(runPath + "\\graph.dot").toPath(),
						outpuFile.toPath());
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			// try {
			// runtime.exec(runPath + "\\cmd.exe /c copy " + "graph.dot "
			// + " ShortPath.dot");
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		}

		int pos = 0;
		String sourceFileName = runPath + "\\" + dotName;
		String tmp_str = "";
		File sourceFile = new File(sourceFileName);
		FileReader souceFileReader = null;

		//prepare readStream
		try {
			souceFileReader = new FileReader(sourceFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader sourceBufferedReader = new BufferedReader(souceFileReader);
		
		//prepare writeStream
		outpuFile = new File(runPath + "\\tmp.dot");
		try {
			outpuFile.createNewFile();
		} catch (IOException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
		}
		FileOutputStream fout=null;
		OutputStreamWriter outWriter=null;
		try {
			fout=new FileOutputStream(outpuFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 try {
			outWriter = new OutputStreamWriter(fout, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}  
         BufferedWriter bufWrite = new BufferedWriter(outWriter); 

         //add Head
         try {
			bufWrite.write("digraph G {\n");
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
         
         //read one by one (line)
		try {
			while((tmp_str = sourceBufferedReader.readLine())!=null) {
				if ((pos = tmp_str.indexOf("[")) < 0) {
					continue;
				}
				String edge = tmp_str.substring(tmp_str.indexOf("\t") + 1, pos);
				if (path_Set.contains(edge)) {// ��ǰ�ı��ڴ���ǵ�·����
					StringBuffer tmpBuffer = new StringBuffer(tmp_str);
					pos = tmp_str.indexOf("]");
					if (tmp_str.indexOf("color") >= 0) {// �Ѿ�������ĳ��·���У���Ϊ����
						tmpBuffer.insert(pos,
								" style=tapered penwidth=4 arrowtail=normal");
					} else {
						tmpBuffer.insert(pos, " color=" + color);
					}
					tmp_str = tmpBuffer.toString();
				}
				tmp_str += "\n";
				bufWrite.write(tmp_str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// add tail && close stream
		 try {
			bufWrite.write("}");
			bufWrite.close();
			fout.close();
			sourceBufferedReader.close();
			souceFileReader.close();
			sourceFile.delete();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		sourceFile.delete();
		outpuFile.renameTo(sourceFile);
	}

	public void end_graph() {
		graph.append("}");
	}

	public void clearTmpDotFile(String dotName) {
		String fileNameString = runPath + "\\" + dotName;
		File tmpFile = new File(fileNameString);
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
	}

	public void runAfterSetColor(String newJpgName, String dotName) {
		 //create new Jpg file
		resultGra = newJpgName;
		dotCodeFile = dotName;
		creatOrder();
		try {
			runtime.exec(runOrder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
