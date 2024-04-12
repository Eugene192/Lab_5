package CollectionManager.Commands;

import Model.Identifiers;
import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Обновить значение элемента коллекции, id которого равен заданному
 */
public class UpdateByID implements CommandWithArgAndObj {
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument, SpaceMarine spaceMarine) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        try {
            long id = Long.parseLong(argument);
            if (Identifiers.have(id)) {
                Identifiers.delete(id);
                collection.add(spaceMarine);
                return "Добавлен!";
            }
            return "Такой ID не найден!";

        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return "Ошибка";
    }
}
