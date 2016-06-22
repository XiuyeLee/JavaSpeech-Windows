package com.xiuye.speech;

public class Speak {

	static{
		System.loadLibrary("Speak");
	}
	
	public native void coInitialize();
	public native void speak(String msg);
	public native void coUninitialize();
	
}
