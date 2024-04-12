package CollectionManager.Commands;

import Model.Identifiers;
import Model.SpaceMarine;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Удалить из коллекции все элементы, меньшие, чем заданный
 */

public class RemoveLower implements CommandWithArgument{
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        try {
            long id = Long.parseLong(argument);
            List<SpaceMarine> objectList = new ArrayList<>();
            List<Long> idList = new ArrayList<>();

            for (SpaceMarine spaceMarine: collection) {
                if (id >= spaceMarine.getId()) {
                    objectList.add(spaceMarine);
                    idList.add(spaceMarine.getId());
                }
            }

            for (SpaceMarine spaceMarine: objectList) {
                collection.remove(spaceMarine);
            }

            for (Long objID: idList) {
                Identifiers.delete(objID);
            }

            return "Выполнено!";
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return "Ошибка";
    }
}
