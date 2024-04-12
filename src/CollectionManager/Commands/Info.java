package CollectionManager.Commands;

import Model.SpaceMarine;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Вывести в стандартный поток вывода информацию о коллекции
 */

public class Info implements Command{
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {
        if (collection.isEmpty())
            return "Коллекция пустая!";

        List<LocalDate> dates = collection.stream().map((SpaceMarine el) -> el.getCreationDate()).toList(); // Здесь получаем список дат
        LocalDate lastDay = dates.stream().max((el, el1) -> {
            if (el.equals(el1))
                return 0;
            else if (el.isBefore(el1))
                return -1;
            return 1;

        }).stream().toList().getFirst(); // Принимает Comparator, пишем здесь условия сравнения и получаем максимальную дату.

        return "Тип коллекции: " + collection.getClass() + "\n" + "Размер коллекции: " + collection.size() + "\n" + "Последний день редактирования: " + lastDay;

    }
}
