package com.xiuye.speech.way;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xiuye.speech.Speech;

public class ReadFile extends Speech {

	public void readTextFile(String textFileName) {

		try (FileInputStream fis = new FileInputStream(textFileName);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader reader = new BufferedReader(isr)) {

			String line = null;
			while((line = reader.readLine()) != null){
				this.speak(line);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
