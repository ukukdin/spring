package hello.springmvc.basic;

import lombok.Data;

@Data // 롬복 Data는 getter, setter, equalsandhascoe, reqiredagrscontrouctor를 자동으로 적용해주낟.
public class HelloData {
    private String username;
    private int age;
}
