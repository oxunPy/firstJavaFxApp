package uz.akfa.firstjavafxapp.models;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Role{
    SIMPLE("code1"), SUPER("code2");

    private String code;

    private Role(String code){
        this.code = code;
    }

    public static Role decode(final String code) {
        return Stream.of(Role.values()).filter(role -> role.getCode().equals(code)).
                findFirst().orElse(null);

    }
    public String getCode(){
        return code;
    }
}
