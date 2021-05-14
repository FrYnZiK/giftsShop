package testgroup.giftography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.giftography.model.Gift;
import testgroup.giftography.repository.GiftDao;

import java.util.List;

@Service
public class GiftServiceImp implements GiftService {

    @Autowired
    GiftDao giftDao;        //interface

    @Override
    public List<Gift> allGifts() {
        return giftDao.allGifts();
    }

    @Override
    public void add(Gift gift) {
        giftDao.add(gift);
    }

    @Override
    public void delete(Gift gift) {
        giftDao.delete(gift);
    }

    @Override
    public void edit(Gift gift) {
        giftDao.edit(gift);
    }

    @Override
    public Gift getById(int id) {
        return giftDao.getById(id);
    }
}
