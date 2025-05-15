package bg.tu_varna.sit.a2.f23621757.commands.commands_interface;
/**
 * Общ интерфейс за всички командни обекти в системата.
 * <p>
 * Всеки клас, който имплементира този интерфейс, трябва да дефинира
 * поведението си чрез метода {@code executeCommand()}.
 */

public interface Command {
    void executeCommand();
}
