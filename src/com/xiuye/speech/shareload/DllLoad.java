package com.xiuye.speech.shareload;

import java.util.concurrent.ExecutionException;

import com.xiuye.speech.installer.DllInstaller;

public class DllLoad {

	public static void loadDLL(){

		try {

			String dllName = DllInstaller.installDll();
			System.loadLibrary(dllName);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
