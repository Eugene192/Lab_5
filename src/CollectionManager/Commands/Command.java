package CollectionManager.Commands;

import java.util.LinkedHashSet;
import Model.SpaceMarine;

public interface Command {
    public String execute(LinkedHashSet<SpaceMarine> collection);
}
