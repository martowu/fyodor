package uk.org.fyodor.generators;

import java.io.UnsupportedEncodingException;
import java.net.URI;

public class UriGenerator implements Generator<URI> {

    Generator<String> protocolGenerator = RDG.value("http://", "https://", "http://www.", "https://www.");
    Generator<String> domainGenerator = RDG.domain();
    Generator<String> suffixGenerator = RDG.domainSuffix();

    public URI next() {
        try {
            return URI.create(protocolGenerator.next() +
                    domainGenerator.next() +
                    "." +
                    new String(suffixGenerator.next().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("exception encoding URI", e);
        }
    }
}
