package com.xiuye.speech.installer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.xiuye.speech.checkvm.VMValidate;

public class DllInstaller {

	private static class InnerInstaller implements Callable<String> {

		@Override
		public String call() throws Exception {

			boolean f = VMValidate.isWinVM32();
			String name = "";
			if(f){
				this.install32DLL();
				name = "Speak";
			}
			else{
				this.install64DLL();
				name = "SpeakX64";
			}

			return name;
		}

		private InputStream getResouece(String filenameInJar) {

			return ClassLoader.getSystemResourceAsStream(filenameInJar);

		}

		private void installDLL(String dllName) {

			File f = new File(dllName);
			if(f.exists()){
				return;
			}

			byte[] data = new byte[1024];

			int length = -1;

			try (InputStream in = this.getResouece(dllName);
					FileOutputStream out = new FileOutputStream(dllName)) {
				while ((length = in.read(data) )!= -1) {
					out.write(data,0,length);
				}
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private void install64DLL(){

			this.installDLL("SpeakX64.dll");

		}

		private void install32DLL(){

			this.installDLL("Speak.dll");
		}

	}



	public static String installDll() throws InterruptedException, ExecutionException {


		FutureTask<String> fTask = new FutureTask<String>(new InnerInstaller());

		Thread thread = new Thread(fTask);

		thread.start();

		return fTask.get();

	}

}
