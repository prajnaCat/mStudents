package com.common.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.common.model.ResultDetailVo;
import com.common.model.SubmitDetailVo;
import com.model.ResultInfo;
import com.tool.Page;

public interface CommonService {

	List<SubmitDetailVo> querySubDetail(String taskId, String classId,Page page) throws Exception;

	void saveSubmitScore(List<SubmitDetailVo> svo)throws Exception;

	List<SubmitDetailVo> querySubDetailByStuid(String stuId, String courseId,Page page) throws Exception;

	List<ResultInfo> saveStudentResultDetail(String courseId,
			String zhuanyeId, String classId, Page page) throws Exception;

	List<ResultDetailVo> queryResultBycouidAndclassid(String courseId, String classId,
			Page page) throws Exception;

	void updatePingFen(List<ResultInfo> res) throws  Exception;


	List<ResultDetailVo> queryPageResultByStuId(String stuid, Page page) throws Exception;

}
