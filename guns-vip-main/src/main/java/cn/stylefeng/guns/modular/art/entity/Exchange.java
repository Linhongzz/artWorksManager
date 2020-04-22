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
@TableName("t_art_exchange")
public class Exchange implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @TableField("art_id")
    private Integer artId;

    /**
     * 时间
     */
    @TableField("app_time")
    private Date appTime;

    /**
     * 事由
     */
    @TableField("reason")
    private String reason;

    /**
     * 使用人
     */
    @TableField("user")
    private String user;

    /**
     * 交流单位
     */
    @TableField("exchange_loc")
    private String exchangeLoc;

    /**
     * 接收人
     */
    @TableField("receiver")
    private String receiver;

    /**
     * 预计归还时间
     */
    @TableField("est_return_time")
    private String estReturnTime;

    /**
     * 归还情况id
     */
    @TableField("return_id")
    private String returnId;

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

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getExchangeLoc() {
        return exchangeLoc;
    }

    public void setExchangeLoc(String exchangeLoc) {
        this.exchangeLoc = exchangeLoc;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getEstReturnTime() {
        return estReturnTime;
    }

    public void setEstReturnTime(String estReturnTime) {
        this.estReturnTime = estReturnTime;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
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
        return "Exchange{" +
        "id=" + id +
        ", artId=" + artId +
        ", appTime=" + appTime +
        ", reason=" + reason +
        ", user=" + user +
        ", exchangeLoc=" + exchangeLoc +
        ", receiver=" + receiver +
        ", estReturnTime=" + estReturnTime +
        ", returnId=" + returnId +
        ", operator=" + operator +
        ", opeTime=" + opeTime +
        "}";
    }
}
