package uk.org.fyodor.generators;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Before;
import org.junit.Test;
import uk.org.fyodor.BaseTest;
import uk.org.fyodor.generators.characters.CharacterFilter;
import uk.org.fyodor.generators.characters.LettersAndDigitsFilter;
import uk.org.fyodor.generators.characters.LettersOnlyFilter;
import uk.org.fyodor.generators.characters.NoDoubleQuotesFilter;

import static org.assertj.core.api.Assertions.assertThat;

public class StringGeneratorTest extends BaseTest {

    private static final int SIZE_OF_RANDOM_STRING = 50;
    private Multiset<Character> chars;

    @Before
    public void charSet() {
        chars = HashMultiset.create();
    }

    @Test
    public void lettersOnly() {
        generateRandomStringsForCharSet(LettersOnlyFilter.getFilter());
    }

    @Test
    public void lettersAndNumbersOnly() {
        generateRandomStringsForCharSet(LettersAndDigitsFilter.getFilter());
    }

    @Test
    public void allCharsString() {
        generateRandomStringsForCharSet(NoDoubleQuotesFilter.getFilter());
    }

    @Test
    public void stringAsCharSet() {
        StringGenerator generator = new StringGenerator(1, "ABCDEFG");
        for (int i = 0; i < 1000; i++) {
            String val = generator.next();
            assertThat(val.length()).isEqualTo(1);
            chars.add(val.charAt(0));
        }
        assertThat(chars.elementSet()).hasSize(generator.getCharSet().length);
        assertThat(chars.elementSet()).containsOnly('A', 'B', 'C', 'D', 'E', 'F', 'G');
    }

    @Test
    public void cannotChangeCharset() {
        StringGenerator generator = new StringGenerator(SIZE_OF_RANDOM_STRING);
        char[] chars = generator.getCharSet();
        chars[0] = chars[chars.length - 1];
        assertThat(chars).isNotEqualTo(generator.getCharSet());
    }

    private void generateRandomStringsForCharSet(CharacterFilter filter) {
        StringGenerator generator = new StringGenerator(SIZE_OF_RANDOM_STRING, filter);
        for (int i = 0; i < 1000; i++) {
            String val = generator.next();
            assertThat(val).hasSize(SIZE_OF_RANDOM_STRING);
            for (char c : val.toCharArray()) {
                chars.add(c);
            }
        }
        assertThat(chars.elementSet()).hasSize(generator.getCharSet().length);
        for (char c : generator.getCharSet()) {
            assertThat(chars.elementSet()).contains(c);
        }
    }
}
