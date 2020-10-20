package by.training.model;

import by.training.domain.PunctuationMark;
import by.training.domain.Sentence;
import by.training.domain.Text;
import by.training.domain.Word;
import by.training.domain.abstractions.LanguageUnit;
import java.util.*;


public class LookService {
    public List<Sentence> DuplicateWordsSentence(Text text) {
        List<Sentence> duplicateSentences = new ArrayList<>();
        List<Sentence> textSentences = (ArrayList)text.getComponentsList();
        Map<Word, Integer> repeatingWords = new HashMap<>();
        for (Sentence sentence : textSentences) {
            List<LanguageUnit> words = sentence.getComponentsList();
            words.removeIf(unit -> unit instanceof PunctuationMark);
            for (LanguageUnit word : words) {
                if (repeatingWords.containsKey((Word) word)) {
                    repeatingWords.put((Word) word, repeatingWords.get(word) + 1);
                } else {
                    repeatingWords.put((Word) word, 1);
                }
            }
        }
        Map.Entry<Word, Integer> mostRepeatingWord = null;
        for (Map.Entry<Word, Integer> entry : repeatingWords.entrySet()) {
            if (mostRepeatingWord == null || entry.getValue() > mostRepeatingWord.getValue()) {
                mostRepeatingWord = entry;
            }
        }
        for (Sentence sentence : textSentences) {
            assert mostRepeatingWord != null;
            if (sentence.getComponentsList().contains(mostRepeatingWord.getKey())) {
                duplicateSentences.add(sentence);
            }
        }
        return duplicateSentences;
    }
}
