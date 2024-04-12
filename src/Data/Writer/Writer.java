package Data.Writer;

import Model.SpaceMarine;

import java.util.LinkedHashSet;

public interface Writer {
    public void write(LinkedHashSet<SpaceMarine> collection);
}
