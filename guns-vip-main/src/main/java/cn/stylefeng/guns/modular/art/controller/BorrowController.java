package cn.stylefeng.guns.modular.art.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.art.entity.Borrow;
import cn.stylefeng.guns.modular.art.model.params.BorrowParam;
import cn.stylefeng.guns.modular.art.service.BorrowService;
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
@RequestMapping("/borrow")
public class BorrowController extends BaseController {

    private String PREFIX = "/art/borrow";

    @Autowired
    private BorrowService borrowService;

    /**
     * 跳转到主页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/borrow.html";
    }

    /**
     * 新增页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/borrow_add.html";
    }

    /**
     * 编辑页面
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/borrow_edit.html";
    }

    /**
     * 新增接口
     *
     * @author LinHongZhang
     * @Date 2020-04-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BorrowParam borrowParam) {
        this.borrowService.add(borrowParam);
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
    public ResponseData editItem(BorrowParam borrowParam) {
        this.borrowService.update(borrowParam);
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
    public ResponseData delete(BorrowParam borrowParam) {
        this.borrowService.delete(borrowParam);
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
    public ResponseData detail(BorrowParam borrowParam) {
        Borrow detail = this.borrowService.getById(borrowParam.getId());
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
    public LayuiPageInfo list(BorrowParam borrowParam) {
        return this.borrowService.findPageBySpec(borrowParam);
    }

}


