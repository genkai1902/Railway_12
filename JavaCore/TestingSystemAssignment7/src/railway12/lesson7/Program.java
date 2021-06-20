package railway12.lesson7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Program {

	public static void main(String[] args) throws IOException {
		
		// static example
		Student s1 = new Student(111, "Thong");
		Student s2 = new Student(222, "Minh");
//		
//		s1.display();
//		s2.display();
		
//		Counter1 c1 = new Counter1();
//		Counter1 c2 = new Counter1();
//		Counter1 c3 = new Counter1();
		
		//check exist
//		File file1 = new File("D:\\lesson7\\demo.txt");
//		if (file1.exists()) {
//			System.out.println("exists!");
//		} else {
//			System.out.println("doesn't exist!");
//		}
		
		//create new file
//		File file2 = new File("D:\\lesson7\\newFile.txt");
//		if (file2.createNewFile()) {
//			System.out.println("created succesfully!");
//		} else {
//			System.out.println("file exists, cannot create a new file!");
//		}
		
		// check file or folder
//		File file3 = new File("D:\\lesson7");
//		if (file3.isDirectory()) {
//			System.out.println("this is folder");
//		} else {
//			System.out.println("this is file");
//		}
		
		// list file
//		for (String fileName : file3.list()) {
//			System.out.println(fileName);
//		}
		
//		FileInputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream("D:\\lesson7\\demo.txt");
//			System.out.println("Content: ");
//			// read characters from FileInputStream and write them
//			int ch;
//			while ((ch = inputStream.read()) != -1) {
//				System.out.print((char) ch);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (inputStream != null) {
//					inputStream.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
//		String str = "toi la ai day la dau";
//		FileOutputStream outputStream = null;
//		try {
//			inputStream = new FileInputStream("D:\\lesson7\\demo.txt");
//			outputStream = new FileOutputStream("D:\\lesson7\\outStream.txt", false);
//			int ch;
//			while ( (ch = inputStream.read()) != -1) {
//				outputStream.write(ch);
//			}
//			outputStream.write(str.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (outputStream != null) {
//					outputStream.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// read and write object
		FileOutputStream fileOut = new FileOutputStream("D:\\lesson7\\obj.ser");
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(s1);
		objectOut.writeObject(s2);
		objectOut.close();
		
		// load object tu file
		FileInputStream fileIn = new FileInputStream("D:\\lesson7\\obj.ser");
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		try {
			Object obj = objectIn.readObject();
			Student sv = (Student) obj;
			sv.display();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objectIn.close();
		}
		
	}

}
