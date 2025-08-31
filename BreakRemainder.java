import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreakRemainder extends JFrame implements ActionListener {
    private final int delay = 10000;
    private String s = "IT'S TIME TO BREAK.\n";
    private Object[] possibleValues = { "Remaind again after 10 seconds", "Remaind again after 20 seconds",
            "Remaind again after 1 hour", "Close the program!" };
    private Object defaultValue = possibleValues[0];
    private Timer t;

    public BreakRemainder() {
        t = new Timer(delay, this);
        t.start();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object selectedValue = JOptionPane.showInputDialog(null, s, "BreakRemainder", JOptionPane.INFORMATION_MESSAGE,
                null, possibleValues, defaultValue);
        if (selectedValue == possibleValues[0]) {
            defaultValue = possibleValues[0];
            t.setDelay(10000);// 1o seconds delay
        } else if (selectedValue == possibleValues[1]) {
            defaultValue = possibleValues[1];
            t.setDelay(20000);// 20 seconds delay
        } else if (selectedValue == possibleValues[2]) {
            defaultValue = possibleValues[2];
            t.setDelay(3600000);// 1 hour delay
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new BreakRemainder();
    }
}