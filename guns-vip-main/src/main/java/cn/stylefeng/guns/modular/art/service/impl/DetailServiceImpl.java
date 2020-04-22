package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Detail;
import cn.stylefeng.guns.modular.art.mapper.DetailMapper;
import cn.stylefeng.guns.modular.art.model.params.DetailParam;
import cn.stylefeng.guns.modular.art.model.result.DetailResult;
import  cn.stylefeng.guns.modular.art.service.DetailService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
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
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {

    @Override
    public void add(DetailParam param){
        Detail entity = getEntity(param);
        LoginUser user = LoginContextHolder.getContext().getUser();

        entity.setOperator(user.getName());
        entity.setOpeTime(new Date(System.currentTimeMillis()));
        this.save(entity);
    }

    @Override
    public void delete(DetailParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DetailParam param){
        Detail oldEntity = getOldEntity(param);
        Detail newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DetailResult findBySpec(DetailParam param){
        return null;
    }

    @Override
    public List<DetailResult> findListBySpec(DetailParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DetailParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DetailParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Detail getOldEntity(DetailParam param) {
        return this.getById(getKey(param));
    }

    private Detail getEntity(DetailParam param) {
        Detail entity = new Detail();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
