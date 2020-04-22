package cn.stylefeng.guns.modular.art.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Donate;
import cn.stylefeng.guns.modular.art.model.params.DonateParam;
import cn.stylefeng.guns.modular.art.service.DonateService;
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
@RequestMapping("/donate")
public class DonateController extends BaseController {

    private String PREFIX = "/art/donate";

    @Autowired
    private DonateService donateService;

    /**
     * 跳转到主页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/donate.html";
    }

    /**
     * 新增页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/donate_add.html";
    }

    /**
     * 编辑页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/donate_edit.html";
    }

    /**
     * 新增接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DonateParam donateParam) {
        this.donateService.add(donateParam);
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
    public ResponseData editItem(DonateParam donateParam) {
        this.donateService.update(donateParam);
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
    public ResponseData delete(DonateParam donateParam) {
        this.donateService.delete(donateParam);
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
    public ResponseData detail(DonateParam donateParam) {
        Donate detail = this.donateService.getById(donateParam.getId());
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
    public LayuiPageInfo list(DonateParam donateParam) {
        return this.donateService.findPageBySpec(donateParam);
    }

}


