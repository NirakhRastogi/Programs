package com.codejam.baseimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class BaseImpl {

	private static Scanner sc = null;
	private static PrintWriter out = null;

	public static Scanner getSc() {
		return sc;
	}

	public static PrintWriter getOut() {
		return out;
	}

	public static void initializeReaderAndWriter(Class<? extends BaseImpl> clazz, String fileName, String fileExt)
			throws FileNotFoundException {
		String packageName = clazz.getPackageName().replaceAll("\\.", "/");
		String filePath = Paths.get("").toAbsolutePath() + "/src/" + packageName + "/" + fileName + fileExt;
		String outputFilePath = Paths.get("").toAbsolutePath() + "/src/" + packageName + "/" + fileName + "-output.txt";
		sc = new Scanner(new File(filePath));
		out = new PrintWriter(new File(outputFilePath));
		Class<?>[] cArgs = new Class[2];
		cArgs[0] = Scanner.class;
		cArgs[1] = PrintWriter.class;
		try {
			Method method = clazz.getMethod("implementCode", cArgs);
			Object c;
			c = clazz.getDeclaredConstructor().newInstance();
			Object[] obj = new Object[2];
			obj[0] = sc;
			obj[1] = out;
			method.invoke(c, obj);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		out.close();
	}

	public abstract void implementCode(Scanner sc, PrintWriter out);

}
