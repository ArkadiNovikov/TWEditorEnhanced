package app.tweditor;

import lombok.Getter;

public class ItemTemplate
        implements Comparable<ItemTemplate> {

    @Getter
    private final DBList fieldList;
    @Getter
    private String itemName;
    private String resourceName;
    @Getter
    private int baseItem;

    public ItemTemplate(DBList fieldList)
            throws DBException {
        this.fieldList = fieldList;
        setupTemplate();
    }

    private void setupTemplate()
            throws DBException {
        this.baseItem = this.fieldList.getInteger("BaseItem");

        this.itemName = this.fieldList.getString("LocalizedName");

        this.resourceName = this.fieldList.getString("TemplateResRef");
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if ((obj != null) && ((obj instanceof ItemTemplate))
                && (((ItemTemplate) obj).getItemName().equals(this.itemName))) {
            equal = true;
        }
        return equal;
    }

    @Override
    public int compareTo(ItemTemplate obj) {
        return this.itemName.compareTo(obj.getItemName());
    }

    @Override
    public String toString() {
        return this.itemName + " (" + this.resourceName + ")";
    }
}
