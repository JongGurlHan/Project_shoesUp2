package project.shoesUp2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ShoesUp2Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ShoesUp2Application.class, args);

		String url_newBalance = "https://www.nbkorea.com/launchingCalendar/list.action?listStatus=C";

		Document doc2 = Jsoup.connect(url_newBalance).get();

		Elements month_newBalance = doc2.select(".lMonth"); //출시월
		Elements date_newBalance = doc2.select(".lDay"); //출시월
		Elements name_newBalance = doc2.select(".launching_name"); //출시월
		Elements releaseTime_newBalance = doc2.select(".launching_time"); //출시월
		Elements imgUrl_newBalance = doc2.select(".launching_img"); //출시월

//		System.out.println(month_newBalance);
//		System.out.println(date_newBalance);
//		System.out.println(name_newBalance);
//		System.out.println(releaseTime_newBalance);
		System.out.println(imgUrl_newBalance);
	}
}
//class="plc-product-date___1zgO_ gl-label gl-label--m gl-label--condensed"
