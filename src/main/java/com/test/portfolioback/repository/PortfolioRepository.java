package com.test.portfolioback.repository;

import com.test.portfolioback.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    
}
