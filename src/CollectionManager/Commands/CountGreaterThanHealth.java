package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Вывести количество элементов, значение поля health которых больше заданного
 */
public class CountGreaterThanHealth implements CommandWithArgument {

    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        try {
            int health = Integer.parseInt(argument);  // Заданное число health. Нужно преобразовать в число, так как на входе String.
            int count = 0;

            for (SpaceMarine spaceMarine: collection) {
                if (spaceMarine.getHealth() >= health) {
                    count++;
                }
            }

            return "Количество элементов: " + String.valueOf(count);
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return "Error!";
    }
}
