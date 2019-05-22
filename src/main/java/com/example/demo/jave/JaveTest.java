package com.example.demo.jave;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

public class JaveTest {
	public static void main(String[] args) throws Exception {
		File source = new File("C:\\Users\\34310\\Desktop\\vedioTest\\20190520160508658.flv");
		File target = new File("C:\\Users\\34310\\Desktop\\vedioTest\\20190520160508658.mp4");
		
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(56000));
        audio.setChannels(new Integer(1));
        audio.setSamplingRate(new Integer(22050));
        VideoAttributes video = new VideoAttributes();
        video.setCodec("mpeg4");
        video.setBitRate(new Integer(800000));
        video.setFrameRate(new Integer(15));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp4");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        encoder.encode(source, target, attrs);
	}
}
