package com.socialmedia.SocialMediaAPI.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.Follow;
import com.socialmedia.SocialMediaAPI.Entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface FollowRepo extends JpaRepository<Follow, Long> {
	User save(User user);
	@Modifying
    @Transactional
    @Query("DELETE FROM Follow f WHERE f.follower.userID = :followerUserID AND f.userTarget.userID = :userTargetID")
    void deleteByFollowerAndUserTarget(@Param("followerUserID") String followerUserID, @Param("userTargetID") String userTargetID);
	ArrayList<Follow> findFollowsByFollowerUserIDAndUserTargetUserID(String followerID, String targetID);
}
