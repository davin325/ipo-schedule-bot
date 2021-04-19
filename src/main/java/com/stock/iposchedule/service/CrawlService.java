package com.stock.iposchedule.service;

import com.stock.iposchedule.dto.IPOinfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlService {
    public List<IPOinfo> runCrawling() {
        List<IPOinfo> ipoInfoList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("http://www.38.co.kr/html/fund/index.htm?o=k&page=1").get();
            Elements contents = doc.select("body > table:nth-child(9) > tbody > tr > td > table:nth-child(2) > tbody > tr > td:nth-child(1) > table:nth-child(11) > tbody > tr:nth-child(2) > td > table > tbody > tr");
            for (Element content : contents) {
                IPOinfo ipoInfo = new IPOinfo();
                Elements tdContents = content.select("td");
                if(tdContents.get(5).text().contains("대신") ||tdContents.get(5).text().contains("미래에셋")
                        ||tdContents.get(5).text().contains("한국투자")||tdContents.get(5).text().contains("NH")||tdContents.get(5).text().contains("삼성")
                        ||tdContents.get(5).text().contains("하나금융")||tdContents.get(5).text().contains("KB")) {
                ipoInfo.setCompany(tdContents.get(0).text());
                ipoInfo.setDate(tdContents.get(1).text());
                ipoInfo.setFinalPrice(tdContents.get(2).text());
                ipoInfo.setHopePrice(tdContents.get(3).text());
                ipoInfo.setStockCompanys(tdContents.get(5).text());
                ipoInfoList.add(ipoInfo);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipoInfoList;
    }
}
