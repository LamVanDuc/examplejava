package com.movie.t2108a.controller;

import com.movie.t2108a.model.Netflix;
import com.movie.t2108a.repository.NetflixRepository;

import java.util.*;


public class NetflixController {
    Scanner input = new Scanner(System.in);
    NetflixRepository netflixRepository = new NetflixRepository();


    List<Netflix> netflixList = netflixRepository.getData();
    int count = 0;

    //sort movie
    public void sortMovie(){

        Collections.sort(netflixList, new Comparator<Netflix>() {
            @Override
            public int compare(Netflix o1, Netflix o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for (Netflix a: netflixList
             ) {
            System.out.println(a.display());
        }


    }

    // search movie by name
    public void searchByName(){
        System.out.println("--------------------- By Name --------------------");
        String name = input.nextLine().toLowerCase(Locale.ROOT);

        for (int i = 0; i < netflixList.size() ; i++){
            if (netflixList.get(i).getTitle().contains(name)){
                System.out.println(netflixList.get(i).display());
                count ++;
            }
        }if (count ==0){
            System.out.println("không tìm thấy tên phim : "+name.toUpperCase(Locale.ROOT));
        }
    }

    //search movie by category
    public void searchByCategory(String category){
        System.out.println("----------------------- By Category------------------");
        for (int i = 0; i < netflixList.size() ; i++){
            if (netflixList.get(i).getCategory().contains(category)){
                System.out.println(netflixList.get(i).toString());
                count++;
            }
        }if (count ==0){
            System.out.println("không tìm thấy thể loại phim : "+category.toUpperCase());
        }
    }

    //search movie by language
    public void searchByLanguage(String language){
        System.out.println("----------------------- By Category------------------");
        for (int i = 0; i < netflixList.size() ; i++){
            if (netflixList.get(i).getLanguage().contains(language)){
                System.out.println(netflixList.get(i).toString());
            }
        }if (count ==0){
            System.out.println("không tìm thấy phim có ngôn ngữ : "+language.toUpperCase(Locale.ROOT));
        }
    }

    public  void countMovieByCategory(){
        Map<String , Integer> countMovieByCategory = new HashMap<>();

        for (int i =0; i< netflixList.size();i++){
            String category =netflixList.get(i).getCategory();
            String arrayCategory[] = category.split("/");

            for (int j = 0 ; j< arrayCategory.length; j++){
                Integer countMovie = countMovieByCategory.get(arrayCategory);
                if (countMovie ==null){
                    countMovieByCategory.put(arrayCategory[j],1);
                }else{
                    countMovieByCategory.put(arrayCategory[j],countMovie+1);
                }
            }


            for (Map.Entry<String , Integer> entry  :  countMovieByCategory.entrySet()) {
                System.out.printf("%s : %d \n", entry.getKey() , entry.getValue());
            }
        }
    }




}
