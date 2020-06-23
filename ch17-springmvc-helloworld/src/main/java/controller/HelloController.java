package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yu
 * @date 2020/6/22
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String handle(){
        System.out.println("index------");
        //这里的hello是逻辑视图的名字,靠配置的视图解析器解析为真正的视图,比如jsp文件
        return "hello";
    }
}
