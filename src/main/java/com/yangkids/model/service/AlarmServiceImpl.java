package com.yangkids.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.AlarmDao;
import com.yangkids.model.dao.ArticleDao;
import com.yangkids.model.dto.Alarm;
import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;

@Service
public class AlarmServiceImpl implements AlarmService {

	private AlarmDao alarmDao;

	@Autowired
	public void setArticleDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}

	// 유저 별 알람 목록 불러오기 
	@Override
	public List<Alarm> getAlarmList(String userId) {
		return alarmDao.selectAll(userId);
	}
	
	@Override
	public Alarm readAlarm(int alarmId) {
		return alarmDao.selectOne(alarmId);
	}


	@Transactional
	@Override
	public int removeAlarm(int alarmId) {
		int result = alarmDao.deleteAlarm(alarmId);
		return result;
	}

	@Transactional
	@Override
	public int checkAlarm(int alarmId) {
		int result = alarmDao.updateAlarm(alarmId);
		return result;
	}

	@Override
	public int writeAlarm(Alarm alarm) {
		int result= alarmDao.insertAlarm(alarm);
		return result;
	}

}
