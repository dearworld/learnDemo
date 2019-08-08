package com.example.demo.jave;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;


public class JaveTest1 {
	public static void main(String[] args) {
		try {
			File source = new File("C:\\file\\voice\\Temp_9EF688433F4440DCAB2F856F66B35370.wav");
			File target = new File("C:\\file\\voice\\Temp_9EF688433F4440DCAB2F856F66B35370.mp3");

			// Audio Attributes
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("libmp3lame");
			audio.setBitRate(128000);
			audio.setChannels(2);
			audio.setSamplingRate(44100);

			// Encoding attributes
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("mp3");
			attrs.setAudioAttributes(audio);

			// Encode
			Encoder encoder = new Encoder();
			encoder.encode(source, target, attrs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
