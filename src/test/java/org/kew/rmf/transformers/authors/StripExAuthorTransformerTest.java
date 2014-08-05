package org.kew.rmf.transformers.authors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kew.rmf.transformers.Transformer;
import org.kew.rmf.transformers.authors.StripExAuthorTransformer;

public class StripExAuthorTransformerTest {

    @Test
    public void stripItSimple() throws Exception {
        Transformer transformer = new StripExAuthorTransformer();
        String author = "Someone ex Else";
        assertEquals("Else", transformer.transform(author));
    }

    @Test
    public void capitalEx() throws Exception {
        Transformer transformer = new StripExAuthorTransformer();
        String author = "Someone ex Else";
        assertEquals("Else", transformer.transform(author));
        author = "Someone Ex Else";
        assertEquals("Else", transformer.transform(author));
        author = "Someone eX Else";
        assertEquals("Else", transformer.transform(author));
        author = "Someone EX Else";
        assertEquals("Else", transformer.transform(author));
    }

}