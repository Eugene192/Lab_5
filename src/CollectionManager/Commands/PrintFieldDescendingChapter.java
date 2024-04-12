package CollectionManager.Commands;

import Model.Chapter;
import Model.SpaceMarine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Вывести значения поля chapter всех элементов в порядке убывания
 */
public class PrintFieldDescendingChapter implements Command {
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {

        Collections.sort(new ArrayList<SpaceMarine>(collection), Collections.reverseOrder());
        List<Chapter> values = collection.stream().map(el -> el.getChapter()).toList();
        StringBuilder stringBuilder = new StringBuilder("Chapters:\n");

        for (Chapter chapter: values) {
            if (chapter != null)
                stringBuilder.append(chapter).append("\n");
        }

        return String.valueOf(stringBuilder);
    }
}
