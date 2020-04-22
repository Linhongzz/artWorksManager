package cn.stylefeng.guns.modular.art.mapper;

import cn.stylefeng.guns.modular.art.entity.Record;
import cn.stylefeng.guns.modular.art.model.params.RecordParam;
import cn.stylefeng.guns.modular.art.model.result.RecordResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LinHongZhang
 * @since 2020-04-13
 */
public interface RecordMapper extends BaseMapper<Record> {

    /**
     * 获取列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<RecordResult> customList(@Param("paramCondition") RecordParam paramCondition);

    /**
     * 获取map列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") RecordParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    Page<RecordResult> customPageList(@Param("page") Page page, @Param("paramCondition") RecordParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") RecordParam paramCondition);

}
