package com.xiuye.speech.test;

import com.xiuye.speech.tts.TTSHelper;

public class TTSTest {

	public static void main(String[] args) {

		TTSHelper.speakOnce("Hello World!");
		TTSHelper.speakOnce("123456");

		//TTS.readFileOnce("words.txt");
		//TTSHelper.readFile("words.txt");

		TTSHelper.reloadReadStringSpeech();
		TTSHelper.setVoice(2);
		TTSHelper.speak("123456");
		TTSHelper.speak("456789");
		TTSHelper.reloadSpeech();
		TTSHelper.speak("英雄联盟！德玛西亚！碾碎他们！");

	}

}
