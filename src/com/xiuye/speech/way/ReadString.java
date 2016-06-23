package com.xiuye.speech.way;

import com.xiuye.speech.Speech;

public class ReadString extends Speech{

	public void readString(String str){
		
		this.speak(str);
		
	}
	
	public void readChar(char c){
		String s = c + "";
		this.speak(s);
	}
	
}
