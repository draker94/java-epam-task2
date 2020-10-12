package by.training.model.io;

import by.training.console.ComplexUnitInfo;
import by.training.domain.Sentence;
import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;

import java.io.*;
import java.util.List;

public class FileIO {

    public Text read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            return new Text(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void write(String path, List<LanguageUnit> sentences, boolean isDuplicate) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            if (isDuplicate) {
                for (LanguageUnit unit : sentences) {
                    bufferedWriter.write(unit.getUnitString());
                    bufferedWriter.write(System.lineSeparator());
                }
            }
            else {
                for (LanguageUnit unit : sentences) {
                    bufferedWriter.write(ComplexUnitInfo.printFullInfo((Sentence)unit));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
