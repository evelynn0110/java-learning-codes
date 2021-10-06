package GUI;

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer2 implements ControllerEventListener{

    public static void main(String [] args){
        MiniMusicPlayer2 mini=new MiniMusicPlayer2();
        mini.go();
    } 

    public void go(){

        try{
            Sequencer sequencer=MidiSystem.getSequencer();
            sequencer.open();

            int [] eventsIWant={127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq=new Sequence(Sequence.PPQ, 4);
            Track track=seq.createTrack();

            for(int i=5;i<60;i+=4){
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,i,100,i));
            }//for

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }catch(Exception ex){ex.printStackTrace();}
    }//go

    public void controlChange(ShortMessage event){//print string when getting events
        System.out.println("la");
    }

    public MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){
        MidiEvent event=null;
        try{
            ShortMessage a=new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event=new MidiEvent(a,tick);
        }catch(Exception e){}
        return event;
    }//make event
    
    class MyDrawPanel extends JPanel implements ControllerEventListener{

        boolean msg=false;

        public void controlChange(ShortMessage event){
            msg=true;
            repaint();
        }

        public void paintComponent(Graphics g){
            if(msg){
                Graphics2D g2=(Graphics2D) g;

                int r=(int) (Math.random()*250);
                int gr=(int) (Math.random()*250);
                int b=(int) (Math.random()*250);
            }
        }
    }
}
