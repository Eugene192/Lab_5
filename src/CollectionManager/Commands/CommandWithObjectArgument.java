package CollectionManager.Commands;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

public interface CommandWithObjectArgument {
    public String execute(LinkedHashSet<SpaceMarine> collection, SpaceMarine spaceMarine);
}
