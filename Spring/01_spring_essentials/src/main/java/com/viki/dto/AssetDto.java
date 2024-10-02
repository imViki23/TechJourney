package com.viki.dto;

import com.viki.constants.AssetCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetDto {
    private Integer id;
    private String name;
    private AssetCategory category;
}
