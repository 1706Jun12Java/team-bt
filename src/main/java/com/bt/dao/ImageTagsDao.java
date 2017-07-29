package com.bt.dao;

import java.util.List;

import com.bt.domain.ImageTags;

public interface ImageTagsDao {
	public List<ImageTags> getImageTags();
    public ImageTags getImageTagsById(int id);
    public int saveImageTags(ImageTags u);
    public void persistImageTags(ImageTags u);
    public boolean updateImageTags(ImageTags u);
    public ImageTags mergeImageTags(ImageTags u);
}
