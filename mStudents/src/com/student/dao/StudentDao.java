package com.student.dao;

import java.util.List;

import com.model.CourseInfo;
import com.model.Submit;
import com.model.Task;

public interface StudentDao {

	void queryStuSubmit();

	List<Task> queryTaskByTaskid(String taskId);

	List<CourseInfo> queryCourseId(String courseId);

	List<Submit> querySubmitBytaskidAndstuid(String taskid, String stuid);

	void saveStuSubmit(Submit sub);

	void updateStuSubmit(Submit sub);

}
