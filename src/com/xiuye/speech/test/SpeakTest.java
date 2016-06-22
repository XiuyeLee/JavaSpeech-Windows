package com.xiuye.speech.test;

import com.xiuye.speech.Speak;

public class SpeakTest {

	public static void main(String[] args) {
		
		Speak s = new Speak();
		s.coInitialize();
		for(int i=0;i<2;i++){
			s.speak("然，是的");
		}
		
		s.coUninitialize();
	}
	

}
