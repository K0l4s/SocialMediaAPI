package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.Follow;
import com.socialmedia.SocialMediaAPI.Repository.FollowRepo;

@Service
public class FollowService {
	@Autowired
	FollowRepo followRepo;
	
	public Follow startFollow(Follow fl) {
		return followRepo.save(fl);
	}
	
	public boolean delFollow(String followerID, String targetID) {
		try {
			if(checkExist(followerID, targetID)==false)
				return false;
			followRepo.deleteByFollowerAndUserTarget(followerID, targetID);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	public boolean checkExist(String followerID, String targetID) {
		ArrayList<Follow> flwList = followRepo.findFollowsByFollowerUserIDAndUserTargetUserID(followerID, targetID);
		if(flwList.isEmpty())
			return false;
		return true;
	}
}
