package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 *  Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class AddIfMin implements CommandWithObjectArgument{
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, SpaceMarine spaceMarine) {
        SpaceMarine minSpaceMarine = collection.stream().min((o1, o2) -> o1.getId().compareTo(o2.getId())).stream().toList().getFirst();
        if (spaceMarine.getHealth() < minSpaceMarine.getHealth()) {
            collection.add(spaceMarine);
            return "SpaceMarine Добавлен!";
        }
        return "SpaceMarine Не был добавлен!";

    }
}
