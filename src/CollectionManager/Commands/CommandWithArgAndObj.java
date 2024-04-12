package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

public interface CommandWithArgAndObj {
    public String execute(LinkedHashSet<SpaceMarine> collection, String argument, SpaceMarine spaceMarine);
}
