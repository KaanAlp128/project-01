package gui;

import model.Department;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class emailCheckListener implements ActionListener {

    private JTextField userInput;
    private Department myDepartment;

        public emailCheckListener(JTextField userInput,Department myDepartment){
            this.userInput = userInput;
            this.myDepartment = myDepartment;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            int check = 0;
        for(int i = 0; i < myDepartment.getInstructors().size();i++) {

            if(userInput.getText().equals(myDepartment.getInstructors().get(i).getEmail())) {

                InstructorFrame frame = new InstructorFrame(myDepartment.getInstructors().get(i));
                check = 0;
                break;

            }
             else {
                 check = 1;
            }

        }
            if(check == 1){
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(450,250);
                JPanel panel = new JPanel();
                frame.add(panel);
                JLabel label = new JLabel("You have entered the wrong email. Please try again. To exit close this window");
                panel.add(label);
                label.setBounds(150,30,80,25);

                frame.setVisible(true);

            }

        }

}
