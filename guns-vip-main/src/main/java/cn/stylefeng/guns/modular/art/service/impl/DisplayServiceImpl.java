package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Display;
import cn.stylefeng.guns.modular.art.mapper.DisplayMapper;
import cn.stylefeng.guns.modular.art.model.params.DisplayParam;
import cn.stylefeng.guns.modular.art.model.result.DisplayResult;
import  cn.stylefeng.guns.modular.art.service.DisplayService;
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
public class DisplayServiceImpl extends ServiceImpl<DisplayMapper, Display> implements DisplayService {

    @Override
    public void add(DisplayParam param){
        Display entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DisplayParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DisplayParam param){
        Display oldEntity = getOldEntity(param);
        Display newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DisplayResult findBySpec(DisplayParam param){
        return null;
    }

    @Override
    public List<DisplayResult> findListBySpec(DisplayParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DisplayParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DisplayParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Display getOldEntity(DisplayParam param) {
        return this.getById(getKey(param));
    }

    private Display getEntity(DisplayParam param) {
        Display entity = new Display();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
