package com.example.demo.jave;

import java.io.File;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

public class JaveTest2 {
	public static void main(String[] args) {
		try {
			File source = new File("C:\\file\\voice\\Temp_9053E712CD9943F4B639D67EFA72D209.wav");
			File target = new File("C:\\file\\voice\\Temp_9053E712CD9943F4B639D67EFA72D209.mp3");

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
			encoder.encode(new MultimediaObject(source), target, attrs);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
