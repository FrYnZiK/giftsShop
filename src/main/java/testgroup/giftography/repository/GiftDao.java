package testgroup.giftography.repository;

import testgroup.giftography.model.Gift;

import java.util.List;

public interface GiftDao {
    List<Gift> allGifts();

    void add(Gift gift);
    void delete(Gift gift);
    void edit(Gift gift);
    Gift getById(int id);
}
