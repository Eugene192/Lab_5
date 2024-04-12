package CollectionManager.Commands;

import Data.Writer.CSVWriter;
import Model.SpaceMarine;

import java.util.LinkedHashSet;

/**
 * Cохранить коллекцию в файл
 */

public class Save implements Command{
    @Override
    public String execute(LinkedHashSet<SpaceMarine> collection) {
        CSVWriter writer = new CSVWriter();
        writer.write(collection);
        return "Saved!";
    }
}
