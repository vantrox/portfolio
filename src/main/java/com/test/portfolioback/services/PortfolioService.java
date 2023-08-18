package com.test.portfolioback.services;

import com.test.portfolioback.entities.Portfolio;
import com.test.portfolioback.exception.NotFoundException;
import com.test.portfolioback.model.PortfolioModel;
import com.test.portfolioback.model.TweetModel;
import com.test.portfolioback.repository.PortfolioRepository;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TweetsApi;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.Get2ListsIdTweetsResponse;
import com.twitter.clientlib.model.Get2UsersIdResponse;
import com.twitter.clientlib.model.Tweet;
import com.twitter.clientlib.model.User;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Service
public class PortfolioService {

    private Logger log = LoggerFactory.getLogger(PortfolioService.class);
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Value("${twitter.clientID}")
    private String clientID;

    @Value("${twitter.clientSecret}")
    private String clientSecret;

    @Value("${twitter.accessToken}")
    private String accessToken;

    @Value("${twitter.refreshToken}")
    private String refreshToken;

    /**
     * Get a portfolio by id
     *
     * @param id reference in database
     * @return get a model with data in portfolio found
     */
    public PortfolioModel get(Long id) throws NotFoundException {
        Get2ListsIdTweetsResponse get2ListsIdTweetsResponse = null;
        TwitterApi apiInstance = null;
        try {
            apiInstance = new TwitterApi(new TwitterCredentialsOAuth2(
                    clientID,
                    clientSecret,
                    accessToken,
                    refreshToken));
            TweetsApi.APIlistsIdTweetsRequest aPIlistsIdTweetsRequest = apiInstance.tweets().listsIdTweets("FNATIC");
            get2ListsIdTweetsResponse = aPIlistsIdTweetsRequest.execute();
        } catch (ApiException ex) {
            log.warn("Error API Twitter", ex.getMessage());
        }
        Portfolio portfolio = portfolioRepository.findById(id).orElse(null);
        if (portfolio != null) {
            List<TweetModel> list = new ArrayList<>(5);
            if (get2ListsIdTweetsResponse == null) {
                list.add(new TweetModel("https://pbs.twimg.com/profile_images/1812114126/newtwitter_400x400.jpg", "DummyName1", "dummy message 1 dummy message 1 dummy message 1 dummy message 1 dummy message 1 "));
                list.add(new TweetModel("https://pbs.twimg.com/profile_images/1386711841410359298/Dqme1G0m_400x400.jpg", "DummyName2", "dummy message 2 dummy message 2 dummy message 2 dummy message 2 dummy message 2 "));
                list.add(new TweetModel("https://pbs.twimg.com/profile_images/1521544530230595584/my_Sigxw_400x400.jpg", "DummyName3", "dummy message 3 dummy message 3 dummy message 3 dummy message 3 dummy message 3 "));
                list.add(new TweetModel("https://pbs.twimg.com/profile_images/901947348699545601/hqRMHITj_400x400.jpg", "DummyName4", "dummy message 4 dummy message 4 dummy message 4 dummy message 4 dummy message 4 "));
                list.add(new TweetModel("https://pbs.twimg.com/profile_images/1117967801652617216/i8PWXebo_400x400.jpg", "DummyName5", "dummy message 5 dummy message 5 dummy message 5 dummy message 5 dummy message 5 "));
            } else {
                for (Tweet tweet : get2ListsIdTweetsResponse.getData().subList(0, 5)) {
                    Get2UsersIdResponse get2UsersIdResponse;
                    try {
                        get2UsersIdResponse = apiInstance.users().findUserById(tweet.getAuthorId()).execute();
                        User user = get2UsersIdResponse.getData();
                        list.add(new TweetModel(user.getProfileImageUrl().toString(),
                                user.getName(), tweet.getText()));
                    } catch (ApiException ex) {
                        log.error("", ex);
                    }
                }
            }
            PortfolioModel portfolioModel = new PortfolioModel().entityToModel(portfolio);
            portfolioModel.setTweets(list);
            return portfolioModel;
        } else {
            throw new NotFoundException("Portfolio not found");
        }
    }

    public PortfolioModel update(PortfolioModel portfolioModel) throws NotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioModel.getId()).orElse(null);
        if (portfolio == null) {
            throw new NotFoundException("Portfolio not found");
        } else {
            if (portfolioModel.getDescription() != null) {
                portfolio.setDescription(portfolioModel.getDescription());
            }
            if (portfolioModel.getImageUrl() != null) {
                portfolio.setImageUrl(portfolioModel.getImageUrl());
            }
            
            if (portfolioModel.getTitle()!= null) {
                portfolio.setTitle(portfolioModel.getTitle());
            }

            portfolio = portfolioRepository.save(portfolio);

            return new PortfolioModel().entityToModel(portfolio);
        }
    }

}
