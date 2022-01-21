package top.headfirst.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import top.headfirst.vhr.model.Hr;
import top.headfirst.vhr.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);



    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrId, @Param("keywords") String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer updateHrPasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}