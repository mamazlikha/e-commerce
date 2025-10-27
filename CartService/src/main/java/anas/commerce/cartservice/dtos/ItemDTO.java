package anas.commerce.cartservice.dtos;

import com.mongodb.lang.Nullable;
import lombok.*;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @Nullable
    private String id;

    @NonNull
    private String productEntityId;
}
