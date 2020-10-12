package by.training.model.io;

import by.training.console.ComplexUnitInfo;
import by.training.domain.Sentence;
import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;
import java.io.*;
import java.util.List;

public class ConsoleIO {

    public Text read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while (!((str = reader.readLine()).equalsIgnoreCase("конец"))) {
                stringBuilder.append(str);
            }
            Text text = new Text(stringBuilder.toString());
            System.out.println("Текст успешно загружен");
            return text;
        } catch (IOException e) {
            System.out.println("Во время загрузки текста произошла ошибка!");
            e.printStackTrace();
            return null;
        }
    }

    public void write(List<LanguageUnit> sentences, boolean isDuplicate) {
        if (isDuplicate) {
            System.out.println("Предложения текста, в которых есть одинаковые слова: ");
            sentences.forEach(sentence -> System.out.println(sentence.getUnitString()));
        } else {
            System.out.println("Обработка текста по языковым единицам: ");
            sentences.forEach(sentence -> System.out.println(ComplexUnitInfo.printFullInfo((Sentence) sentence)));
        }
    }
}
