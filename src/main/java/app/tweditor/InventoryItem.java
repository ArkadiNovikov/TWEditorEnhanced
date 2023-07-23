package app.tweditor;

public class InventoryItem
        implements Comparable<InventoryItem> {

    private final DBElement element;
    private final String name;
    private int count;

    public InventoryItem(String name, DBElement element)
            throws DBException {
        this.name = name;
        this.element = element;
        DBList fieldList = (DBList) element.getValue();
        this.count = fieldList.getInteger("StackSize");
    }

    public String getName() {
        return this.name;
    }

    public DBElement getElement() {
        return this.element;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if ((obj != null) && ((obj instanceof InventoryItem))
                && (((InventoryItem) obj).getName().equals(this.name))
                && (((InventoryItem) obj).getCount() == this.count)) {
            equal = true;
        }
        return equal;
    }

    @Override
    public int compareTo(InventoryItem obj) {
        int diff = this.name.compareTo(obj.getName());
        if (diff == 0) {
            int objCount = obj.getCount();
            if (this.count < objCount) {
                diff = -1;
            } else if (this.count > objCount) {
                diff = 1;
            } else {
                diff = 0;
            }
        }
        return diff;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", new Object[]{this.name, Integer.valueOf(this.count)});
    }
}
