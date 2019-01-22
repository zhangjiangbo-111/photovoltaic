package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupershortForecHisExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public SupershortForecHisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
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

        public Criteria andDataTimeIsNull() {
            addCriterion("data_time is null");
            return (Criteria) this;
        }

        public Criteria andDataTimeIsNotNull() {
            addCriterion("data_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataTimeEqualTo(Date value) {
            addCriterion("data_time =", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotEqualTo(Date value) {
            addCriterion("data_time <>", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThan(Date value) {
            addCriterion("data_time >", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("data_time >=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThan(Date value) {
            addCriterion("data_time <", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThanOrEqualTo(Date value) {
            addCriterion("data_time <=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeIn(List<Date> values) {
            addCriterion("data_time in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotIn(List<Date> values) {
            addCriterion("data_time not in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeBetween(Date value1, Date value2) {
            addCriterion("data_time between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotBetween(Date value1, Date value2) {
            addCriterion("data_time not between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andShortForecIsNull() {
            addCriterion("short_forec is null");
            return (Criteria) this;
        }

        public Criteria andShortForecIsNotNull() {
            addCriterion("short_forec is not null");
            return (Criteria) this;
        }

        public Criteria andShortForecEqualTo(Double value) {
            addCriterion("short_forec =", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecNotEqualTo(Double value) {
            addCriterion("short_forec <>", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecGreaterThan(Double value) {
            addCriterion("short_forec >", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecGreaterThanOrEqualTo(Double value) {
            addCriterion("short_forec >=", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecLessThan(Double value) {
            addCriterion("short_forec <", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecLessThanOrEqualTo(Double value) {
            addCriterion("short_forec <=", value, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecIn(List<Double> values) {
            addCriterion("short_forec in", values, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecNotIn(List<Double> values) {
            addCriterion("short_forec not in", values, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecBetween(Double value1, Double value2) {
            addCriterion("short_forec between", value1, value2, "shortForec");
            return (Criteria) this;
        }

        public Criteria andShortForecNotBetween(Double value1, Double value2) {
            addCriterion("short_forec not between", value1, value2, "shortForec");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table supershort_forec_his
     *
     * @mbg.generated do_not_delete_during_merge Mon Jan 21 11:52:44 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table supershort_forec_his
     *
     * @mbg.generated Mon Jan 21 11:52:44 CST 2019
     */
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