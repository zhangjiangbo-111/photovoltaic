package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WindActSDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WindActSDataExample() {
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

        public Criteria andAngleIsNull() {
            addCriterion("angle is null");
            return (Criteria) this;
        }

        public Criteria andAngleIsNotNull() {
            addCriterion("angle is not null");
            return (Criteria) this;
        }

        public Criteria andAngleEqualTo(Double value) {
            addCriterion("angle =", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotEqualTo(Double value) {
            addCriterion("angle <>", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThan(Double value) {
            addCriterion("angle >", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThanOrEqualTo(Double value) {
            addCriterion("angle >=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThan(Double value) {
            addCriterion("angle <", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThanOrEqualTo(Double value) {
            addCriterion("angle <=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleIn(List<Double> values) {
            addCriterion("angle in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotIn(List<Double> values) {
            addCriterion("angle not in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleBetween(Double value1, Double value2) {
            addCriterion("angle between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotBetween(Double value1, Double value2) {
            addCriterion("angle not between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andVoltage1IsNull() {
            addCriterion("voltage1 is null");
            return (Criteria) this;
        }

        public Criteria andVoltage1IsNotNull() {
            addCriterion("voltage1 is not null");
            return (Criteria) this;
        }

        public Criteria andVoltage1EqualTo(Double value) {
            addCriterion("voltage1 =", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1NotEqualTo(Double value) {
            addCriterion("voltage1 <>", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1GreaterThan(Double value) {
            addCriterion("voltage1 >", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1GreaterThanOrEqualTo(Double value) {
            addCriterion("voltage1 >=", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1LessThan(Double value) {
            addCriterion("voltage1 <", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1LessThanOrEqualTo(Double value) {
            addCriterion("voltage1 <=", value, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1In(List<Double> values) {
            addCriterion("voltage1 in", values, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1NotIn(List<Double> values) {
            addCriterion("voltage1 not in", values, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1Between(Double value1, Double value2) {
            addCriterion("voltage1 between", value1, value2, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage1NotBetween(Double value1, Double value2) {
            addCriterion("voltage1 not between", value1, value2, "voltage1");
            return (Criteria) this;
        }

        public Criteria andVoltage2IsNull() {
            addCriterion("voltage2 is null");
            return (Criteria) this;
        }

        public Criteria andVoltage2IsNotNull() {
            addCriterion("voltage2 is not null");
            return (Criteria) this;
        }

        public Criteria andVoltage2EqualTo(Double value) {
            addCriterion("voltage2 =", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2NotEqualTo(Double value) {
            addCriterion("voltage2 <>", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2GreaterThan(Double value) {
            addCriterion("voltage2 >", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2GreaterThanOrEqualTo(Double value) {
            addCriterion("voltage2 >=", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2LessThan(Double value) {
            addCriterion("voltage2 <", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2LessThanOrEqualTo(Double value) {
            addCriterion("voltage2 <=", value, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2In(List<Double> values) {
            addCriterion("voltage2 in", values, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2NotIn(List<Double> values) {
            addCriterion("voltage2 not in", values, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2Between(Double value1, Double value2) {
            addCriterion("voltage2 between", value1, value2, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage2NotBetween(Double value1, Double value2) {
            addCriterion("voltage2 not between", value1, value2, "voltage2");
            return (Criteria) this;
        }

        public Criteria andVoltage3IsNull() {
            addCriterion("voltage3 is null");
            return (Criteria) this;
        }

        public Criteria andVoltage3IsNotNull() {
            addCriterion("voltage3 is not null");
            return (Criteria) this;
        }

        public Criteria andVoltage3EqualTo(Double value) {
            addCriterion("voltage3 =", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3NotEqualTo(Double value) {
            addCriterion("voltage3 <>", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3GreaterThan(Double value) {
            addCriterion("voltage3 >", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3GreaterThanOrEqualTo(Double value) {
            addCriterion("voltage3 >=", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3LessThan(Double value) {
            addCriterion("voltage3 <", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3LessThanOrEqualTo(Double value) {
            addCriterion("voltage3 <=", value, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3In(List<Double> values) {
            addCriterion("voltage3 in", values, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3NotIn(List<Double> values) {
            addCriterion("voltage3 not in", values, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3Between(Double value1, Double value2) {
            addCriterion("voltage3 between", value1, value2, "voltage3");
            return (Criteria) this;
        }

        public Criteria andVoltage3NotBetween(Double value1, Double value2) {
            addCriterion("voltage3 not between", value1, value2, "voltage3");
            return (Criteria) this;
        }

        public Criteria andCurrent1IsNull() {
            addCriterion("current1 is null");
            return (Criteria) this;
        }

        public Criteria andCurrent1IsNotNull() {
            addCriterion("current1 is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent1EqualTo(Double value) {
            addCriterion("current1 =", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1NotEqualTo(Double value) {
            addCriterion("current1 <>", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1GreaterThan(Double value) {
            addCriterion("current1 >", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1GreaterThanOrEqualTo(Double value) {
            addCriterion("current1 >=", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1LessThan(Double value) {
            addCriterion("current1 <", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1LessThanOrEqualTo(Double value) {
            addCriterion("current1 <=", value, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1In(List<Double> values) {
            addCriterion("current1 in", values, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1NotIn(List<Double> values) {
            addCriterion("current1 not in", values, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1Between(Double value1, Double value2) {
            addCriterion("current1 between", value1, value2, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent1NotBetween(Double value1, Double value2) {
            addCriterion("current1 not between", value1, value2, "current1");
            return (Criteria) this;
        }

        public Criteria andCurrent2IsNull() {
            addCriterion("current2 is null");
            return (Criteria) this;
        }

        public Criteria andCurrent2IsNotNull() {
            addCriterion("current2 is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent2EqualTo(Double value) {
            addCriterion("current2 =", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2NotEqualTo(Double value) {
            addCriterion("current2 <>", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2GreaterThan(Double value) {
            addCriterion("current2 >", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2GreaterThanOrEqualTo(Double value) {
            addCriterion("current2 >=", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2LessThan(Double value) {
            addCriterion("current2 <", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2LessThanOrEqualTo(Double value) {
            addCriterion("current2 <=", value, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2In(List<Double> values) {
            addCriterion("current2 in", values, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2NotIn(List<Double> values) {
            addCriterion("current2 not in", values, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2Between(Double value1, Double value2) {
            addCriterion("current2 between", value1, value2, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent2NotBetween(Double value1, Double value2) {
            addCriterion("current2 not between", value1, value2, "current2");
            return (Criteria) this;
        }

        public Criteria andCurrent3IsNull() {
            addCriterion("current3 is null");
            return (Criteria) this;
        }

        public Criteria andCurrent3IsNotNull() {
            addCriterion("current3 is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent3EqualTo(Double value) {
            addCriterion("current3 =", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3NotEqualTo(Double value) {
            addCriterion("current3 <>", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3GreaterThan(Double value) {
            addCriterion("current3 >", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3GreaterThanOrEqualTo(Double value) {
            addCriterion("current3 >=", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3LessThan(Double value) {
            addCriterion("current3 <", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3LessThanOrEqualTo(Double value) {
            addCriterion("current3 <=", value, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3In(List<Double> values) {
            addCriterion("current3 in", values, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3NotIn(List<Double> values) {
            addCriterion("current3 not in", values, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3Between(Double value1, Double value2) {
            addCriterion("current3 between", value1, value2, "current3");
            return (Criteria) this;
        }

        public Criteria andCurrent3NotBetween(Double value1, Double value2) {
            addCriterion("current3 not between", value1, value2, "current3");
            return (Criteria) this;
        }

        public Criteria andTempeIsNull() {
            addCriterion("tempe is null");
            return (Criteria) this;
        }

        public Criteria andTempeIsNotNull() {
            addCriterion("tempe is not null");
            return (Criteria) this;
        }

        public Criteria andTempeEqualTo(Double value) {
            addCriterion("tempe =", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeNotEqualTo(Double value) {
            addCriterion("tempe <>", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeGreaterThan(Double value) {
            addCriterion("tempe >", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeGreaterThanOrEqualTo(Double value) {
            addCriterion("tempe >=", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeLessThan(Double value) {
            addCriterion("tempe <", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeLessThanOrEqualTo(Double value) {
            addCriterion("tempe <=", value, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeIn(List<Double> values) {
            addCriterion("tempe in", values, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeNotIn(List<Double> values) {
            addCriterion("tempe not in", values, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeBetween(Double value1, Double value2) {
            addCriterion("tempe between", value1, value2, "tempe");
            return (Criteria) this;
        }

        public Criteria andTempeNotBetween(Double value1, Double value2) {
            addCriterion("tempe not between", value1, value2, "tempe");
            return (Criteria) this;
        }

        public Criteria andWindIsNull() {
            addCriterion("wind is null");
            return (Criteria) this;
        }

        public Criteria andWindIsNotNull() {
            addCriterion("wind is not null");
            return (Criteria) this;
        }

        public Criteria andWindEqualTo(Double value) {
            addCriterion("wind =", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindNotEqualTo(Double value) {
            addCriterion("wind <>", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindGreaterThan(Double value) {
            addCriterion("wind >", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindGreaterThanOrEqualTo(Double value) {
            addCriterion("wind >=", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindLessThan(Double value) {
            addCriterion("wind <", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindLessThanOrEqualTo(Double value) {
            addCriterion("wind <=", value, "wind");
            return (Criteria) this;
        }

        public Criteria andWindIn(List<Double> values) {
            addCriterion("wind in", values, "wind");
            return (Criteria) this;
        }

        public Criteria andWindNotIn(List<Double> values) {
            addCriterion("wind not in", values, "wind");
            return (Criteria) this;
        }

        public Criteria andWindBetween(Double value1, Double value2) {
            addCriterion("wind between", value1, value2, "wind");
            return (Criteria) this;
        }

        public Criteria andWindNotBetween(Double value1, Double value2) {
            addCriterion("wind not between", value1, value2, "wind");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Double value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Double value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Double value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Double value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Double value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Double value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Double> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Double> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Double value1, Double value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Double value1, Double value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(Double value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(Double value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(Double value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(Double value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(Double value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<Double> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<Double> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(Double value1, Double value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(Double value1, Double value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andNopowerIsNull() {
            addCriterion("nopower is null");
            return (Criteria) this;
        }

        public Criteria andNopowerIsNotNull() {
            addCriterion("nopower is not null");
            return (Criteria) this;
        }

        public Criteria andNopowerEqualTo(Double value) {
            addCriterion("nopower =", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerNotEqualTo(Double value) {
            addCriterion("nopower <>", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerGreaterThan(Double value) {
            addCriterion("nopower >", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerGreaterThanOrEqualTo(Double value) {
            addCriterion("nopower >=", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerLessThan(Double value) {
            addCriterion("nopower <", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerLessThanOrEqualTo(Double value) {
            addCriterion("nopower <=", value, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerIn(List<Double> values) {
            addCriterion("nopower in", values, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerNotIn(List<Double> values) {
            addCriterion("nopower not in", values, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerBetween(Double value1, Double value2) {
            addCriterion("nopower between", value1, value2, "nopower");
            return (Criteria) this;
        }

        public Criteria andNopowerNotBetween(Double value1, Double value2) {
            addCriterion("nopower not between", value1, value2, "nopower");
            return (Criteria) this;
        }

        public Criteria andWindspeedIsNull() {
            addCriterion("windspeed is null");
            return (Criteria) this;
        }

        public Criteria andWindspeedIsNotNull() {
            addCriterion("windspeed is not null");
            return (Criteria) this;
        }

        public Criteria andWindspeedEqualTo(Double value) {
            addCriterion("windspeed =", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedNotEqualTo(Double value) {
            addCriterion("windspeed <>", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedGreaterThan(Double value) {
            addCriterion("windspeed >", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedGreaterThanOrEqualTo(Double value) {
            addCriterion("windspeed >=", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedLessThan(Double value) {
            addCriterion("windspeed <", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedLessThanOrEqualTo(Double value) {
            addCriterion("windspeed <=", value, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedIn(List<Double> values) {
            addCriterion("windspeed in", values, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedNotIn(List<Double> values) {
            addCriterion("windspeed not in", values, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedBetween(Double value1, Double value2) {
            addCriterion("windspeed between", value1, value2, "windspeed");
            return (Criteria) this;
        }

        public Criteria andWindspeedNotBetween(Double value1, Double value2) {
            addCriterion("windspeed not between", value1, value2, "windspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedIsNull() {
            addCriterion("motorspeed is null");
            return (Criteria) this;
        }

        public Criteria andMotorspeedIsNotNull() {
            addCriterion("motorspeed is not null");
            return (Criteria) this;
        }

        public Criteria andMotorspeedEqualTo(Double value) {
            addCriterion("motorspeed =", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedNotEqualTo(Double value) {
            addCriterion("motorspeed <>", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedGreaterThan(Double value) {
            addCriterion("motorspeed >", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedGreaterThanOrEqualTo(Double value) {
            addCriterion("motorspeed >=", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedLessThan(Double value) {
            addCriterion("motorspeed <", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedLessThanOrEqualTo(Double value) {
            addCriterion("motorspeed <=", value, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedIn(List<Double> values) {
            addCriterion("motorspeed in", values, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedNotIn(List<Double> values) {
            addCriterion("motorspeed not in", values, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedBetween(Double value1, Double value2) {
            addCriterion("motorspeed between", value1, value2, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andMotorspeedNotBetween(Double value1, Double value2) {
            addCriterion("motorspeed not between", value1, value2, "motorspeed");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Double value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Double value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Double value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Double value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Double value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Double value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Double> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Double> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Double value1, Double value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Double value1, Double value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andElectricIsNull() {
            addCriterion("electric is null");
            return (Criteria) this;
        }

        public Criteria andElectricIsNotNull() {
            addCriterion("electric is not null");
            return (Criteria) this;
        }

        public Criteria andElectricEqualTo(Double value) {
            addCriterion("electric =", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotEqualTo(Double value) {
            addCriterion("electric <>", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricGreaterThan(Double value) {
            addCriterion("electric >", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricGreaterThanOrEqualTo(Double value) {
            addCriterion("electric >=", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricLessThan(Double value) {
            addCriterion("electric <", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricLessThanOrEqualTo(Double value) {
            addCriterion("electric <=", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricIn(List<Double> values) {
            addCriterion("electric in", values, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotIn(List<Double> values) {
            addCriterion("electric not in", values, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricBetween(Double value1, Double value2) {
            addCriterion("electric between", value1, value2, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotBetween(Double value1, Double value2) {
            addCriterion("electric not between", value1, value2, "electric");
            return (Criteria) this;
        }

        public Criteria andFactorIsNull() {
            addCriterion("factor is null");
            return (Criteria) this;
        }

        public Criteria andFactorIsNotNull() {
            addCriterion("factor is not null");
            return (Criteria) this;
        }

        public Criteria andFactorEqualTo(Double value) {
            addCriterion("factor =", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotEqualTo(Double value) {
            addCriterion("factor <>", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThan(Double value) {
            addCriterion("factor >", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThanOrEqualTo(Double value) {
            addCriterion("factor >=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThan(Double value) {
            addCriterion("factor <", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThanOrEqualTo(Double value) {
            addCriterion("factor <=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorIn(List<Double> values) {
            addCriterion("factor in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotIn(List<Double> values) {
            addCriterion("factor not in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorBetween(Double value1, Double value2) {
            addCriterion("factor between", value1, value2, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotBetween(Double value1, Double value2) {
            addCriterion("factor not between", value1, value2, "factor");
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