package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */

public class Show implements Command {
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        StringBuilder stringBuilder = new StringBuilder("SpaceMarines:\n");

        for (SpaceMarine spaceMarine: collection) {
            stringBuilder.append(spaceMarine.toString()).append("\n");
        }

        return String.valueOf(stringBuilder);
    }
}
