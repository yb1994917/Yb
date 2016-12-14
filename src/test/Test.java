package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTable;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test {
	private String s1="3";
	public static ArrayList<String> list=new ArrayList<String>();
	/**
	 * @param <E>
	 * @param args
	 */
	public static  void main(String[] args) {
//			System.out.println(System.currentTimeMillis());
//			System.out.println("3==4"+(3==4));
			LinkedList<Integer> linkedList = new LinkedList<Integer>();
//			for (int i = 0; i < 100; i++) {
//				linkedList.add(i);
//			}
//			for (int i = 0; i < linkedList.size(); i++) {
//				Integer integer = linkedList.get(i);
//				System.out.println(integer);
////				String.valueOf(obj);
//				
//			}
//			
//			for (Integer integer : linkedList) {
//				System.out.println(integer);
//			}
			String [] arr=new String[]{};
//			arr.length
			
			
			ClassPool pool=ClassPool.getDefault();
			try {
				CtClass ctClass = pool.get("java.lang.String");
				CtMethod declaredMethod = ctClass.getDeclaredMethod("concat");
				String name = declaredMethod.getName();
				System.out.println(name);
			} catch (Exception e) {
			}
			
			int[] selectedRows = new JTable().getSelectedRows();
			int selectedRow = new JTable().getSelectedRow();
			int[] selectedColumns = new JTable().getSelectedColumns();
//			ExecutorService pool= Executors.newFixedThreadPool(3);
//			pool.execute(new Runnable() {
//				@Override
//				public void run() {
//					
//				}
//			});
			for (int i = 0; i < selectedRows.length; i++) {
				for (int j = 0; j < selectedColumns.length; j++) {
					Object valueAt = new JTable().getValueAt(i, j);
//					String.valueOf(b)
				}
			}
	}

}
