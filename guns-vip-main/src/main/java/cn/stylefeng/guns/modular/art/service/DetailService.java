package cn.stylefeng.guns.modular.art.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Detail;
import cn.stylefeng.guns.modular.art.model.params.DetailParam;
import cn.stylefeng.guns.modular.art.model.result.DetailResult;
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
public interface DetailService extends IService<Detail> {

    /**
     * 新增
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void add(DetailParam param);

    /**
     * 删除
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void delete(DetailParam param);

    /**
     * 更新
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void update(DetailParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    DetailResult findBySpec(DetailParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<DetailResult> findListBySpec(DetailParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
     LayuiPageInfo findPageBySpec(DetailParam param);

}
