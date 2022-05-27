package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.techelevator.auctions.dao.MemoryAuctionDao.auctions;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    //list() method
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> getAuctions(@RequestParam(defaultValue = "") String title_like,
                                     @RequestParam(defaultValue = "0") double currentBid_lte) {
        if (!title_like.equals("") && (currentBid_lte > 0)) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }else if (!title_like.equals("")){
            return dao.searchByTitle(title_like);
        } else {
            return dao.list();
        }
    }

    //return specific auction based on value passed
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id){
        return dao.get(id);
    }

    //add the auction that's passed
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
        if(auction != null){
            dao.create(auction);
            return auction;
        }
        return null;
    }

}