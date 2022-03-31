package uz.akfa.firstjavafxapp.StudentsData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import uz.akfa.firstjavafxapp.models.Student;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LineBasedJsonReader {

    public static void readAllDataByLine() throws IOException {
        FileReader fileReader = new FileReader(Students.file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);



        // reading file line by line
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static Set<Student> getAllStudentsFromFile(){
        Stream<String> lines = null;
        try {
            FileInputStream stream = new FileInputStream(Students.file);
            lines = new BufferedReader(new InputStreamReader(stream)).lines();
        }catch(IOException e){
            e.printStackTrace();;
        }
        ArrayList<Map<String, String>> list = new ArrayList<>();

        Consumer<? super Object> consumer = new Consumer<Object>() {
            @Override
            public void accept(Object o) {
//                System.out.println((Student) o);
                list.add((Map) o);
            }
        };

        JSONParser parser = new JSONParser();
        ContainerFactory containerFactory = new ContainerFactory() {
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap();
            }

            @Override
            public List creatArrayContainer() {
                return new LinkedList();
            }
        };


        lines.map(x -> {
            try {
                return (Map) parser.parse(x, containerFactory);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).forEach(consumer);
//        System.out.println(list);

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
        objectMapper.disable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
        Set<Student> students = new HashSet<>();
        System.out.println(list);
        list.forEach(stringStringMap -> students.add(objectMapper.convertValue(stringStringMap, Student.class)));
        return students;
    }

//    private static ObjectMapper createObjectMapper(){
//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
//        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
//        return mapper;
//    }

}
