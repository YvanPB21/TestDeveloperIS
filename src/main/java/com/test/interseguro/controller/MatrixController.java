package com.test.interseguro.controller;

import com.test.interseguro.model.Matrix;
import com.test.interseguro.resource.MatrixResource;
import com.test.interseguro.resource.SaveMatrixResource;
import com.test.interseguro.service.MatrixService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MatrixController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MatrixService matrixService;

    @PostMapping("/matrices")
    public MatrixResource rotateMatrix(@Valid @RequestBody SaveMatrixResource resource)  {
        Matrix matrix = convertToEntity(resource);
        return convertToResource(matrixService.rotateMatrix(matrix));
    }

    private Matrix convertToEntity(SaveMatrixResource resource) {
        return mapper.map(resource, Matrix.class);
    }

    private MatrixResource convertToResource(Matrix entity) {
        return mapper.map(entity, MatrixResource.class);
    }
}
