package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tabChangeListener implements ChangeListener {
    private JPanel outputPanel;
    public tabChangeListener(JPanel outputPanel){
        this.outputPanel = outputPanel;

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        outputPanel.removeAll();
        outputPanel.revalidate();
        outputPanel.repaint();
    }
}
