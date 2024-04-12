package CollectionManager;

import CollectionManager.Commands.*;
import Data.Reader.CSVReader;
import Model.SpaceMarine;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Класс для управления командами, которое взаимодействуют с коллекцией
 */
public class CollectionManager {
    private final HashMap<String, Command> commands = new HashMap<>();
    private final HashMap<String, CommandWithArgument> commandsWithArgument = new HashMap<>();
    private final HashMap<String, CommandWithObjectArgument> commandsWithObjectArgument = new HashMap<>();
    private final HashMap<String, CommandWithArgAndObj> commandWithArgAndObj = new HashMap<>();

    private LinkedHashSet<SpaceMarine> collection;

    public CollectionManager() {  // Конструктор коллекции
        CSVReader csvReader = new CSVReader();
        this.collection = csvReader.read();
        if (this.collection == null)
            this.collection = new LinkedHashSet<>();

        this.commands.put("clear", new Clear());
        this.commands.put("show", new Show());
        this.commands.put("save", new Save());
        this.commands.put("info", new Info());
        this.commands.put("max_by_id", new MaxByID());
        this.commands.put("print_field_descending_chapter", new PrintFieldDescendingChapter());

        this.commandsWithArgument.put("remove_by_id", new RemoveByID());
        this.commandsWithArgument.put("count_greater_than_health", new CountGreaterThanHealth());
        this.commandsWithArgument.put("remove_lower", new RemoveLower());
        this.commandsWithArgument.put("remove_greater", new RemoveGreater());

        this.commandsWithObjectArgument.put("add", new Add());
        this.commandsWithObjectArgument.put("add_if_min", new AddIfMin());

        this.commandWithArgAndObj.put("update_by_id", new UpdateByID());
    }

    public String findCommand(String userLine) {    // Метод по чтению введенной команды
        if (userLine.isEmpty() || userLine.replaceAll(" ", "").isEmpty())
            return "Напиши команду!";

        String[] values = userLine.split(" ");
        String command = values[0];

        if (values.length == 1) {
            if (this.commandsWithObjectArgument.containsKey(command))
                return this.commandsWithObjectArgument.get(command).execute(this.collection, new SpaceMarine());

            else if (commands.containsKey(command))
                return this.commands.get(command).execute(this.collection);
        }

        else if (values.length == 2 && values[1].charAt(0) == '{' && values[1].charAt(values[1].length() - 1) == '}') {
            String argument = values[1].replaceAll("\\{", "").replaceAll("}", "");

            if (commandsWithArgument.containsKey(command))
                return this.commandsWithArgument.get(command).execute(this.collection, argument);

            else if (commandWithArgAndObj.containsKey(command))
                return this.commandWithArgAndObj.get(command).execute(this.collection, argument, new SpaceMarine());
        }

        return "Неизвестная команда!";
    }

}