package com.music.controller;

import com.music.dto.DurationDTO;
import com.music.dto.GenreDTO;
import com.music.dto.SongDTO;
import com.music.model.*;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@RestController
public class SongController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/songList/{userId}")
    public ModelAndView getRecords(@PathVariable int userId) {
        ModelAndView mav = new ModelAndView("songRecord");
        List<Song> songs = userService.getAllSongs();
        List<SongDTO> songDTO = new ArrayList<SongDTO>();

        for (Song song: songs) {
            SongDTO dto = new SongDTO();
            dto.setSongId(song.getSongId());
            dto.setSongName(song.getSongName());
            dto.setDownloads(song.getDownloads());
            songDTO.add(dto);
        }
        List<Genre> genres = userService.getAllGenre();

        List<GenreDTO> genreDTO = new ArrayList<GenreDTO>();

        for (Genre genre: genres) {
            GenreDTO dto = new GenreDTO();
            dto.setGenreId(genre.getGenreId());
            dto.setGenreName(genre.getGenreName());
            dto.setSongs(userService.getAllSongs(genre.getGenreId()));

            genreDTO.add(dto);
        }

        Genre genre = new Genre();
        mav.addObject("userId",userId);
        mav.addObject("songs",songDTO);
        mav.addObject("genres", genreDTO);
        mav.addObject("genreAttribute",genre);
        return mav;
    }

    //---------------------------- to list all the items(POST)--------------------------------------------//
    @PostMapping (value = "/songList")
    public ModelAndView postRecords(@ModelAttribute("genreAttribute")Genre genre,@RequestParam("id") int userId) {
        ModelAndView mav = new ModelAndView("songRecord");
        Genre genre1 = userService.getGenreByName(genre.getGenreName());
        List<Song> songs = userService.getAllSongs(genre1.getGenreId());
        List<SongDTO> songDTO = new ArrayList<SongDTO>();

        for (Song song: songs) {
            SongDTO dto = new SongDTO();
            dto.setSongId(song.getSongId());
            dto.setSongName(song.getSongName());
            dto.setDownloads(song.getDownloads());
            songDTO.add(dto);

        }
        List<Genre> genres = userService.getAllGenre();

        List<GenreDTO> genreDTO = new ArrayList<GenreDTO>();

        for (Genre genre2: genres) {
            GenreDTO dto = new GenreDTO();
            dto.setGenreId(genre2.getGenreId());
            dto.setGenreName(genre2.getGenreName());

            dto.setSongs(userService.getAllSongs(genre2.getGenreId()));
            genreDTO.add(dto);
        }

        mav.addObject("userId",userId);
        mav.addObject("songs",songDTO);
        mav.addObject("genres", genreDTO);
        mav.addObject("genreAttribute",genre1);
        return mav;
    }
    @GetMapping(value="/viewPurchaseRequests")
    public ModelAndView purchaseRequest(){
        ModelAndView mav =new ModelAndView("purchaseApproval");
        List<Basket> baskets = userService.getAllBaskets();
        mav.addObject("baskets",baskets);
        return mav;
    }
    @GetMapping(value="/approve")
    public ModelAndView purchaseApprove(@RequestParam("id") int basketId){
        ModelAndView mav = new ModelAndView("processPurchase");
        Basket basket = userService.getBasketById(basketId);
        mav.addObject("basket",basket);
        return mav;
    }
    @RequestMapping(value="/doApprove")
    public ModelAndView doApprove(@RequestParam("bid") int songId,@RequestParam("cid")int basketId){
        ModelAndView mav = new ModelAndView("success");
        Song song = userService.getSongById(songId);
        Song song1= new Song();
        song1.setSongId(song.getSongId());
        song1.setSongName(song.getSongName());
        song1.setDownloads(song.getDownloads()+1);
        userService.updateSong(song1);
        userService.deleteBasketById(basketId);
        return mav;
    }
    @RequestMapping(value="/createUserForm")
    public ModelAndView newCustomerForm() {
        UserForm userForm = new UserForm();
        ModelAndView mav = new ModelAndView("userForm");
        mav.addObject("userFormAttribute",userForm);
        return mav;
    }
    @RequestMapping(value = "/saveUserForm", method = RequestMethod.POST)
    public ModelAndView saveUserForm(@ModelAttribute("userForm") UserForm userForm) {
            userService.saveUserForm(userForm);
        return new ModelAndView("requestSuccess");
    }
    @RequestMapping(value="/getRegistrationRequests")
    public ModelAndView getRegistrationRequests(){
        List<UserForm> userForm = userService.getAllRegistrationRequests();
        ModelAndView mav = new ModelAndView("registrationRequests");
        mav.addObject("userForm",userForm);
        return mav;}
@RequestMapping(value="/approveRegistration")
    public ModelAndView approveRegistration(@RequestParam("bid")int formId){
        ModelAndView mav = new ModelAndView("requestSuccess");
        UserForm userForm=userService.getUserFormById(formId);
        User user = new User();
        Address address = new Address();
       address.setAddressId(userForm.getFaddressId());
        address.setStreet(userForm.getStreet());
        address.setCity(userForm.getCity());
        address.setDistrict(userForm.getDistrict());
        address.setPinCode(userForm.getPinCode());
        userService.saveAddress(address);
        List<Address> addressList1 = new ArrayList<Address>();
        addressList1.add(address);
        user.setUserId(userForm.getUserId());
        user.setUserName(userForm.getUserName());
        user.setRole(userForm.getRole());
        user.setPassword(userForm.getPassword());
        user.setAddressList(addressList1);
        userService.updateUser(user);
        return mav;

}
 @Transactional
 @GetMapping(value = "/editUser")
    public ModelAndView getEdit(@RequestParam("id") int userId) {
        ModelAndView mav = new ModelAndView("editUser");
                User user1  = userService.getUserById(userId);
                List<Address> address2 = user1.getAddressList();
           mav.addObject("userAttribute",user1);
           mav.addObject("addressList",address2);
           return mav;
    }
    @RequestMapping(value = "/editUserSave", method = RequestMethod.POST)
    public ModelAndView postEdit(@RequestParam("id") Integer userId,
                                 @ModelAttribute("userAttribute") User user) {
        user.setUserId(userId);
        User user2 = userService.getUserById(userId);
        user.setAddressList(user2.getAddressList());
        user2.setUserId(user.getUserId());
        userService.updateUser(user);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/editAddress", method = RequestMethod.GET)
    public ModelAndView getEdit(@RequestParam("bid") int userId,@RequestParam("cid") int addressId) {
        ModelAndView mav = new ModelAndView("editAddress");
        Address address2 = userService.getAddressById(addressId);
        mav.addObject("userId",userId);
        mav.addObject("addressAttribute",address2);
        return mav;
    }
    @RequestMapping(value = "/editAddressSave", method = RequestMethod.POST)
    public ModelAndView postEdit(@RequestParam("id") int addressId,
                                @ModelAttribute("addressAttribute") Address address) {

        address.setAddressId(addressId);
        userService.saveAddress(address);

        return new ModelAndView("success");
    }

@RequestMapping(value="/editUserRole")
    public ModelAndView editUserRole(){
        ModelAndView mav = new ModelAndView("userList");
        List<User> users= userService.getAllUser();
        mav.addObject("userList",users);
        return mav;
}
@GetMapping(value="/editRole")
    public ModelAndView editRole(@RequestParam("id") int userId){
        ModelAndView mav = new ModelAndView("success");
        User user2= userService.getUserById(userId);
        Admin admin = new Admin();
        admin.setAdminId(user2.getUserId());
        admin.setAdminName(user2.getUserName());
        admin.setRole("admin");
        admin.setPassword(user2.getPassword());
        userService.saveAdmin(admin);
        return mav;
}
    @RequestMapping(value = "/timeList", method = RequestMethod.GET)
    public ModelAndView getTimeRecords() {
        ModelAndView mav = new ModelAndView("durationRecord");

        List<Song> songs = userService.getAllSongs();

        List<SongDTO> songDTO = new ArrayList<SongDTO>();

        for (Song song: songs) {
            SongDTO dto = new SongDTO();

            dto.setSongId(song.getSongId());
            dto.setSongName(song.getSongName());
            dto.setDownloads(song.getDownloads());
            songDTO.add(dto);

        }
        List<Duration> durations = userService.getAllDuration();

        List<DurationDTO> durationDTO = new ArrayList<DurationDTO>();

        for (Duration duration: durations) {
            DurationDTO dto = new DurationDTO();

            dto.setDurationId(duration.getDurationId());
            dto.setTimeDuration(duration.getTimeDuration());

            dto.setSongs(userService.getAllSongs(duration.getDurationId()));

            durationDTO.add(dto);
        }

        Duration duration = new Duration();
        mav.addObject("items",songDTO);
        mav.addObject("durations", durationDTO);
        mav.addObject("durationAttribute",duration);
        return mav;
    }

    //---------------------------- to list all the items(POST)--------------------------------------------//
    @RequestMapping(value = "/durationList", method = RequestMethod.POST)
    public ModelAndView postTimeRecords(@ModelAttribute("durationAttribute")Duration duration1) {

        ModelAndView mav = new ModelAndView("durationRecord");
        Duration duration2 = userService.getDurationByTime(duration1.getTimeDuration());
        List<Song> songs = userService.fetchAllSongs(duration2.getDurationId());

        List<SongDTO> songDTO = new ArrayList<SongDTO>();

        for (Song song: songs) {
            SongDTO dto = new SongDTO();

            dto.setSongId(song.getSongId());
            dto.setSongName(song.getSongName());
            dto.setDownloads(song.getDownloads());
            songDTO.add(dto);

        }
        List<Duration> durations = userService.getAllDuration();

        List<DurationDTO> durationDTO = new ArrayList<DurationDTO>();

        for (Duration duration: durations) {
            DurationDTO dto = new DurationDTO();

            dto.setDurationId(duration.getDurationId());
            dto.setTimeDuration(duration.getTimeDuration());

            dto.setSongs(userService.fetchAllSongs(duration.getDurationId()));

            durationDTO.add(dto);
        }


        mav.addObject("items",songDTO);
        mav.addObject("durations", durationDTO);
        mav.addObject("durationAttribute",duration2);
        return mav;
    }
    @RequestMapping(value="/deleteSong")
    public ModelAndView deleteSong(@RequestParam("id")int songId){
        userService.deleteSongById(songId);
        return new ModelAndView("success");
    }
    @RequestMapping(value="/deleteUserForm")
    public ModelAndView deleteUserForm(@RequestParam("id")int formId){
        userService.deleteUserFormById(formId);
        return new ModelAndView("success");
    }
    @RequestMapping(value="/deletePurchase")
    public ModelAndView deletePurchase(@RequestParam("id")int basketId){
        userService.deleteBasketById(basketId);
        return new ModelAndView("success");
    }





}
