package test.two.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface BillMapper {

    @Insert("insert into billinfo values(0,#{eename},#{billname},#{money},#{billtime},#{flaw},#{want},#{endorse},#{path})")
    int addPath(@Param("path") String path, @Param("billname") String billname, @Param("eename") String eename, @Param("endorse") String endorse, @Param("flaw") String flaw, @Param("billtime") String billtime, @Param("money") String money, @Param("want") String want);

    @Select("select path from image where id=6")
    String findPth();
}
