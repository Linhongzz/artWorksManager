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
@TableName("t_art_return")
public class Return implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @TableField("art_id")
    private Integer artId;

    /**
     * 归还时间
     */
    @TableField("return_time")
    private Date returnTime;

    /**
     * 归还人
     */
    @TableField("returnee")
    private String returnee;

    /**
     * 验收情况
     */
    @TableField("acceptance")
    private String acceptance;

    /**
     * 验收人
     */
    @TableField("acceptor")
    private String acceptor;

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

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnee() {
        return returnee;
    }

    public void setReturnee(String returnee) {
        this.returnee = returnee;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
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
        return "Return{" +
        "id=" + id +
        ", artId=" + artId +
        ", returnTime=" + returnTime +
        ", returnee=" + returnee +
        ", acceptance=" + acceptance +
        ", acceptor=" + acceptor +
        ", operator=" + operator +
        ", opeTime=" + opeTime +
        "}";
    }
}
