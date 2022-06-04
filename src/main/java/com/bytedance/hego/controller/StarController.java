package com.bytedance.hego.controller;

import com.bytedance.hego.bean.Star;
import com.bytedance.hego.dto.ResponseCode;
import com.bytedance.hego.service.StarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class StarController {

    @Autowired
    private StarService customerService;

    /**
     * 跳转到新增客户页
     *
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "views/star/insert";
    }

    /**
     * 新增客户
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode insert(Star customer) {
        int count = customerService.insertSelective(customer);
        if (count > 0) {
            return new ResponseCode(200, "新增成功", null);
        }
        return new ResponseCode(500, "新增失败", null);
    }

    /**
     * 跳转到更新客户页
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("id") Long id, Model model) {
        Star customer = customerService.selectByPrimaryKey(id);
        model.addAttribute("customer", customer);
        return "views/star/update";
    }

    /**
     * 更新客户
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode update(Star customer) {
        int count = customerService.updateByPrimaryKeySelective(customer);
        if (count > 0) {
            return new ResponseCode(200, "更新成功");
        }
        return new ResponseCode(500, "更新失败");
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("id") Long id) {
        int count = customerService.deleteByPrimaryKey(id);
        if (count > 0) {
            return new ResponseCode(200, "删除成功",null);
        }
        return new ResponseCode(200, "删除失败",null);
    }

    /**
     * 分页查询
     *
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        PageHelper.startPage(pn, 8);
        List<Star> list = customerService.list();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/star/manage";
    }
}
