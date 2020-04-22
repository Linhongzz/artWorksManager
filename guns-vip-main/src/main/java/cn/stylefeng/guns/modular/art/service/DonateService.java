package cn.stylefeng.guns.modular.art.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Donate;
import cn.stylefeng.guns.modular.art.model.params.DonateParam;
import cn.stylefeng.guns.modular.art.model.result.DonateResult;
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
public interface DonateService extends IService<Donate> {

    /**
     * 新增
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void add(DonateParam param);

    /**
     * 删除
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void delete(DonateParam param);

    /**
     * 更新
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void update(DonateParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    DonateResult findBySpec(DonateParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<DonateResult> findListBySpec(DonateParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
     LayuiPageInfo findPageBySpec(DonateParam param);

}
