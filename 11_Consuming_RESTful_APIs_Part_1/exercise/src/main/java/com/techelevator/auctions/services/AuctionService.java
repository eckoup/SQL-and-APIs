package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
       return restTemplate.getForObject(API_BASE_URL, Auction[].class);
    }

    public Auction getAuction(int id) {
       return restTemplate.getForObject(API_BASE_URL + id, Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        String searchTitle = "?title_like=" + title;
        return restTemplate.getForObject(API_BASE_URL + searchTitle, Auction[].class);
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        String currentBid = "?currentBid_lte=" + price;
        return restTemplate.getForObject(API_BASE_URL + currentBid, Auction[].class );    }

}
