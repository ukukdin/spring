package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge){
        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
        @RequestParam String username,
        @RequestParam int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){
        log.info("userName={}, age={}", username, age);

        return "ok";
    }
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
        @RequestParam(required = true) String username,
        @RequestParam(required = false)  int age){
        log.info("userName={}, age={}", username, age);

        return "ok";
    }

    @RequestMapping("/request-param-default")
    public String requestParamDefault(
        @RequestParam(required = true, defaultValue = "guest") String username,
        @RequestParam(required = false, defaultValue = "-1")  int age){
        log.info("userName={}, age={}", username, age);

        return "ok";
    }
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("userName={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("helloDate={}", helloData);
        return "ok";
    }
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
