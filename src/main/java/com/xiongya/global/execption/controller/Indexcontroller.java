package com.xiongya.global.execption.controller;

import com.alibaba.fastjson.JSON;
import com.xiongya.global.execption.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Indexcontroller {

    /**
     * http://loclahost:8080/business
     * @param msg
     * @return
     */
    @RequestMapping(value = "business")
    public String business(@RequestBody String msg){
        if (msg == null){
            throw new BusinessException("参数不能为空。。。");
        }
        return JSON.toJSONString("test business exception");
    }


    /**
     * http://loclahost:8080/system
     * @return
     */
    @RequestMapping(value = "system")
    public String system() {
        int i = 1/0;
        return JSON.toJSONString("test system ecxeption");
    }
}
