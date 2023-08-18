package com.test.portfolioback.model;

import com.test.portfolioback.entities.Portfolio;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioModel {

    private Long id;
    private String description;
    private String imageUrl;
    private String name;
    private String title;
    private List<TweetModel> tweets;
    
    public PortfolioModel(Long id, String title, String description){
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public PortfolioModel entityToModel(Portfolio portfolio) {
        return PortfolioModel.builder()
                .description(portfolio.getDescription())
                .id(portfolio.getId())
                .imageUrl(portfolio.getImageUrl())
                .title(portfolio.getTitle())
                .name(portfolio.getTitle().split(" ")[0])
                .build();
    }
}
