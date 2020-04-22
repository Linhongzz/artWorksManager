package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Record;
import cn.stylefeng.guns.modular.art.mapper.RecordMapper;
import cn.stylefeng.guns.modular.art.model.params.RecordParam;
import cn.stylefeng.guns.modular.art.model.result.RecordResult;
import  cn.stylefeng.guns.modular.art.service.RecordService;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Override
    public void add(RecordParam param){
        Record entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(RecordParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(RecordParam param){
        Record oldEntity = getOldEntity(param);
        Record newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public RecordResult findBySpec(RecordParam param){
        return null;
    }

    @Override
    public List<RecordResult> findListBySpec(RecordParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(RecordParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(RecordParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Record getOldEntity(RecordParam param) {
        return this.getById(getKey(param));
    }

    private Record getEntity(RecordParam param) {
        Record entity = new Record();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
