package pt.iscte.mei.school.appointments.application.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor(staticName = "from")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ApiModel(description = "Information's to search the appointment registered")
public class SearchAppointmentDTO {

    @NotNull(message = "{RegisterAppointmentDTO.startDate.NotNull}")
    private LocalDateTime startDate;

    @NotNull(message = "{RegisterAppointmentDTO.endDate.NotNull}")
    private LocalDateTime endDate;
}
