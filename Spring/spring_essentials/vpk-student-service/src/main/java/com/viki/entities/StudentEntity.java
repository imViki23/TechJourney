package com.viki.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AddressEntity addressEntity;

    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity courseEntity;

    @OneToMany(mappedBy = "studentEntity")
    private List<AssetEntity> assetEntities;
}
