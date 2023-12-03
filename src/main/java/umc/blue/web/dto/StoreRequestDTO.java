package umc.blue.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

public class StoreRequestDTO {

    @Getter
    public static class addDTO {
        @NotBlank
        String storeName;
        @NotBlank
        String storeAddress;
        @Size(min=9, max=12)
        String storePhone;
        String openTime;
        String closeTime;
        @NotNull
        Long regionId;
    }
}
