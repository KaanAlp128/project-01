package gui;

import model.Course;
import model.GradeItem;
import model.Instructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class registerGradeListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Instructor instructor;
    private JPanel outputPanel;


    public registerGradeListener(JTabbedPane tabbedPane, Instructor instructor, JPanel outputPanel) {
        this.tabbedPane = tabbedPane;
        this.instructor = instructor;
        this.outputPanel = outputPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.outputPanel.removeAll();
        Course course = instructor.getCourses().get(tabbedPane.getSelectedIndex());
        Color red = new Color(128, 0, 0);
        this.outputPanel.setLayout(new GridLayout(0, 3));

        JLabel enter = new JLabel("Enter exam Id: ");
        outputPanel.add(enter);

        JLabel empty = new JLabel("     ");
        outputPanel.add(empty);

        JTextField userInput = new JTextField();
        outputPanel.add(userInput);


        JLabel iD = new JLabel("ID");
        iD.setForeground(red);
        this.outputPanel.add(iD);

        JLabel name = new JLabel("NAME");
        name.setForeground(red);
        this.outputPanel.add(name);

        JLabel grades = new JLabel("GRADES");
        grades.setForeground(red);
        this.outputPanel.add(grades);


        ArrayList<JTextField> textFields = new ArrayList<JTextField>();

        for (int i = 0; i < course.getStudents().size(); i++) {
            JLabel studentID = new JLabel(course.getStudents().get(i).getıD());
            this.outputPanel.add(studentID);
            JLabel studentName = new JLabel(course.getStudents().get(i).getName());
            this.outputPanel.add(studentName);
            JTextField studentGrade = new JTextField();
            this.outputPanel.add(studentGrade);
            textFields.add(studentGrade);

        }

        JButton button = new JButton("Save");
        outputPanel.add(button);
        button.addActionListener(new saveAction(instructor, userInput.getText(), course, textFields));
        this.outputPanel.revalidate();
        this.outputPanel.repaint();

    }
}
