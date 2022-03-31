//package uz.akfa.firstjavafxapp.models;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.type.MapType;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class RoleDeserializer extends JsonDeserializer<Role> {
//
//    @Override
//    public Role deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
//        final String value = p.getValueAsString();
//        final Map<String, String> map = deserializeAsMap(value, (ObjectMapper) p.getCodec(), ctxt);
//
//        return Role.decode(value);
//    }
//
//    private Map<String, String> deserializeAsMap(String value, ObjectMapper mapper, DeserializationContext ctxt) throws IOException {
//        final MapType mapType = ctxt.getTypeFactory().constructMapType(Map.class, String.class, String.class);
//        return mapper.readValue(value, mapType);
//    }
//}
