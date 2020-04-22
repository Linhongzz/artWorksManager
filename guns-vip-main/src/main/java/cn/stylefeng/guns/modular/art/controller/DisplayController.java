package cn.stylefeng.guns.modular.art.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Display;
import cn.stylefeng.guns.modular.art.model.params.DisplayParam;
import cn.stylefeng.guns.modular.art.service.DisplayService;
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
@RequestMapping("/display")
public class DisplayController extends BaseController {

    private String PREFIX = "/art/display";

    @Autowired
    private DisplayService displayService;

    /**
     * 跳转到主页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/display.html";
    }

    /**
     * 新增页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/display_add.html";
    }

    /**
     * 编辑页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/display_edit.html";
    }

    /**
     * 新增接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DisplayParam displayParam) {
        this.displayService.add(displayParam);
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
    public ResponseData editItem(DisplayParam displayParam) {
        this.displayService.update(displayParam);
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
    public ResponseData delete(DisplayParam displayParam) {
        this.displayService.delete(displayParam);
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
    public ResponseData detail(DisplayParam displayParam) {
        Display detail = this.displayService.getById(displayParam.getId());
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
    public LayuiPageInfo list(DisplayParam displayParam) {
        return this.displayService.findPageBySpec(displayParam);
    }

}


