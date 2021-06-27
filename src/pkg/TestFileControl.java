package pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestFileControl {
	public static void main(String[] args) {
		String inPath = "files/test1.txt";
		String absolutePath = "/Users/sharping/Documents/dev/test2.txt";
		String relativePath = "files/test2.txt";
		
		try {
			InputStream fis = new FileInputStream(inPath);
	        //OutputStream fos = new FileOutputStream(absolutePath);
	        OutputStream fos = new FileOutputStream(relativePath);
	        
	        File ofile = new File(relativePath);
	       
	        if(ofile.exists())
	        	System.out.println("exist");
	        else
	        	System.out.println("not exist");
	        
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1)
				fos.write(buf,0,size);
			
			fos.close();
			fis.close();
			
			File project = new File(".");
	        String rootPath = project.getAbsolutePath();
	        System.out.println("현재 프로젝트의 경로 : "+ rootPath);
	        
	        String[] args2 = rootPath.split(File.separator);
	        
	        System.out.println("프로젝트 이름 : " + args2[args2.length-2]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
