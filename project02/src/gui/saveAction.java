package gui;

import model.Course;
import model.Instructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class saveAction implements ActionListener {
    private Instructor instructor;
    private String examId;
    private Course course;
    private ArrayList<JTextField> textFields;

    public saveAction(Instructor instructor, String examId, Course course, ArrayList<JTextField> textFields) {
        this.instructor = instructor;
        this.examId = examId;
        this.course = course;
        this.textFields = textFields;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<Integer> grades = new ArrayList<Integer>();

        for (int i = 0; i < textFields.size(); i++) {
            inputs.add(textFields.get(i).getText());
        }

        grades = convert(inputs);
        if (grades == null) {
            return;
        }

        this.instructor.registerExamGrades(this.course.getiD(),this.examId,grades);
        this.course.addExamId(this.examId);
    }

    private ArrayList<Integer> convert(ArrayList<String> inputs) {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        try {
            for (int i = 0; i < inputs.size(); i++) {
                int grade = Integer.parseInt(inputs.get(i).trim());
                if (grade < 0 || grade > 100) {
                    throw new NumberFormatException("Not between 0 and 100");
                }
                grades.add(grade);

            }
            return grades;
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number.");
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 250);
            JPanel panel = new JPanel();
            frame.add(panel);
            JLabel label = new JLabel("All students must have an integer grade between 0 and 100.");
            panel.add(label);
            label.setBounds(150, 30, 80, 25);
            frame.setVisible(true);

        }
        return null;
    }


}
