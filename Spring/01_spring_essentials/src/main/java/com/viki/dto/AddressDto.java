package com.viki.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String area;
    private String pinCode;
}
