package anas.commerce.inventoryservice.dtos;


import com.mongodb.lang.Nullable;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ItemDto {


    @Nullable
    private String id;

    @NonNull
    private String productEntityId;

    @NonNull
    private String supplierNumber;

}
