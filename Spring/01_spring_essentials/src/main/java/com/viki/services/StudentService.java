package com.viki.services;

import com.viki.dto.*;
import com.viki.entities.AddressEntity;
import com.viki.constants.AssetCategory;
import com.viki.entities.StudentEntity;
import com.viki.repositories.CourseRepository;
import com.viki.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<StudentDto> readAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentEntityEntity -> StudentDto.builder()
                        .id(studentEntityEntity.getId())
                        .name(studentEntityEntity.getName())
                        .address(studentEntityEntity.getAddressEntity() != null ? AddressDto.builder()
                                .area(studentEntityEntity.getAddressEntity().getArea())
                                .pinCode(studentEntityEntity.getAddressEntity().getPinCode())
                                .build() : null)
                        .course(CourseDto.builder()
                                .id(studentEntityEntity.getCourseEntity().getId())
                                .name(studentEntityEntity.getCourseEntity().getName())
                                .build())
                        .assets(studentEntityEntity.getAssetEntities().stream()
                                .map(assetEntity -> AssetDto.builder()
                                        .id(assetEntity.getId())
                                        .category(AssetCategory.valueOf(assetEntity.getCategory()))
                                        .name(assetEntity.getName())
                                        .build())
                                .toList())
                        .build())
                .toList();
    }

    public StudentDto create(CreateStudentDto createStudentDto) {
        var courseEntity = courseRepository.findById(createStudentDto.getCourseId()).get();
        var studentEntity = StudentEntity.builder()
                .name(createStudentDto.getName())
                .addressEntity(createStudentDto.getAddress() != null ? AddressEntity.builder()
                        .area(createStudentDto.getAddress().getArea())
                        .pinCode(createStudentDto.getAddress().getPinCode())
                        .build() : null)
                .courseEntity(courseEntity)
                .build();
        studentEntity.getAddressEntity().setStudentEntity(studentEntity);
        var updatedStudentEntity = studentRepository.save(studentEntity);
        return StudentDto.builder()
                .id(updatedStudentEntity.getId())
                .name(updatedStudentEntity.getName())
                .address(updatedStudentEntity.getAddressEntity() != null ? AddressDto.builder()
                        .area(updatedStudentEntity.getAddressEntity().getArea())
                        .pinCode(updatedStudentEntity.getAddressEntity().getPinCode())
                        .build() : null)
                .course(CourseDto.builder()
                        .id(updatedStudentEntity.getCourseEntity().getId())
                        .name(updatedStudentEntity.getCourseEntity().getName())
                        .build())
                .build();
    }
}
