package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Getter@Setter@ToString
public class Employee {
    private Long id;
    private String name;
    private String sn;
    private BigDecimal salary;
    private Integer dept_id;

}
