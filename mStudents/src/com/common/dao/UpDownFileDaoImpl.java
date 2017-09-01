package com.common.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.StuDocInfo;
import com.model.TeaDocInfo;
import com.tool.StringUtils;
import com.wondersgroup.wssip.commons.dao.CommonHibernateDaoUtils;

@Repository("upDownFileDao")
public class UpDownFileDaoImpl implements UpDownFileDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public TeaDocInfo saveTeaFile(TeaDocInfo teadoc) {
		String teadocid = StringUtils.getId("tF");
		if (StringUtils.isEmpty(teadoc.getTeadocid())) {
			teadoc.setTeadocid(teadocid);
			hibernateTemplate.save(teadoc);
		} else {
			hibernateTemplate.update(teadoc);
		}
		return teadoc;
	}

	@Override
	public StuDocInfo saveStuFile(StuDocInfo studoc) {
		String studocid = StringUtils.getId("sF");
		if (StringUtils.isEmpty(studoc.getStudocid())) {
			studoc.setStudocid(studocid);
			hibernateTemplate.save(studoc);
		} else {
			hibernateTemplate.update(studoc);
		}
		return studoc;
	}
}
