package gui;

import java.util.Random;
import javax.swing.*;

import model.Course;
import model.Department;
import model.Student;

public class GuiMain {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Department myDepartment = createDepartment();

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Email:");
        panel.add(label);
        label.setBounds(330, 250, 80, 25);

        JTextField userInput = new JTextField(40);
        userInput.setBounds(360, 250, 260, 25);
        panel.add(userInput);

        JButton button = new JButton("Login");
        panel.add(button);
        emailCheckListener listener = new emailCheckListener(userInput, myDepartment);
        button.addActionListener(listener);
        button.setBounds(450, 280, 80, 25);
        frame.setVisible(true);

    }

    private static Department createDepartment() {

        Department department = new Department("Computer Science");

        department.addInstructor("Reyyan Yeniterzi");
        department.addInstructor("Reyhan Aydogan");
        department.addInstructor("Murat Sensoy");

        department.createCourse("CS102", "Object Oriented Programming");
        department.createCourse("CS201", "Data Structures");
        department.createCourse("CS101", "Introduction to CS");
        department.createCourse("CS404", "Digital Image Processing");
        department.createCourse("CS560", "Information Retrieval");

        department.assignInstructorToCourse("Reyyan Yeniterzi", "CS102");
        department.assignInstructorToCourse("Reyyan Yeniterzi", "CS560");
        department.assignInstructorToCourse("Reyhan Aydogan", "CS101");

        for (int i = 0; i < 10; i++)
            department.addStudent(createRandomName());

        Course oop = department.getCourse("CS102");
        for (int i = 0; i < 5; i++) {
            Student student = department.getStudents().get(i);
            student.registerToCourse(oop);
        }

        Course ir = department.getCourse("CS560");
        for (int i = 4; i < 8; i++) {
            Student student = department.getStudents().get(i);
            student.registerToCourse(ir);
        }

        return department;
    }


    private static String createRandomName() {
        String[] firstNames = {"Ali", "Ayse", "Ahmet", "Mehmet", "Mustafa", "Gizem", "Sibel", "Burak", "Bahar"};
        String[] lastNames = {"Yilmaz", "Caliskan", "Korkmaz", "Kaya", "Akar", "Sonmez", "Celikoglu"};

        Random random = new Random();

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String name = firstName + " " + lastName;

        return name;
    }


}
