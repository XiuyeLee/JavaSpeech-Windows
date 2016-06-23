package com.xiuye.speech.tts;

public class TTSHelper {

	private static final TTS tts = new TTS();

	public static void speak(String msg) {
		tts.speak(msg);
	}

	public static void readString(String str) {
		tts.readString(str);
	}

	public static void readFile(String filename) {
		tts.readFile(filename);
	}

	public static void release() {
		tts.close();
	}

	public static void readOnceFile(String filename) {
		TTS.readFileOnce(filename);
	}

	public static void readOnceString(String str) {
		TTS.readStringOnce(str);
	}

	public static void speakOnce(String msg) {
		TTS.speakOnce(msg);
	}

	public static void reloadSpeech() {
		tts.close();
		tts.open(TTS.DEFAULT_SPEECH);

	}

	public static void reloadReadFileSpeech(){
		tts.close();
		tts.open(TTS.READ_FILE_SPEECH);
	}
	
	public static void reloadReadStringSpeech(){
		tts.close();
		tts.open(TTS.READ_STRING_SPEECH);
	}
	
	public static int kindsOfVoice(){
		return tts.kindsOfVoice();
	}
	public static void pause(){
		tts.pause();
	}
	public static void resume(){
		tts.resume();
	}
	
	public static void setVolume(int volume){
		tts.setVolume(volume);
	}
	
	public static void setVoice(int voice){
		tts.setVoice(voice);
	}
	
	public static void setSpeed(int speed){
		tts.setSpeed(speed);
	}
	
	public static int getSpeed(){
		return tts.getSpeed();
	}
	
	public static int getVoice(){
		return tts.getVoice();
	}
	
	public static int getVolume(){
		return tts.getVolume();
	}
}
