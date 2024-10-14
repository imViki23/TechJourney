package com.viki.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentDto {
    private String name;
    private AddressDto address;
    private String courseId;
}
