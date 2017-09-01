package com.student.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CourseInfo;
import com.model.Submit;
import com.model.Task;
import com.student.dao.StudentDao;
import com.tool.StringUtils;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;

	@Override
	public ArrayList queryStuSubmit() {
		studentDao.queryStuSubmit();
		return null;
	}

	@Override
	public String saveStudentSubmit(Submit sub) throws Exception {
		
		String status="00";
		
		String taskid=sub.getTaskId();
		String stuid=sub.getStuId();
		List<Submit> sublist=studentDao.querySubmitBytaskidAndstuid(taskid,stuid);
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		String dd=f.format(d);
		d=f.parse(dd);
		if(sublist.size()==1){
			for(Submit st:sublist){
				status=st.getTjstatus();
				st.setTjtime(d);//当前时间作为作业提交时间
				st.setStuDocId(sub.getStuDocId());
				st.setBeizhu(sub.getBeizhu());
				studentDao.updateStuSubmit(st);
			}
		}
		if("00".equals(status)&&sublist.size()==0){
			String subid = StringUtils.getId("s");
			sub.setSubmitId(subid);//赋值给submitid
			sub.setTjtime(d);//当前时间作为作业提交时间
			sub.setTjstatus("11");//"00"未提交，"11"已提交
			sub.setIsvalue("1");//"1"有效
			List<Task>talist=studentDao.queryTaskByTaskid(sub.getTaskId());
			for(Task ta:talist){
				sub.setTaskname(ta.getTaskname());
				List<CourseInfo> coulist=studentDao.queryCourseId(ta.getCourseId());
				for(CourseInfo cou:coulist){
					sub.setCourseId(cou.getCourseId());
					sub.setCoursename(cou.getName());
				}
			}
			studentDao.saveStuSubmit(sub);
		}else if("11".equals(status)){
			status="11";
		}else{
			status="22";
		}
		return status;
	}
	
}
