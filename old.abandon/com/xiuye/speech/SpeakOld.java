package com.xiuye.speech;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SpeakOld {

	/**
	 * 以下方式会产生 错误 :首次加载的时候:
	 * C:\Users\Administrator\Desktop>java -jar speech.jar Exception in
	 * thread "main" java.lang.UnsatisfiedLinkError: C:\Users\Administrato
	 * r\Desktop\Speak.dll: 另一个程序正在使用此文件，进程无法访问。 at
	 * java.lang.ClassLoader$NativeLibrary.load(Native Method) at
	 * java.lang.ClassLoader.loadLibrary0(ClassLoader.java:1941) at
	 * java.lang.ClassLoader.loadLibrary(ClassLoader.java:1857) at
	 * java.lang.Runtime.loadLibrary0(Runtime.java:870) at
	 * java.lang.System.loadLibrary(System.java:1122) at
	 * com.xiuye.speech.Speak.<clinit>(Speak.java:30) at
	 * com.xiuye.speech.test.SpeakTest.main(SpeakTest.java:9)
	 * 
	 */
	static {
		String OSArch = System.getProperty("sun.arch.data.model");
		InputStream in = null;
		FileOutputStream out = null;
		try {
			// jvm 32载入
			if ("32".equals(OSArch)) {
				File fSpeakDll = new File("Speak.dll");
				if (!fSpeakDll.exists()) {

					in = ClassLoader.getSystemResourceAsStream("Speak.dll");

					byte[] data = new byte[1024];
					out = new FileOutputStream("Speak.dll", false);
					while (in.read(data) != -1) {
						out.write(data);
						out.flush();
					}

				}
				System.loadLibrary("Speak");
				// Runtime.getRuntime().loadLibrary("Speak");
			}
			// jvm 64载入
			else {
				File fSpeakX64Dll = new File("SpeakX64.dll");
				if (!fSpeakX64Dll.exists()) {
					in = ClassLoader.getSystemResourceAsStream("SpeakX64.dll");
					byte[] data = new byte[1024];
					out = new FileOutputStream("SpeakX64.dll", false);
					while (in.read(data) != -1) {
						out.write(data);
						out.flush();
					}

				}
				System.loadLibrary("SpeakX64");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public native void coInitialize();

	public native void speak(String msg);

	public native void coUninitialize();

	public native void setSpeed(int speed);// rate 10 -10

	public native int getSpeed();

	public native void pause();

	public native void resume();

	public native int kindsOfVoice();

	/**
	 * 如果说不了中文说明只能说英语
	 * 
	 * @param kindOfVoice
	 */
	public native void setVoice(int kindOfVoice);

	public native int getVoice();

	public native void setVolume(int size);

	public native int getVolume();

}
