package test.two.spring.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import test.two.spring.bean.userInfo;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from userinfo")
    List<userInfo> findAll();

    @Select("select * from userinfo where account=#{account}")
    userInfo findUserByAccount(@Param("account") String account);

    @Select("select * from userinfo where account=#{account}")
    String findUserByTel(@Param("account")String account);

    @Select("select id from userinfo where account=#{account}")
    int findUserId(@Param("account") String account);

    @Update("update userinfo set eename=#{eename},lgname=#{lgname},email=#{email},address=#{address},idcard=#{idcard} where account=#{account}")
    int addInfo(@Param("eename") String eename,@Param("lgname") String lgname,@Param("email") String email,@Param("address") String address,@Param("idcard") String idcard,@Param("account") String account);

    @Select("select eename from userinfo where id=#{id}")
    String findEename(@Param("id") int id);


}