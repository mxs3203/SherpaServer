package com.sherpa.dto;

import com.sherpa.model.Tag;

public class TagDto {

	private long tagId;
	private String tagName;

	public TagDto() {
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Tag toModel() {
		Tag tag = new Tag();
		tag.setTagId(tagId);
		tag.setTagName(tagName);
		return tag;
	}

}
