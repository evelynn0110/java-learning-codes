package GUI;
import javax.sound.midi.*;

public class MiniMusicPlayer1 {

    public static void main(String [] args){
        try{
            Sequencer sequencer=MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq=new Sequence(Sequence.PPQ, 4);//create and open sequence
            Track track=seq.createTrack();

            for(int i=5;i<61;i+=4){

                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));//调用makeEvent()产生信息和事件

            }//for

            sequencer.setSequence(seq);//start play
            sequencer.setTempoInBPM(220);
            sequencer.start();

        }catch(Exception ex){ex.printStackTrace();}

    }//main

    public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){
        MidiEvent event=null;
        try{
            ShortMessage a=new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event =new MidiEvent(a, tick);
        }catch(Exception e){}

        return event;
    }
    
}