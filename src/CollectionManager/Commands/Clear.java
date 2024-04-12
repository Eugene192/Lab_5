package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Очистить коллекцию
 */

public class Clear implements Command {
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        collection.clear();
        return "Коллекция очищена";
    }
}
