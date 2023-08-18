package com.test.portfolioback.controller;

import com.test.portfolioback.exception.NotFoundException;
import com.test.portfolioback.model.PortfolioModel;
import com.test.portfolioback.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@RestController
@RequestMapping(value = "/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService profileServices;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PortfolioModel message(@PathVariable Long id) throws NotFoundException {
        PortfolioModel portfolioModel = profileServices.get(id);
        return portfolioModel;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public PortfolioModel message(@RequestBody PortfolioModel portfolio) throws NotFoundException {
        return profileServices.update(portfolio);
    }
}
