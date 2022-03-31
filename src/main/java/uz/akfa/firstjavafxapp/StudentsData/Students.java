package uz.akfa.firstjavafxapp.StudentsData;

import uz.akfa.firstjavafxapp.models.Role;
import uz.akfa.firstjavafxapp.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Students {
    public static File file = new File("C:/Users/cshar/OneDrive/Desktop/data.json");
    private static FileWriter fileWriter;
    public Students(){
        try{
            FileWriter fileWriter = new FileWriter(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static FileWriter getFileWriter(){
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWriter;
    }

    public static Set<Student> getStudentList() {
        return LineBasedJsonReader.getAllStudentsFromFile();
    }

    private static void fillStudentList() {
        Set<Student> studentList = new HashSet<>();
        studentList.add(new Student(1L, "Alex", "Boy", Role.SIMPLE, "555"));
        studentList.add(new Student(2L, "Taylor", "Swift", Role.SIMPLE, "sfsf"));
        studentList.add(new Student(3L, "Carol", "CASPIAN", Role.SIMPLE, "123"));
        studentList.add(new Student(4L, "Zack", "King", Role.SUPER, "sfsfcbc"));
        studentList.add(new Student(5L, "admin", "Black", Role.SIMPLE, "6767hjh"));
        studentList.add(new Student(6L, "Simon", "Says", Role.SUPER, "vbnbn"));
        studentList.add(new Student(7L, "Teddie", "Bear", Role.SIMPLE, "213456"));
        studentList.add(new Student(8L, "Michael", "Tyson", Role.SIMPLE, "zczxqwd"));

        LineBasedJsonWrite.writeList(studentList, getFileWriter());
    }

    public static void main(String[] args) {
        fillStudentList();
        System.out.println(LineBasedJsonReader.getAllStudentsFromFile());

    }
}