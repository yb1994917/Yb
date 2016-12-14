package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader1 extends ClassLoader{

    public MyClassLoader1(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if(!"test.Test1".equals(name))
                return super.loadClass(name);

        try {
            String url = "file:C:/ProgramData/" +
                            "test/Test1.class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();	

            byte[] classData = buffer.toByteArray();

            return defineClass("test.Test1",
                    classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    	Test1 test1 = new Test1();
		test1.show();
//    	MyClassLoader loader1 = new MyClassLoader(getSystemClassLoader(),"MyClassLoader");
//            //String path = new File(MyClassLoader.getSystemClassLoader().getResource("").getPath()).getParent();
       MyClassLoader1 myClassLoader1 = new MyClassLoader1(Test1.class.getClassLoader());
       try {
		Class loadClass = myClassLoader1.loadClass("test.Test1");
//		 Test1 test=(Test1)loadClass.newInstance();   不能直接转为Test1 ClassCastException
          TestInt test=(TestInt)loadClass.newInstance();   //返回的实例Class是有区别的，可以面向父类编程啊  
          //  //... body of class ... override superclass methods
          //    or implement interface methods
          Method[] m = loadClass.getDeclaredMethods();
          for (Method method : m) {
          	   System.out.println(method.getName());	
			}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
           
	}
}
