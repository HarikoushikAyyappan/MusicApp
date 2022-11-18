package com.music.controller;

import com.music.dto.GenreDTO;
import com.music.model.*;
import com.music.repository.UserRepository;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/userLogin")
    public ModelAndView newCustomerFor() {
        ModelAndView modelAndView = new ModelAndView("userLoginPage");
        User user = new User();
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("/userPage")
    public ModelAndView customerPage(@RequestParam int userId, @RequestParam String password ){
        List<User> customerResult = userService.find(userId,password);
        if(customerResult.isEmpty()){
            return new ModelAndView("errorPage");
        }
        else{
            ModelAndView mav = new ModelAndView("userPage");
            mav.addObject("customerResult", customerResult);
            return mav;}
    }
    @RequestMapping("/adminLogin")
    public ModelAndView newAdminForm() {
        ModelAndView modelAndView = new ModelAndView("adminLoginPage");
        modelAndView.addObject("admin",new Admin());
        return modelAndView;
    }
    @RequestMapping("/adminPage")
    public ModelAndView adminPage(@RequestParam int adminId,@RequestParam String password ){
        List<Admin> result = userService.search(adminId,password);
        if(result.isEmpty()){
            return new ModelAndView("errorPage");
        }
        else {
            ModelAndView mav = new ModelAndView("adminPage");
            mav.addObject("result", result);
            return mav;
        }
    }
    @RequestMapping("/superAdminLogin")
    public ModelAndView newSuperAdminForm() {
        ModelAndView modelAndView = new ModelAndView("superAdminLoginPage");
        modelAndView.addObject("superAdmin",new SuperAdmin());
        return modelAndView;
    }
    @RequestMapping("/superAdminPage")
    public ModelAndView superAdminPage(@RequestParam int superAdminId,@RequestParam String password ){
        List<SuperAdmin> result = userService.searchSuper(superAdminId,password);
        if(result.isEmpty()){
            return new ModelAndView("errorPage");
        }
        else {
            ModelAndView mav = new ModelAndView("superAdminPage");
            mav.addObject("result", result);
            return mav;
        }
    }
    @RequestMapping("/newGenre")
    public ModelAndView newCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("newGenre");
        modelAndView.addObject("genreAttribute",new Genre());
        return modelAndView;
    }
    @RequestMapping(value = "/saveSong", method = RequestMethod.POST)
    public ModelAndView saveSong(@ModelAttribute("song") Song song) {
        userService.updateSong(song);
        return new ModelAndView("success");
    }
    @RequestMapping(value = "/adminList")
    public ModelAndView home() {
        List<Admin > adminList  = userService.getAllAdmin();
        Admin admin = new Admin();
        ModelAndView mav = new ModelAndView("adminList");
        mav.addObject("admin",admin);
        mav.addObject("adminList", adminList);
        return mav;
    }
    @RequestMapping("/delete")
    public ModelAndView deleteAdminForm(@RequestParam int adminId) {
        userService.delete(adminId);
        return new ModelAndView("success");
    }
    @RequestMapping(value = "/addGenre", method = RequestMethod.POST)
    public ModelAndView postAdd(@ModelAttribute("genreAttribute") Genre genre) {

        userService.add(genre);
        return new ModelAndView("addGenrePage");
    }

    @RequestMapping(value = "/genreList", method = RequestMethod.GET)
    public ModelAndView getRecords() {
        ModelAndView mav = new ModelAndView("adminRecord");

        List<Genre> genres = userService.getAllGenre();

        List<GenreDTO> genreDTO = new ArrayList<GenreDTO>();

        for (Genre genre: genres) {
            GenreDTO dto = new GenreDTO();

            dto.setGenreId(genre.getGenreId());
            dto.setGenreName(genre.getGenreName());

            dto.setSongs(userService.getAllSongs(genre.getGenreId()));

            genreDTO.add(dto);
        }

        mav.addObject("genres", genreDTO);
        return mav;
    }
    @RequestMapping(value = "/editGenre", method = RequestMethod.GET)
    public ModelAndView getEdit(@RequestParam("id") Integer genreId) {
        ModelAndView mav =new ModelAndView("editGenre");
        Genre genre1 = userService.getGenreById(genreId);
        mav.addObject("genreAttribute",genre1);

        return mav;
    }
    @RequestMapping(value = "/saveGenre", method = RequestMethod.POST)
    public ModelAndView postEdit(@RequestParam("id") Integer genreId,
                           @ModelAttribute("genreAttribute") Genre genre) {

        genre.setGenreId(genreId);
        userService.add(genre);
        return new ModelAndView("addGenrePage");
    }
    @RequestMapping(value="/addSong",method = RequestMethod.GET)
    public ModelAndView getAdd(@RequestParam("id")Integer genreId){
        ModelAndView mav =new ModelAndView("addSongTo");
        Song song = new Song();
        mav.addObject("genreId",genreId);
        mav.addObject("songAttribute",song);
        return mav;
    }
    @RequestMapping(value="/saveSongs", method = RequestMethod.POST)
    public ModelAndView postAdd(@RequestParam("id")Integer genreId,@ModelAttribute("songAttribute")Song song)  {
        userService.addSongTo(genreId, song);
        return new ModelAndView("addGenrePage");
    }

    @RequestMapping(value="/addToUser")
    public ModelAndView getAddToUser(@RequestParam("bid")int userId,@RequestParam("cid")int songId){
        ModelAndView mav = new ModelAndView("cartRecord");
        User user = userService.getUserById(userId);
        Song song = userService.getSongById(songId);
        if(song.getBlock().equalsIgnoreCase("no")){

        userService.addSongToUser(user.getUserId(),song.getSongId());

        List<Song> songs = userService.getAllSongs(user.getUserId());

        System.out.println(user.getUserName());

        mav.addObject("CurrentUser",user);
        mav.addObject("CurrentSongs",songs);
        mav.addObject("basketAttribute",new Basket());

        return mav;}
        else{
            return new ModelAndView("songBlocked");
        }

    }
    @RequestMapping(value="/checkOut",method = RequestMethod.POST)
    public ModelAndView checkOut(@RequestParam("id")int userId,@RequestParam("basketId")int basketId){

        Basket basket = new Basket();
        basket.setBasketId(basketId);
        User user = userService.getUserById(userId);

        basket.setUser(user);

        List<Song> song = (List) user.getSongs();
        Set<Song> song1 = new HashSet<Song>() ;
        for(Song i:song1){
            Song mySong = (Song) i;
            userService.updateSong(mySong);
            song1.add(mySong);
        }
        basket.setSongList((Set<Song>) song1);
        userService.addBasket(basket);
        List<Song> songs = userService.getAllSongs(user.getUserId());


            return new ModelAndView("requestSuccess");

    }

}
