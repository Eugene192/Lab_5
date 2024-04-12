package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

public interface CommandWithArgument {
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument);
}
