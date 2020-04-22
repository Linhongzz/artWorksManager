package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Return;
import cn.stylefeng.guns.modular.art.mapper.ReturnMapper;
import cn.stylefeng.guns.modular.art.model.params.ReturnParam;
import cn.stylefeng.guns.modular.art.model.result.ReturnResult;
import  cn.stylefeng.guns.modular.art.service.ReturnService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LinHongZhang
 * @since 2020-04-13
 */
@Service
public class ReturnServiceImpl extends ServiceImpl<ReturnMapper, Return> implements ReturnService {

    @Override
    public void add(ReturnParam param){
        Return entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ReturnParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ReturnParam param){
        Return oldEntity = getOldEntity(param);
        Return newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ReturnResult findBySpec(ReturnParam param){
        return null;
    }

    @Override
    public List<ReturnResult> findListBySpec(ReturnParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ReturnParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ReturnParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Return getOldEntity(ReturnParam param) {
        return this.getById(getKey(param));
    }

    private Return getEntity(ReturnParam param) {
        Return entity = new Return();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
