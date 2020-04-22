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
public class ReturnParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer artId;

    /**
     * 归还时间
     */
    private Date returnTime;

    /**
     * 归还人
     */
    private String returnee;

    /**
     * 验收情况
     */
    private String acceptance;

    /**
     * 验收人
     */
    private String acceptor;

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
