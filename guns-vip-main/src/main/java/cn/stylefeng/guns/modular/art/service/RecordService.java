package cn.stylefeng.guns.modular.art.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Record;
import cn.stylefeng.guns.modular.art.model.params.RecordParam;
import cn.stylefeng.guns.modular.art.model.result.RecordResult;
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
public interface RecordService extends IService<Record> {

    /**
     * 新增
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void add(RecordParam param);

    /**
     * 删除
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void delete(RecordParam param);

    /**
     * 更新
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    void update(RecordParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    RecordResult findBySpec(RecordParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<RecordResult> findListBySpec(RecordParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
     LayuiPageInfo findPageBySpec(RecordParam param);

}
