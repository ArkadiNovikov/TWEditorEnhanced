package app.tweditor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LocalizedSubstring
        implements Cloneable {

    private String string;
    private int language;
    private int gender;

    @Override
    public Object clone() {
        Object clonedObject;
        try {
            clonedObject = super.clone();
        } catch (CloneNotSupportedException exc) {
            throw new UnsupportedOperationException("Unable to clone localized substring", exc);
        }

        return clonedObject;
    }
}
