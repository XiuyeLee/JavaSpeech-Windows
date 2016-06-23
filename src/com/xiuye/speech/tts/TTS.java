package com.xiuye.speech.tts;

import com.xiuye.speech.way.ReadFile;


public class TTS/* Text To Speech */{


	public static void readFile(String filename){
		
		try(ReadFile rf = new ReadFile()){
			rf.readTextFile(filename);
		}
		
	}
	
	
}
