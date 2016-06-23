package com.xiuye.speech;

import com.xiuye.speech.shareload.DllLoad;

public class Speak {

	static {
		/**
		 * 通过DllLoad来解决 C:\Users\Administrator\Desktop>java -jar speech.jar
		 * Exception in thread "main" java.lang.UnsatisfiedLinkError:
		 * C:\Users\Administrato r\Desktop\Speak.dll: 另一个程序正在使用此文件，进程无法访问。 at
		 * java.lang.ClassLoader$NativeLibrary.load(Native Method) at
		 * java.lang.ClassLoader.loadLibrary0(ClassLoader.java:1941) at
		 * java.lang.ClassLoader.loadLibrary(ClassLoader.java:1857) at
		 * java.lang.Runtime.loadLibrary0(Runtime.java:870) at
		 * java.lang.System.loadLibrary(System.java:1122) at
		 * com.xiuye.speech.Speak.<clinit>(Speak.java:30) at
		 * com.xiuye.speech.test.SpeakTest.main(SpeakTest.java:9)
		 * 实际上是使用了FutureTask解决的
		 * 
		 */
		DllLoad.loadDLL();
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
