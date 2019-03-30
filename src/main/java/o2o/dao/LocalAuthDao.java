package o2o.dao;

import o2o.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-23 17:36
 */
public interface LocalAuthDao {
    /*
     * @description: 通过账号密码查询对应信息，登陆用
     * @date: 2019/3/23
     * @param：[userName, password]
     * @return: o2o.entity.LocalAuth
     */
    LocalAuth queryLocalByUserNameAndPwd(@Param("userName")String userName,@Param("password")String password);

    /*
     * @description: 通过用户id查询对应lacalAuth
     * @date: 2019/3/23
     * @param：[userId]
     * @return: o2o.entity.LocalAuth
     */
    LocalAuth queryLocalByUserId(@Param("userId")long userId);

   /*
    * 添加平台账号
    */
    int insertLocalAuth(LocalAuth localAuth);
    /*
     *通过userId,userName,password更改密码
     */
    int updateLocalAuth(@Param("userId")long userId,@Param("userName")String userName,
                        @Param("password")String password,@Param("newPassword")String newPassword,
                        @Param("lastEditTime")Date lastEditTime);
}
