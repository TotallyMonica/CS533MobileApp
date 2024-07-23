package com.github.totallymonica.cs533mobileapp.helper;

import com.github.totallymonica.cs533mobileapp.model.Category;
import com.github.totallymonica.cs533mobileapp.model.Offer;
import com.github.totallymonica.cs533mobileapp.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * CS533 Mobile App
 * https://github.com/TotallyMonica/CS533MobileApp
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
public class Data {
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> newList = new ArrayList<>();
    List<Product> popularList = new ArrayList<>();
    List<Offer> offerList = new ArrayList<>();

    public List<Category> getCategoryList() {
        categoryList.clear();

        categoryList.add(new Category("1", "Food", "https://www.mashed.com/img/gallery/the-truth-about-hotel-breakfast-buffets/l-intro-1609346085.jpg"));
        categoryList.add(new Category("2", "Linens", "http://www.hotel-linen-supplier.com/wp-content/uploads/2019/06/Hotel-linen2.jpg")); // Use drawable prefix for local resources
        categoryList.add(new Category("3", "Cleaning Supplies", "https://www.thespruce.com/thmb/8K778grvhfBTNdRUZ41VnoEEVlw=/4000x2265/filters:fill(auto,1)/DirtyMopandBucket-5c5f326fc9e77c000166214f.jpg"));
        categoryList.add(new Category("4", "Room Amenities", "https://cpimg.tistatic.com/03123971/b/4/Hotel-Amenities.jpg"));
        categoryList.add(new Category("5", "Toiletries", "https://media.timeout.com/images/105719103/image.jpg"));
        categoryList.add(new Category("6", "Event Supplies", "https://images.rosewoodhotels.com/is/image/rwhg/pavilion-010-1"));

        return categoryList;
    }

    public List<Product> getProductList() {
        productList.clear();

        //Food Category (ID: 1)
        productList.add(new Product("1", "1", "Pancake Mix", "", "50 Lbs", "$", "80", "0", "https://images.heb.com/is/image/HEBGrocery/001857413"));
        productList.add(new Product("2", "1", "Coffee", "", "20 Lbs", "$", "100", "10% OFF", "https://cdnimg.webstaurantstore.com/images/products/extra_large/45595/637734.jpg" ));
        productList.add(new Product("3", "1", "Tea Bags", "", "1000 Count", "$", "80", "5% OFF", "https://specialteacompany.com/wp-content/uploads/2013/11/p-12014-Woven-Tea-Bags.jpg"));
        productList.add(new Product("4", "1", "Sugar", "", "100 Lbs", "$", "50", "0", "https://www.bakingbusiness.com/ext/resources/2021/9/SugarBagsTrio_Lead.jpg?height=635&t=1631299050&width=1200"));
        productList.add(new Product("10", "1", "Breakfast Cereals", "", "20 boxes", "$", "90", "10% OFF", "https://media4.popsugar-assets.com/files/2016/02/22/834/n/1922398/10b0a4ff59945843_feb_22_cereal.xxxlarge_2x.jpg"));

        // Linens Category (ID: 2)
        productList.add(new Product("11", "2", "Bath Towels", "", "100 count", "$", "300", "10% OFF", "https://i5.walmartimages.com/asr/7959ea91-d71f-45a1-a10c-5e477c9341f5_1.e02d2dd0e42d33e156c96ef3aa883c74.jpeg"));
        productList.add(new Product("12", "2", "Bed Sheets", "", "50 count", "$", "500", "0", "https://i5.walmartimages.com/asr/aa49ec8a-c213-4a45-afb2-c4ae962df67b_1.aa0a3581338db261f61099f719d5944f.jpeg?odnWidth=1000&odnHeight=1000&odnBg=ffffff"));
        productList.add(new Product("13", "2", "Pillow Cases", "", "200 count", "$", "200", "0", "https://images-na.ssl-images-amazon.com/images/I/617XtyBbonL._AC_SL1200_.jpg"));
        productList.add(new Product("14", "2", "Comforters", "", "30 count", "$", "600", "0", "https://www.curatedbyjw.com/images/products/v2/lrg/curatedbyjw-down-comforter-jw-112_lrg.jpg"));

        // Cleaning Supplies Category (ID: 3)
        productList.add(new Product("16", "3", "Laundry Detergent", "", "50 Lbs", "$", "100", "5% OFF", "https://midwestdetergents.com/wp-content/uploads/2022/07/Midwest-Detergents-Bulk-Green-Laundry-Detergent.jpg"));
        productList.add(new Product("17", "3", "Dish Soap", "", "20 Lbs", "$", "70", "0", "https://www.webstaurantstore.com/images/products/large/198988/772499.jpg"));
        productList.add(new Product("18", "3", "All-Purpose Cleaner", "", "30 Lbs", "$", "90", "20% OFF", "https://i5.walmartimages.com/asr/cee162f8-e698-493b-a9c2-a6af3740e5e7_1.b2a155f64890b4494fc08cb852fd212d.png?odnWidth=612&odnHeight=612&odnBg=ffffff"));
        productList.add(new Product("19", "3", "Glass Cleaner", "", "25 Lbs", "$", "80", "0", "https://content.etilize.com/images/900/1032575704.jpg"));
        productList.add(new Product("20", "3", "Disinfectant Wipes", "", "200 count", "$", "50", "15% OFF", "https://www.webstaurantstore.com/images/products/extra_large/162908/1127156.jpg"));

        // Room Amenities Category (ID: 4)
        productList.add(new Product("21", "4", "Shampoo", "", "100 bottles", "$", "200", "0", "https://cdnimg.webstaurantstore.com/images/products/xxl/536762/2105024.jpg"));
        productList.add(new Product("22", "4", "Conditioner", "", "100 bottles", "$", "200", "0", "https://image.made-in-china.com/2f0j00lYMbSVitbCcP/Private-Label-Cosmetics-Hair-Care-Coconut-Oil100-Organic-Deep-Repair-Sulfate-Free-Bulk-Hair-Conditioner-for-All-Hair-Types.jpg"));
        productList.add(new Product("23", "4", "Body Lotion", "", "100 bottles", "$", "250", "0", "https://images.americanhotel.com/images/products/1104905_1.jpg?width=1500&height=1500"));
        productList.add(new Product("24", "4", "Soap Bars", "", "500 count", "$", "150", "10% OFF", "https://cdnimg.webstaurantstore.com/images/products/medium/445153/1651690.jpg"));
        productList.add(new Product("25", "4", "Mouthwash", "", "100 bottles", "$", "200", "0", "https://media.takealot.com/covers_images/72ca2dde4f094587be798d642d0d70cc/s-zoom.file"));

        // Toiletries Category (ID: 5)
        productList.add(new Product("26", "5", "Toothpaste", "", "200 tubes", "$", "100", "0", "https://m.media-amazon.com/images/I/816XwpESzUL.jpg"));
        productList.add(new Product("27", "5", "Toothbrushes", "", "200 count", "$", "80", "0", "https://www.hotel-suppliers.com/wp-content/uploads/2021/09/dqe.jpg"));
        productList.add(new Product("28", "5", "Shaving kit", "", "100 bottles", "$", "150", "10% OFF", "https://static.wixstatic.com/media/c456ed_0579ae0d65754e35807dc88ee24dd476~mv2_d_1440_1438_s_2.jpg/v1/fill/w_996,h_996,al_c,q_85,usm_0.66_1.00_0.01/c456ed_0579ae0d65754e35807dc88ee24dd476~mv2_d_1440_1438_s_2.jpg"));

        // Event Supplies Category (ID: 6)
        productList.add(new Product("31", "6", "Tablecloths", "", "100 count", "$", "400", "0", "https://tableclothfactory.com/files/product_pics/pic_yk7ek_1591878032.jpg"));
        productList.add(new Product("33", "6", "Napkins", "", "1000 count", "$", "300", "0", "https://image.dhgate.com/0x0s/f2-albu-g8-M01-D8-8B-rBVaVFyGObqAIOlmAAHkviXrIVs576.jpg/5-colors-napkin-wholesale-50-70cm-cotton.jpg"));
        productList.add(new Product("34", "6", "Serving Trays", "", "50 count", "$", "200", "0", "https://cambro-bf.imgix.net/puebcz-2nj3vc-1lwa03/1525RST612_15_X_25_Hotel_Room_Service_Tray_Brushed_Steel.jpg?fit=crop&h=500&auto=format,compress"));
        productList.add(new Product("35", "6", "Drink Glasses", "", "1000 count", "$", "150", "20% OFF", "https://i.pinimg.com/originals/fc/fa/88/fcfa8825cf19432f771dfeedf4ef1902.jpg"));

        return productList;
    }

    public List<Product> getNewList() {
        Product product = new Product("1", "1", "Apple", "", "1 Kg", "$", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        newList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bounch", "$", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        newList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Lit.", "$", "25", "", "http://sunsetcleaningcia.com/wp-content/uploads/2016/05/houseclean.png");
        newList.add(product);
        product = new Product("4", "2", "House Clean Brush", "", "1 Piece", "$", "10", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        newList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "20", "$", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        newList.add(product);
        return newList;
    }

    public List<Product> getPopularList() {
        Product product = new Product("6", "3", "Baby Oil", "", "500 Ml", "$", "31", "", "https://www.fortunaonline.net/media/catalog/product/cache/1/small_image/295x/040ec09b1e35df139433887a97daa66f/n/k/nkbcp12_-_xia-shib-ao-baby-oil-200ml.png");
        popularList.add(product);
        product = new Product("7", "4", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("8", "4", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("9", "5", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("10", "5", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("11", "6", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("12", "6", "Apple", "", "1 Kg", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("13", "1", "Litche", "", "1 Kg", "$", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg");
        popularList.add(product);
        return popularList;
    }

    public List<Offer> getOfferList() {
        Offer offer = new Offer("http://1.bp.blogspot.com/-MMt-60IWEdw/VqZsh45Dv8I/AAAAAAAAMHg/70D9tVowlyc/s1600/askmegrocery-republic-day-offer.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.lootkaro.com/wp-content/uploads/2016/05/as1.jpg");
        offerList.add(offer);
        offer = new Offer("https://453xbcknr3t3ahr522mms518-wpengine.netdna-ssl.com/wp-content/themes/iga-west/images/banner-save-more.jpg");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/SVD/July18/750x375.png");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/BreakfastStore/kmande_2018-06-15T12-00_f010a5_1121973_grocery_750x375.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.enjoygrocery.com/images/enjoygrocery-offer.jpg");
        offerList.add(offer);


        return offerList;
    }
}
