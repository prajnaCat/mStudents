package com.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.UpDownFileDao;
import com.model.StuDocInfo;
import com.model.TeaDocInfo;

@Service("upDownFileService")
public class UpDownFileServiceImpl implements UpDownFileService {
	@Autowired
	private UpDownFileDao upDownFileDao;

	@Override
	public TeaDocInfo saveTeaFile(TeaDocInfo teadoc) {
		teadoc.setIsvalue("1");
		return upDownFileDao.saveTeaFile(teadoc);
	}

	@Override
	public StuDocInfo saveStuFile(StuDocInfo studoc) {
		studoc.setIsvalue("1");
		return upDownFileDao.saveStuFile(studoc);
	}
}
