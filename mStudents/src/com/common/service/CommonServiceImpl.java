package com.common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.CommonDao;
import com.common.model.ResultDetailVo;
import com.common.model.SubmitDetailVo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StuDocInfo;
import com.model.StudentInfo;
import com.model.Submit;
import com.model.Task;
import com.model.TeaDocInfo;
import com.tool.DataDetailTool;
import com.tool.Page;
import com.tool.StringUtils;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;

	/**
	 * 老师验收作业时，根据作业ID和班级ID 获取学生的作业提交详情。
	 * 
	 * @throws Exception
	 */
	@Override
	public List<SubmitDetailVo> querySubDetail(String taskId, String classId,
			Page page) throws Exception {
		List<SubmitDetailVo> subvolist = new ArrayList<SubmitDetailVo>();
		if (taskId != null && taskId.length() > 0) {
			List<Submit> sublist;
			sublist = commonDao.querySubDetailThress(taskId, classId, page);
			SubmitDetailVo subvo = new SubmitDetailVo();

			for (Submit sb : sublist) {
				subvo.setSubId(sb.getSubmitId());// 提交id
				subvo.setTitime(sb.getTjtime().toString());// 提交时间
				subvo.setClassId(sb.getClassId() + " 班");// 学生班级
				if (sb.getScore() != null) {
					subvo.setScore(sb.getScore());// 评分
				}
				subvo.setStuId(sb.getStuId());// 学生ID
				subvo.setStuDocId(sb.getStuDocId());// 提交的文档ID
				StuDocInfo sd = commonDao.queryStuDocBydocid(sb.getStuDocId());
				subvo.setName(sd.getName());// 文档的原名
				subvo.setDocname(sd.getDocname());// 文档的别名
				subvo.setTjstatus(sb.getTjstatus());// 提交状态
				StudentInfo stu = commonDao.queryStudentBystuid(sb.getStuId());
				subvo.setStuName(stu.getStuName());// 学生姓名
				Task ta = commonDao.queryTaskBytaskid(sb.getTaskId());
				subvo.setJiezhiTime(ta.getJiezhiTime());// 截止时间
				subvo.setTaskname(ta.getTaskname());// 作业名称
				subvo.setFbtime(ta.getFabuTime());
				subvolist.add(subvo);
				subvo = new SubmitDetailVo();
			}
		} else {
			System.out.println("taskId为空");
		}
		return subvolist;
	}

	/**
	 * 老师验收作业时，保存老师的评分
	 * 
	 * @return
	 */
	@Override
	public void saveSubmitScore(List<SubmitDetailVo> svo) throws Exception {
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = ff.format(d);
		Date ddd = ff.parse(dd);
		for (SubmitDetailVo s : svo) {
			List<Submit> sublist = commonDao.querySubmitBysubid(s.getSubId());
			for (Submit ss : sublist) {
				ss.setPftime(ddd);
				ss.setTjstatus("22");// 已评分
				ss.setScore(s.getScore());
				commonDao.saveSubmit(ss);
			}
		}
	}

	/**
	 * 学生根据学生ID或者专业ID 获取具体消息的提交信息
	 * 
	 * @return List<SubmitDetailVo>
	 */
	@Override
	public List<SubmitDetailVo> querySubDetailByStuid(String stuId,
			String courseId, Page page) throws Exception {
		List<SubmitDetailVo> subvolist = new ArrayList<SubmitDetailVo>();
		StudentInfo stu = commonDao.queryStudentBystuid(stuId);
		String zyid = stu.getZhuanyeId();
		SubmitDetailVo subvo = new SubmitDetailVo();
		List<Task> talist = commonDao.queryTaskBycourseid(courseId, zyid, page);
		for (Task ta : talist) {
			subvo.setFbtime(ta.getFabuTime());// 发布时间
			subvo.setJiezhiTime(ta.getJiezhiTime());// 截止时间
			subvo.setTaskname(ta.getTaskname());// 作业名称6
			if (ta.getTeadocid() != null) {
				subvo.setTeaDocId(ta.getTeadocid());
				TeaDocInfo td = commonDao.queryTeaDocById(ta.getTeadocid());
				if (td != null) {
					subvo.setTeadocname(td.getDocname());
					subvo.setTeaname(td.getName());
				}
			}
			List<Submit> sublist = commonDao.querySubDetailByStuIdAndTaskid(
					stuId, ta.getTaskId());
			if (sublist.size() > 0) {
				for (Submit sb : sublist) {
					subvo.setSubId(sb.getSubmitId());// 提交id
					subvo.setTitime(sb.getTjtime().toString());// 提交时间
					subvo.setScore(sb.getScore());// 评分
					subvo.setCourseid(sb.getCourseId());// 课程id
					subvo.setCoursename(sb.getCoursename());// 课程名称
					subvo.setStuDocId(sb.getStuDocId());// 提交的文档ID
					StuDocInfo sd = commonDao.queryStuDocBydocid(sb
							.getStuDocId());
					subvo.setName(sd.getName());// 文档的原名
					subvo.setDocname(sd.getDocname());// 文档的别名
					subvo.setTjstatus(sb.getTjstatus());// 提交状态
				}
			} else {
				subvo.setTjstatus("00");// 提交状态:"00":未提交
				Task t = commonDao.queryTaskBytaskid(ta.getTaskId());
				subvo.setCourseid(t.getCourseId());
				CourseInfo cf = commonDao
						.queryCourseInfoBycoid(t.getCourseId());
				subvo.setCoursename(cf.getName());
			}
			subvolist.add(subvo);
			subvo = new SubmitDetailVo();
		}
		return subvolist;
	}

	/**
	 * 根据课程ID、专业ID、班级ID 获取某班级的所有学生的这门课程的详细信息。 
	 * 平均分、最大值、最小值、方差。 根据条件存入ResultInfo
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ResultInfo> saveStudentResultDetail(String courseId,
			String zhuanyeId, String classId, Page page) throws Exception {

		List<ResultInfo> rebolist = new ArrayList<ResultInfo>();
		List<Task> tasklist = commonDao.queryTaskByCouidAndZyid(courseId,
				zhuanyeId);
		List<StudentInfo> stulist = commonDao.queryStudentsByclassid(classId,
				page);
		ResultInfo resvo = new ResultInfo();// 实体类result

		double[] num = null;
		for (StudentInfo stu : stulist) {
			List<ResultInfo> reslist = commonDao.queryResultByStuidAndCourseid(
					stu.getStuId(), courseId);
			String isok = "00";
			boolean ishave = true;
			if (reslist.size() == 1) {
				for (ResultInfo result : reslist) {
					if ("22".equals(result.getPfstatus())) {
						ishave = false;
						System.out.println(result.getClassId() + " "
								+ result.getCoursename() + " 已评分");
					} else if ("11".equals(result.getPfstatus())) {
						resvo = result;
						isok = "11";
					}
				}
			}
			// 如果result中存在此学生的结果，，且 结果状态是"22"(已评分)，则不能再生成。

			if (ishave) {
				if ("00".equals(isok)) {
					String resid = courseId + "r" + stu.getStuId();// 生成主键
					resvo.setResId(resid);
				}
				resvo.setTasknum(tasklist.size());// 布置作业次数
				resvo.setIsvalue("1");
				resvo.setClassId(stu.getClassId());// 学生班级
				resvo.setStuId(stu.getStuId());// 学生学号
				resvo.setStuName(stu.getStuName());// 学生姓名
				List<Submit> sublist = commonDao.querySubmitByStuidAndCouid(
						stu.getStuId(), courseId);
				resvo.setJiaonum(sublist.size());// 交作业次数
				resvo.setSctime(StringUtils.getNewDate());
				if (sublist.size() > 0) {
					for (int i = 0; i < sublist.size(); i++) {
						resvo.setCourseId(sublist.get(i).getCourseId());// 课程ID
						resvo.setCoursename(sublist.get(i).getCoursename());// 作业科目名称
					}
				
				List<Submit> substatuslist = commonDao
						.querySubmitByStuidAndCouidAndTistatus(stu.getStuId(),
								courseId);
				resvo.setPfstatus("11");// 评分状态："11"：未评分 "22":已评分
				resvo.setPingfnum(substatuslist.size());// 评分次数
				if (substatuslist.size() > 0) {
					num = new double[substatuslist.size()];
					for (int i = 0; i < substatuslist.size(); i++) {
						num[i] = substatuslist.get(i).getScore();
					}
				}
				if (num != null && num.length > 0) {
					resvo.setMaxscore(DataDetailTool.getMaxval(num));// 最大值
					resvo.setPjscore(DataDetailTool.getPjval(num));// 平均值
					resvo.setMinscore(DataDetailTool.getMinval(num));// 最小值
					resvo.setFangcha(DataDetailTool.getFangcha(num));// 方差
					resvo.setBzcha(DataDetailTool.getBiaoZ(num));// 标准差
				} else {
					resvo.setMaxscore((Double) null);// 最大值
					resvo.setPjscore((Double) null);// 平均值
					resvo.setMinscore((Double) null);// 最小值
					resvo.setFangcha((Double) null);// 方差
					resvo.setBzcha((Double) null);// 标准差
				}
				commonDao.saveResult(resvo);// 保存实体类：Result
				rebolist.add(resvo);
				resvo = null;
				resvo = new ResultInfo();
				}
			}

		}

		return rebolist;
	}

	@Override
	public List<ResultDetailVo> queryResultBycouidAndclassid(String courseId,
			String classId, Page page) throws Exception {
		List<ResultInfo> list = commonDao.queryResultBycouidAndclassid(
				courseId, classId, page);
		List<ResultDetailVo> volist = new ArrayList<ResultDetailVo>();
		
		for (ResultInfo r : list) {
			ResultDetailVo revo = new ResultDetailVo();
			revo.setResId(r.getResId());
			revo.setClassId(r.getClassId());
			revo.setCourseId(r.getCourseId());
			revo.setCoursename(r.getCoursename());
			revo.setFangcha(r.getFangcha());
			revo.setJiaonum(r.getJiaonum());
			revo.setMaxscore(r.getMaxscore());
			revo.setMinscore(r.getMinscore());
			revo.setPingfnum(r.getPingfnum());
			revo.setPjscore(r.getPjscore());
			if (r.getResfen() != null) {
				revo.setResfen(r.getResfen());
			} else {
				revo.setResfen((Double) null);
			}
			revo.setPfstatus(r.getPfstatus());
			revo.setStuId(r.getStuId());
			revo.setStuName(r.getStuName());
			revo.setTasknum(r.getTasknum());
			volist.add(revo);
		}
		return volist;
	}

	/**
	 * 保存老师的总分评分，生成时间，状态改为："22"
	 */
	@Override
	public void updatePingFen(List<ResultInfo> reslist) {
		/*
		 * Date d=new Date(); SimpleDateFormat ff=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String dd=ff.format(d); Date
		 * ddd=ff.parse(dd);
		 */
		for (ResultInfo res : reslist) {
			List<ResultInfo> list = commonDao
					.queryResultByResid(res.getResId());
			for (ResultInfo rf : list) {
				rf.setIsvalue("0");
				rf.setResfen((Double) res.getResfen());
				rf.setFangcha((Double) res.getFangcha());
				rf.setMaxscore((Double) res.getMaxscore());
				rf.setBzcha((Double) res.getBzcha());
				rf.setMinscore((Double) res.getMinscore());
				rf.setPjscore((Double) res.getPjscore());
				commonDao.saveResult(rf);
			}
		}
	}

	/**
	 * 分页查询resultInfo 参数：stuid page
	 * 
	 * @return List
	 * @author xiaoxie
	 * @throws Exception
	 */
	@Override
	public List<ResultDetailVo> queryPageResultByStuId(String stuid, Page page)
			throws Exception {
		List<ResultInfo> reslist = commonDao
				.queryPageResultByStuId(stuid, page);
		List<ResultDetailVo> resvolist = new ArrayList<ResultDetailVo>();
		ResultDetailVo vo = new ResultDetailVo();
		for (ResultInfo rf : reslist) {
			vo.setCourseId(rf.getCourseId());// 课程ID
			CourseInfo cou = commonDao.queryCourseInfoBycoid(rf.getCourseId());
			vo.setCoursename(cou.getName());// 课程名称
			cou = null;
			vo.setResId(rf.getResId());
			vo.setFangcha(rf.getFangcha());
			vo.setJiaonum(rf.getJiaonum());
			vo.setMaxscore(rf.getMaxscore());
			vo.setMinscore(rf.getMinscore());
			vo.setPfstatus(rf.getPfstatus());
			vo.setPingfnum(rf.getPingfnum());
			vo.setPjscore(rf.getPjscore());
			vo.setResfen(rf.getResfen());
			vo.setTasknum(rf.getTasknum());
			resvolist.add(vo);
			vo = null;
			vo = new ResultDetailVo();
		}
		return resvolist;
	}

}
