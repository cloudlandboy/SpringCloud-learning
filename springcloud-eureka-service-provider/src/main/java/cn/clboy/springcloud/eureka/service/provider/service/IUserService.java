package cn.clboy.springcloud.eureka.service.provider.service;


import cn.clboy.springcloud.eureka.service.provider.pojo.TbUser;

/**
 * @Author cloudlandboy
 * @Date 2019/11/25 下午4:59
 * @Since 1.0.0
 */

public interface IUserService {

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public TbUser queryById(Long id);
}