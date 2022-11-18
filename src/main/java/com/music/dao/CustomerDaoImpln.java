package com.music.dao;

import com.music.model.*;
import com.music.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpln implements CustomerDao {
    @Autowired
    LoginCustomerRepository loginCustomer;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreNameRepository genreNameRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private UserFormRepository userFormRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DurationRepository durationRepository;
    @Autowired
    private DurationTimeRepository durationTimeRepository;


    @Transactional
    public List<User> find(int userId, String password) {
        return loginCustomer.find(userId, password);
    }

    @Transactional
    public List<Admin> search(int adminId, String password) {
        return adminRepository.search(adminId, password);
    }

    @Transactional
    public List<SuperAdmin> searchSuper(int superAdminId, String password) {
        return superAdminRepository.searchSuper(superAdminId, password);
    }

    @Transactional
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Transactional
    public Genre getGenreByName(String genreName) {
        return genreNameRepository.getGenreByName(genreName);
    }

    @Transactional
    public List<Song> getAllSongs(int genreId) {
        Genre genre = genreRepository.findById(genreId).get();
        return new ArrayList<Song>(genre.getSongList());
    }

    @Transactional
    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    @Transactional
    public User getDetails(int userId) {
        return userRepository.findById(userId).get();
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Transactional
    public void delete(int adminId) {
        adminRepository.deleteById(adminId);
    }

    @Transactional
    public void add(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    public Genre getGenreById(Integer genreId) {
        return genreRepository.findById(genreId).get();

    }
    @Transactional
    public void addSongTo(Integer genreId,Song song)  {


        Song song1 = new Song();

        song1.setSongId(song.getSongId());
        song1.setSongName(song.getSongName());

        songRepository.save(song1);

        Genre genre1 =genreRepository.findById(genreId).get();
        genre1.getSongList().add(song1);

        genreRepository.save(genre1);
    }
    @Transactional
    public User getUserById(int userId){
        return userRepository.findById(userId).get();
    }
    @Transactional
    public Song getSongById(int songId){
        return songRepository.findById(songId).get();
    }
    @Transactional
    public void addSongToUser(int userId,int songId){

        Song song2 = songRepository.findById(songId).get();

        User user2 = userRepository.findById(userId).get();
        user2.getSongs().add(song2);

        userRepository.save(user2);
    }
    @Transactional
    public void addBasket(Basket basket) {

        basketRepository.save(basket);
    }
    @Transactional
    public List<Basket> getAllBaskets(){
        return basketRepository.findAll();
    }
    @Transactional
    public Basket getBasketById(int basketId){
        return basketRepository.findById(basketId).get();
    }
    @Transactional
    public void deleteBasketById(int basketId){
        basketRepository.deleteById(basketId);
    }
    @Transactional
    public void saveUserForm(UserForm userForm){
        userFormRepository.save(userForm);}
    @Transactional
    public List<UserForm> getAllRegistrationRequests(){return userFormRepository.findAll();}
    @Transactional
    public UserForm getUserFormById(int userFormId){
        return userFormRepository.findById(userFormId).get();
    }
    @Transactional
    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
    @Transactional
    public Address getAddressById(int addressId){
        return addressRepository.findById(addressId).get();
    }
    @Transactional
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @Transactional
    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }
    @Transactional
    public Duration getDurationByTime(float timeDuration){
        return durationTimeRepository.getDurationByTime(timeDuration);
    }
    @Transactional
    public List<Duration> getAllDuration(){
        return durationRepository.findAll();
    }
    @Transactional
    public void deleteSongById(int songId){
        songRepository.deleteById(songId);
    }
    @Transactional
    public void deleteUserFormById(int formId){
        userFormRepository.deleteById(formId);
    }
    @Transactional
    public List<Song> fetchAllSongs(int durationId) {
        Duration duration = durationRepository.findById(durationId).get();
        return new ArrayList<Song>(duration.getSongs());
    }



    }


