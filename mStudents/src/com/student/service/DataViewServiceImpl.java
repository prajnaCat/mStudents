package com.student.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.Submit;
import com.model.Task;
import com.model.ZhuanyeInfo;
import com.student.dao.DataViewDao;
import com.tool.StringUtils;

@Service("dataViewService")
public class DataViewServiceImpl implements DataViewService {

	@Autowired
	private DataViewDao dataViewDao;

	/**
	 * 返回所有老师的发布作业时间分布图数据：数组
	 * @throws Exception 
	 */
	public int[][] getAllFaBuDataView() throws Exception {
	 List<Task> talist=dataViewDao.getAllFaBuDataView();
	int [][] result=new int[168][3];//定义一个168*3的二维数组
	int [] res=null;//定义一个一维数组
	int y=-1;
	for(int j=0;j<=6;j++){//利用0~6来代表星期数
		 for(int x=0;x<=23;x++){//使用0~23来代表小时数
			 y+=1;				
			 res=new int[3];//一维数组初始化，长度为3 
			 int count=0;
			 for(int i=0;i<talist.size();i++){//遍历查询到的实体类的Task的List集合
				 //获取到教师发布时间的字符串。
				 String dd=talist.get(i).getFabuTime().toString();
				 int week=StringUtils.getWeek(dd);//利用工具类，获取发布时间所在的星期数
				 int hour=StringUtils.get24Hour(dd);//利用工具类，获取发布时间所在的小时。
				 if(j==week&&x==hour){//如果星期数、小时数和双层遍历的数值相等，则累计加一。
					  count+=1;
				 }
			 }
				 res[0]=j;//为一维数组第1位赋值
				 res[1]=x;//为一维数组第2位赋值
				 res[2]=count;//为一维数组第3位赋值
				result[y]=res;//为二维数组的y位赋值。
		 }
	
	 }
		return result;
	}

	/**
	 * 获取前10 的作业提交情况：总人数 | 实际提交数量
	 * @throws Exception 
	 */
	@Override
	public ArrayList getAllCountTaskData() throws Exception {
		List<Task> talist=dataViewDao.getTenthTask();
		ArrayList result=new ArrayList();
		String [] arrxm=new String[talist.size()];//定义字符串一维数组
		int[]    arrsum=new int[talist.size()];//定义int类型一维数组 ，存放总人数
		int[]    arrtnum=new int[talist.size()];//定义int类型一维数组，存放已提交人数
		for(int i=0;i<talist.size();i++){//遍历实体类Task的List集合
			ZhuanyeInfo zy=dataViewDao.getZhuanyeInfoById(talist.get(i).getZhuanyeId());
			List<ClassInfo> clslist=dataViewDao.queryClassInfoByZyid(zy.getZhuanyeId());
			int sum=0;
			for(ClassInfo c:clslist){
				sum+=c.getClassNum();//获取专业总人数
			}
			List<Submit> sublist=dataViewDao.querySubmitByTaskId(talist.get(i).getTaskId());
			int tnum=-sublist.size();//获取已提交作业人数
			String name=zy.getZhuanyeName();
			arrxm[i]=name;//为字符串数组赋值
			arrsum[i]=sum;//为总人数数组赋值
			arrtnum[i]=tnum;//为已提交人数数组赋值
		}
		result.add(0, arrxm);//把字符串数组存放到数组集合的1位置
		result.add(1,arrsum);//把总人数数组存放到数组集合的2位置
		result.add(2, arrtnum);//把提交人数数组存放到数组集合的3位置
	
		return result;
	}

	@Override
	public ArrayList getAllCountTjnumData() {
		List<ResultInfo> reslist=dataViewDao.queryAllResultInfo();
		ArrayList result=new ArrayList();//初始化数组集合
		String [] arrstuid=new String[reslist.size()];//初始化学号一维数组
		double[]    arrmax=new double[reslist.size()];//初始化最大值一维数组
		double[]    arrmin=new double[reslist.size()];//初始化最小值一维数组
		double[]    arrarg=new double[reslist.size()];//初始化平均值一维数组
		double[]    arrres=new double[reslist.size()];//初始化最终成绩一维数组
		for(int i=0;i<reslist.size();i++){//遍历实体类ResultInfo的List集合
			arrstuid[i]=reslist.get(i).getStuId();//为学号数组的0~i赋值
			arrmax[i]=reslist.get(i).getMaxscore();//为最大值数组的0~i赋值
			arrmin[i]=reslist.get(i).getMinscore();//为最小值数组的0~i赋值
			arrarg[i]=reslist.get(i).getPjscore();//为平均值数组的0~i赋值
			arrres[i]=reslist.get(i).getResfen();//为最终成绩数组的0~i赋值
		}
		result.add(0,arrstuid);//把学号一维数组放到数组集合的1位置
		result.add(1,arrmax);//把最大值一维数组放到数组集合的2位置
		result.add(2, arrmin);//把最小值一维数组放到数组集合的3位置
		result.add(3, arrarg);//把平均值一维数组放到数组集合的4位置
		result.add(4, arrres);//把最终成绩一维数组放到数组集合的5位置
		
		return result;
	}
/**
 * 获取学生提交作业，按每月，每天的数量累计
 * @throws Exception 
 */
	@Override
	public Map<String, int[]> getMonthnumAndDaynum() throws Exception {
		Map<String, int[]> map=new HashMap<String, int[]>();
		List<Submit>sublist=dataViewDao.getAllSubmitInfo();
		int month=0;
		int sum=0;
		int count=0;
		for(int x=1;x<13;x++){//利用数字1~12代表月份，来遍历每个月份
			sum=0;
			int [] data=new int[32];//初始化大小为32的数组
			int index=0;
			for(int y=1;y<32;y++){//利用数字1~31代表日数，来便利每一天
				int dmonth=0;
				int dday=0;
				index+=1;
				count=0;
				for(int i=0;i<sublist.size();i++){
					String dd=sublist.get(i).getTjtime().toString();
				    dday=StringUtils.getIntDay(dd);//获取提交时间的所在的日数
					dmonth=StringUtils.getIntMonth(dd);//获取提交时间所在的月份数。
					if(y==dday&&x==dmonth){//如果提交时间的天数和月份数和遍历数都相等，累计加一
						count+=1;
					}
				}
				data[index]=count;
			}
			for(int i=0;i<sublist.size();i++){//遍历实体类Submit的List集合。
				//获取提交时间
				String dd=sublist.get(i).getTjtime().toString();
				month=StringUtils.getIntMonth(dd);//获取提交时间所在的月份
				if(x==month){
					sum+=1;//如果提交时间的月份和遍历数相等，则累计加一
				}
			}
			data[0]=sum;
			map.put("'"+x+"'", data);
		}
		return map;
	}

@Override
public ArrayList getResultFenBu(String stuid, String courseid) {
	ArrayList result=new ArrayList();
	List<Submit> sublist=dataViewDao.getSubmitByStuidAndCourseid(stuid,courseid);
	String []tkname=new String [sublist.size()];
	double[]subfen=new double[sublist.size()];
	for(int i=0;i<sublist.size();i++){
		tkname[i]=sublist.get(i).getTaskname();
		if(sublist.get(i).getScore()!=null&&sublist.get(i).getScore()>0){
			subfen[i]=sublist.get(i).getScore();
		}else{
			subfen[i]=-1;
		}
	result.add(0, tkname);
	result.add(1, subfen);
	}
	return result;
}

@Override
public int[][] getTiJiaoDataViewByStuid(String stuid) throws Exception {
	 List<Submit> sublist=dataViewDao.getTiJiaoDataViewByStuid(stuid);
		int [][] result=new int[168][3];
		int [] res=null;
		int y=-1;
			 for(int j=0;j<=6;j++){
				 for(int x=0;x<=23;x++){
					 y+=1;
					 res=new int[3];
					 int count=0;
					 for(int i=0;i<sublist.size();i++){
						 String dd=sublist.get(i).getTjtime().toString();
						 int week=StringUtils.getWeek(dd);
						 int hour=StringUtils.get24Hour(dd);
						 if(j==week&&x==hour){
							  count+=1;
						 }
					 }
						 res[0]=j;
						 res[1]=x;
						 res[2]=count;
						result[y]=res;
				 }
		
		 }
			return result;
}

@Override
public ArrayList getCountSubmitData(String stuid) {
	List<ResultInfo> reslist=dataViewDao.queryResultInfoByStuid(stuid);
	ArrayList  result=new ArrayList();
	Map m=null;
	for(int i=0;i<reslist.size();i++){
		m=new HashMap();
		m.put("value", reslist.get(i).getJiaonum());
		m.put("name", reslist.get(i).getCoursename());
		result.add(m);
		m=null;
	}
	return result;
}

	@Override
	public ArrayList getAllResultFeData(String stuid) {
		ArrayList result=new ArrayList();
		List<ResultInfo> reslist=dataViewDao.queryResultInfoByStuidAndPfstatus(stuid);
		String []tkname=new String [reslist.size()];
		double[]subfen=new double[reslist.size()];
		for(int i=0;i<reslist.size();i++){
			tkname[i]=reslist.get(i).getCoursename();
			if(reslist.get(i).getResfen()!=null&&reslist.get(i).getResfen()>0){
				subfen[i]=reslist.get(i).getResfen();
			}else{
				subfen[i]=0;
			}
		result.add(0, tkname);
		result.add(1, subfen);
		}
		return result;
	 }

	@Override
	public ArrayList getStudentResultDetail(String stuid) {
		List<ResultInfo> reslist=dataViewDao.queryResultInfoByStuidAndPfstatus(stuid);
		ArrayList result=new ArrayList();
		String []  course=new String[reslist.size()];
		double[]    arrmax=new double[reslist.size()];
		double[]    arrmin=new double[reslist.size()];
		double[]    arrarg=new double[reslist.size()];
		double[]    arrres=new double[reslist.size()];
		String []  kong=new String[reslist.size()];
		for(int i=0;i<reslist.size();i++){
			course[i]=reslist.get(i).getCoursename();
			arrmax[i]=reslist.get(i).getMaxscore();
			arrmin[i]=reslist.get(i).getMinscore();
			arrarg[i]=reslist.get(i).getPjscore();
			arrres[i]=reslist.get(i).getResfen();
			kong[i]="-";
		}
		result.add(0,course);
		result.add(1,arrmin);
		result.add(2, arrmax);
		result.add(3, arrarg);
		result.add(4, arrres);
		result.add(5,kong);
		return result;
	}

	@Override
	public int[][] getFaBuDataViewByTeaid(String teaid) throws Exception {
		List<Task> talist=dataViewDao.queryTaskByTeaid(teaid);
		int [][] result=new int[168][3];
		int [] res=null;
		int y=-1;
			 for(int j=0;j<=6;j++){
				 for(int x=0;x<=23;x++){
					 y+=1;
					 res=new int[3];
					 int count=0;
					 for(int i=0;i<talist.size();i++){
						 String dd=talist.get(i).getFabuTime().toString();
						 int week=StringUtils.getWeek(dd);
						 int hour=StringUtils.get24Hour(dd);
						 if(j==week&&x==hour){
							  count+=1;
						 }
					 }
						 res[0]=j;
						 res[1]=x;
						 res[2]=count;
						result[y]=res;
				 }
		
		 }
			return result;
	}

	@Override
	public ArrayList getCountFaBuDataByTeaid(String teaid) {
		List<Task>tasklist=dataViewDao.queryTaskByTeaid(teaid);
		for  ( int  i  =   0 ; i  <  tasklist.size()  -   1 ; i ++ )   { 
		    for  ( int  j  =  tasklist.size()  -   1 ; j  >  i; j -- )   { 
				if(tasklist.get(i).getCourseId().equals(tasklist.get(j).getCourseId())){
					tasklist.remove(j);
				}
			}
		}
		ArrayList  result=new ArrayList();
		Map m=null;
		for(Task t:tasklist){
			List<Task> list=dataViewDao.queryTaskByCourseid(t.getCourseId());
			CourseInfo cou=dataViewDao.queryCourseByid(t.getCourseId());
			m=new HashMap();
			m.put("value", list.size());
			m.put("name", cou.getName());
			result.add(m);
			m=null;
		}
		
		return result;
	}

	@Override
	public ArrayList countTaskDataByTeaid(String teaid) throws Exception {
		List<Task> talist=dataViewDao.getTenthTaskByTeaid(teaid);
		ArrayList result=new ArrayList();
		String [] arrxm=new String[talist.size()];
		int[]    arrsum=new int[talist.size()];
		int[]    arrtnum=new int[talist.size()];
		for(int i=0;i<talist.size();i++){
			ZhuanyeInfo zy=dataViewDao.getZhuanyeInfoById(talist.get(i).getZhuanyeId());
			List<ClassInfo> clslist=dataViewDao.queryClassInfoByZyid(zy.getZhuanyeId());
			int sum=0;
			for(ClassInfo c:clslist){
				sum+=c.getClassNum();
			}
			List<Submit> sublist=dataViewDao.querySubmitByTaskId(talist.get(i).getTaskId());
			int tnum=-sublist.size();
			String name=talist.get(i).getTaskname();
			arrxm[i]=name;
			arrsum[i]=sum;
			arrtnum[i]=tnum;
		}
		result.add(0, arrxm);
		result.add(1,arrsum);
		result.add(2, arrtnum);
	
		return result;
	}

	@Override
	public Map<String, int[]> countPingfenTimeFenBuData(String teaid) throws Exception {
		Map<String, int[]> map=new HashMap<String, int[]>();
		List<Task> tlist=dataViewDao.queryTaskByTeaid(teaid);
		List<Submit> pflist=new ArrayList<Submit>();
		for(Task t:tlist){
			List<Submit>sublist=dataViewDao.getSubmitInfoByTaskid(t.getTaskId());
			for(Submit s:sublist){
				pflist.add(s);
			}
		}
		int month=0;
		int sum=0;
		int count=0;
		for(int x=1;x<13;x++){
			sum=0;
			int [] data=new int[32];
			int index=0;
			for(int y=1;y<32;y++){
				int dmonth=0;
				int dday=0;
				index+=1;
				count=0;
				for(int i=0;i<pflist.size();i++){
					String dd=pflist.get(i).getPftime().toString();
				    dday=StringUtils.getIntDay(dd);
					dmonth=StringUtils.getIntMonth(dd);
					if(y==dday&&x==dmonth){
						count+=1;
					}
				}
				data[index]=count;
			}
			for(int i=0;i<pflist.size();i++){
				String dd=pflist.get(i).getPftime().toString();
				month=StringUtils.getIntMonth(dd);
				if(x==month){
					sum+=1;
				}
				
			}
			
			data[0]=sum;
			map.put("'"+x+"'", data);
		}
		return map;
	}

	@Override
	public ArrayList getFirstNianData(String stuid,int i) throws ParseException {
		Date begin=null;
		Date end=null;
		String start=null;
		String last=null;
		String nian=stuid.substring(1,5);
		SimpleDateFormat  sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(i==1){
			Integer year=Integer.parseInt(nian)+1;
			start=nian+"-09-01 00:00:00";
			last=year+"-08-30 00:00:00";
			
			begin=sf.parse(start);
			end=sf.parse(last);
		}else if(i==2){
			Integer year01=Integer.parseInt(nian)+1;
			Integer year02=Integer.parseInt(nian)+2;
			start=year01+"-09-01 00:00:00";
			last=year02+"-08-30 00:00:00";
			begin=sf.parse(start);
			end=sf.parse(last);
		}else if(i==3){
			Integer year01=Integer.parseInt(nian)+2;
			Integer year02=Integer.parseInt(nian)+3;
			start=year01+"-09-01 00:00:00";
			last=year02+"-08-30 00:00:00";
			begin=sf.parse(start);
			end=sf.parse(last);
		}else if(i==4){
			Integer year01=Integer.parseInt(nian)+3;
			Integer year02=Integer.parseInt(nian)+4;
			start=year01+"-09-01 00:00:00";
			last=year02+"-08-30 00:00:00";
			begin=sf.parse(start);
			end=sf.parse(last);
		}
		List<ResultInfo> reslist=dataViewDao.queryResultInfoByTime(stuid,start,last);
		ArrayList  result=new ArrayList();
		Map m=null;
		Map val=val=new HashMap();
		ArrayList  res01=new ArrayList();
		ArrayList  res02=new ArrayList();
		if(reslist.size()>0){
			double [] fen=new double[reslist.size()];
			for(int j=0;j<reslist.size();j++){
				m=new HashMap();
				
				m.put("name", reslist.get(j).getCoursename());
				m.put("max", 100);
				fen[j]=reslist.get(j).getResfen();
				res01.add(m);
				m=null;
			}
			val.put("value", fen);
			if(i==1)
				val.put("name", "第一学年");
			if(i==2)
				val.put("name", "第二学年");	
			if(i==3)
				val.put("name", "第三学年");
			if(i==4)
				val.put("name", "第四学年");	
			res02.add(val);
		}else{
			double [] fen=new double[3];
			for(int j=0;j<3;j++){
				m=new HashMap();
				
				m.put("name", "课程为空");
				m.put("max", 100);
				fen[j]=0;
				res01.add(m);
				m=null;
			}
			val.put("value", fen);
			if(i==1)
				val.put("name", "第一学年");
			if(i==2)
				val.put("name", "第二学年");	
			if(i==3)
				val.put("name", "第三学年");
			if(i==4)
				val.put("name", "第四学年");	
			res02.add(val);
		}
		
		result.add(0, res01);
		result.add(1, res02);
		return result;
	}
}
