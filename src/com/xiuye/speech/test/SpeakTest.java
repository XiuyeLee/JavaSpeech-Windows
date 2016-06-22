package com.xiuye.speech.test;

import com.xiuye.speech.Speak;

public class SpeakTest {

	public static void main(String[] args) {
		
		Speak s = new Speak();
		s.coInitialize();
		System.out.println("11:"+s.kindsOfVoice());
		s.setVoice(1);
		System.out.println("13:"+s.getVoice());
		s.setSpeed(0);//success
		System.out.println("15:"+s.getSpeed());//success
		s.setVolume(111);//success
		System.out.println("16:"+s.getVolume());//success
		for(int i=0;i<2;i++){
			s.speak("是短发是");
			s.pause();
			//s.resume();
		}
		s.resume();
		s.resume();
		s.coUninitialize();
	}
	

}
