package com.tool;

import java.math.BigDecimal;
import java.util.Arrays;

public class DataDetailTool {

	/**
	 * 	平均值
	 * @param num
	 * @return
	 */
	public static double getPjval(double num[]){
		double sum=0;
		for(int i=0;i<num.length;i++){
			sum+=num[i];
		}
		BigDecimal   b   =   new   BigDecimal(sum/num.length);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f1;
	}
	
	/**
	 * 	最大值
	 * @param num
	 * @return
	 */
	public static double getMaxval(double num[]){
		double max=num[0];
		for(int i=0;i<num.length;i++){
			if(num[i]>max){
				max=num[i];
			}
		}
		
		return max;
	}
	/**
	 * 	最小值
	 * @param num
	 * @return
	 */
	public static double getMinval(double num[]){
		double min=num[0];
		for(int i=0;i<num.length;i++){
			if(num[i]<min){
				min=num[i];
			}
		}
		return min;
	}
	/**
	 * 	众数
	 * @param num
	 * @return
	 */

	public static double mostNum(double num[]) {
		Arrays.sort(num);
		int count = 1;
		int longest = 0;
		double most = 0;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1]) {
				count++;
			} else {
				count = 1;// 如果不等于，就换到了下一个数，那么计算下一个数的次数时，count的值应该重新符值为一
				continue;
			}
			if (count > longest) {
				most = num[i];
				longest = count;
			}
		}
		return most;
	}
	
	/**
	 * 方差
	 * @param num
	 * @return
	 */
	public static double getFangcha(double num[]){
		double pj= getPjval(num);
		double sum=0;
		for(int i=0;i<num.length;i++){
			sum+=Math.pow(num[i]-pj, 2);
		}
		BigDecimal   b   =   new   BigDecimal(sum/num.length);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f1;
		
	}
	
	/**
	 * 标准差
	 * @param num
	 * @return
	 */
	public static double getBiaoZ(double num[]){
		double fc=getFangcha(num);
		BigDecimal   b   =   new   BigDecimal(Math.sqrt(fc));  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return f1;
	}
	
	
}
