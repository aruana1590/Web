package kz.aruana15.Web.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DevelopersDtoResponse {
    @NotBlank(message = "fio should not be blank")
    private String fio;

    private Integer salary;

}
