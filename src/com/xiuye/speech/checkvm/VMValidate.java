package com.xiuye.speech.checkvm;

public class VMValidate {

	public static boolean isWinVM32(){
		
		String OSArch = System.getProperty("sun.arch.data.model");
		if("32".equals(OSArch)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
}
