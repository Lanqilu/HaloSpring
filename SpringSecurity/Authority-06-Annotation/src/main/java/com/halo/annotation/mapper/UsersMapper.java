package com.halo.annotation.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halo.annotation.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Halo
 * @date Created in 2021/04/15 5:07 PM
 * @description
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
