package com.hm.hm_page.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HmBook {
    private Integer id;

    private String title;

    private String titlePic;

    private String author;

    private String chapterLast;

    private Integer chapterLastId;

    private String isEnd;

    private BigDecimal hot;

    private String label;

    private String type;

    private Date latestTime;

    private Date createTime;

    private String createPerson;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic == null ? null : titlePic.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getChapterLast() {
        return chapterLast;
    }

    public void setChapterLast(String chapterLast) {
        this.chapterLast = chapterLast == null ? null : chapterLast.trim();
    }

    public Integer getChapterLastId() {
        return chapterLastId;
    }

    public void setChapterLastId(Integer chapterLastId) {
        this.chapterLastId = chapterLastId;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(String isEnd) {
        this.isEnd = isEnd == null ? null : isEnd.trim();
    }

    public BigDecimal getHot() {
        return hot;
    }

    public void setHot(BigDecimal hot) {
        this.hot = hot;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}