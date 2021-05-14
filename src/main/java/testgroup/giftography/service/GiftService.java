package testgroup.giftography.service;

import testgroup.giftography.model.Gift;

import java.util.List;

public interface GiftService {
    List<Gift> allGifts();

    void add(Gift gift);
    void delete(Gift gift);
    void edit(Gift gift);
    Gift getById(int id);
}
