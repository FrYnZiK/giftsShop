package testgroup.giftography.repository;

import testgroup.giftography.model.Gift;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class GiftDaoImpl implements GiftDao {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Gift> gifts = new HashMap<>();

    static {
        Gift gift1 = new Gift();
        gift1.setId(AUTO_ID.getAndIncrement());
        gift1.setTitle("Inception");
        gift1.setYear(2010);
        gift1.setGenre("sci-fi");
        gift1.setWatched(true);
        gifts.put(gift1.getId(), gift1);

        // + gift2, gift3, gift4, ...
    }

    @Override
    public List<Gift> allGifts() {
        Gift pornFilm = new Gift();
        pornFilm.setTitle("Best German movie");
        pornFilm.setGenre("German films");
        pornFilm.setId(new Random().nextInt(100500));
        pornFilm.setYear(new Random().nextInt(21) + 2000);
        pornFilm.setWatched(new Random().nextBoolean());

        gifts.put(new Random().nextInt(1000), pornFilm);
        return new ArrayList<>(gifts.values());
    }

    @Override
    public void add(Gift gift) {
        gift.setId(AUTO_ID.getAndIncrement());
        gifts.put(gift.getId(), gift);
    }

    @Override
    public void delete(Gift gift) {
        gifts.remove(gift.getId());
    }

    @Override
    public void edit(Gift gift) {
        gifts.put(gift.getId(), gift);
    }

    @Override
    public Gift getById(int id) {
        return gifts.get(id);
    }
}
