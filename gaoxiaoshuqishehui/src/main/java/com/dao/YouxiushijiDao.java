package com.dao;

import com.entity.YouxiushijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiushijiView;

/**
 * 优秀事迹栏目 Dao 接口
 *
 * @author 
 */
public interface YouxiushijiDao extends BaseMapper<YouxiushijiEntity> {

   List<YouxiushijiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
