package pt.iscte.mei.school.appointments.application.dto;


import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ApiModel(description = "Information's to register a new appointment")
public final class RegisterAppointmentDTO {

    @NotEmpty(message = "{RegisterAppointmentDTO.startDate.NotNull}")
    private List<LocalDateTime> startDates;

    @NotEmpty(message = "{RegisterAppointmentDTO.endDate.NotNull}")
    private List<LocalDateTime> endDates;

    @NotBlank(message = "{RegisterAppointmentDTO.classroomId.NotBlank}")
    private String classroomId;

    @NotBlank(message = "{RegisterAppointmentDTO.courseId.NotBlank}")
    private String courseId;

    @NotBlank(message = "{RegisterAppointmentDTO.curricularUnitId.NotBlank}")
    private String curricularUnitId;

    @NotNull(message = "{RegisterAppointmentDTO.capacity.NotNull}")
    private int capacity;

    @NotEmpty(message = "{RegisterAppointmentDTO.features.NotEmpty}")
    private List<String> features;
}
