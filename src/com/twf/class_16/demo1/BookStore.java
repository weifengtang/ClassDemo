package com.twf.class_16.demo1;

/**
 * @ClassName:BookStore
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/315:30
 * @Version:1.0
 **/
public class BookStore {


    double price = 0 ;

    //卖书
    public void saleBook(IBook book){

        double dic  = new Dicoument(book.getPrice()).getDic();
        price = book.getPrice()*dic;

        System.out.println("name = "+book.getName()+" 原价price = "
                +book.getPrice()+"  购入价："+price+" author = "+book.getAuthor());
    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.saleBook(new NovelBook("小说",30d,"唐伟锋"));
        bookStore.saleBook(new ComputerBook("软件工程",50d,"唐伟锋1","软件工程领域"));

    }
}
