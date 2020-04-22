package cn.stylefeng.guns.modular.art.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Record;
import cn.stylefeng.guns.modular.art.model.params.RecordParam;
import cn.stylefeng.guns.modular.art.service.RecordService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author LinHongZhang
 * @Date 2020-04-13 20:28:37
 */
@Controller
@RequestMapping("/record")
public class RecordController extends BaseController {

    private String PREFIX = "/art/record";

    @Autowired
    private RecordService recordService;

    /**
     * 跳转到主页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/record.html";
    }

    /**
     * 新增页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/record_add.html";
    }

    /**
     * 编辑页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/record_edit.html";
    }

    /**
     * 新增接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(RecordParam recordParam) {
        this.recordService.add(recordParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(RecordParam recordParam) {
        this.recordService.update(recordParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(RecordParam recordParam) {
        this.recordService.delete(recordParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(RecordParam recordParam) {
        Record detail = this.recordService.getById(recordParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(RecordParam recordParam) {
        return this.recordService.findPageBySpec(recordParam);
    }

}


