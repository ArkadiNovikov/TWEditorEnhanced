package app.tweditor;

import java.util.List;

public class AlchemyIngredient {

    private final int id;
    private final List<String> substances;

    public AlchemyIngredient(int id, List<String> substances) {
        this.id = id;
        this.substances = substances;
    }

    public int getID() {
        return this.id;
    }

    public List<String> getSubstances() {
        return this.substances;
    }
}
