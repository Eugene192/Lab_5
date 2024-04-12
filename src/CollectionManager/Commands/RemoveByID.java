package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

/**
 * Удалить элемент из коллекции по его id
 */

public class RemoveByID implements CommandWithArgument {

    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        try {
            int id = Integer.parseInt(argument);
            SpaceMarine spaceMarine = collection.stream().filter(el -> el.getId() == id).toList().getFirst();
            if (spaceMarine == null)
                return "ID не найден!";

            collection.remove(spaceMarine);
            return "SpaceMarine удален!";

        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка формата числа");
        }
        catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
        return null;
    }
}
