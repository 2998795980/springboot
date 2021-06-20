package com.yuzhe.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class CommonResult {
    private String status;
    private Object data;
}
