package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.io.File;

public class Music implements Runnable{

    @Override
    public void run() {

        try {
            File file = new File("sampleAudio123.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // There are several different amounts of time you can loop it, so you can change this if you want, or you can just use clip.stop() whenever you want.
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //finished = true;

    }
    public static void main(String [] args){

        (new Thread(new Music())).start();
    }
}
