package com.hm.hm_page.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HmChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HmChapterExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNull() {
            addCriterion("chapter_name is null");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNotNull() {
            addCriterion("chapter_name is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNameEqualTo(String value) {
            addCriterion("chapter_name =", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotEqualTo(String value) {
            addCriterion("chapter_name <>", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThan(String value) {
            addCriterion("chapter_name >", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThanOrEqualTo(String value) {
            addCriterion("chapter_name >=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThan(String value) {
            addCriterion("chapter_name <", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThanOrEqualTo(String value) {
            addCriterion("chapter_name <=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLike(String value) {
            addCriterion("chapter_name like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotLike(String value) {
            addCriterion("chapter_name not like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameIn(List<String> values) {
            addCriterion("chapter_name in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotIn(List<String> values) {
            addCriterion("chapter_name not in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameBetween(String value1, String value2) {
            addCriterion("chapter_name between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotBetween(String value1, String value2) {
            addCriterion("chapter_name not between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNull() {
            addCriterion("chapter_num is null");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNotNull() {
            addCriterion("chapter_num is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNumEqualTo(Integer value) {
            addCriterion("chapter_num =", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotEqualTo(Integer value) {
            addCriterion("chapter_num <>", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThan(Integer value) {
            addCriterion("chapter_num >", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapter_num >=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThan(Integer value) {
            addCriterion("chapter_num <", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThanOrEqualTo(Integer value) {
            addCriterion("chapter_num <=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumIn(List<Integer> values) {
            addCriterion("chapter_num in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotIn(List<Integer> values) {
            addCriterion("chapter_num not in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumBetween(Integer value1, Integer value2) {
            addCriterion("chapter_num between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("chapter_num not between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andPagenumIsNull() {
            addCriterion("pagenum is null");
            return (Criteria) this;
        }

        public Criteria andPagenumIsNotNull() {
            addCriterion("pagenum is not null");
            return (Criteria) this;
        }

        public Criteria andPagenumEqualTo(Integer value) {
            addCriterion("pagenum =", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotEqualTo(Integer value) {
            addCriterion("pagenum <>", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumGreaterThan(Integer value) {
            addCriterion("pagenum >", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pagenum >=", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumLessThan(Integer value) {
            addCriterion("pagenum <", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumLessThanOrEqualTo(Integer value) {
            addCriterion("pagenum <=", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumIn(List<Integer> values) {
            addCriterion("pagenum in", values, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotIn(List<Integer> values) {
            addCriterion("pagenum not in", values, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumBetween(Integer value1, Integer value2) {
            addCriterion("pagenum between", value1, value2, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotBetween(Integer value1, Integer value2) {
            addCriterion("pagenum not between", value1, value2, "pagenum");
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