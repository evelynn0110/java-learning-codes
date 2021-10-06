package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C {

    JFrame frame;
    JLabel label;
    public static void main(String [] args){
        SimpleGui3C gui=new SimpleGui3C();
        gui.go();
    }

    public void go(){
        frame=new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*JButton button=new JButton("change colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel=new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);*/

        JButton labelButton=new JButton("change label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton=new JButton("change color");
        colorButton.addActionListener(new ColorListener());

        label =new JLabel("I'm a label");
        MyDrawPanel drawPanel=new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);



        frame.setSize(300,300);

        frame.setVisible(true);

        


    }//go method

    /*
    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }*/

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Ouch!");
        }
    }//end inner class

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }

    
    
}
