package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGuil implements ActionListener{
    JButton button;
    public static void main(String [] args){
        SimpleGuil gui=new SimpleGuil();
        gui.go();
    }


    public void go(){
        JFrame frame=new JFrame();
        

        JButton button=new JButton("click me");//创建button

        button.addActionListener(this);//按钮注册

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//window关掉时程序也会结束

        frame.getContentPane().add(button);

        frame.setSize(300,300);//设定frame大小

        frame.setVisible(true);//

    }

    public void actionPerformed(ActionEvent event){
        button.setText("I'v been clicked!");
    }
}
