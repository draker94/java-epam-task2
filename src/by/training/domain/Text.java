package by.training.domain;

import by.training.domain.abstractions.ComplexUnit;
import by.training.domain.abstractions.LanguageUnit;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Text extends ComplexUnit {

    public Text(String unit) {
        super(unit);
    }

    @Override
    public List<LanguageUnit> getComponentsList() {
        if (componentsList != null) {
            return componentsList;
        } else {
            componentsList = new ArrayList<>();
            BreakIterator breakIterator = BreakIterator.getSentenceInstance();
            breakIterator.setText(unit);
            int index = 0;

            while (breakIterator.next() != BreakIterator.DONE) {
                String sentence = unit.substring(index, breakIterator.current());
                componentsList.add(new Sentence(sentence));
                index = breakIterator.current();
            }
            return componentsList;
        }
    }
}
