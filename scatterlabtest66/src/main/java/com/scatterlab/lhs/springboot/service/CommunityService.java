package com.scatterlab.lhs.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scatterlab.lhs.springboot.model.Community;
import com.scatterlab.lhs.springboot.model.RespCode;
import com.scatterlab.lhs.springboot.repository.CommunityMapper;

@Service
@Transactional
public class CommunityService {
	
    @Autowired
    CommunityMapper communityMapper;

    public List<Community> getCommunityList() {
		return communityMapper.selectCommunityList();
	}
    
    public Community getCommunityById(Community community) {
		return communityMapper.selectCommunityById(community);
	}
	
    public List<Community> getCommentsById(Community community) {
		return communityMapper.selectCommentsById(community);
	}
    
    public int deleteCommunity(Community community) {
    	return communityMapper.deleteCommunity(community);
    	 
	}
    
    public int updateLike(Community community) {
    	return communityMapper.updateLike(community);
    	 
	}
    
    public int updateDislike(Community community) {
    	return communityMapper.updateDislike(community);
    	 
	}
    
    public int insertCommunity(Community community) {
    	return communityMapper.insertCommunity(community);
    	 
	}
    
    public int insertComments(Community community) {
    	return communityMapper.insertComments(community);
    	 
	}
    
    public int updateComments(Community community) {
    	return communityMapper.updateComments(community);
    	 
	}

}
