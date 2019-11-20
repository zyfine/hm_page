package com.hm.hm_page.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HmBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HmBookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitlePicIsNull() {
            addCriterion("title_pic is null");
            return (Criteria) this;
        }

        public Criteria andTitlePicIsNotNull() {
            addCriterion("title_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTitlePicEqualTo(String value) {
            addCriterion("title_pic =", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotEqualTo(String value) {
            addCriterion("title_pic <>", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicGreaterThan(String value) {
            addCriterion("title_pic >", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicGreaterThanOrEqualTo(String value) {
            addCriterion("title_pic >=", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLessThan(String value) {
            addCriterion("title_pic <", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLessThanOrEqualTo(String value) {
            addCriterion("title_pic <=", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLike(String value) {
            addCriterion("title_pic like", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotLike(String value) {
            addCriterion("title_pic not like", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicIn(List<String> values) {
            addCriterion("title_pic in", values, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotIn(List<String> values) {
            addCriterion("title_pic not in", values, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicBetween(String value1, String value2) {
            addCriterion("title_pic between", value1, value2, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotBetween(String value1, String value2) {
            addCriterion("title_pic not between", value1, value2, "titlePic");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andChapterLastIsNull() {
            addCriterion("chapter_last is null");
            return (Criteria) this;
        }

        public Criteria andChapterLastIsNotNull() {
            addCriterion("chapter_last is not null");
            return (Criteria) this;
        }

        public Criteria andChapterLastEqualTo(String value) {
            addCriterion("chapter_last =", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastNotEqualTo(String value) {
            addCriterion("chapter_last <>", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastGreaterThan(String value) {
            addCriterion("chapter_last >", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastGreaterThanOrEqualTo(String value) {
            addCriterion("chapter_last >=", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastLessThan(String value) {
            addCriterion("chapter_last <", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastLessThanOrEqualTo(String value) {
            addCriterion("chapter_last <=", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastLike(String value) {
            addCriterion("chapter_last like", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastNotLike(String value) {
            addCriterion("chapter_last not like", value, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastIn(List<String> values) {
            addCriterion("chapter_last in", values, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastNotIn(List<String> values) {
            addCriterion("chapter_last not in", values, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastBetween(String value1, String value2) {
            addCriterion("chapter_last between", value1, value2, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastNotBetween(String value1, String value2) {
            addCriterion("chapter_last not between", value1, value2, "chapterLast");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdIsNull() {
            addCriterion("chapter_last_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdIsNotNull() {
            addCriterion("chapter_last_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdEqualTo(Integer value) {
            addCriterion("chapter_last_id =", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdNotEqualTo(Integer value) {
            addCriterion("chapter_last_id <>", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdGreaterThan(Integer value) {
            addCriterion("chapter_last_id >", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapter_last_id >=", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdLessThan(Integer value) {
            addCriterion("chapter_last_id <", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdLessThanOrEqualTo(Integer value) {
            addCriterion("chapter_last_id <=", value, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdIn(List<Integer> values) {
            addCriterion("chapter_last_id in", values, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdNotIn(List<Integer> values) {
            addCriterion("chapter_last_id not in", values, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdBetween(Integer value1, Integer value2) {
            addCriterion("chapter_last_id between", value1, value2, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andChapterLastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chapter_last_id not between", value1, value2, "chapterLastId");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNull() {
            addCriterion("is_end is null");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNotNull() {
            addCriterion("is_end is not null");
            return (Criteria) this;
        }

        public Criteria andIsEndEqualTo(String value) {
            addCriterion("is_end =", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotEqualTo(String value) {
            addCriterion("is_end <>", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThan(String value) {
            addCriterion("is_end >", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThanOrEqualTo(String value) {
            addCriterion("is_end >=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThan(String value) {
            addCriterion("is_end <", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThanOrEqualTo(String value) {
            addCriterion("is_end <=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLike(String value) {
            addCriterion("is_end like", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotLike(String value) {
            addCriterion("is_end not like", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndIn(List<String> values) {
            addCriterion("is_end in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotIn(List<String> values) {
            addCriterion("is_end not in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndBetween(String value1, String value2) {
            addCriterion("is_end between", value1, value2, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotBetween(String value1, String value2) {
            addCriterion("is_end not between", value1, value2, "isEnd");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(BigDecimal value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(BigDecimal value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(BigDecimal value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(BigDecimal value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<BigDecimal> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<BigDecimal> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIsNull() {
            addCriterion("latest_time is null");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIsNotNull() {
            addCriterion("latest_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatestTimeEqualTo(Date value) {
            addCriterion("latest_time =", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotEqualTo(Date value) {
            addCriterion("latest_time <>", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeGreaterThan(Date value) {
            addCriterion("latest_time >", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("latest_time >=", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeLessThan(Date value) {
            addCriterion("latest_time <", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeLessThanOrEqualTo(Date value) {
            addCriterion("latest_time <=", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIn(List<Date> values) {
            addCriterion("latest_time in", values, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotIn(List<Date> values) {
            addCriterion("latest_time not in", values, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeBetween(Date value1, Date value2) {
            addCriterion("latest_time between", value1, value2, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotBetween(Date value1, Date value2) {
            addCriterion("latest_time not between", value1, value2, "latestTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}