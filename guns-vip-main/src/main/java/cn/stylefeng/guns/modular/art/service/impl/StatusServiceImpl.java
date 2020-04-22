package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Status;
import cn.stylefeng.guns.modular.art.mapper.StatusMapper;
import cn.stylefeng.guns.modular.art.model.params.StatusParam;
import cn.stylefeng.guns.modular.art.model.result.StatusResult;
import  cn.stylefeng.guns.modular.art.service.StatusService;
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
public class StatusServiceImpl extends ServiceImpl<StatusMapper, Status> implements StatusService {

    @Override
    public void add(StatusParam param){
        Status entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(StatusParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(StatusParam param){
        Status oldEntity = getOldEntity(param);
        Status newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public StatusResult findBySpec(StatusParam param){
        return null;
    }

    @Override
    public List<StatusResult> findListBySpec(StatusParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(StatusParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(StatusParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Status getOldEntity(StatusParam param) {
        return this.getById(getKey(param));
    }

    private Status getEntity(StatusParam param) {
        Status entity = new Status();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
