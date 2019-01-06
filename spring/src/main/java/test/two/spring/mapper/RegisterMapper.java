package test.two.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {
    @Select("select * from userinfo where account = #{account}")
    String SelectTel(String account);

    @Insert("insert into userinfo values(0,#{account},#{password},'','','',#{salt},'','','','')")
    int addUserinfo(@Param("account") String account,@Param("password") String password,@Param("salt") String salt);
}
