package com.viki.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentRequest {
    private String name;
    private AddressDto addressDto;
    private String courseId;
}
