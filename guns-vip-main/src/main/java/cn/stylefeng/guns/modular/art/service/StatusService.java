package cn.stylefeng.guns.modular.art.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Status;
import cn.stylefeng.guns.modular.art.model.params.StatusParam;
import cn.stylefeng.guns.modular.art.model.result.StatusResult;
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
public interface StatusService extends IService<Status> {

    /**
     * 新增
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void add(StatusParam param);

    /**
     * 删除
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void delete(StatusParam param);

    /**
     * 更新
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void update(StatusParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    StatusResult findBySpec(StatusParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<StatusResult> findListBySpec(StatusParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
     LayuiPageInfo findPageBySpec(StatusParam param);

}
