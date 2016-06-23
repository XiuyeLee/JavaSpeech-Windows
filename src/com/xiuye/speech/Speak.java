package com.xiuye.speech;

public class Speak {

	static {
		String OSArch = System.getProperty("sun.arch.data.model");
		//jvm 32载入
		if ("32".equals(OSArch)) {
			System.loadLibrary("Speak");
			//Runtime.getRuntime().loadLibrary("Speak");
		}
		//jvm 64载入
		else{
			System.loadLibrary("SpeakX64");
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
