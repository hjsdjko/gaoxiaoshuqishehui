package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.YouxiushijiDao;
import com.entity.YouxiushijiEntity;
import com.service.YouxiushijiService;
import com.entity.view.YouxiushijiView;

/**
 * 优秀事迹栏目 服务实现类
 */
@Service("youxiushijiService")
@Transactional
public class YouxiushijiServiceImpl extends ServiceImpl<YouxiushijiDao, YouxiushijiEntity> implements YouxiushijiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YouxiushijiView> page =new Query<YouxiushijiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
