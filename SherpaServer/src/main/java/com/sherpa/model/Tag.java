package com.sherpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sherpa.dto.TagDto;

@Entity
@Table(name = "tag", catalog = "sherpa")
public class Tag implements java.io.Serializable {

	private static final long serialVersionUID = 6040534604155616135L;

	private long tagId;
	private String tagName;
	private Set<EventTagCross> eventTagCrosses = new HashSet<EventTagCross>(0);

	public Tag() {
	}

	public Tag(long tagId) {
		this.tagId = tagId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	public long getTagId() {
		return this.tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tag_name", nullable = false, length = 64)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
	public Set<EventTagCross> getEventTagCrosses() {
		return this.eventTagCrosses;
	}

	public void setEventTagCrosses(Set<EventTagCross> eventTagCrosses) {
		this.eventTagCrosses = eventTagCrosses;
	}

	public TagDto toDto() {
		TagDto tagDto = new TagDto();
		tagDto.setTagId(tagId);
		tagDto.setTagName(tagName);
		return tagDto;
	}

}
