package test.two.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.two.spring.bean.userInfo;

@Mapper
public interface LoginMapper {

    @Select("select * from userinfo where tel=#{tel} and password=#{password}")
    userInfo findUserByNamePassWord(@Param("tel") String tel,@Param("password") String password);
}
