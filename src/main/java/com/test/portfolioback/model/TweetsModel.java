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
public class TweetsModel {
    private long tweetId;
    private String tweetIdStr;
    private String tweetText;
    private String tweetLink;
    private long userId;
    private String userIdStr;
    private String createdAt;
}
