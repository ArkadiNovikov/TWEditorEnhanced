package app.tweditor;

public abstract class DBElementValue
        implements Cloneable {

    @Override
    public Object clone() {
        Object clonedObject;
        try {
            clonedObject = super.clone();
        } catch (CloneNotSupportedException exc) {
            throw new UnsupportedOperationException("Unable to clone database element value", exc);
        }

        return clonedObject;
    }
}
