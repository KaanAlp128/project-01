package gui;

import model.Instructor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

public class InstructorFrame extends JFrame {

    private Instructor instructor;
    private JPanel panel;


    public InstructorFrame(Instructor instructor) {
        this.instructor = instructor;
        init();
    }

    private void init() {
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        JTabbedPane tabbedPane = new JTabbedPane();
        for (int i = 0; i < instructor.getCourses().size(); i++) {

            tabbedPane.addTab(instructor.getCourses().get(i).getiD(), makePanel());
            this.add(tabbedPane);


        }
        JPanel tabPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        tabPanel.add(tabbedPane);
        JButton listStudentsButton = new JButton("List Students");
        buttonPanel.add(listStudentsButton);

        JButton registerExamGradesButton = new JButton("Register Exam Grades");
        buttonPanel.add(registerExamGradesButton);

        JButton listGradesButton = new JButton("List Grades");
        buttonPanel.add(listGradesButton);


        tabPanel.setLayout(new GridLayout());
        tabPanel.setBounds(0,0,900,50);
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.setBounds(0,52,900,50);
        outputPanel.setBounds(0,200,900,300);

        this.add(tabPanel);
        this.add(buttonPanel);
        this.add(outputPanel);

        tabbedPane.addChangeListener(new tabChangeListener(outputPanel));
        listStudentsButton.addActionListener(new listStudentsListener(tabbedPane, instructor, outputPanel));
        listGradesButton.addActionListener(new listGradesListener(tabbedPane, instructor, outputPanel));
        registerExamGradesButton.addActionListener(new registerGradeListener(tabbedPane,instructor,outputPanel));

        this.setVisible(true);
    }

    private static JPanel makePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        return panel;

    }
}
