package com.halo.hello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halo.hello.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Halo
 * @create 2021/10/08 上午 11:24
 * @description
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
