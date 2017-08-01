package com.bt.dao;

import java.util.List;

import com.bt.domain.Tags;

public interface TagsDao {
	 public List<Tags> getTags();
	    public Tags getTagsById(int id);
	    public int saveTags(Tags u);
	    public void persistTags(Tags u);
	    public boolean updateTags(Tags u);
	    public Tags mergeTags(Tags u);
}
