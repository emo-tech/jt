package com.emo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emo.mybatis.entity.PmsSkuStock;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * sku的库存 Mapper 接口
 * </p>
 *
 * @author sherxia92
 * @since 2022-09-05
 */
public interface PmsSkuStockMapper extends BaseMapper<PmsSkuStock> {


    /**
     * list
     * @return
     */
    @Select("select id, stock from pms_sku_stock")
    List<PmsSkuStock> selectPmsSkuStockList();
}
