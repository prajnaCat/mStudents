package com.student.dao;

import java.util.Date;
import java.util.List;

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.Submit;
import com.model.Task;
import com.model.ZhuanyeInfo;

public interface DataViewDao {

	List<Task> getAllFaBuDataView();

	List<Task> getTenthTask() throws Exception;

	ZhuanyeInfo getZhuanyeInfoById(String zhuanyeId);

	List<Submit> querySubmitByTaskId(String taskId);

	List<ClassInfo> queryClassInfoByZyid(String zhuanyeId);

	List<ResultInfo> queryAllResultInfo();

	List<Submit> getAllSubmitInfo();

	List<Submit> getSubmitByStuidAndCourseid(String stuid, String courseid);

	List<Submit> getTiJiaoDataViewByStuid(String stuid);

	List<ResultInfo> queryResultInfoByStuid(String stuid);

	List<ResultInfo> queryResultInfoByStuidAndPfstatus(String stuid);

	List<Task> queryTaskByTeaid(String teaid);

	List<Task> queryTaskByCourseid(String courseId);

	CourseInfo queryCourseByid(String courseId);

	List<Task> getTenthTaskByTeaid(String teaid)throws Exception;

	List<Submit> getSubmitInfoByTaskid(String taskId);

	List<ResultInfo> queryResultInfoByTime(String stuid, String start, String last);

}
