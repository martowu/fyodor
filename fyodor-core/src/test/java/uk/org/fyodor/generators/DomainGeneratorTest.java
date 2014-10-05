package uk.org.fyodor.generators;

import org.junit.Test;
import uk.org.fyodor.BaseTestWithRule;

import static uk.org.fyodor.FyodorAssertions.assertThat;

public class DomainGeneratorTest extends BaseTestWithRule {

    Generator<String> domainGenerator = RDG.domain();

    @Test
    public void noInvalidCharacters(){
        for (int i = 0;i < 10000; i++) {
            String domain = domainGenerator.next();
            assertThat(domain.startsWith("-")).isFalse();
            assertThat(domain.endsWith("-")).isFalse();
        }
    }
}
