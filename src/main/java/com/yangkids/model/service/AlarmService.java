package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Alarm;
import com.yangkids.model.dto.SearchCondition;

public interface AlarmService {
	
	// 유저 별 알람 목록
	public List<Alarm> getAlarmList(String userId);
	
	// 알람 삭제 
	public int removeAlarm(int alarmId);
	
	// 읽었을 경우 읽음 처리 
	public int checkAlarm(int alarmId);
	
	// 알람 생성
	public int writeAlarm(Alarm alarm);
}
