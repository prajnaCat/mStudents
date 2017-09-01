package com.student.service;

import java.text.ParseException;
import java.util.ArrayList;

import com.model.Submit;

public interface StudentService {

	ArrayList queryStuSubmit();

	String saveStudentSubmit(Submit sub) throws Exception;

}
