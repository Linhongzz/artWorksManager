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
public class BorrowParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer artId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 事由
     */
    private String reason;

    /**
     * 使用人
     */
    private String user;

    /**
     * 暂借单位
     */
    private String borrowLoc;

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 预计归还时间
     */
    private String estReturnTime;

    /**
     * 归还情况id
     */
    private Integer returnId;

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
