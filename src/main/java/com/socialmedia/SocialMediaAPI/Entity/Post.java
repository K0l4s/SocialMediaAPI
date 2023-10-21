package com.socialmedia.SocialMediaAPI.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "post", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "postID")})
public class Post {
    @Id
    @GeneratedValue
    private Long postID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="cityID")
    private City city;
    
    @Column(nullable = true)
    private String imageURL;
    
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime createDay;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Long postID, User user, City city, String imageURL, String content,
			LocalDateTime createDay) {
		super();
		this.postID = postID;
		this.user = user;
		this.city = city;
		this.imageURL = imageURL;
		this.content = content;
		this.createDay = createDay;
	}
	public Long getPostID() {
		return postID;
	}
	public void setPostID(Long postID) {
		this.postID = postID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreateDay() {
		return createDay;
	}
	public void setCreateDay(LocalDateTime createDay) {
		this.createDay = createDay;
	}
}

