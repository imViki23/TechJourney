package com.viki.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student {
    private Integer id;
    private String name;
    private AddressDto addressDto;
    private Role role;
    private List<AssetDto> assetDtos;
}
