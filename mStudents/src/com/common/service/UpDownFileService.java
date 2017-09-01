package com.common.service;

import com.model.StuDocInfo;
import com.model.TeaDocInfo;

public interface UpDownFileService {

	TeaDocInfo saveTeaFile(TeaDocInfo teadoc);

	StuDocInfo saveStuFile(StuDocInfo studoc);

}
