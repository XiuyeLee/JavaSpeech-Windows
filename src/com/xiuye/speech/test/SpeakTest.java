package com.xiuye.speech.test;

import com.xiuye.speech.Speak;

public class SpeakTest {

	public static void main(String[] args) {
		
		Speak s = new Speak();
		s.coInitialize();
		s.speak("hello，java发送消息");
		s.coUninitialize();
	}
	

}
