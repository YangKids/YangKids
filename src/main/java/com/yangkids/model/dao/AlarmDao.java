package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Alarm;

public interface AlarmDao {
	// 알람 목록
	public List<Alarm> selectAll(String userId);

	// 알람 삭제
	public int deleteAlarm(int alarmId);

	// 알람 수정 (읽음 표시)
	public int updateAlarm(int alarmId);
	
	// 알람 등록
	public int insertAlarm(Alarm alarm);
	
}
