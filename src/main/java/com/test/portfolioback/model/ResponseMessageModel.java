package com.test.portfolioback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageModel {
    private String message;
    private Integer code;
}
