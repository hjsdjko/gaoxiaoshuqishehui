package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxiushijiEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 优秀事迹栏目 服务类
 */
public interface YouxiushijiService extends IService<YouxiushijiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}