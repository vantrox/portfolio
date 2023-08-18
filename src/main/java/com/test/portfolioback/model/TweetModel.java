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
public class TweetModel {
    private String image;
    private String name;
    private String message;
}
