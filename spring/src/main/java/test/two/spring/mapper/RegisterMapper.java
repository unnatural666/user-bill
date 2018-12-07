package test.two.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.two.spring.bean.userInfo;

@Mapper
public interface RegisterMapper {
    @Select("select * from userinfo where tel = #{tel}")
    String SelectTel(String tel);

    @Insert("insert into userinfo values(0,#{tel},'',#{password},'','')")
    int addUserinfo(@Param("tel") String tel,@Param("password") String password);
}
