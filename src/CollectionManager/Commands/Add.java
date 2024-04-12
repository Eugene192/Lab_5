package CollectionManager.Commands;

import Model.Identifiers;
import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Добавить новый элемент в коллекцию
 */
public class Add implements CommandWithObjectArgument{
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, SpaceMarine spaceMarine) {
        collection.add(spaceMarine);
        return "SpaceMarine добавлен!";
    }
}
