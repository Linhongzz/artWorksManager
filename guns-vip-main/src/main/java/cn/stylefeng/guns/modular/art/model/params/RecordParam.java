package cn.stylefeng.guns.modular.art.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author LinHongZhang
 * @since 2020-04-13
 */
@Data
public class RecordParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 作品id
     */
    private Integer artId;

    /**
     * 当前状态
     */
    private String status;

    /**
     * 状态id
     */
    private Integer statusId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date opeTime;

    @Override
    public String checkParam() {
        return null;
    }

}
