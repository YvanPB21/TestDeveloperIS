package com.test.interseguro.service;

import com.test.interseguro.model.Matrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService{

    @Override
    public Matrix rotateMatrix(Matrix matrix) {
        Integer[][] mat = matrix.getMatrix();
        int n = mat.length;
        for (int i = 0; i < n/ 2; i ++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][n - 1 - i];
                mat[j][n - 1 - i] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = temp;
            }
        }
        matrix.setMatrix(mat);
        return matrix;
    }
}
