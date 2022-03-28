package com.movie.t2108a;

import com.movie.t2108a.controller.NetflixController;
import com.movie.t2108a.model.Netflix;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        NetflixController netflixController = new NetflixController();
        String searchMovie ;

        Scanner scanner = new Scanner(System.in);
        try {
            while (true){



                menu();
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        netflixController.sortMovie();
                        break;
                    case 2:
                        netflixController.searchByName();
                        break;
                    case 3:
                        System.out.println("vui lòng nhập thể loại phim: ");
                        searchMovie =  scanner.next();
                        netflixController.searchByCategory(searchMovie.toLowerCase(Locale.ROOT));
                        break;
                    case 4:
                        System.out.println("vui lòng nhập ngôn ngữ của phim : ");
                        searchMovie = scanner.next();
                        netflixController.searchByLanguage(searchMovie.toLowerCase(Locale.ROOT));
                        break;
                    case 5:
                        netflixController.countMovieByCategory();
                        break;
                    case 6:
                        System.exit(1);
                        break;
                    default:System.out.println("Chọn sai cú pháp .");

                }
            }
        }catch (InputMismatchException e){
            System.out.println("Nhập sai định dạng !");
        }

    }
    public static void printfList (List<Netflix> list){
        for (Netflix Netflix : list){
            System.out.println(Netflix);
        }
    }

    // menu
    public static void menu(){

        System.out.println("------------------ menu ------------------");
        System.out.println("1. sắp sếp phim ");
        System.out.println("2. tìm phim theo tên");
        System.out.println("3. tìm phim theo thể loại");
        System.out.println("4. tìm theo ngôn ngữ ");
        System.out.println("5. liệt kê phim theo thể loại");
        System.out.println("6. kết thúc chương trình");
        System.out.println("   vui lòng nhập lựa chọn của bạn : ");
    }
}
