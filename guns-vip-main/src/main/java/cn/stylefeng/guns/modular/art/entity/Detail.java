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
@TableName("t_art_detail")
public class Detail implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 尺寸
     */
    @TableField("size")
    private String size;

    /**
     * 款识
     */
    @TableField("literal_sign")
    private String literalSign;

    /**
     * 创作日期
     */
    @TableField("creation_date")
    private Date creationDate;

    /**
     * 来源
     */
    @TableField("source")
    private String source;

    /**
     * 类别
     */
    @TableField("category")
    private String category;

    /**
     * 收藏证书号
     */
    @TableField("certificate")
    private String certificate;

    /**
     * 照片
     */
    @TableField("photo")
    private String photo;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLiteralSign() {
        return literalSign;
    }

    public void setLiteralSign(String literalSign) {
        this.literalSign = literalSign;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return "Detail{" +
        "id=" + id +
        ", name=" + name +
        ", author=" + author +
        ", size=" + size +
        ", literalSign=" + literalSign +
        ", creationDate=" + creationDate +
        ", source=" + source +
        ", category=" + category +
        ", certificate=" + certificate +
        ", photo=" + photo +
        ", operator=" + operator +
        ", opeTime=" + opeTime +
        "}";
    }
}
