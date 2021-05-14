package testgroup.giftography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testgroup.giftography.model.Gift;
import testgroup.giftography.service.GiftService;


@Controller
public class GiftController {

    @Autowired
    GiftService giftServiceImp;     //интерфейс

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allGifts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gifts");

        modelAndView.addObject("giftsList", giftServiceImp.allGifts());

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Gift gift = giftServiceImp.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("gift", gift);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");   //где отобразить результат метода
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addGift(@ModelAttribute("gift") Gift gift) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        giftServiceImp.add(gift);
        return modelAndView;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGift(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Gift gift = giftServiceImp.getById(id);
        giftServiceImp.delete(gift);
        return modelAndView;
    }
}
