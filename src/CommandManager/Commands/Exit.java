package CommandManager.Commands;

public class Exit implements CommandM {
    /**
     * Завершить программу (без сохранения в файл)
     */

    @Override
    public void execute() { System.exit(69); }
}
