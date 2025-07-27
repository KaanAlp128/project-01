package model;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;
    private ArrayList<Student> students;

    public Department(String name) {
        this.name = name;
        courses = new ArrayList<Course>();
        instructors = new ArrayList<Instructor>();
        students = new ArrayList<Student>();
    }

    public void addInstructor(String name) {
        Instructor instructor = new Instructor(name);
        instructors.add(instructor);
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        students.add(student);

    }

    public void assignInstructorToCourse(String instructorName, String courseID) {
        int check1 = 0;
        int check2 = 0;
        int x = -1;
        int y = -1;

        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getName().equals(instructorName)) {
                check1 = 1;
                x = i;
                break;
            }
        }

        if(check1 == 0){
            System.out.println("Instructor not found: " + instructorName);
        }

        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getiD().equals(courseID)) {
                check2 = 1;
                y = i;
                break;

            }
        }

        if(check2 == 0){
            System.out.println("Course not found: " + courseID);
        }

        if(check1 == 1 && check2 == 1){
               courses.get(y).setInstructor(instructors.get(x));
               instructors.get(x).addCourse(courses.get(y));

        }

    }

    public void createCourse(String iD, String name) {
        Course course = new Course(iD, name);
        courses.add(course);
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public Course getCourse(String courseParameter) {
        int x = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(courseParameter) || courses.get(i).getiD().equals(courseParameter)) {
                x = i;
                break;
            }

        }
        if(x == -1){

            return null;

        }
        return courses.get(x);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Instructor getInstructorByName(String name) {
        int x = -1;
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getName().equals(name)) {
                x = i;
                break;
            }
        }
        if(x == -1 ){

            return null;
        }
        return instructors.get(x);
    }

    public void listInstructors() {

      System.out.println("Instructors registered in this department are: ");
        for (int i = 0; i <instructors.size(); i++){
            System.out.println(instructors.get(i));

        }
    }

    public void listCourses() {
         System.out.println("Courses given by this department are: ");
         int  x = 0;
         for(int i = 0; i < courses.size(); i++) {

         if (instructors.get(x).getCourses().size() != 0) {
             if(courses.get(i).getName().equals(instructors.get(x).getCourses().get(0).getName())) {
                 System.out.println(courses.get(i) + " by " + instructors.get(x).getName());
                 x++;
             } else {
                 System.out.println(courses.get(i));
             }
         }
         else{
                 System.out.println(courses.get(i));
             }
     }
        }


    public void listStudents() {

        System.out.println("Students registered in this department are: ");
        for (int i = 0; i <students.size(); i++){
            System.out.println(students.get(i));

        }
    }
}

