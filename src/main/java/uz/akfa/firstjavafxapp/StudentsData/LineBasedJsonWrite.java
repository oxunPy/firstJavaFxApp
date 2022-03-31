package uz.akfa.firstjavafxapp.StudentsData;

import org.json.simple.JSONObject;
import uz.akfa.firstjavafxapp.models.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class LineBasedJsonWrite {

    // write into file
    public static void write(Student student, FileWriter fileWriter) {
        try {
            fileWriter.write(getJsonObject(student).toJSONString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeList(Set<Student> studentSet, FileWriter fileWriter) {

        studentSet.forEach(student -> {
            try {
                fileWriter.write(getJsonObject(student).toJSONString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getJsonObject(Student student) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", student.getId());
        jsonObject.put("firstName", student.getFirstName());
        jsonObject.put("lastName", student.getLastName());
        jsonObject.put("password", student.getPassword());
        return jsonObject;
    }



}



