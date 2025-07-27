package model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<Course> courses;


    public Instructor(String name) {
        super(name);
        setEmail(initEmail(name));
        courses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    private String initEmail(String name) {

        String[] lastName = name.split(" ");
        String lastname = lastName[lastName.length - 1];
        String[] firstName = name.split(" ");
        String firstname = firstName[0];

        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@ozyegin.edu.tr";

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void registerExamGrades(String courseId, String examId, ArrayList<Integer> examGrades) {

        int check = 0;
        int x = 0;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getiD().equals(courseId)) {
                check = 1;
                x = i;
                break;
            }
        }
        if (check == 0) {
            System.out.println("Instructor " + this.getName() + " cannot grade the " + courseId + ".");
        }
        if (check == 1) {

            for (int i = 0; i < courses.get(x).getStudents().size(); i++) {
                GradeItem grade = new GradeItem(courseId, examId, examGrades.get(i));
                courses.get(x).getStudents().get(i).addGrade(grade);

            }

        }
    }

    public void listGradesForExam(String courseId, String examId) {
        System.out.println(courseId + " " + examId + " grades are: ");
        int check = 0;
        int x = -1;
        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getiD().equals(courseId)) {
                check = 1;
                x = i;
                break;
            }
        }
        if (check == 1) {
            for (int i = 0; i < courses.get(x).getStudents().size(); i++) {
                System.out.println(courses.get(x).getStudents().get(i) + ": [" + courses.get(x).getStudents().get(i).getGradeItem(courseId, examId).getExamId() + ": " + courses.get(x).getStudents().get(i).getGradeItem(courseId, examId).getGrade() + " ]");
            }
        }
    }

    public void printAverageGradeForExam(String courseId, String examId) {
        int check = 0;
        int x = -1;
        double TotalGrade = 0;
        int NumberOfGrades = 0;
        double AverageGrade = 0;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getiD().equals(courseId)) {
                check = 1;
                x = i;
                break;
            }
        }
        if (check == 1) {

            for (int i = 0; i < courses.get(x).getStudents().size(); i++) {

                TotalGrade += courses.get(x).getStudents().get(i).getGradeItem(courseId, examId).getGrade();
                NumberOfGrades++;
            }
            AverageGrade = TotalGrade / NumberOfGrades;
            System.out.println(courseId + " " + examId + " average grade is: " + AverageGrade);
        }
    }

        public double getAverageGradeForExam (String courseId, String examId){
            int check = 0;
            int x = -1;
            double TotalGrade = 0;
            int NumberOfGrades = 0;
            double AverageGrade = 0;

            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getiD().equals(courseId)) {
                    check = 1;
                    x = i;
                    break;
                }
            }
            if (check == 1) {

                for (int i = 0; i < courses.get(x).getStudents().size(); i++) {

                    TotalGrade += courses.get(x).getStudents().get(i).getGradeItem(courseId, examId).getGrade();
                    NumberOfGrades++;
                }
                AverageGrade = TotalGrade / NumberOfGrades;

            }

                return AverageGrade;
        }


}