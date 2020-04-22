package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Donate;
import cn.stylefeng.guns.modular.art.mapper.DonateMapper;
import cn.stylefeng.guns.modular.art.model.params.DonateParam;
import cn.stylefeng.guns.modular.art.model.result.DonateResult;
import  cn.stylefeng.guns.modular.art.service.DonateService;
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
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements DonateService {

    @Override
    public void add(DonateParam param){
        Donate entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DonateParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DonateParam param){
        Donate oldEntity = getOldEntity(param);
        Donate newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DonateResult findBySpec(DonateParam param){
        return null;
    }

    @Override
    public List<DonateResult> findListBySpec(DonateParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DonateParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DonateParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Donate getOldEntity(DonateParam param) {
        return this.getById(getKey(param));
    }

    private Donate getEntity(DonateParam param) {
        Donate entity = new Donate();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
