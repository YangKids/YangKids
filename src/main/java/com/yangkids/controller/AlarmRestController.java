package com.yangkids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.Alarm;
import com.yangkids.model.service.AlarmService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-alarm")
@Api(tags = "Alarm 컨트롤러")
@CrossOrigin("*")
public class AlarmRestController {
	//git
	@Autowired
	private AlarmService alarmService;

	@ApiOperation(value = "알람 목록")
	@GetMapping("/alarm")
	public ResponseEntity<?> alarm(String userId) {
		List<Alarm> list = alarmService.getAlarmList(userId);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Alarm>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "알람 확인")
	@PutMapping("/check/{alarmId}")
	public ResponseEntity<?> checkAlarm(@PathVariable int alarmId){
		try {
			int result = alarmService.checkAlarm(alarmId);
			if(result==0) throw new Exception();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch (Exception e) {
            return exceptionHandling(e);
        }
	}

	@ApiOperation(value = "알람 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<?> alarmDelete(int alarmId) {
		try {
			int result = alarmService.removeAlarm(alarmId);

			if (result == 0)
				throw new Exception();

			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
