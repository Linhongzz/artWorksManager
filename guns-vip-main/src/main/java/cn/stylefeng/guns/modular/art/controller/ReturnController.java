package cn.stylefeng.guns.modular.art.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Return;
import cn.stylefeng.guns.modular.art.model.params.ReturnParam;
import cn.stylefeng.guns.modular.art.service.ReturnService;
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
@RequestMapping("/return")
public class ReturnController extends BaseController {

    private String PREFIX = "/art/return";

    @Autowired
    private ReturnService returnService;

    /**
     * 跳转到主页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/return.html";
    }

    /**
     * 新增页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/return_add.html";
    }

    /**
     * 编辑页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/return_edit.html";
    }

    /**
     * 新增接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ReturnParam returnParam) {
        this.returnService.add(returnParam);
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
    public ResponseData editItem(ReturnParam returnParam) {
        this.returnService.update(returnParam);
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
    public ResponseData delete(ReturnParam returnParam) {
        this.returnService.delete(returnParam);
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
    public ResponseData detail(ReturnParam returnParam) {
        Return detail = this.returnService.getById(returnParam.getId());
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
    public LayuiPageInfo list(ReturnParam returnParam) {
        return this.returnService.findPageBySpec(returnParam);
    }

}


