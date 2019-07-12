package com.scatterlab.lhs.springboot.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Community")
public class Community {
    private Long id;
    private Long uprId;
    private Long depth;
    private String title;
	private String contents;
    private long hit;
    private long liked;
    private long disliked;
    private long commentCnt;
	private String regId;
    private String nickname;
    private String profilephoto;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public long getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(long commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public long getLiked() {
		return liked;
	}
	public void setLiked(long liked) {
		this.liked = liked;
	}
	public long getDisliked() {
		return disliked;
	}
	public void setDisliked(long disliked) {
		this.disliked = disliked;
	}
    public Long getUprId() {
		return uprId;
	}
	public void setUprId(Long uprId) {
		this.uprId = uprId;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfilephoto() {
		return profilephoto;
	}
	public void setProfilePhoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}
}