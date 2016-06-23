package com.xiuye.speech.tts;

import com.xiuye.speech.Speech;
import com.xiuye.speech.exception.SpeechException;
import com.xiuye.speech.way.ReadFile;
import com.xiuye.speech.way.ReadString;

public class TTS/* Text To Speech */implements AutoCloseable {

	private Speech speech;

	public boolean isNull() {
		return this.speech == null;
	}

	public void checkSpeechAndExists() {

		if (this.isNull()) {
			this.openSpeech();
		}

	}

	/**
	 * read file content only once, hava no another functions, only once for
	 * speaking file content
	 * 
	 * @param filename
	 */
	public static void readFileOnce(String filename) {

		try (ReadFile rf = new ReadFile()) {
			rf.readTextFile(filename);
		}

	}

	/**
	 * 
	 * read strings only once don't use another functions using this function.
	 * 
	 * @param msg
	 */
	public static void readStringOnce(String msg) {
		try (ReadString rs = new ReadString()) {
			rs.speak(msg);
		}
	}

	public void setVoice(int kindOfVoice) {

		this.checkSpeechAndExists();
		this.speech.setVoice(kindOfVoice);

	}

	public void setVolume(int volumeSize) {
		this.checkSpeechAndExists();
		this.speech.setVolume(volumeSize);
	}

	public void setSpeed(int speed) {
		this.checkSpeechAndExists();
		this.speech.setSpeed(speed);
	}

	public int getSpeed() {
		this.checkSpeechAndExists();
		return this.speech.getSpeed();
	}

	public int getVoice() {
		this.checkSpeechAndExists();
		return this.speech.getVoice();
	}

	public int getVolume() {
		this.checkSpeechAndExists();
		return this.speech.getVolume();
	}

	public int kindsOfVoice() {
		this.checkSpeechAndExists();
		return this.speech.kindsOfVoice();
	}

	@Override
	public void close() {
		this.checkSpeechAndExists();
		this.speech.close();

	}

	public void openReadStringSpeech() {
		this.speech = new ReadString();
	}

	public void openReadFileSpeech() {
		this.speech = new ReadFile();
	}

	public void openSpeech() {
		this.speech = new Speech();
	}

	public static final int READ_FILE_SPEECH = 0;

	public static final int READ_STRING_SPEECH = 1;

	public static final int DEFAULT_SPEECH = 2;

	public void open(int speech) {

		switch (speech) {
		case READ_FILE_SPEECH:
			this.openReadFileSpeech();
			break;
		case READ_STRING_SPEECH:
			this.openReadStringSpeech();
			break;
		case DEFAULT_SPEECH:
			this.openSpeech();
			break;
		default:
			this.openSpeech();
			break;

		}

	}

	public void readFile(String filename) {

		if (this.speech == null) {
			this.openReadFileSpeech();
		}

		if (this.speech instanceof ReadString) {
			throw new SpeechException(
					"It should be ReadFile com.xiuye.speech.way.ReadFile class");
		}

		if (this.speech instanceof ReadFile) {
			((ReadFile) this.speech).readTextFile(filename);
		}

	}

	public void readString(String msg) {

		if (this.speech == null) {
			this.openReadStringSpeech();
		}

		if (this.speech instanceof ReadFile) {
			throw new SpeechException(
					"It should be com.xiuye.speech.way.ReadString class");
		}
		if (this.speech instanceof ReadString) {
			((ReadString) this.speech).readString(msg);
		}
	}

	public static void speakOnce(String msg){
		try(Speech s = new Speech()){
			s.speak(msg);
		}
	}
	
	public void speak(String msg) {

		if (this.speech == null) {
			this.openSpeech();
		}
		this.speech.speak(msg);
	}

	public void pause() {
		this.speech.pause();
	}

	public void resume() {
		this.speech.resume();
	}
}
