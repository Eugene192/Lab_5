package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 *  Вывести любой объект из коллекции, значение поля id которого является максимальным
 */
public class MaxByID implements Command {
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        return collection.stream().max((o1, o2) -> o1.getId().compareTo(o2.getId())).stream().toList().getFirst().toString();
    }
}
