package Data;

import java.io.File;

public class Values { // Класс для хранения пути до файла
    public static final String separator = File.separator;
    public static final  String path = "src" + separator + "FileWithData" + separator + System.getProperty("path");
}
