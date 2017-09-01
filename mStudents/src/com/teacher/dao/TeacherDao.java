package com.teacher.dao;

import java.util.List;

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StudentInfo;
import com.model.Task;
import com.model.ZhuanyeInfo;

public interface TeacherDao {

	List<CourseInfo> queryCourse(String teaid);

	List<ZhuanyeInfo> queryZhuanYe();

	void saveFaBuTask(Task task);

	

	List<Task> queryTask();

	List<Task> queryTaskById(String id);

	List<Task> queryTaskByZyid(String zyid);



	List<StudentInfo> queryStudentBystuId(String stuid);

	List<CourseInfo> queryCourseBycourseid(String courseid);

	List<ZhuanyeInfo> queryZhuanyeByStuid(String zyid);

	List<Task> queryTaskByzhuanyeId(String zyid);

	List<Task> queryTaskByTeaid(String teaid);

	List<Task> queryZyidByTaskid(String taskid);

	List<ClassInfo> queryClassByZyid(String zyid);

	List<Task> queryCourseIdByTeaid(String teaid);

	List<Task> queryZyByCourseidAndTeaid(String courseid, String teaid);

	List<ZhuanyeInfo> queryZyByzyid(String zhuanyeId);

	List<ResultInfo> queryResultByResid(String resId);

	void saveResult(ResultInfo rf);

	List<Task> queryTaskByCouidAndZyid(String courseid, String zyid);
}
