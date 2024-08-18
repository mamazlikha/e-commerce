package anas.commerce.cartservice.dtos;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @Nullable
    private String id;

    @NonNull
    private String productEntityId;

    @NonNull
    private String supplierNumber;
}
