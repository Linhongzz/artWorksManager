package cn.stylefeng.guns.modular.art.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Borrow;
import cn.stylefeng.guns.modular.art.mapper.BorrowMapper;
import cn.stylefeng.guns.modular.art.model.params.BorrowParam;
import cn.stylefeng.guns.modular.art.model.result.BorrowResult;
import  cn.stylefeng.guns.modular.art.service.BorrowService;
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
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements BorrowService {

    @Override
    public void add(BorrowParam param){
        Borrow entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BorrowParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BorrowParam param){
        Borrow oldEntity = getOldEntity(param);
        Borrow newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BorrowResult findBySpec(BorrowParam param){
        return null;
    }

    @Override
    public List<BorrowResult> findListBySpec(BorrowParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BorrowParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BorrowParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Borrow getOldEntity(BorrowParam param) {
        return this.getById(getKey(param));
    }

    private Borrow getEntity(BorrowParam param) {
        Borrow entity = new Borrow();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
