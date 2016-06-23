package com.xiuye.speech.way;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xiuye.speech.Speech;
import com.xiuye.speech.exception.EmptyStringException;
import com.xiuye.speech.exception.FileSuffixException;

public class ReadFile extends Speech {

	public void readTextFile(String textFileName) {

		if(textFileName == null){
			throw new NullPointerException("Input text filename string is null!");
		}
		if(textFileName.isEmpty()){
			throw new EmptyStringException("Input text filename string is empty!");
		}
		if(!textFileName.endsWith(".txt")){
			throw new FileSuffixException("Input text filename's suffix is not \".txt\"");
		}
		
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
