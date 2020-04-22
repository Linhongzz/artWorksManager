package cn.stylefeng.guns.modular.art.mapper;

import cn.stylefeng.guns.modular.art.entity.Status;
import cn.stylefeng.guns.modular.art.model.params.StatusParam;
import cn.stylefeng.guns.modular.art.model.result.StatusResult;
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
public interface StatusMapper extends BaseMapper<Status> {

    /**
     * 获取列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<StatusResult> customList(@Param("paramCondition") StatusParam paramCondition);

    /**
     * 获取map列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") StatusParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    Page<StatusResult> customPageList(@Param("page") Page page, @Param("paramCondition") StatusParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") StatusParam paramCondition);

}
