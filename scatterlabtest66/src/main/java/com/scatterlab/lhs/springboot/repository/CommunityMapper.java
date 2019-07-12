package com.scatterlab.lhs.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.scatterlab.lhs.springboot.model.Community;
import com.scatterlab.lhs.springboot.model.RespCode;

@Mapper
public interface CommunityMapper {
	
	List<Community> selectCommunityList();
	Community selectCommunityById(Community community);
	List<Community> selectCommentsById(Community community);
	int deleteCommunity(Community community);
	int updateLike(Community community);
	int updateDislike(Community community);
	int insertCommunity(Community community);
	int insertComments(Community community);
	int updateComments(Community community);
}
