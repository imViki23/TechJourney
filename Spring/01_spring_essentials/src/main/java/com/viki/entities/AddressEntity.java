package com.viki.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class AddressEntity {

    @Id
    private Integer id;

    private String area;

    private String pinCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private StudentEntity studentEntity;
}
