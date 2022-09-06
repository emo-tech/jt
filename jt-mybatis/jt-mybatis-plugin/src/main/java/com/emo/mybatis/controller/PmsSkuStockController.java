package com.emo.mybatis.controller;

import com.emo.mybatis.entity.PmsSkuStock;
import com.emo.mybatis.mapper.PmsSkuStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sherxia92
 */
@RestController
@RequestMapping(value = "/")
public class PmsSkuStockController {

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;

    @RequestMapping("/list01")
    public List<PmsSkuStock> list01() {
        return pmsSkuStockMapper.selectPmsSkuStockList();
    }
}
