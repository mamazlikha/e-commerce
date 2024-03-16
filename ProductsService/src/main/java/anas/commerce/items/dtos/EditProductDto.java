package anas.commerce.items.dtos;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class EditProductDto extends ProductDTO {

    @NonNull
    private String id;

}
