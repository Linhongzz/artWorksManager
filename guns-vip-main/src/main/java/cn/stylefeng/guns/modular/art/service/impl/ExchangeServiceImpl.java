package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Exchange;
import cn.stylefeng.guns.modular.art.mapper.ExchangeMapper;
import cn.stylefeng.guns.modular.art.model.params.ExchangeParam;
import cn.stylefeng.guns.modular.art.model.result.ExchangeResult;
import  cn.stylefeng.guns.modular.art.service.ExchangeService;
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
public class ExchangeServiceImpl extends ServiceImpl<ExchangeMapper, Exchange> implements ExchangeService {

    @Override
    public void add(ExchangeParam param){
        Exchange entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ExchangeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ExchangeParam param){
        Exchange oldEntity = getOldEntity(param);
        Exchange newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ExchangeResult findBySpec(ExchangeParam param){
        return null;
    }

    @Override
    public List<ExchangeResult> findListBySpec(ExchangeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ExchangeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ExchangeParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Exchange getOldEntity(ExchangeParam param) {
        return this.getById(getKey(param));
    }

    private Exchange getEntity(ExchangeParam param) {
        Exchange entity = new Exchange();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
