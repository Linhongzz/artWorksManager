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
public class DetailResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 尺寸
     */
    private String size;

    /**
     * 款识
     */
    private String literalSign;

    /**
     * 创作日期
     */
    private Date creationDate;

    /**
     * 来源
     */
    private String source;

    /**
     * 类别
     */
    private String category;

    /**
     * 收藏证书号
     */
    private String certificate;

    /**
     * 照片
     */
    private String photo;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date opeTime;

}
