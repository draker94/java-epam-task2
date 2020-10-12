package by.training.model.io;

import by.training.console.ComplexUnitInfo;
import by.training.domain.Sentence;
import by.training.domain.Text;
import by.training.domain.abstractions.ComplexUnit;
import by.training.domain.abstractions.LanguageUnit;

import java.io.*;
import java.util.List;

public class ConsoleIO {

    public Text read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return new Text(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void write(List<LanguageUnit> sentences, boolean isDuplicate) {
        if (isDuplicate) {
            sentences.forEach(System.out::println);
        }
        else {
            sentences.forEach(unit -> ComplexUnitInfo.printFullInfo((Sentence)unit));
        }
    }
}
