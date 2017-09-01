package com.common.dao;

import java.util.List;

import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StuDocInfo;
import com.model.StudentInfo;
import com.model.Submit;
import com.model.Task;
import com.model.TeaDocInfo;
import com.tool.Page;

public interface CommonDao {

	List<Submit> querySubDetailThress(String taskId, String classId, Page page) throws Exception;

	StudentInfo queryStudentBystuid(String string);

	Task queryTaskBytaskid(String taskid);

	StuDocInfo queryStuDocBydocid(String stuDocId);

	List<Submit> querySubmitBysubid(String subId);

	void saveSubmit(Submit ss);

	List<Submit> querySubDetailByStuIdAndTaskid(String stuId, String courseId
			) throws Exception;

	List<Submit> querySubDetailByStuId(String stuId, Page page) throws Exception;

	List<Task> queryTaskByCouidAndZyid(String courseId, String zhuanyeId);

	List<StudentInfo> queryStudentsByclassid(String classId,Page page) throws Exception;

	List<Submit> querySubmitByStuidAndCouid(String stuId, String courseId) ;

	List<Submit> querySubmitByStuidAndCouidAndTistatus(String stuId,
			String courseId);

	void saveResult(ResultInfo res);

	List<ResultInfo> queryResultBycouidAndclassid(String courseId, String classId,
			Page page) throws Exception;

	List<ResultInfo> queryResultByResid(String resId);

	void updateResInfo(ResultInfo res);

	TeaDocInfo queryTeaDocById(String teadocid);

	List<Task> queryTaskBycourseid(String courseId,String stuid, Page page) throws Exception;

	CourseInfo queryCourseInfoBycoid(String courseId);

	List<ResultInfo> queryPageResultByStuId(String stuid, Page page) throws Exception;

	List<ResultInfo> queryResultByStuidAndCourseid(String stuId, String courseId);

}
