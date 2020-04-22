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
@TableName("t_art_display")
public class Display implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @TableField("art_id")
    private Integer artId;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

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
     * 主办方
     */
    @TableField("organizer")
    private String organizer;

    /**
     * 会展名称
     */
    @TableField("exhibition")
    private String exhibition;

    /**
     * 展出地点
     */
    @TableField("location")
    private String location;

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
    private Integer returnId;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getExhibition() {
        return exhibition;
    }

    public void setExhibition(String exhibition) {
        this.exhibition = exhibition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
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
        return "Display{" +
        "id=" + id +
        ", artId=" + artId +
        ", startTime=" + startTime +
        ", reason=" + reason +
        ", user=" + user +
        ", organizer=" + organizer +
        ", exhibition=" + exhibition +
        ", location=" + location +
        ", receiver=" + receiver +
        ", estReturnTime=" + estReturnTime +
        ", returnId=" + returnId +
        ", operator=" + operator +
        ", opeTime=" + opeTime +
        "}";
    }
}
