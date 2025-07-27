package model;

import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Course> enrolledCourses;
    private  ArrayList<GradeItem> grades;

    public Student(String name) {
        super(name);
        setEmail(initEmail(name));
        enrolledCourses = new ArrayList<Course>();
        grades = new ArrayList<GradeItem>();
    }

    private String initEmail(String name) {

        String[] lastName = name.split(" ");
        String lastname = lastName[lastName.length - 1];
        String[] firstName = name.split(" ");
        String firstname = firstName[0];

        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@ozu.edu.tr";

    }


    public ArrayList<GradeItem> getGrades() {
        return grades;
    }

    public void registerToCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);


        if (course.getInstructor() == null) {
            System.out.println("Course not available");
        }
    }

    public void dropCourse(Course course) {
        course.removeStudent(this);
        enrolledCourses.remove(course);
    }

    public void addGrade(GradeItem grade) {
        for (int i = 0; i < grades.size(); i++) {

            if (grades.get(i).getCourseId().equals(grade.getCourseId()) && grades.get(i).getExamId().equals(grade.getExamId())) {
                grades.remove(i);

            }
        }
        grades.add(grade);
    }

    public GradeItem getGradeItem(String courseID, String examID) {
        int x = -1;

        for (int i = 0; i < grades.size(); i++) {

            if (grades.get(i).getCourseId().equals(courseID) && grades.get(i).getExamId().equals(examID)) {
                x = i;
            }
            if (x == -1) {
                return null;
            }
        }
            return grades.get(x);
    }

    public void listGrades(){
        for(int i = 0; i <grades.size();i++) {
            if(i != 0 ) {

                if (grades.get(i).getCourseId().equals(grades.get(i - 1).getCourseId())) {
                    System.out.println("[" + grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");

                }
                else {
                    System.out.println(grades.get(i).getCourseId() + " grades of " + this.getName() + " [" + grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");

                }
            }
            else {
                System.out.println(grades.get(i).getCourseId() + " grades of " + this.getName() + " [" + grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");
                }
            }
        }
    }




