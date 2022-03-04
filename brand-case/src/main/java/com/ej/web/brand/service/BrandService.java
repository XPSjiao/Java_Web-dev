package com.ej.web.brand.service.impl;

import com.ej.web.brand.pojo.Brand;
import com.ej.web.brand.pojo.PageBean;

import java.util.List;

/**
 * @program: Java_Web-dev
 * @description: BrandService接口
 * @author: EthanJiao
 * @create: 2022-03-04
 **/
public interface BrandService {

    /**
     * 查询所有
     * @return List<Brand>
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);
}
