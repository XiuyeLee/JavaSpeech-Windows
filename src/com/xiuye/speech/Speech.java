package com.xiuye.speech;

public class Speech extends Speak implements AutoCloseable{

	public Speech() {

		this.init();

	}

	private void init() {
		this.coInitialize();
	}

	public void open() {
		this.coInitialize();
	}

	public void setSpeed(int speed)// rate 10 -10
	{
		super.setSpeed(speed);
	}

	public int getSpeed() {
		return super.getSpeed();
	}

	public void pause() {
		super.pause();
	}

	public void resume() {
		super.resume();
	}

	public int kindsOfVoice() {
		return super.kindsOfVoice();
	}

	/**
	 * 如果说不了中文说明只能说英语
	 * 
	 * @param kindOfVoice
	 */
	public void setVoice(int kindOfVoice) {
		super.setVoice(kindOfVoice);
	}

	public int getVoice() {
		return super.getVoice();
	}

	public void setVolume(int size) {
		super.setVolume(size);
	}

	public int getVolume() {
		return super.getVolume();
	}

	public void speak(String msg) {

		super.speak(msg);

	}

	@Override
	public void close() {
		this.coUninitialize();
	}
}
