package uk.org.fyodor.generators;

import org.junit.Test;
import uk.org.fyodor.BaseTestWithRule;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class NINumberGeneratorTest extends BaseTestWithRule {

    Pattern niNumberPattern = Pattern.compile("^(?!BG)(?!GB)(?!NK)(?!KN)(?!TN)(?!NT)(?!ZZ)(?:[A-CEGHJ-PR-TW-Z][A-CEGHJ-NPR-TW-Z])(?:\\s*\\d\\s*){6}([A-D]|\\s)$");

    @Test
    public void generateNINumbers(){
        Generator<String> generator = RDG.niNumber();
        for (int i = 0; i < 1000; i++) {
            String niNumber = generator.next();
            assertThat(niNumberPattern.matcher(niNumber).matches()).isTrue();
        }
    }
}
