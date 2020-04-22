package cn.stylefeng.guns.modular.art.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LinHongZhang
 * @since 2020-04-13
 */
@TableName("t_art_des")
public class Des implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    /**
     * 对应作品id
     */
    @TableField("art_id")
    private Integer artId;

    /**
     * 损毁时间
     */
    @TableField("des_time")
    private Date desTime;

    /**
     * 损毁原因
     */
    @TableField("des_reason")
    private String desReason;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 操作时间
     */
    @TableField("ope_time")
    private Date opeTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Date getDesTime() {
        return desTime;
    }

    public void setDesTime(Date desTime) {
        this.desTime = desTime;
    }

    public String getDesReason() {
        return desReason;
    }

    public void setDesReason(String desReason) {
        this.desReason = desReason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOpeTime() {
        return opeTime;
    }

    public void setOpeTime(Date opeTime) {
        this.opeTime = opeTime;
    }

    @Override
    public String toString() {
        return "Des{" +
        "id=" + id +
        ", artId=" + artId +
        ", desTime=" + desTime +
        ", desReason=" + desReason +
        ", operator=" + operator +
        ", opeTime=" + opeTime +
        "}";
    }
}
