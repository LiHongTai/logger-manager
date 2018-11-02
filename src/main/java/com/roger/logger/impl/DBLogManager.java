package com.roger.logger.impl;

import com.alibaba.fastjson.JSON;
import com.roger.entity.LogAdmDTO;
import com.roger.logger.ILogManager;
import org.springframework.stereotype.Service;

@Service("dbLogManager")
public class DBLogManager implements ILogManager {

    @Override
    public void dealLog(LogAdmDTO logAdmDTO) {
        System.out.println("分析日志，处理日志，日志内容如下："+ JSON.toJSONString(logAdmDTO));
    }
}
