package timer;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.Comparator;

import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every second
        Timer timer = new Timer(1000, listener);
        timer.start();

        // keep program running until the user selects "OK" 测试改动
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}