package project.shoesUp2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.shoesUp2.item.Item;
import project.shoesUp2.item.ItemRepository;

import java.io.IOException;

@SpringBootApplication
public class ShoesUp2Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ShoesUp2Application.class, args);


//
//		String url_newBalance = "https://www.nbkorea.com/launchingCalendar/list.action?listStatus=C";
//
//		Document doc2 = Jsoup.connect(url_newBalance).get();
//
//
//		Elements img = doc2.select("div.launching_img img");
//		for (Element image : img){
//			System.out.println(image.attr("src"));
//		}




	}
}
