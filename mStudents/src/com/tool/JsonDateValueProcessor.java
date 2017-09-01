package com.tool;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public JsonDateValueProcessor() {
    }

    public DateFormat getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return this.process(value, jsonConfig);
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return this.process(value, jsonConfig);
    }

    private Object process(Object value, JsonConfig jsonConfig) {
        Object dateValue = value;
        if(value instanceof Date) {
            dateValue = new java.util.Date(((Date)value).getTime());
        }

        return dateValue instanceof java.util.Date?this.dateFormat.format(dateValue):dateValue;
    }
}
