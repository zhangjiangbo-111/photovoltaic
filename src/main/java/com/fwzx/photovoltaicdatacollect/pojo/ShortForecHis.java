package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class ShortForecHis {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column short_forec_his.data_time
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    private Date dataTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column short_forec_his.short_forec
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    private Double shortForec;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column short_forec_his.data_time
     *
     * @return the value of short_forec_his.data_time
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    public Date getDataTime() {
        return dataTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column short_forec_his.data_time
     *
     * @param dataTime the value for short_forec_his.data_time
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column short_forec_his.short_forec
     *
     * @return the value of short_forec_his.short_forec
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    public Double getShortForec() {
        return shortForec;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column short_forec_his.short_forec
     *
     * @param shortForec the value for short_forec_his.short_forec
     *
     * @mbg.generated Mon Jan 21 09:08:19 CST 2019
     */
    public void setShortForec(Double shortForec) {
        this.shortForec = shortForec;
    }
}