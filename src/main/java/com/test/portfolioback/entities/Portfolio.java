package com.test.portfolioback.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Entity
@Table(name = "portfolio")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idportfolio")
    private Long id;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Basic(optional = false)
    @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    public Portfolio(Long id, String description, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
    }   
    
}
