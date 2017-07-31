package com.bt.dao;

import java.util.List;

import com.bt.domain.Likes;

public interface LikesDao {
	 public List<Likes> getLikes();
	    public Likes getLikesById(int id);
	    public int saveLikes(Likes u);
	    public void persistLikes(Likes u);
	    public boolean updateLikes(Likes u);
	    public Likes mergeLikes(Likes u);
}
