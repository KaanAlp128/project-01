package model;

import java.util.ArrayList;

public class Course {
    private String iD;
    private String name;
    private Instructor instructor;
    private ArrayList<Student> students;
    private ArrayList<String> examIds;

    public Course(String iD, String name){
        this.iD = iD;
        this.name = name;
        students = new ArrayList<Student>();
        this.examIds = new ArrayList<String>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
    public String getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }
    public Instructor getInstructor() {
        return instructor;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void addExamId(String examId){

        for (int i = 0; i < examIds.size(); i++) {
            if (examIds.get(i).equals(examId)) {
                return;
            }
        }
        examIds.add(examId);

    }

    public ArrayList<String> getExamIds() {
        return examIds;
    }



    public void listStudents() {
        System.out.println("Students registered in " + getName() + " are:");
        for (int i = 0; i <students.size(); i++){
            System.out.println(students.get(i).getName());
        }
    }
    public String toString(){
        return iD + " " + name;

    }
}

