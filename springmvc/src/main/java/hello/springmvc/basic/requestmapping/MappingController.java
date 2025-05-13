package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController 는 반환값으로 뷰를 찾는 것이 아니라 Http 메시지 바디에 바로 입력 한다. 따라서 실행 결과로 ok 메세지를 받을 수 있다. @ResponseBody 와도 관련이 있다.
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetv2");

        return "ok";
    }

    /**
     * pathVaroable tkdyd
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId) String userId -> @PathVariable userId
     * /mapping/userA
     *
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId ={}", data);
        return "ok";
    }

    /***
     * 다중 매핑
     * PathVariable 사용
     *
     */

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}", userId,orderId);
        return "ok";
    }
    /**
     * 특정 파라미터 조건 매핑
     */
    @GetMapping(value ="/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }
    /**
     * 특정 헤더로 추가 매핑
     */
    @GetMapping(value = "mapping-header",headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑 -Http 요청 Content-Type, consume
     */
    @PostMapping(value="/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑 - HTTP 요청 Accept, produce
     *
     */
    @PostMapping(value="/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce(){
        log.info("mappingProduce");
        return "ok";
    }
}
