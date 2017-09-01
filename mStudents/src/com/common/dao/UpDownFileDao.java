package com.common.dao;

import com.model.StuDocInfo;
import com.model.TeaDocInfo;

public interface UpDownFileDao {

	TeaDocInfo saveTeaFile(TeaDocInfo teadoc);

	StuDocInfo saveStuFile(StuDocInfo studoc);

}
