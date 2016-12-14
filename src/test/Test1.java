package test;

import java.util.ArrayList;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;

public class Test1 implements TestInt {
	public static void main(String[] args) {
		ClassPool pool=ClassPool.getDefault();
			try {
		
				CtClass ctClass = pool.makeClass("MyRunnable");
				ctClass.setInterfaces(new CtClass[]{pool.get("java.lang.Runnable")});
				ctClass.writeFile("e:/mycla");
				System.out.println("生成完毕!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 public void show() {
		    System.out.println("show/.......");
		  }

	
	

}
