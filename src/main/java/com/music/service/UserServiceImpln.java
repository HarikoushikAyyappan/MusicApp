package com.music.service;

import com.music.dao.CustomerDao;
import com.music.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class UserServiceImpln implements UserService{
    @Autowired
    CustomerDao customerDao;
    public List<User> find(int userId, String password){
        return customerDao.find(userId,password);
    }
    public List<Admin> search(int adminId, String password){
        return customerDao.search(adminId,password);
    }
    public List<SuperAdmin> searchSuper(int adminId, String password){
        return customerDao.searchSuper(adminId,password);
    }
    public List<Song> getAllSongs(){
        return customerDao.getAllSongs();
    }
    public List<Genre> getAllGenre(){
        return customerDao.getAllGenre();
    }
    public Genre getGenreByName(String genreName){
        return customerDao.getGenreByName(genreName);
    }
    public List<Song> getAllSongs(int genreId){
        return customerDao.getAllSongs(genreId);
    }
    public Song updateSong(Song song){
       return customerDao.updateSong(song);
    }
    public User getDetails(int userId){
        return customerDao.getDetails(userId);
    }
    public User updateUser(User user){
        return customerDao.updateUser(user);
    }
    public List<Admin> getAllAdmin(){
        return customerDao.getAllAdmin();
    }
    public void delete(int adminId){
         customerDao.delete(adminId);
    }
    public void add(Genre genre){
        customerDao.add(genre);
    }
    public Genre getGenreById(Integer genreId){
        return customerDao.getGenreById(genreId);
    }
    public void addSongTo(Integer genreId,Song song){
        customerDao.addSongTo(genreId,song);
    }

    public User getUserById(int userId){
        return customerDao.getUserById(userId);
    }
    public Song getSongById(int songId){
        return customerDao.getSongById(songId);
    }
    public void addSongToUser(int userId,int songId){
        customerDao.addSongToUser(userId,songId);
    }
    public void addBasket(Basket basket){
        customerDao.addBasket(basket);
    }
    public List<Basket> getAllBaskets(){
        return customerDao.getAllBaskets();
    }
    public Basket getBasketById(int basketId){
        return customerDao.getBasketById(basketId);
    }
    public void deleteBasketById(int basketId){
        customerDao.deleteBasketById(basketId);
    }
    public void saveUserForm(UserForm userForm){customerDao.saveUserForm(userForm);}
    public List<UserForm> getAllRegistrationRequests(){
        return customerDao.getAllRegistrationRequests();}
    public UserForm getUserFormById(int userFormId){
        return customerDao.getUserFormById(userFormId);}
    public Address saveAddress(Address address){
        return customerDao.saveAddress(address);
        }
        public Address getAddressById(int addressId){
        return customerDao.getAddressById(addressId);
        }
    public List<User> getAllUser(){
        return customerDao.getAllUser();
    }
    public void saveAdmin(Admin admin){
        customerDao.saveAdmin(admin);
    }
    public Duration getDurationByTime(float timeDuration){
        return customerDao.getDurationByTime(timeDuration);
    }
   public List<Duration> getAllDuration(){
        return customerDao.getAllDuration();
   }
   public void deleteSongById(int songId){
        customerDao.deleteSongById(songId);
   }


    public void deleteUserFormById(int formId) {
        customerDao.deleteUserFormById(formId);

    }
    public List<Song> fetchAllSongs(int durationId){
        return customerDao.getAllSongs(durationId);
    }

}

