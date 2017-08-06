package com.bt.dao;

import java.util.List;

import com.bt.domain.*;

public interface ImagePostedDao {
	 public List<ImagePosted> getImagesPosted();
	    public ImagePosted getImagePostedById(int id);
	    public int saveImagePosted(ImagePosted u);
	    public void persistImagePosted(ImagePosted u);
	    public boolean updateImagePosted(ImagePosted u);
	    public ImagePosted mergeImagePosted(ImagePosted u);
		public void postImage(String caption, String image, User user);
}
