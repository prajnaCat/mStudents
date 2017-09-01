package com.common.dao;

import java.util.List;

import com.model.StudentInfo;
import com.model.TeacherInfo;

public interface LoginDao {


	List<StudentInfo> loginStudent(String userid,String password);

	List<TeacherInfo> loginTeacher(String userid,String password);

}
