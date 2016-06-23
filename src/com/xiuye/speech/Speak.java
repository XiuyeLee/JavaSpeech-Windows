package com.xiuye.speech;

import com.xiuye.speech.shareload.DllLoad;

class Speak {

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

	protected native void coInitialize();

	protected native void speak(String msg);

	protected native void coUninitialize();

	protected native void setSpeed(int speed);// rate 10 -10

	protected native int getSpeed();

	protected native void pause();

	protected native void resume();

	protected native int kindsOfVoice();

	/**
	 * 如果说不了中文说明只能说英语
	 * 
	 * @param kindOfVoice
	 */
	protected native void setVoice(int kindOfVoice);

	protected native int getVoice();

	protected native void setVolume(int size);

	protected native int getVolume();

}
