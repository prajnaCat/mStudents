package com.student.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

public interface DataViewService {

	int[][] getAllFaBuDataView() throws Exception;

	ArrayList getAllCountTaskData() throws Exception;

	ArrayList getAllCountTjnumData();

	Map<String, int[]> getMonthnumAndDaynum() throws Exception;

	ArrayList getResultFenBu(String stuid, String courseid);

	int[][] getTiJiaoDataViewByStuid(String stuid)throws Exception;

	ArrayList getCountSubmitData(String stuid);

	ArrayList getAllResultFeData(String stuid);

	ArrayList getStudentResultDetail(String stuid);

	int[][] getFaBuDataViewByTeaid(String teaid) throws Exception;

	ArrayList getCountFaBuDataByTeaid(String teaid);

	ArrayList countTaskDataByTeaid(String teaid) throws Exception;

	Map<String, int[]> countPingfenTimeFenBuData(String teaid) throws Exception;

	ArrayList getFirstNianData(String stuid, int i) throws ParseException;

}
