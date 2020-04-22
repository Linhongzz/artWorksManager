package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Des;
import cn.stylefeng.guns.modular.art.mapper.DesMapper;
import cn.stylefeng.guns.modular.art.model.params.DesParam;
import cn.stylefeng.guns.modular.art.model.result.DesResult;
import  cn.stylefeng.guns.modular.art.service.DesService;
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
public class DesServiceImpl extends ServiceImpl<DesMapper, Des> implements DesService {

    @Override
    public void add(DesParam param){
        Des entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DesParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DesParam param){
        Des oldEntity = getOldEntity(param);
        Des newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DesResult findBySpec(DesParam param){
        return null;
    }

    @Override
    public List<DesResult> findListBySpec(DesParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DesParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DesParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Des getOldEntity(DesParam param) {
        return this.getById(getKey(param));
    }

    private Des getEntity(DesParam param) {
        Des entity = new Des();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
