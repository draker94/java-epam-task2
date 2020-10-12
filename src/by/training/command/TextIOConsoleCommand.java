package by.training.command;

import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;
import by.training.model.LookService;
import by.training.model.io.ConsoleIO;
import java.util.List;

public class TextIOConsoleCommand {
    private ConsoleIO consoleIO;

    public Text read() {
        System.out.println("Скопируйте в консоль текст для загрузки. Для завершениия операции введите " +
                "с новой строки \"Конец\"");
        consoleIO = new ConsoleIO();
        return consoleIO.read();
    }

    public void writeDuplicate(Text text) {
        LookService lookService = new LookService();
        List<LanguageUnit> sentences = lookService.DuplicateSentences(text);
        consoleIO = new ConsoleIO();
        consoleIO.write(sentences, true);
        System.out.println("Текст выведен на экран!");
    }

    public void writeParsedText(Text text) {
        List<LanguageUnit> sentences = text.getComponentsList();
        consoleIO = new ConsoleIO();
        consoleIO.write(sentences, false);
        System.out.println("Текст выведен на экран!");
    }
}
