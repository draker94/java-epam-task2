package by.training;

import by.training.command.TextIOConsoleCommand;
import by.training.command.TextIOFileCommand;
import by.training.console.ComplexUnitInfo;
import by.training.domain.Text;


public class WordProcessor {

    public static void main(String[] args) {
        TextIOFileCommand textIOFileCommand = new TextIOFileCommand();
        Text textFromFile = textIOFileCommand.read("data/test.txt");
        System.out.println(ComplexUnitInfo.printFullInfo(textFromFile));
        textIOFileCommand.writeParsedText("data/test1.txt", textFromFile);
        textIOFileCommand.writeDuplicate("data/test2.txt", textFromFile);

        TextIOConsoleCommand textIOConsoleCommand = new TextIOConsoleCommand();
        Text textFromConsole = textIOConsoleCommand.read();
        textIOConsoleCommand.writeParsedText(textFromConsole);
        textIOConsoleCommand.writeDuplicate(textFromConsole);
    }
}
