package Model;

import java.util.*;

public class Identifiers { // Класс для индифицирования ID
    private static final List<Long> listID = new ArrayList<>();

    public static boolean have(long id) { return listID.contains(id); }

    public static Long generate() {
        if (listID.isEmpty()) {
            listID.add(1L);
            return 1L;
        }
        listID.add(listID.getLast() + 1);
        return listID.getLast();
    }

    public static boolean delete(Long id) {
        return listID.remove(id);
    }
}
