package test.two.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.two.spring.bean.userInfo;

@Mapper
public interface userInfoMapper {
    @Select("select * from userinfo where id=#{id}")
    public userInfo getUserById(Integer id);
}
