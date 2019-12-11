package com.example.netty.webSocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

@RequestMapping("/web/socket")
@RestController
public class WebSocketController {

//    /**
//     * 页面请求
//     * @param cid
//     * @return
//     */
//    @GetMapping("/{cid}")
//    public ModelAndView socket(@PathVariable String cid) {
//        System.out.println("执行了。。。");
//        ModelAndView mav=new ModelAndView("/socket");
//        mav.addObject("cid", cid);
//        return mav;
//    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @PostMapping(value = "send/{cid}/{message}")
    public String pushToWeb(@PathVariable String cid,@PathVariable String message) {
        try {
            SocketMessage newMessage = new SocketMessage(message, new Date());
            WebSocketServer.sendInfo(newMessage,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }
}
