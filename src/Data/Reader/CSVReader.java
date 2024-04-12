package Data.Reader;

import Data.Values;
import Model.SpaceMarine;

import java.io.*;
import java.util.LinkedHashSet;

public class CSVReader implements Reader{ // Класс чтения
    @Override
    public LinkedHashSet<SpaceMarine> read() { //LinkedHashSet - хранит в порядке добавления в HashMap
        LinkedHashSet<SpaceMarine> linkedHashSet = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Values.path)))  {
            linkedHashSet = (LinkedHashSet<SpaceMarine>) objectInputStream.readObject();
        }

        catch (IOException | ClassNotFoundException e) { // Ошибка ввода/вывода и ошибка ненахождения класса
            System.out.println(e.getMessage());
        }

        return linkedHashSet;
    }
}
