package anas.commerce.inventoryservice.dtos;


import com.mongodb.lang.Nullable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ItemDto {


    @Nullable
    private String id;

    @NonNull
    private String productEntityId;

}
