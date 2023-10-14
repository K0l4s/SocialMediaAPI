package com.socialmedia.SocialMediaAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="follow", uniqueConstraints = {@UniqueConstraint(columnNames = "followID")})
public class Follow {
	@Id
	@GeneratedValue
	private Long followID;
	
	 @ManyToOne
	 @JoinColumn(name = "follower_userID")
	 private User follower;

	 @ManyToOne
	 @JoinColumn(name = "target_userID")
	 private User userTarget;

	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Follow(Long followID, User follower, User userTarget) {
		super();
		this.followID = followID;
		this.follower = follower;
		this.userTarget = userTarget;
	}

	public Long getFollowID() {
		return followID;
	}

	public void setFollowID(Long followID) {
		this.followID = followID;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getUserTarget() {
		return userTarget;
	}

	public void setUserTarget(User userTarget) {
		this.userTarget = userTarget;
	}
}
