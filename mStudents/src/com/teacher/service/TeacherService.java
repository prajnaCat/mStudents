package com.teacher.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.Task;

public interface TeacherService {

	ArrayList queryCourse(String teaid);

	ArrayList queryZhuanYe();

	void saveFaBuTask(Task task);

	ArrayList queryTaskById(String id);

	ArrayList queryCourseByStuid(String stuid);

	ArrayList queryZhuanyeByStuid(String stuid);

	ArrayList queryTaskByzhuanyeId(String zyid);

	ArrayList queryTaskByTeaid(String teaid);

	ArrayList queryClassBytaskid(String taskid);

	ArrayList queryCourseByTeaid(String teaid);

	ArrayList queryZyByCourseidAndTeaid(String courseid, String teaid);

	ArrayList queryClassByZyid(String zhuanyeId);

	void updatePingFen(List<ResultInfo> res) throws ParseException;

	ArrayList queryTaskByCouidAndZyid(String courseid, String zyid);

	ArrayList queryCourseByzhuanyeId(String zyid);

}
