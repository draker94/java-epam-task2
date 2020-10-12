package by.training.model;

import by.training.domain.PunctuationMark;
import by.training.domain.Sentence;
import by.training.domain.Text;
import by.training.domain.abstractions.LanguageUnit;
import java.util.*;

public class LookService {

    public List<LanguageUnit> DuplicateSentences(Text text) {
        List<LanguageUnit> duplicateSentences = new ArrayList<>();
        List<LanguageUnit> textSentences = text.getComponentsList();

        for (LanguageUnit sentence : textSentences) {
            List<LanguageUnit> words = ((Sentence)sentence).getComponentsList();
            words.removeIf(unit -> unit instanceof PunctuationMark);
            Set<LanguageUnit> setWords = new HashSet<>(words);
            if (setWords.size() != words.size()) {
                duplicateSentences.add(sentence);
            }
        }
        return duplicateSentences;
    }

}
