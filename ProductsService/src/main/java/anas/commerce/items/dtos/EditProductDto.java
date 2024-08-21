package anas.commerce.items.dtos;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EditProductDto extends ProductDTO {

    @NonNull
    private String id;

}
