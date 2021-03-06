package uk.org.fyodor.generators;

import org.junit.Test;
import uk.org.fyodor.BaseTest;

import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyGeneratorTest extends BaseTest {

    @Test
    public void generateCurrencies(){
        Generator<Currency> generator = RDG.currency();
        for (int i = 0; i < 1000; i++) {
            Currency currency = generator.next();
            assertThat(currency.getCurrencyCode()).hasSize(3);
            print(currency);
        }

    }
}
