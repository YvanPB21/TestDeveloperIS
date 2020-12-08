package com.test.interseguro.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveMatrixResource {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 9999999)
    private Integer[][]matrix;
}
