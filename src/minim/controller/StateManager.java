package minim.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import minim.Minim;

public class StateManager {
	public static Object load(Class<?> c) {
		String filename = getpath(c);
		try {
			File file = new File(filename);
			if (!file.exists()) {
				return null;
			}
			final FileInputStream streamIn = new FileInputStream(file);
			final ObjectInputStream objectinputstream = new ObjectInputStream(
					streamIn);
			Object o = objectinputstream.readObject();
			objectinputstream.close();
			return o;
		} catch (Exception e) {
			System.err.println("Could not load data file: " + filename);
			e.printStackTrace();
			return null;
		}
	}

	static String getpath(Class<?> class1) {
		return Minim.BASEPATH + class1.getSimpleName().toLowerCase() + ".data";
	}

	public static void save(Class<?> c, Object o) {
		String file = getpath(c);
		try {
			final FileOutputStream fout = new FileOutputStream(file);
			final ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			System.err.println("Could not load save file: " + file);
			e.printStackTrace();
		}
	}
}
