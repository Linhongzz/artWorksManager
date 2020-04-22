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
public class DesResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 对应作品id
     */
    private Integer artId;

    /**
     * 损毁时间
     */
    private Date desTime;

    /**
     * 损毁原因
     */
    private String desReason;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date opeTime;

}
