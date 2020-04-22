package cn.stylefeng.guns.modular.art.model.result;

import lombok.Data;
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
public class ExchangeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer artId;

    /**
     * 时间
     */
    private Date appTime;

    /**
     * 事由
     */
    private String reason;

    /**
     * 使用人
     */
    private String user;

    /**
     * 交流单位
     */
    private String exchangeLoc;

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
    private String returnId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date opeTime;

}
