package com.xiuye.speech.test;

import com.xiuye.speech.Speak;

public class SpeakTest {

	public static void main(String[] args) {
		
		Speak s = new Speak();
		s.coInitialize();
		for(int i=0;i<10;i++){
			s.speak("态报告则发送成功，需要状态报告则已发送；没有msg_id，重发次数超限");
		}
		
		s.coUninitialize();
	}
	

}
