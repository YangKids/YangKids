package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Alarm;

public interface AlarmDao {
	public List<Alarm> selectAll(String userId);

	// 알람 상세
	public Alarm selectOne(int alarmId);

	// 알람 삭제
	public int deleteAlarm(int alarmId);

	// 알람 수정 (읽었는지)
	public int updateAlarm(int alarmId);
	
	// 알람 등록
	public int insertAlarm(Alarm alarm);
	
	


}
