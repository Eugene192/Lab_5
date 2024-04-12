package Main;


import CollectionManager.Commands.Command;
import CommandManager.CommandManager;
import static Model.JustScanner.Scan;

public class Main {
    public static void run() {
         CommandManager commandManager = new CommandManager();
         System.out.println("Введите команду 'help', чтобы посмотреть команды.");
         while (true) {
             System.out.print("Введите команду: ");
             String result = commandManager.findCommand(Scan().toLowerCase());
             if (result != null)
                System.out.println(result);
         }
    }

    public static void main(String[] args) {
        System.setProperty("path", "data.csv");
        Main.run();
    }
}