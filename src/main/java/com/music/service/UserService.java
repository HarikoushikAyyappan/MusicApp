package com.music.service;

import com.music.model.*;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {
    List<User> find(int userId, String password);
    List<Admin> search(int adminId, String password);
    List<SuperAdmin> searchSuper(int superAdminId, String password);
    List<Song> getAllSongs();
    List<Genre> getAllGenre();
    Genre getGenreByName(String genreName);
    List<Song> getAllSongs(int genreId);
    Song updateSong(Song song);
    User getDetails(int userId);
    User updateUser(User user);
    List<Admin> getAllAdmin();
    void delete(int adminId);
     void add(Genre genre);
    Genre getGenreById(Integer genreId);
     void addSongTo(Integer genreId,Song song);

     User getUserById(int userId);
     Song getSongById(int songId);
     void addSongToUser(int userId,int songId);
     void addBasket(Basket basket);
     List<Basket> getAllBaskets();
     Basket getBasketById(int basketId);
    void deleteBasketById(int basketId);
    void saveUserForm(UserForm userForm);
    List<UserForm> getAllRegistrationRequests();
    UserForm getUserFormById(int userFormId);
    Address saveAddress(Address address);
    Address getAddressById(int addressId);
    List<User> getAllUser();
    void saveAdmin(Admin admin);
    Duration getDurationByTime( float timeDuration);
    List<Duration> getAllDuration();
    void deleteSongById(int songId);
    void deleteUserFormById(int formId);
    List<Song> fetchAllSongs(int durationId);


}
