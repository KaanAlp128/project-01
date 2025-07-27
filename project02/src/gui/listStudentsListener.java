package gui;

import model.Course;
import model.Instructor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listStudentsListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Instructor instructor;
    private JPanel panel;

    public listStudentsListener(JTabbedPane tabbedPane,Instructor instructor,JPanel panel){
            this.tabbedPane = tabbedPane;
            this.instructor = instructor;
            this.panel = panel;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel.removeAll();
        Course course = instructor.getCourses().get(tabbedPane.getSelectedIndex());
        this.panel.setLayout(new GridLayout(course.getStudents().size()+1 ,3));
        Color red = new Color(128,0,0);

        JLabel iD = new JLabel("ID");
        iD.setForeground(red);
        this.panel.add(iD);

        JLabel name = new JLabel("NAME");
        name.setForeground(red);
        this.panel.add(name);

        JLabel email = new JLabel("EMAIL");
        email.setForeground(red);
        this.panel.add(email);

        for (int i = 0; i < course.getStudents().size(); i++) {
             JLabel studentID= new JLabel(course.getStudents().get(i).getıD());
             this.panel.add(studentID);
             JLabel studentName = new JLabel(course.getStudents().get(i).getName());
             this.panel.add(studentName);
             JLabel studentEmail = new JLabel(course.getStudents().get(i).getEmail());
             this.panel.add(studentEmail);
        }
        this.panel.revalidate();
        this.panel.repaint();
    }
}
