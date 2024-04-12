package CommandManager.Commands;

import CommandManager.CommandManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static Model.JustScanner.Scan;

public class ExecuteScript {  // Класс для инициализации команд в файле
    public void execute(String path) {

        CommandManager commandManager = new CommandManager();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                ) {
            String command;

            while ((command = bufferedReader.readLine()) != null) {
                if (!command.equalsIgnoreCase("execute_script")){
                    String element = commandManager.findCommand(command);
                    if (element != null){
                        System.out.println(element);
                    }
                }

            }
        }

        catch (IOException e) {  // Ошибка ввода/вывода
            System.out.println(e.getMessage());
        }
    }

}