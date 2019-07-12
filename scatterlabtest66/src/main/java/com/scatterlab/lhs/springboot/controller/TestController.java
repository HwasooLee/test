package com.scatterlab.lhs.springboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scatterlab.lhs.springboot.model.Community;
import com.scatterlab.lhs.springboot.model.RespCode;
import com.scatterlab.lhs.springboot.service.CommunityService;


@RestController
public class TestController {
	
	private static Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private CommunityService communityService;
	
	//커뮤니티 리스트 가져오기
	@RequestMapping(value = "/community", method = RequestMethod.GET) 
	public ResponseEntity<List<Community>> community() {
		
		List<Community> communityList = communityService.getCommunityList();
		logger.info(":::getCommunityList:::"+communityList.toString());
		
		return new ResponseEntity<List<Community>>(communityList, HttpStatus.OK);
	}
	
	//커뮤니티 상세 가져오기
	@RequestMapping(value = "/communityById", method = RequestMethod.GET) 
	public ResponseEntity<Community> communityById(@RequestParam(value = "communityId") long communityId) {
		logger.info(":::communityId::"+communityId);
		
		Community community = new Community();
		community.setId(communityId);
		
		Community communityById = communityService.getCommunityById(community);

		
		return new ResponseEntity<Community>(communityById, HttpStatus.OK);
	}
	
	//댓글 상세 가져오기
	@RequestMapping(value = "/commentsById", method = RequestMethod.GET) 
	public ResponseEntity<List<Community>> commentsById(@RequestParam(value = "communityId") long communityId) {
		logger.info(":::communityId::"+communityId);
		
		Community community = new Community();
		community.setId(communityId);
		
		List<Community> commentsById = communityService.getCommentsById(community);

		
		return new ResponseEntity<List<Community>>(commentsById, HttpStatus.OK);
	}
	
	//게시글,댓글 삭제하기
	@RequestMapping(value = "/community" , method = RequestMethod.DELETE)
	public ResponseEntity<RespCode> deleteCommunity(@PathParam("communityId") Long communityId) {
		logger.info(":::communityId::"+communityId);
		
		Community community = new Community();
		community.setId(communityId);
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.deleteCommunity(community);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}
	
	//좋아요
	@RequestMapping(value = "/like", method = RequestMethod.PUT) 
	public ResponseEntity<RespCode> updateLike(@RequestParam(value = "communityId") long communityId) {
		logger.info(":::communityId::"+communityId);
		
		Community community = new Community();
		community.setId(communityId);
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.updateLike(community);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}
	
	//싫어요
	@RequestMapping(value = "/dislike", method = RequestMethod.PUT) 
	public ResponseEntity<RespCode> updateDislike(@RequestParam(value = "communityId") long communityId) {
		logger.info(":::communityId::"+communityId);
		
		Community community = new Community();
		community.setId(communityId);
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.updateDislike(community);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}
	
	//게시글 작성
	@RequestMapping(value = "/community", method = RequestMethod.POST) 
	public ResponseEntity<RespCode> insertCommunity(@RequestBody Community reqCommunity) {
		
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.insertCommunity(reqCommunity);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}
	
	//댓글 작성
	@RequestMapping(value = "/comments", method = RequestMethod.POST) 
	public ResponseEntity<RespCode> insertComments(@RequestBody Community reqCommunity) {
		
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.insertComments(reqCommunity);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}

	//게시글 수정
	@RequestMapping(value = "/community", method = RequestMethod.PUT) 
	public ResponseEntity<RespCode> updateComments(@RequestBody Community reqCommunity) {
		
		RespCode respCode = new RespCode();
		
		try {
			int procCnt = communityService.updateComments(reqCommunity);
			if(procCnt > 0) {
				respCode.setProcCnt(procCnt);
				respCode.setRespMsg("성공");
				respCode.setRespCode("Y");
			} else {
				respCode.setRespMsg("실패");
				respCode.setRespCode("N");
			}
			
		} catch (Exception e) {
			respCode.setRespMsg("실패");
			respCode.setRespCode("N");
		}
		
		return new ResponseEntity<RespCode>(respCode, HttpStatus.OK);
	}
}