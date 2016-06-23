package com.xiuye.speech;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SpeakOld {

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
