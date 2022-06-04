package com.bytedance.hego.controller;

import com.bytedance.hego.bean.User;
import com.bytedance.hego.dto.ResponseCode;
import com.bytedance.hego.service.UserService;
import org.springframework.web.bind.annotation.*;

public class UserController {
    private UserService userService;

    @PostMapping("/insert")
    public ResponseCode insert(@RequestBody User user) {
        int count = userService.insert(user);
        if (count == 0) {
            return new ResponseCode(0, "新增失败");
        }
        return new ResponseCode(1, "新增成功");
    }

    @PostMapping("/update")
    public ResponseCode update(@RequestBody User user) {
        int count = userService.updateByPrimaryKey(user);
        if (count == 0) {
            return new ResponseCode(0, "更新失败");
        }
        return new ResponseCode(1, "更新成功");
    }

    @PostMapping("/delete")
    public ResponseCode delete(@RequestParam("id") Long id) {
        int count = userService.deleteByPrimaryKey(id);
        if (count == 0) {
            return new ResponseCode(0, "删除失败");
        }
        return new ResponseCode(1, "删除成功");
    }

    @GetMapping("/get/{id}")
    public ResponseCode get(@PathVariable("id") Long id) {
        User user = userService.selectByPrimaryKey(id);
        if (user == null) {
            return new ResponseCode(0, "数据为空");
        }
        return new ResponseCode(1, "查询成功", user);
    }
}
