package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.ShortForecFut;
import com.fwzx.photovoltaicdatacollect.pojo.ShortForecFutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShortForecFutMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    long countByExample(ShortForecFutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    int deleteByExample(ShortForecFutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    int insert(ShortForecFut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    int insertSelective(ShortForecFut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    List<ShortForecFut> selectByExample(ShortForecFutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") ShortForecFut record, @Param("example") ShortForecFutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table short_forec_fut
     *
     * @mbg.generated Thu Jan 24 09:40:14 CST 2019
     */
    int updateByExample(@Param("record") ShortForecFut record, @Param("example") ShortForecFutExample example);

	void deleteAllData();

	void insertDataByStr(@Param("dataSql") String dataSql);
}