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
public class DonateResult implements Serializable {

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
     * 受赠单位（人）
     */
    private String recipient;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date opeTime;

}
