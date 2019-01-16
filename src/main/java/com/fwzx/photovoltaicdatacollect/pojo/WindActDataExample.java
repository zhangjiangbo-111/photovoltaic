package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WindActDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WindActDataExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNull() {
            addCriterion("get_time is null");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNotNull() {
            addCriterion("get_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetTimeEqualTo(Date value) {
            addCriterion("get_time =", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotEqualTo(Date value) {
            addCriterion("get_time <>", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThan(Date value) {
            addCriterion("get_time >", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("get_time >=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThan(Date value) {
            addCriterion("get_time <", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThanOrEqualTo(Date value) {
            addCriterion("get_time <=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeIn(List<Date> values) {
            addCriterion("get_time in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotIn(List<Date> values) {
            addCriterion("get_time not in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeBetween(Date value1, Date value2) {
            addCriterion("get_time between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotBetween(Date value1, Date value2) {
            addCriterion("get_time not between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andInstRadiationIsNull() {
            addCriterion("inst_radiation is null");
            return (Criteria) this;
        }

        public Criteria andInstRadiationIsNotNull() {
            addCriterion("inst_radiation is not null");
            return (Criteria) this;
        }

        public Criteria andInstRadiationEqualTo(Double value) {
            addCriterion("inst_radiation =", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationNotEqualTo(Double value) {
            addCriterion("inst_radiation <>", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationGreaterThan(Double value) {
            addCriterion("inst_radiation >", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationGreaterThanOrEqualTo(Double value) {
            addCriterion("inst_radiation >=", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationLessThan(Double value) {
            addCriterion("inst_radiation <", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationLessThanOrEqualTo(Double value) {
            addCriterion("inst_radiation <=", value, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationIn(List<Double> values) {
            addCriterion("inst_radiation in", values, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationNotIn(List<Double> values) {
            addCriterion("inst_radiation not in", values, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationBetween(Double value1, Double value2) {
            addCriterion("inst_radiation between", value1, value2, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andInstRadiationNotBetween(Double value1, Double value2) {
            addCriterion("inst_radiation not between", value1, value2, "instRadiation");
            return (Criteria) this;
        }

        public Criteria andWindSIsNull() {
            addCriterion("wind_s is null");
            return (Criteria) this;
        }

        public Criteria andWindSIsNotNull() {
            addCriterion("wind_s is not null");
            return (Criteria) this;
        }

        public Criteria andWindSEqualTo(Double value) {
            addCriterion("wind_s =", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSNotEqualTo(Double value) {
            addCriterion("wind_s <>", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSGreaterThan(Double value) {
            addCriterion("wind_s >", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSGreaterThanOrEqualTo(Double value) {
            addCriterion("wind_s >=", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSLessThan(Double value) {
            addCriterion("wind_s <", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSLessThanOrEqualTo(Double value) {
            addCriterion("wind_s <=", value, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSIn(List<Double> values) {
            addCriterion("wind_s in", values, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSNotIn(List<Double> values) {
            addCriterion("wind_s not in", values, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSBetween(Double value1, Double value2) {
            addCriterion("wind_s between", value1, value2, "windS");
            return (Criteria) this;
        }

        public Criteria andWindSNotBetween(Double value1, Double value2) {
            addCriterion("wind_s not between", value1, value2, "windS");
            return (Criteria) this;
        }

        public Criteria andWindDIsNull() {
            addCriterion("wind_d is null");
            return (Criteria) this;
        }

        public Criteria andWindDIsNotNull() {
            addCriterion("wind_d is not null");
            return (Criteria) this;
        }

        public Criteria andWindDEqualTo(Double value) {
            addCriterion("wind_d =", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDNotEqualTo(Double value) {
            addCriterion("wind_d <>", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDGreaterThan(Double value) {
            addCriterion("wind_d >", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDGreaterThanOrEqualTo(Double value) {
            addCriterion("wind_d >=", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDLessThan(Double value) {
            addCriterion("wind_d <", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDLessThanOrEqualTo(Double value) {
            addCriterion("wind_d <=", value, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDIn(List<Double> values) {
            addCriterion("wind_d in", values, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDNotIn(List<Double> values) {
            addCriterion("wind_d not in", values, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDBetween(Double value1, Double value2) {
            addCriterion("wind_d between", value1, value2, "windD");
            return (Criteria) this;
        }

        public Criteria andWindDNotBetween(Double value1, Double value2) {
            addCriterion("wind_d not between", value1, value2, "windD");
            return (Criteria) this;
        }

        public Criteria andTemIsNull() {
            addCriterion("tem is null");
            return (Criteria) this;
        }

        public Criteria andTemIsNotNull() {
            addCriterion("tem is not null");
            return (Criteria) this;
        }

        public Criteria andTemEqualTo(Double value) {
            addCriterion("tem =", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotEqualTo(Double value) {
            addCriterion("tem <>", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemGreaterThan(Double value) {
            addCriterion("tem >", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemGreaterThanOrEqualTo(Double value) {
            addCriterion("tem >=", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemLessThan(Double value) {
            addCriterion("tem <", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemLessThanOrEqualTo(Double value) {
            addCriterion("tem <=", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemIn(List<Double> values) {
            addCriterion("tem in", values, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotIn(List<Double> values) {
            addCriterion("tem not in", values, "tem");
            return (Criteria) this;
        }

        public Criteria andTemBetween(Double value1, Double value2) {
            addCriterion("tem between", value1, value2, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotBetween(Double value1, Double value2) {
            addCriterion("tem not between", value1, value2, "tem");
            return (Criteria) this;
        }

        public Criteria andHumiIsNull() {
            addCriterion("humi is null");
            return (Criteria) this;
        }

        public Criteria andHumiIsNotNull() {
            addCriterion("humi is not null");
            return (Criteria) this;
        }

        public Criteria andHumiEqualTo(Double value) {
            addCriterion("humi =", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiNotEqualTo(Double value) {
            addCriterion("humi <>", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiGreaterThan(Double value) {
            addCriterion("humi >", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiGreaterThanOrEqualTo(Double value) {
            addCriterion("humi >=", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiLessThan(Double value) {
            addCriterion("humi <", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiLessThanOrEqualTo(Double value) {
            addCriterion("humi <=", value, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiIn(List<Double> values) {
            addCriterion("humi in", values, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiNotIn(List<Double> values) {
            addCriterion("humi not in", values, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiBetween(Double value1, Double value2) {
            addCriterion("humi between", value1, value2, "humi");
            return (Criteria) this;
        }

        public Criteria andHumiNotBetween(Double value1, Double value2) {
            addCriterion("humi not between", value1, value2, "humi");
            return (Criteria) this;
        }

        public Criteria andPressIsNull() {
            addCriterion("press is null");
            return (Criteria) this;
        }

        public Criteria andPressIsNotNull() {
            addCriterion("press is not null");
            return (Criteria) this;
        }

        public Criteria andPressEqualTo(Double value) {
            addCriterion("press =", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotEqualTo(Double value) {
            addCriterion("press <>", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThan(Double value) {
            addCriterion("press >", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThanOrEqualTo(Double value) {
            addCriterion("press >=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThan(Double value) {
            addCriterion("press <", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThanOrEqualTo(Double value) {
            addCriterion("press <=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressIn(List<Double> values) {
            addCriterion("press in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotIn(List<Double> values) {
            addCriterion("press not in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressBetween(Double value1, Double value2) {
            addCriterion("press between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotBetween(Double value1, Double value2) {
            addCriterion("press not between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPrePowerIsNull() {
            addCriterion("pre_power is null");
            return (Criteria) this;
        }

        public Criteria andPrePowerIsNotNull() {
            addCriterion("pre_power is not null");
            return (Criteria) this;
        }

        public Criteria andPrePowerEqualTo(Double value) {
            addCriterion("pre_power =", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerNotEqualTo(Double value) {
            addCriterion("pre_power <>", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerGreaterThan(Double value) {
            addCriterion("pre_power >", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerGreaterThanOrEqualTo(Double value) {
            addCriterion("pre_power >=", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerLessThan(Double value) {
            addCriterion("pre_power <", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerLessThanOrEqualTo(Double value) {
            addCriterion("pre_power <=", value, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerIn(List<Double> values) {
            addCriterion("pre_power in", values, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerNotIn(List<Double> values) {
            addCriterion("pre_power not in", values, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerBetween(Double value1, Double value2) {
            addCriterion("pre_power between", value1, value2, "prePower");
            return (Criteria) this;
        }

        public Criteria andPrePowerNotBetween(Double value1, Double value2) {
            addCriterion("pre_power not between", value1, value2, "prePower");
            return (Criteria) this;
        }

        public Criteria andActPowerIsNull() {
            addCriterion("act_power is null");
            return (Criteria) this;
        }

        public Criteria andActPowerIsNotNull() {
            addCriterion("act_power is not null");
            return (Criteria) this;
        }

        public Criteria andActPowerEqualTo(Double value) {
            addCriterion("act_power =", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerNotEqualTo(Double value) {
            addCriterion("act_power <>", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerGreaterThan(Double value) {
            addCriterion("act_power >", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("act_power >=", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerLessThan(Double value) {
            addCriterion("act_power <", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerLessThanOrEqualTo(Double value) {
            addCriterion("act_power <=", value, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerIn(List<Double> values) {
            addCriterion("act_power in", values, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerNotIn(List<Double> values) {
            addCriterion("act_power not in", values, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerBetween(Double value1, Double value2) {
            addCriterion("act_power between", value1, value2, "actPower");
            return (Criteria) this;
        }

        public Criteria andActPowerNotBetween(Double value1, Double value2) {
            addCriterion("act_power not between", value1, value2, "actPower");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterion("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterion("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterion("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterion("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterion("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterion("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterion("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterion("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterion("entry_time not between", value1, value2, "entryTime");
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