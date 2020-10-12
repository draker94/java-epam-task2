package by.training.command;

import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;
import by.training.model.LookService;
import by.training.model.io.FileIO;
import java.util.List;

public class TextIOFileCommand {

    private FileIO fileIO;

    public Text read(String relativePath) {
        System.out.println("Попытка загрузки текста по пути - " + relativePath);
        fileIO = new FileIO();
        Text text = fileIO.read(relativePath);
        System.out.println("Текст успешно загружен");
        return text;
    }

    public void writeDuplicate(String relativePath, Text text) {
        LookService lookService = new LookService();
        List<LanguageUnit> sentences = lookService.DuplicateSentences(text);
        fileIO = new FileIO();
        System.out.println("Попытка записи предложений текста, в которых есть одинаковые слова в файд - "
        + relativePath);
        fileIO.write(relativePath, sentences, true);
        System.out.println("Текст успешно записан!");
    }

    public void writeParsedText(String relativePath, Text text) {
        List<LanguageUnit> sentences = text.getComponentsList();
        fileIO = new FileIO();
        System.out.println("Попытка записи текста, обработанного по языковым единицам в файл - "
                + relativePath);
        fileIO.write(relativePath, sentences, false);
        System.out.println("Текст успешно записан!");
    }
}

