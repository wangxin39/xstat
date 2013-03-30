package cn.iaicc.smgk.util;

import java.io.File;

public class LibPathUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File libs = new File("../lib");
		try{
			StringBuffer sb = new StringBuffer();
			File[] files = libs.listFiles();
			for(File file:files) {
				if(file.getName().lastIndexOf(".jar") != -1) {
					sb.append(" lib/"+file.getName());
				}
			}
			System.out.println(""+sb.toString());
			
 		}catch(Exception e) {
 			e.printStackTrace();
 		}


	}

}
