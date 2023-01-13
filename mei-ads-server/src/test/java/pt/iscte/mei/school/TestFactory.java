package pt.iscte.mei.school;

import java.util.UUID;

public class TestFactory {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
