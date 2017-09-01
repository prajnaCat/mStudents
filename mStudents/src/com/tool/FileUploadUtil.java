package com.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

public class FileUploadUtil {

	private static final long serialVersionUID = 1L;
	// 保存文件的目录
	private static String PATH_FOLDER = "/";
	// 存放临时文件的目录
	private static String TEMP_FOLDER = "/";

	public String teaupload(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse, String name) {
		// HttpServletRequest request = this.servletRequest.get;
		ServletContext servletCtx = servletRequest.getSession()
				.getServletContext();
		// 初始化路径
		// 保存文件的目录
		PATH_FOLDER = servletCtx.getRealPath("/upload/teacher/yongjiu");
		// 存放临时文件的目录,存放xxx.tmp文件的目录
		TEMP_FOLDER = servletCtx.getRealPath("/upload/teacher/linshi");
		try {
			servletRequest.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} // 设置编码
		servletResponse.setCharacterEncoding("utf-8");
		servletResponse.setContentType("text/html;charset=UTF-8");
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			/*
			 * struts 封装了 httpservlet 转为 MultiPartRequestWrapper 取文件
			 */
			MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) servletRequest;
			Enumeration myEnumeration = wrapper.getFileParameterNames();

			while (myEnumeration.hasMoreElements()) {

				String fileparametername = myEnumeration.nextElement()
						.toString();
				System.out.println("fileparametername=" + fileparametername);
				File[] files = wrapper.getFiles(fileparametername);
				String[] filenames = wrapper.getFileNames(fileparametername);

				System.out.println(files[0]);
				System.out.println(filenames[0]);

				name = name
						+ filenames[0].substring(filenames[0].lastIndexOf("."),
								filenames[0].length());

				/*
				 * 保存文件
				 */
				File f = new File(PATH_FOLDER, name);
				InputStream in = new FileInputStream(files[0]);
				int byteread = 0; // 读取的字节数

				FileOutputStream out = new FileOutputStream(f);
				byte[] buffer = new byte[1024];

				while ((byteread = in.read(buffer)) != -1) {
					out.write(buffer, 0, byteread);
				}
				try {
					if (out != null)
						out.close();
					if (in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				/*PropertiesUtil pu = new PropertiesUtil("/config.properties");*/
				String uploadpath = "F:\\temp";
				File file =new File(uploadpath);    
				//如果文件夹不存在则创建    
				if  (!file .exists()  && !file .isDirectory())      
				{         
				    file .mkdir();    
				}
				File f1 = new File(uploadpath, name);
				InputStream in1 = new FileInputStream(files[0]);
				int byteread1 = 0; // 读取的字节数

				FileOutputStream out1 = new FileOutputStream(f1);
				byte[] buffer1 = new byte[1024];

				while ((byteread1 = in1.read(buffer1)) != -1) {
					out1.write(buffer1, 0, byteread1);
				}
				try {
					if (out1 != null)
						out1.close();
					if (in1 != null)
						in1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return name;
	}

	public String stuupload(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse, String name) {
		// HttpServletRequest request = this.servletRequest.get;
		ServletContext servletCtx = servletRequest.getSession()
				.getServletContext();
		// 初始化路径
		// 保存文件的目录
		PATH_FOLDER = servletCtx.getRealPath("/upload/student/yongjiu");
		// 存放临时文件的目录,存放xxx.tmp文件的目录
		TEMP_FOLDER = servletCtx.getRealPath("/upload/student/linshi");
		try {
			servletRequest.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} // 设置编码
		servletResponse.setCharacterEncoding("utf-8");
		servletResponse.setContentType("text/html;charset=UTF-8");
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			/*
			 * struts 封装了 httpservlet 转为 MultiPartRequestWrapper 取文件
			 */
			MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) servletRequest;
			Enumeration myEnumeration = wrapper.getFileParameterNames();

			while (myEnumeration.hasMoreElements()) {

				String fileparametername = myEnumeration.nextElement()
						.toString();
				System.out.println("fileparametername=" + fileparametername);
				File[] files = wrapper.getFiles(fileparametername);
				String[] filenames = wrapper.getFileNames(fileparametername);

				System.out.println(files[0]);
				System.out.println(filenames[0]);

				name = name
						+ filenames[0].substring(filenames[0].lastIndexOf("."),
								filenames[0].length());

				/*
				 * 保存文件
				 */
				File f = new File(PATH_FOLDER, name);
				InputStream in = new FileInputStream(files[0]);
				int byteread = 0; // 读取的字节数

				FileOutputStream out = new FileOutputStream(f);
				byte[] buffer = new byte[1024];

				while ((byteread = in.read(buffer)) != -1) {
					out.write(buffer, 0, byteread);
				}
				try {
					if (out != null)
						out.close();
					if (in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				/*PropertiesUtil pu = new PropertiesUtil("/config.properties");*/
				String uploadpath = "F:\\temp";
				File file =new File(uploadpath);    
				//如果文件夹不存在则创建    
				if  (!file .exists()  && !file .isDirectory())      
				{         
				    file .mkdir();    
				}
				File f1 = new File(uploadpath, name);
				InputStream in1 = new FileInputStream(files[0]);
				int byteread1 = 0; // 读取的字节数

				FileOutputStream out1 = new FileOutputStream(f1);
				byte[] buffer1 = new byte[1024];

				while ((byteread1 = in1.read(buffer1)) != -1) {
					out1.write(buffer1, 0, byteread1);
				}
				try {
					if (out1 != null)
						out1.close();
					if (in1 != null)
						in1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return name;
	}

}
