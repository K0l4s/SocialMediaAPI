package com.socialmedia.SocialMediaAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="like_comment", uniqueConstraints = {
		@UniqueConstraint(columnNames = "likeCommentID")
})
public class LikeComment {
	@Id
	@GeneratedValue
	private Long likeCommentID;
	
	@ManyToOne
	@JoinColumn(name="commentID")
	private Comment comment;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public LikeComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeComment(Long likeCommentID, Comment comment, User user) {
		super();
		this.likeCommentID = likeCommentID;
		this.comment = comment;
		this.user = user;
	}

	public Long getLikeCommentID() {
		return likeCommentID;
	}

	public void setLikeCommentID(Long likeCommentID) {
		this.likeCommentID = likeCommentID;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
