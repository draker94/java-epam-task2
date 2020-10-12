package by.training.command;

import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;
import by.training.model.LookService;
import by.training.model.io.ConsoleIO;

import java.util.List;

public class TextIOConsoleCommand {
    private ConsoleIO consoleIO;

    public Text read() {
        consoleIO = new ConsoleIO();
        Text text = consoleIO.read();
        System.out.println("Текст успешно загружен");
        return text;
    }

    public void writeDuplicate(Text text) {
        LookService lookService = new LookService();
        List<LanguageUnit> sentences = lookService.DuplicateSentences(text);
        consoleIO = new ConsoleIO();
        consoleIO.write(sentences, true);
        System.out.println("Текст успешно записан!");
    }

    public void writeParsedText(Text text) {
        List<LanguageUnit> sentences = text.getComponentsList();
        consoleIO = new ConsoleIO();
        consoleIO.write(sentences, false);
        System.out.println("Текст успешно записан!");
    }

}
