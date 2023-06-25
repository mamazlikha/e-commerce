package anas.commerce.items.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class ItemDTO {

    @Nullable
    private Long id;

    @NonNull
    private double price;

    @NonNull
    private int quantity;

    @NonNull
    private String description;
}
