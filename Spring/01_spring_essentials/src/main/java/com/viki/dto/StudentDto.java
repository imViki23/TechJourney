package com.viki.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDto {
    private Integer id;
    private String name;
    private AddressDto address;
    private CourseDto course;
    private List<AssetDto> assets;
}
