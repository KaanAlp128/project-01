package gui;

import model.Course;
import model.Instructor;
import model.GradeItem;
import model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class listGradesListener implements ActionListener {
    private Instructor instructor;
    private JPanel outputPanel;
    private JTabbedPane tabbedPane;

    public listGradesListener(JTabbedPane tabbedPane, Instructor instructor, JPanel outputPanel) {
        this.tabbedPane = tabbedPane;
        this.instructor = instructor;
        this.outputPanel = outputPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.outputPanel.removeAll();
        Course course = instructor.getCourses().get(tabbedPane.getSelectedIndex());
        ArrayList<String> examIds = course.getExamIds();
        this.outputPanel.setLayout(new GridLayout(course.getStudents().size() + 2 ,2));
        Color red = new Color(128, 0, 0);

        for (int j = 0; j < examIds.size(); j++ ) {


            JLabel iD = new JLabel("ID");
            iD.setForeground(red);
            this.outputPanel.add(iD);

            JLabel name = new JLabel("NAME");
            name.setForeground(red);
            this.outputPanel.add(name);

            JLabel examId = new JLabel("GRADES");
            examId.setForeground(red);
            this.outputPanel.add(examId);

            for (int i = 0; i < course.getStudents().size(); i++) {
                JLabel studentID = new JLabel(course.getStudents().get(i).getıD());
                this.outputPanel.add(studentID);
                JLabel studentName = new JLabel(course.getStudents().get(i).getName());
                this.outputPanel.add(studentName);
                JLabel studentGrade = new JLabel(String.valueOf(course.getStudents().get(i).getGradeItem(course.getiD(),examIds.get(j)).getGrade()));
                this.outputPanel.add(studentGrade);

            }
            JLabel average = new JLabel("Average");
            average.setForeground(red);
            this.outputPanel.add(average);

            JLabel empty = new JLabel("");
            this.outputPanel.add(empty);

            JLabel averageGrade = new JLabel(String.valueOf(instructor.getAverageGradeForExam(course.getiD(),examIds.get(j))));
            this.outputPanel.add(averageGrade);

        }
            this.outputPanel.revalidate();
            this.outputPanel.repaint();


    }
}
