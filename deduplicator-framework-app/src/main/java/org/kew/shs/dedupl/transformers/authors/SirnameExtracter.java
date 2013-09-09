package org.kew.shs.dedupl.transformers.authors;

import org.kew.shs.dedupl.transformers.RegexDefCollection;
import org.kew.shs.dedupl.transformers.Transformer;
import org.kew.shs.dedupl.util.LibraryRegister;

@LibraryRegister(category="transformers")
public class SirnameExtracter extends RegexDefCollection implements Transformer {

    public String transform(String s) {
        // Linnaeus special: first we remove the Dot after <L> in order to make it appear as a sirname,
        //  but only where it's very likely to be Linnaeus; afterwards we'll add it again.
        s = s.replaceAll(String.format("L\\.(?=\\s)", ALPHANUMDIAC), "L ");
        String chars = String.format("(?<!%s)(-*%s\\.\\s*)(?=[^$\\)])", ALPHANUMDIAC, ALPHANUMDIAC);
        s = s.replaceAll(chars, "");
        return s.replaceAll("L ", "L\\.");
    }

}
