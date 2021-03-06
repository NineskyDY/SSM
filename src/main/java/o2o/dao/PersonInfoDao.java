package o2o.dao;

import o2o.entity.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonInfoDao {

	/**
	 * 
	 * @param personInfoCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<PersonInfo> queryPersonInfoList(
            @Param("personInfoCondition") PersonInfo personInfoCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	/**
	 *
	 * @param personInfoCondition
	 * @return
	 */
	int queryPersonInfoCount(
            @Param("personInfoCondition") PersonInfo personInfoCondition);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);

	/**
	 *根据id得到用户信息
	 * @return
	 */
	int insertPersonInfo(PersonInfo personInfo);

	/**
	 *插入用户信息
	 * @return
	 */
	int updatePersonInfo(PersonInfo personInfo);

	/**
	 *
	 * @return
	 */
	int deletePersonInfo(long userId);
}
