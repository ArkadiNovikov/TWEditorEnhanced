package app.tweditor;

import java.util.List;
import lombok.*;

@Value
public class AlchemyIngredient {
    
    private final int id;
    private final List<String> substances;
}
