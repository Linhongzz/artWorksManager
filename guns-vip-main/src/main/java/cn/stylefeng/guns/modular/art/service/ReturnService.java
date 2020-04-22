package cn.stylefeng.guns.modular.art.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Return;
import cn.stylefeng.guns.modular.art.model.params.ReturnParam;
import cn.stylefeng.guns.modular.art.model.result.ReturnResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LinHongZhang
 * @since 2020-04-13
 */
public interface ReturnService extends IService<Return> {

    /**
     * 新增
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void add(ReturnParam param);

    /**
     * 删除
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void delete(ReturnParam param);

    /**
     * 更新
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void update(ReturnParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    ReturnResult findBySpec(ReturnParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<ReturnResult> findListBySpec(ReturnParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
     LayuiPageInfo findPageBySpec(ReturnParam param);

}
