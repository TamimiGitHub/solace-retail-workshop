package restock.restock;

import java.time.Instant;
import java.util.*;

import restock.Order;


// TODO: Move the potential order data to a json file
// TODO: Read the catalog json file and select items from it.
public class GenerateOrder {
    public static Integer MAX_ITEMS = 20;
    public static Integer MAX_QUANTITY = 10;
    private Order order = new Order();
    private static HashMap<String, Double> availableItems;

    public GenerateOrder() {
        // Default constructor for a new order
        System.out.println("Creating a new order!");
        availableItems  = buildItems();

        Random random = new Random();
        // Generate an order number.
        // Order number will be date plus a random 4 digit number
        // This will overflow Long eventually I suppose.
        order.setOrderNumber((Instant.now().toEpochMilli() * 10000) + random.nextInt(9999));

        // Set customer ID
        order.setCustomerID(random.nextInt(999999999));

        // Assign Order Status
        order.setStatus("New");

        // Assign store
        order.setStore(availableStores[random.nextInt(availableStores.length)]);

        // Assign requestTime UTC
        order.setRequestTime(Instant.now().toString());

        // Build order contents
        List<item> items = new ArrayList<item>();
        for (int i = 0; i <random.nextInt(MAX_ITEMS); i++) {
            items.add(generateItem());
        }
        order.setItems(items);

        // Assign status
        order.setStatus("Created");

        order.setStoreSize(random.nextInt(3));
    }

    /*
    Function to build items for an order 1 at a time
     */
    private static item generateItem() {
        Random random = new Random();
        item myItem = new item();
        List<String> itemList = new ArrayList<String>(availableItems.keySet());
        int randomItem = new Random().nextInt(itemList.size());
        myItem.setItemName(itemList.get(randomItem));
        myItem.setItemQuantity(random.nextInt(MAX_QUANTITY)+1);
        myItem.setItemPrice(availableItems.get(itemList.get(randomItem)));
        return myItem;
    }

    public Order getOrder() {
        return order;
    }






    // 2D array of items that can go into an order


    String[] availableStores = {
        "Pittsburg",
        "Buckeye",
        "Brea",
        "Indio",
        "Scottsdale",
        "Columbus",
        "Lancaster",
        "Lincoln",
        "Trenton",
        "Boston",
        "Glendora",
        "Rochester",
        "Florissant",
        "Annapolis",
        "Chapel Hill",
        "Lawrence",
        "Calexico",
        "Calumet City",
        "Missoula",
        "Clovis",
        "Pearland",
        "Gilbert",
        "Wausau",
        "Raleigh",
        "Orange",
        "Walnut Creek",
        "Bremerton",
        "Porterville",
        "Marana",
        "Tallahassee",
        "Conroe",
        "Blacksburg",
        "San Antonio",
        "Hartford",
        "Waterloo",
        "Binghamton",
        "Meridian",
        "Fond du Lac",
        "Baytown",
        "Cary",
        "Weymouth Town",
        "Tulsa",
        "Mission",
        "Cuyahoga Falls",
        "Malden",
        "Allen",
        "Tucson",
        "Franklin",
        "Shakopee",
        "Jacksonville",
        "Atlantic City",
        "Erie",
        "Merced",
        "Abilene",
        "Yorba Linda",
        "Greenville",
        "Huntersville",
        "St. Clair Shores",
        "Harrisburg",
        "San Buenaventura (Ventura)",
        "Fremont",
        "Pueblo",
        "Chelsea",
        "Belleville",
        "Minneapolis",
        "Bartlett",
        "Wichita Falls", 
        "Missouri City",
        "St. Louis"
    };

    private HashMap<String, Double> buildItems() {
        availableItems = new HashMap<>();
        // Each item has a random price between .01 and 50.00
        availableItems.put("DELLE VENEZIE PINOT GRIGIO - PASQUA COLORI D'ITALIA", 41.22);
        availableItems.put("1792 - BCLS PERSONAL BARREL BOURBON", 29.78);
        availableItems.put("MICHELOB - ULTRA SLEEK 24 CAN", 34.37);
        availableItems.put("STEAM WHISTLE - PILSNER CAN", 24.05);
        availableItems.put("BAROLO - SANDRONE LE VIGNE 2016", 35.89);
        availableItems.put("ABSOLUT - JUICE STRAWBERRY EDITION", 23.69);
        availableItems.put("OLD PULTENEY - 2007 SINGLE CASK", 6.08);
        availableItems.put("FRONSAC - CHATEAU MOULIN HAUT LAROQUE 2018", 7.65);
        availableItems.put("ARGYLE - VINTAGE BRUT 2014", 16.03);
        availableItems.put("GLENFARCLAS - 17 YEAR OLD", 29.44);
        availableItems.put("BALVENIE - WEEK OF PEAT 14YO", 27.8);
        availableItems.put("CANADIAN CLUB 43 YEAR OLD - CC CHRONICLES ISSUE NO. 3", 40.85);
        availableItems.put("RUSSELL BREWING - BLOOD ALLEY ESB TALL CAN", 15.8);
        availableItems.put("MERLOT  DONINI", 35.3);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 1999", 27.91);
        availableItems.put("REMY MARTIN - GRANDE CHAMPAGNE LOUIS XIII", 39.05);
        availableItems.put("DEVERON - 12 YEAR OLD", 40.31);
        availableItems.put("DUJARDIN - V.S.O.P.", 17.99);
        availableItems.put("SILENT SAM", 15.77);
        availableItems.put("NIKKA - TAKETSURU 21 YEAR OLD MADEIRA FINISH", 29.31);
        availableItems.put("ST ESTEPHE - CHATEAU LILIAN LADOUYS 2018", 36.15);
        availableItems.put("COMPASS BOX - MENAGERIE", 13.85);
        availableItems.put("PALM BAY - 0G VARIETY CAN", 36.9);
        availableItems.put("SAINT VIVANT - V.S.O.P.", 49.44);
        availableItems.put("BOLGHERI SUPERIORE - ORNELLAIA 2016", 33.24);
        availableItems.put("GRAVES BLANC - CLOS FLORIDENE 2013", 17.0);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 2017", 37.02);
        availableItems.put("CORONA LIGHT - SLEEK CAN", 30.72);
        availableItems.put("GRANT'S - SHERRY CASK 8 YO", 24.06);
        availableItems.put("GEVREY CHAMBERTIN 1ER LAVAUX ST JACQUES - ALBERT BICHOT 2016", 48.21);
        availableItems.put("CEDARCREEK - CHARDONNAY 2019", 46.79);
        availableItems.put("PAUILLAC - CHATEAU LYNCH BAGES 2010", 19.69);
        availableItems.put("CHASSAGNE MONTRACHET 1ER LES VERGERS - DOM FONT GAGNARD 16", 8.65);
        availableItems.put("PIPER HEIDSIECK - CUVEE BRUT", 35.31);
        availableItems.put("SMIRNOFF INFUSIONS - WATERMELON AND MINT", 26.38);
        availableItems.put("TRUMPETER - ROSE DE MALBEC EXTRA BRUT", 46.98);
        availableItems.put("BORDEAUX ROUGE - JEAN PIERRE MOUEIX 2016", 40.28);
        availableItems.put("GROWERS - SUMMER PEACH CAN", 16.32);
        availableItems.put("REVELSTOKE GIN - SERIES NO. 1", 3.0);
        availableItems.put("DAGERAAD - BURNABARIAN TALL CAN", 16.45);
        availableItems.put("CHIANTI CLASSICO GRAN SELEZIONE - RUFFINO ROMITORIO DI SANTE", 18.9);
        availableItems.put("CROWN ROYAL BLENDERS MASH", 11.8);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 2017", 39.26);
        availableItems.put("PINOT NOIR - SOKOL BLOSSER DUNDEE HILLS 2017", 16.29);
        availableItems.put("CHATEAU LAFITE ROTHSCHILD 2013", 21.57);
        availableItems.put("NAPA VALLEY RED - OPUS ONE 2014", 25.02);
        availableItems.put("LAMB'S - NAVY", 46.82);
        availableItems.put("CABERNET SAUVIGNON - MIL PIEDRAS VALLEY DE UCO 2018", 0.76);
        availableItems.put("SHIRAZ - PIRRAMIMMA 1892 MCLAREN VALE 2018", 3.59);
        availableItems.put("VOSNE ROMANEE 1ER LES ROUGES DU DESSUS - PIERRE BRISSET 2015", 41.8);
        availableItems.put("NIKKA - THE NIKKA 12 YEAR OLD", 20.62);
        availableItems.put("SAUVIGNON BLANC - CRANSWICK COCOPARRA RIVERINA", 21.6);
        availableItems.put("STELLERS JAY - BRUT 2016", 41.81);
        availableItems.put("THE KRAKEN - BLACK SPICED", 25.47);
        availableItems.put("CHINON - DOMAINE DE L'R LE CANAL DES GRANDS PIECES 2019", 36.35);
        availableItems.put("PESSAC LEOGNAN - LA CLARTE DE HAUT BRION BLANC 2018", 37.96);
        availableItems.put("CABERNET SAUVIGNON - 8 RIOS CHILE 2018", 46.0);
        availableItems.put("BILLECART SALMON - VINTAGE 2007", 45.11);
        availableItems.put("MALBEC - CATENA ZAPATA ADRIANNA VINEYARD RIVER STONES", 3.95);
        availableItems.put("NAPA VALLEY RED - BOND QUELLA 2014", 38.62);
        availableItems.put("VINTAGE PORT - DOW'S 2017", 25.36);
        availableItems.put("Angelica", 43.22);
        availableItems.put("Savoy cabbage", 16.79);
        availableItems.put("Silver linden", 45.73);
        availableItems.put("Kiwi", 11.17);
        availableItems.put("Allium (Onion)", 7.98);
        availableItems.put("Garden onion", 15.0);
        availableItems.put("Leek", 33.73);
        availableItems.put("Garlic", 35.31);
        availableItems.put("Chives", 46.51);
        availableItems.put("Lemon verbena", 30.62);
        availableItems.put("Cashew nut", 37.66);
        availableItems.put("Pineapple", 12.71);
        availableItems.put("Dill", 34.02);
        availableItems.put("Custard apple", 12.92);
        availableItems.put("Wild celery", 7.57);
        availableItems.put("Peanut", 35.51);
        availableItems.put("Burdock", 40.61);
        availableItems.put("Horseradish", 26.02);
        availableItems.put("Tarragon", 35.5);
        availableItems.put("Mugwort", 30.95);
        availableItems.put("Asparagus", 48.35);
        availableItems.put("Oat", 19.2);
        availableItems.put("Star fruit", 46.51);
        availableItems.put("Brazil nut", 40.17);
        availableItems.put("Common beet", 31.75);
        availableItems.put("Borage", 30.37);
        availableItems.put("Chinese mustard", 7.36);
        availableItems.put("Swede", 26.53);
        availableItems.put("Rape", 32.85);
        availableItems.put("Common cabbage", 5.54);
        availableItems.put("Cauliflower", 46.15);
        availableItems.put("Brussel sprouts", 28.86);
        availableItems.put("Kohlrabi", 42.5);
        availableItems.put("Broccoli", 20.95);
        availableItems.put("Chinese cabbage", 13.84);
        availableItems.put("Turnip", 25.72);
        availableItems.put("Pigeon pea", 8.35);
        availableItems.put("Tea", 3.42);
        availableItems.put("Capers", 37.3);
        availableItems.put("Pepper (C. annuum)", 5.45);
        availableItems.put("Papaya", 49.86);
        availableItems.put("Safflower", 23.85);
        availableItems.put("Caraway", 38.76);
        availableItems.put("Pecan nut", 33.0);
        availableItems.put("Chestnut", 49.44);
        availableItems.put("Roman camomile", 27.62);
        availableItems.put("Chickpea", 22.95);
        availableItems.put("Endive", 17.22);
        availableItems.put("Chicory", 32.26);
        availableItems.put("Chinese cinnamon", 9.05);
        availableItems.put("Ceylon cinnamon", 4.56);
        availableItems.put("Watermelon", 28.98);
        availableItems.put("Lime", 44.23);
        availableItems.put("Lemon", 22.8);
        availableItems.put("Pummelo", 27.47);
        availableItems.put("Mandarin orange (Clementine, Tangerine)", 31.36);
        availableItems.put("Sweet orange", 18.67);
        availableItems.put("Coffee", 23.54);
        availableItems.put("Arabica coffee", 36.65);
        availableItems.put("Robusta coffee", 37.81);
        availableItems.put("Coriander", 38.48);
        availableItems.put("Common hazelnut", 2.28);
        availableItems.put("Saffron", 22.75);
        availableItems.put("Muskmelon", 1.34);
        availableItems.put("Cucumber", 10.81);
        availableItems.put("Cucurbita (Gourd)", 33.68);
        availableItems.put("Cumin", 31.19);
        availableItems.put("Turmeric", 43.92);
        availableItems.put("Quince", 29.97);
        availableItems.put("Lemon grass", 23.1);
        availableItems.put("Globe artichoke", 33.68);
        availableItems.put("Wild carrot", 2.15);
        availableItems.put("Japanese persimmon", 14.51);
        availableItems.put("Cardamom", 31.48);
        availableItems.put("Black crowberry", 48.28);
        availableItems.put("Loquat", 40.0);
        availableItems.put("Rocket salad", 31.73);
        availableItems.put("Wax apple", 30.49);
        availableItems.put("Common buckwheat", 1.05);
        availableItems.put("Tartary buckwheat", 12.87);
        availableItems.put("Fig", 19.34);
        availableItems.put("Fennel", 11.32);
        availableItems.put("Strawberry", 25.53);
        availableItems.put("Black huckleberry", 10.92);
        availableItems.put("Soy bean", 1.86);
        availableItems.put("Sunflower", 5.2);
        availableItems.put("Sea-buckthornberry", 2.39);
        availableItems.put("Barley", 24.97);
        availableItems.put("Hyssop", 17.69);
        availableItems.put("Star anise", 48.66);
        availableItems.put("Swamp cabbage", 32.77);
        availableItems.put("Sweet potato", 44.04);
        availableItems.put("Black walnut", 22.74);
        availableItems.put("Common walnut", 7.42);
        availableItems.put("Lettuce", 48.89);
        availableItems.put("Grass pea", 40.05);
        availableItems.put("Sweet bay", 21.08);
        availableItems.put("Lentils", 32.01);
        availableItems.put("Garden cress", 43.73);
        availableItems.put("Lovage", 12.41);
        availableItems.put("Flaxseed", 42.27);
        availableItems.put("Mexican oregano", 27.15);
        availableItems.put("Lichee", 47.94);
        availableItems.put("Lupine", 9.82);
        availableItems.put("Apple", 44.47);
        availableItems.put("Mango", 20.49);
        availableItems.put("German camomile", 19.73);
        availableItems.put("Lemon balm", 43.01);
        availableItems.put("Mentha (Mint)", 39.09);
        availableItems.put("Orange mint", 4.87);
        availableItems.put("Cornmint", 45.26);
        availableItems.put("Spearmint", 48.14);
        availableItems.put("Peppermint", 44.46);
        availableItems.put("Medlar", 41.51);
        availableItems.put("Bitter gourd", 48.11);
        availableItems.put("Mulberry", 17.57);
        availableItems.put("Black mulberry", 40.47);
        availableItems.put("Nutmeg", 47.91);
        availableItems.put("Sweet basil", 25.48);
        availableItems.put("Evening primrose", 44.78);
        availableItems.put("Olive", 11.85);
        availableItems.put("Sweet marjoram", 8.32);
        availableItems.put("Pot marjoram", 34.68);
        availableItems.put("Common oregano", 39.87);
        availableItems.put("Rice", 23.73);
        availableItems.put("Millet", 38.1);
        availableItems.put("Poppy", 48.64);
        availableItems.put("Passion fruit", 23.68);
        availableItems.put("Parsnip", 6.58);
        availableItems.put("Avocado", 27.22);
        availableItems.put("Parsley", 0.81);
        availableItems.put("Scarlet bean", 2.28);
        availableItems.put("Lima bean", 11.72);
        availableItems.put("Common bean", 44.2);
        availableItems.put("Date", 41.07);
        availableItems.put("Black chokeberry", 28.82);
        availableItems.put("Anise", 32.08);
        availableItems.put("Pine nut", 4.0);
        availableItems.put("Pepper (Spice)", 42.33);
        availableItems.put("Pistachio", 13.04);
        availableItems.put("Common pea", 45.26);
        availableItems.put("Purslane", 41.87);
        availableItems.put("Prunus (Cherry, Plum)", 11.09);
        availableItems.put("Apricot", 34.09);
        availableItems.put("Sweet cherry", 49.22);
        availableItems.put("Sour cherry", 22.12);
        availableItems.put("European plum", 42.22);
        availableItems.put("Almond", 27.12);
        availableItems.put("Peach", 30.31);
        availableItems.put("Guava", 29.52);
        availableItems.put("Pomegranate", 22.9);
        availableItems.put("Pear", 35.69);
        availableItems.put("Radish", 39.32);
        availableItems.put("Garden rhubarb", 14.1);
        availableItems.put("Blackcurrant", 4.26);
        availableItems.put("Redcurrant", 30.67);
        availableItems.put("Gooseberry", 36.37);
        availableItems.put("Watercress", 15.98);
        availableItems.put("Rosemary", 41.02);
        availableItems.put("Rubus (Blackberry, Raspberry)", 23.64);
        availableItems.put("Cloudberry", 26.41);
        availableItems.put("Red raspberry", 5.3);
        availableItems.put("Black raspberry", 38.24);
        availableItems.put("Sorrel", 30.4);
        availableItems.put("Common sage", 28.06);
        availableItems.put("Black elderberry", 23.97);
        availableItems.put("Summer savory", 34.25);
        availableItems.put("Winter savory", 44.67);
        availableItems.put("Rye", 24.19);
        availableItems.put("Sesame", 31.5);
        availableItems.put("Garden tomato", 30.44);
        availableItems.put("Cherry tomato", 35.57);
        availableItems.put("Garden tomato", 43.48);
        availableItems.put("Eggplant", 36.91);
        availableItems.put("Potato", 49.25);
        availableItems.put("Rowanberry", 37.9);
        availableItems.put("Sorghum", 0.5);
        availableItems.put("Spinach", 1.68);
        availableItems.put("Cloves", 6.44);
        availableItems.put("Tamarind", 3.91);
        availableItems.put("Dandelion", 30.7);
        availableItems.put("Cocoa bean", 20.91);
        availableItems.put("Common thyme", 5.13);
        availableItems.put("Linden", 41.5);
        availableItems.put("Small-leaf linden", 36.02);
        availableItems.put("Fenugreek", 3.63);
        availableItems.put("Common wheat", 23.22);
        availableItems.put("Vaccinium (Blueberry, Cranberry, Huckleberry)", 43.14);
        availableItems.put("Lowbush blueberry", 30.05);
        availableItems.put("Sparkleberry", 5.81);
        availableItems.put("Highbush blueberry", 25.11);
        availableItems.put("American cranberry", 17.2);
        availableItems.put("Bilberry", 40.13);
        availableItems.put("Lingonberry", 39.93);
        availableItems.put("Vanilla", 14.46);
        availableItems.put("Common verbena", 7.24);
        availableItems.put("Broad bean", 21.53);
        availableItems.put("Adzuki bean", 35.31);
        availableItems.put("Gram bean", 47.75);
        availableItems.put("Mung bean", 27.32);
        availableItems.put("Climbing bean", 31.67);
        availableItems.put("Cowpea", 17.67);
        availableItems.put("Muscadine grape", 43.75);
        availableItems.put("Common grape", 31.44);
        availableItems.put("Corn", 16.94);
        availableItems.put("Ginger", 42.75);
        availableItems.put("Arctic blackberry", 24.61);
        availableItems.put("Banana", 30.43);
        availableItems.put("Bayberry", 42.1);
        availableItems.put("Elliott's blueberry", 3.9);
        availableItems.put("Canada blueberry", 25.44);
        availableItems.put("Bog bilberry", 33.42);
        availableItems.put("Buffalo currant", 4.05);
        availableItems.put("Celeriac", 14.37);
        availableItems.put("Celery stalks", 27.29);
        availableItems.put("Chinese chives", 12.35);
        availableItems.put("European cranberry", 3.0);
        availableItems.put("Deerberry", 46.49);
        availableItems.put("Ginseng", 14.04);
        availableItems.put("Cascade huckleberry", 46.34);
        availableItems.put("Oval-leaf huckleberry", 18.83);
        availableItems.put("Evergreen huckleberry", 9.91);
        availableItems.put("Red huckleberry", 17.84);
        availableItems.put("Longan", 23.4);
        availableItems.put("Macadamia nut (M. tetraphylla)", 2.55);
        availableItems.put("Garden onion ", 6.04);
        availableItems.put("Summer grape", 24.6);
        availableItems.put("Fox grape", 13.09);
        availableItems.put("Nectarine", 11.55);
        availableItems.put("Peach ", 22.46);
        availableItems.put("Pepper (C. baccatum)", 25.25);
        availableItems.put("Pepper (C. chinense)", 15.66);
        availableItems.put("Pepper (Capsicum)", 46.41);
        availableItems.put("Rambutan", 27.13);
        availableItems.put("Red rice", 43.89);
        availableItems.put("Annual wild rice", 1.69);
        availableItems.put("Swiss chard", 22.28);
        availableItems.put("Lemon thyme", 45.41);
        availableItems.put("Tronchuda cabbage", 35.65);
        availableItems.put("Japanese walnut", 29.65);
        availableItems.put("Welsh onion", 34.67);
        availableItems.put("Hard wheat", 37.38);
        availableItems.put("Shallot", 48.4);
        availableItems.put("Rocket salad", 21.43);
        availableItems.put("Carrot", 17.73);
        availableItems.put("Triticale", 37.6);
        availableItems.put("Black cabbage", 49.92);
        availableItems.put("Half-highbush blueberry", 27.06);
        availableItems.put("Celery leaves", 4.82);
        availableItems.put("Chicory leaves", 44.56);
        availableItems.put("Komatsuna", 14.1);
        availableItems.put("Pak choy", 14.1);
        availableItems.put("Napa cabbage", 35.7);
        availableItems.put("Chicory roots", 8.68);
        availableItems.put("Grapefruit/Pummelo hybrid", 2.77);
        availableItems.put("Grapefruit", 34.19);
        availableItems.put("Jostaberry", 19.19);
        availableItems.put("Kai-lan", 18.49);
        availableItems.put("Italian oregano", 35.6);
        availableItems.put("Oxheart cabbage", 17.92);
        availableItems.put("Daikon radish", 0.37);
        availableItems.put("Black radish", 27.51);
        availableItems.put("Radish", 49.42);
        availableItems.put("Red beetroot", 8.5);
        availableItems.put("Sweet rowanberry", 5.15);
        availableItems.put("Pineappple sage", 0.75);
        availableItems.put("Skunk currant", 5.7);
        availableItems.put("Beer", 2.07);
        availableItems.put("Breakfast cereal", 32.81);
        availableItems.put("Pasta", 24.62);
        availableItems.put("Biscuit", 11.09);
        availableItems.put("Sourdough", 45.15);
        availableItems.put("Spirit", 25.52);
        availableItems.put("Fortified wine", 25.59);
        availableItems.put("Abalone", 16.45);
        availableItems.put("Abiyuch", 43.67);
        availableItems.put("Acerola", 26.49);
        availableItems.put("Acorn", 13.79);
        availableItems.put("Winter squash", 5.1);
        availableItems.put("Agar", 24.46);
        availableItems.put("Red king crab", 38.28);
        availableItems.put("Alfalfa", 17.08);
        availableItems.put("Allspice", 33.31);
        availableItems.put("Amaranth", 32.42);
        availableItems.put("Arrowhead", 8.97);
        availableItems.put("Arrowroot", 9.03);
        availableItems.put("Asian pear", 12.63);
        availableItems.put("Atlantic herring", 26.77);
        availableItems.put("Atlantic mackerel", 47.16);
        availableItems.put("Painted comber", 48.73);
        availableItems.put("Atlantic pollock", 33.92);
        availableItems.put("Atlantic wolffish", 2.25);
        availableItems.put("Bamboo shoots", 7.13);
        availableItems.put("Striped bass", 6.6);
        availableItems.put("Beaver", 49.06);
        availableItems.put("Beech nut", 5.08);
        availableItems.put("Beluga whale", 24.27);
        availableItems.put("Bison", 48.8);
        availableItems.put("Black bear", 17.23);
        availableItems.put("Alaska blackfish", 48.84);
        availableItems.put("Blue crab", 30.68);
        availableItems.put("Blue mussel", 48.02);
        availableItems.put("Northern bluefin tuna", 28.52);
        availableItems.put("Bluefish", 25.87);
        availableItems.put("Wild boar", 32.64);
        availableItems.put("Bowhead whale", 33.95);
        availableItems.put("Breadfruit", 47.88);
        availableItems.put("Breadnut tree seed", 21.15);
        availableItems.put("Rapini", 9.45);
        availableItems.put("Brown bear", 44.12);
        availableItems.put("Buffalo", 36.0);
        availableItems.put("Burbot", 6.24);
        availableItems.put("Giant butterbur", 37.51);
        availableItems.put("American butterfish", 17.62);
        availableItems.put("Butternut", 18.73);
        availableItems.put("Butternut squash", 20.27);
        availableItems.put("Calabash", 33.71);
        availableItems.put("Cardoon", 12.37);
        availableItems.put("Caribou", 11.67);
        availableItems.put("Natal plum", 27.69);
        availableItems.put("Carob", 17.39);
        availableItems.put("Common carp", 34.32);
        availableItems.put("Cassava", 26.18);
        availableItems.put("Channel catfish", 42.41);
        availableItems.put("Chayote", 30.96);
        availableItems.put("Cherimoya", 0.5);
        availableItems.put("Chervil", 19.02);
        availableItems.put("Chia", 15.71);
        availableItems.put("Chicken (Cock, Hen, Rooster)", 23.24);
        availableItems.put("Chinese broccoli", 32.65);
        availableItems.put("Chinese chestnut", 1.07);
        availableItems.put("Chinese water chestnut", 32.81);
        availableItems.put("Garland chrysanthemum", 32.48);
        availableItems.put("Cisco", 16.3);
        availableItems.put("Nuttall cockle", 1.71);
        availableItems.put("Coconut", 29.5);
        availableItems.put("Pacific cod", 35.62);
        availableItems.put("Atlantic cod", 31.32);
        availableItems.put("Common octopus", 17.43);
        availableItems.put("Corn salad", 9.3);
        availableItems.put("Cottonseed", 9.64);
        availableItems.put("Catjang pea", 0.17);
        availableItems.put("Malus (Crab apple)", 16.73);
        availableItems.put("Squashberry", 45.0);
        availableItems.put("Atlantic croaker", 1.84);
        availableItems.put("Cusk", 30.33);
        availableItems.put("Cuttlefish", 39.94);
        availableItems.put("Mule deer", 49.56);
        availableItems.put("Devilfish", 2.6);
        availableItems.put("Dock", 25.88);
        availableItems.put("Dolphin fish", 4.53);
        availableItems.put("Freshwater drum", 30.98);
        availableItems.put("Mallard duck", 12.22);
        availableItems.put("Dungeness crab", 20.05);
        availableItems.put("Durian", 45.18);
        availableItems.put("Eastern oyster", 33.3);
        availableItems.put("Freshwater eel", 9.23);
        availableItems.put("Elderberry", 17.07);
        availableItems.put("Elk", 3.86);
        availableItems.put("Emu", 36.55);
        availableItems.put("Oregon yampah", 47.27);
        availableItems.put("European anchovy", 15.11);
        availableItems.put("European chestnut", 43.48);
        availableItems.put("Turbot", 29.17);
        availableItems.put("Fireweed", 11.17);
        availableItems.put("Florida pompano", 20.18);
        availableItems.put("Ginkgo nuts", 17.1);
        availableItems.put("Greylag goose", 38.99);
        availableItems.put("Grape", 33.27);
        availableItems.put("Greenland halibut/turbot", 28.95);
        availableItems.put("Groundcherry", 41.82);
        availableItems.put("Grouper", 47.54);
        availableItems.put("Guinea hen", 0.71);
        availableItems.put("Haddock", 13.83);
        availableItems.put("Hippoglossus (Common halibut)", 41.35);
        availableItems.put("Hazelnut", 33.17);
        availableItems.put("Hickory nut", 44.01);
        availableItems.put("Horse", 34.72);
        availableItems.put("Horseradish tree", 47.24);
        availableItems.put("Alaska blueberry", 31.22);
        availableItems.put("Hyacinth bean", 45.58);
        availableItems.put("Irish moss", 43.54);
        availableItems.put("Pacific jack mackerel", 15.61);
        availableItems.put("Jackfruit", 45.11);
        availableItems.put("Japanese chestnut", 20.9);
        availableItems.put("Java plum", 8.97);
        availableItems.put("Jerusalem artichoke", 38.84);
        availableItems.put("Jujube", 34.73);
        availableItems.put("Jute", 29.28);
        availableItems.put("Kale", 14.13);
        availableItems.put("Kelp", 25.16);
        availableItems.put("King mackerel", 9.15);
        availableItems.put("Kumquat", 40.22);
        availableItems.put("Lambsquarters", 31.97);
        availableItems.put("Leather chiton", 21.36);
        availableItems.put("Wild leek", 7.34);
        availableItems.put("Common ling", 5.46);
        availableItems.put("Lingcod", 31.97);
        availableItems.put("American lobster", 18.26);
        availableItems.put("Loganberry", 28.8);
        availableItems.put("Lotus", 34.46);
        availableItems.put("Sacred lotus", 17.42);
        availableItems.put("White lupine", 23.69);
        availableItems.put("Malabar spinach", 18.26);
        availableItems.put("Mammee apple", 46.3);
        availableItems.put("Purple mangosteen", 14.56);
        availableItems.put("Alpine sweetvetch", 40.24);
        availableItems.put("Milkfish", 41.76);
        availableItems.put("Monkfish", 16.46);
        availableItems.put("Moose", 2.3);
        availableItems.put("Moth bean", 9.77);
        availableItems.put("Mountain yam", 11.2);
        availableItems.put("Striped mullet", 17.86);
        availableItems.put("Muskrat", 8.8);
        availableItems.put("White mustard", 0.1);
        availableItems.put("Mustard spinach", 18.24);
        availableItems.put("New Zealand spinach", 5.58);
        availableItems.put("Nopal", 13.23);
        availableItems.put("Ocean pout", 43.74);
        availableItems.put("North Pacific giant octopus", 9.92);
        availableItems.put("Ohelo berry", 35.72);
        availableItems.put("Okra", 24.63);
        availableItems.put("Tunicate", 44.95);
        availableItems.put("Opossum", 45.19);
        availableItems.put("Ostrich", 3.29);
        availableItems.put("Spotted seal", 38.91);
        availableItems.put("Pacific herring", 19.48);
        availableItems.put("Pacific oyster", 3.2);
        availableItems.put("Pacific rockfish", 43.34);
        availableItems.put("Velvet duck", 34.55);
        availableItems.put("Pepper (C. frutescens)", 44.35);
        availableItems.put("Common persimmon", 18.92);
        availableItems.put("Pheasant", 18.21);
        availableItems.put("Northern pike", 30.09);
        availableItems.put("Pili nut", 12.34);
        availableItems.put("Colorado pinyon", 14.64);
        availableItems.put("Pitanga", 15.3);
        availableItems.put("Plains prickly pear", 17.4);
        availableItems.put("French plantain", 49.11);
        availableItems.put("American pokeweed", 45.08);
        availableItems.put("Polar bear", 41.84);
        availableItems.put("Opium poppy", 1.18);
        availableItems.put("Prairie turnip", 47.03);
        availableItems.put("Prickly pear", 23.51);
        availableItems.put("Quinoa", 16.14);
        availableItems.put("European rabbit", 48.96);
        availableItems.put("Raccoon", 40.22);
        availableItems.put("Rainbow smelt", 48.49);
        availableItems.put("Rainbow trout", 27.98);
        availableItems.put("Malabar plum", 14.79);
        availableItems.put("Rose hip", 44.29);
        availableItems.put("Roselle", 30.99);
        availableItems.put("Orange roughy", 20.53);
        availableItems.put("Sablefish", 17.23);
        availableItems.put("Pink salmon", 20.91);
        availableItems.put("Chum salmon", 36.39);
        availableItems.put("Coho salmon", 19.21);
        availableItems.put("Sockeye salmon", 43.1);
        availableItems.put("Chinook salmon", 19.97);
        availableItems.put("Atlantic salmon", 25.74);
        availableItems.put("Salmonberry", 3.25);
        availableItems.put("Common salsify", 30.84);
        availableItems.put("Sapodilla", 15.34);
        availableItems.put("Mamey sapote", 25.39);
        availableItems.put("Spanish mackerel", 5.28);
        availableItems.put("Pacific sardine", 22.38);
        availableItems.put("Scallop", 20.96);
        availableItems.put("Scup", 38.68);
        availableItems.put("Sea cucumber", 42.12);
        availableItems.put("Steller sea lion", 17.42);
        availableItems.put("Bearded seal", 10.19);
        availableItems.put("Ringed seal", 43.67);
        availableItems.put("Seatrout", 27.51);
        availableItems.put("Sesbania flower", 38.96);
        availableItems.put("American shad", 17.48);
        availableItems.put("Shark", 32.1);
        availableItems.put("Sheefish", 40.45);
        availableItems.put("Sheep (Mutton, Lamb)", 31.31);
        availableItems.put("Sheepshead", 23.79);
        availableItems.put("Hedge mustard", 20.47);
        availableItems.put("Skipjack tuna", 43.7);
        availableItems.put("Snapper", 6.02);
        availableItems.put("Soursop", 41.36);
        availableItems.put("Spelt", 30.23);
        availableItems.put("Spirulina", 41.56);
        availableItems.put("Squab", 22.29);
        availableItems.put("Squirrel", 12.44);
        availableItems.put("Strawberry guava", 4.4);
        availableItems.put("Greater sturgeon", 22.7);
        availableItems.put("White sucker", 4.09);
        availableItems.put("Sugar apple", 10.11);
        availableItems.put("Pumpkinseed sunfish", 36.21);
        availableItems.put("Swordfish", 43.49);
        availableItems.put("Taro", 2.51);
        availableItems.put("Teff", 16.81);
        availableItems.put("Tilefish", 44.31);
        availableItems.put("Mexican groundcherry", 13.0);
        availableItems.put("Towel gourd", 9.71);
        availableItems.put("Salmonidae (Salmon, Trout)", 38.07);
        availableItems.put("Turkey", 8.76);
        availableItems.put("Cattle (Beef, Veal)", 1.33);
        availableItems.put("Walleye", 28.45);
        availableItems.put("Alaska pollock", 22.12);
        availableItems.put("Wasabi", 18.05);
        availableItems.put("Wax gourd", 2.58);
        availableItems.put("Whelk", 19.23);
        availableItems.put("Coalfish pollock", 10.29);
        availableItems.put("Broad whitefish", 46.45);
        availableItems.put("Whitefish", 47.93);
        availableItems.put("Whiting", 28.24);
        availableItems.put("Wild rice", 11.25);
        availableItems.put("Tea leaf willow", 21.38);
        availableItems.put("Winged bean", 22.27);
        availableItems.put("Yam", 27.16);
        availableItems.put("Jicama", 49.76);
        availableItems.put("Yautia", 4.41);
        availableItems.put("Yellowfin tuna", 36.5);
        availableItems.put("Yellowtail amberjack", 33.85);
        availableItems.put("Pollock", 13.52);
        availableItems.put("Albacore tuna", 37.29);
        availableItems.put("Gadus (Common cod)", 25.78);
        availableItems.put("Atlantic halibut", 3.91);
        availableItems.put("Pacific halibut", 7.15);
        availableItems.put("Pacific salmon", 27.53);
        availableItems.put("Smelt", 11.73);
        availableItems.put("Clupeinae (Herring, Sardine, Sprat)", 27.63);
        availableItems.put("Spiny lobster", 13.62);
        availableItems.put("Snow crab", 10.3);
        availableItems.put("Black-eyed pea", 25.85);
        availableItems.put("Deer", 38.97);
        availableItems.put("Macadamia nut", 21.19);
        availableItems.put("Percoidei", 18.26);
        availableItems.put("Perciformes", 27.77);
        availableItems.put("Arctic ground squirrel", 47.95);
        availableItems.put("Rabbit", 33.82);
        availableItems.put("Domestic goat", 41.13);
        availableItems.put("Beefalo", 40.06);
        availableItems.put("Antelope", 13.43);
        availableItems.put("Bivalvia ", 41.58);
        availableItems.put("Squid", 48.85);
        availableItems.put("Shrimp", 8.37);
        availableItems.put("Crayfish", 49.11);
        availableItems.put("Flatfish", 26.16);
        availableItems.put("Domestic pig (Piglet, Pork)", 8.74);
        availableItems.put("Walrus", 12.49);
        availableItems.put("Alaska wild rhubarb", 26.06);
        availableItems.put("Oriental wheat", 4.13);
        availableItems.put("Yardlong bean", 13.99);
        availableItems.put("Great horned owl", 11.04);
        availableItems.put("Quail", 15.51);
        availableItems.put("Boysenberry", 13.52);
        availableItems.put("Persian lime", 36.66);
        availableItems.put("Feijoa", 5.86);
        availableItems.put("Rowal", 4.96);
        availableItems.put("Jew's ear", 10.55);
        availableItems.put("Common mushroom", 20.45);
        availableItems.put("Shiitake", 38.78);
        availableItems.put("Purple laver", 29.41);
        availableItems.put("Wakame", 8.41);
        availableItems.put("Enokitake", 27.76);
        availableItems.put("Epazote", 2.78);
        availableItems.put("Oyster mushroom", 33.2);
        availableItems.put("Cloud ear fungus", 14.58);
        availableItems.put("Maitake", 13.53);
        availableItems.put("Ostrich fern", 26.35);
        availableItems.put("Spot croaker", 20.2);
        availableItems.put("Sourdock", 35.58);
        availableItems.put("Tinda", 38.25);
        availableItems.put("Atlantic menhaden", 16.07);
        availableItems.put("Wheat", 24.95);
        availableItems.put("Common chokecherry", 39.02);
        availableItems.put("Agave", 30.21);
        availableItems.put("Narrowleaf cattail", 33.99);
        availableItems.put("Jellyfish", 12.66);
        availableItems.put("Anchovy", 23.69);
        availableItems.put("Blue whiting", 17.7);
        availableItems.put("Carp bream", 31.37);
        availableItems.put("Chanterelle", 7.91);
        availableItems.put("Sturgeon", 11.89);
        availableItems.put("Charr", 24.67);
        availableItems.put("Cinnamon", 10.52);
        availableItems.put("Crab", 12.08);
        availableItems.put("Common dab", 28.34);
        availableItems.put("Spiny dogfish", 29.09);
        availableItems.put("Anatidae (Duck, Goose, Swan)", 49.67);
        availableItems.put("Anguilliformes (Eel)", 1.33);
        availableItems.put("True frog", 34.79);
        availableItems.put("Garfish", 43.06);
        availableItems.put("Gadiformes (Cod, Hake)", 49.23);
        availableItems.put("Mountain hare", 1.83);
        availableItems.put("Lake trout", 37.12);
        availableItems.put("Lemon sole", 12.23);
        availableItems.put("Clawed lobster", 28.96);
        availableItems.put("Lumpsucker", 1.78);
        availableItems.put("Scombridae (Bonito, Mackerel, Tuna)", 6.14);
        availableItems.put("Marine mussel", 41.51);
        availableItems.put("Norway haddock", 43.3);
        availableItems.put("Norway lobster", 42.56);
        availableItems.put("Norway pout", 19.13);
        availableItems.put("Oil palm", 10.89);
        availableItems.put("True oyster", 32.01);
        availableItems.put("Sago palm", 16.44);
        availableItems.put("Persimmon", 42.66);
        availableItems.put("Pikeperch", 14.31);
        availableItems.put("Pleuronectidae (Dab, Halibut, Plaice)", 36.0);
        availableItems.put("Rock ptarmigan", 9.05);
        availableItems.put("Pacific ocean perch", 30.85);
        availableItems.put("Black salsify", 18.24);
        availableItems.put("True seal", 17.85);
        availableItems.put("Red algae", 12.7);
        availableItems.put("Kombu", 27.31);
        availableItems.put("Snail", 25.2);
        availableItems.put("True sole", 18.0);
        availableItems.put("Catfish", 35.26);
        availableItems.put("Thistle", 35.23);
        availableItems.put("Thunnus (Common tuna)", 41.73);
        availableItems.put("Walnut", 20.76);
        availableItems.put("Cetacea (Dolphin, Porpoise, Whale)", 31.48);
        availableItems.put("Columbidae (Dove, Pigeon)", 29.52);
        availableItems.put("Conch", 10.72);
        availableItems.put("Apple cider", 45.5);
        availableItems.put("Liquor", 4.59);
        availableItems.put("Cheese", 11.5);
        availableItems.put("Milk (Cow)", 26.1);
        availableItems.put("Eggs", 8.76);
        availableItems.put("Yogurt", 35.37);
        availableItems.put("Bean", 41.25);
        availableItems.put("Vodka", 8.31);
        availableItems.put("Whisky", 5.54);
        availableItems.put("Ice cream", 34.16);
        availableItems.put("Gin", 11.78);
        availableItems.put("Honey", 40.41);
        availableItems.put("Liquorice", 26.77);
        availableItems.put("Vinegar", 18.46);
        availableItems.put("Rum", 18.47);
        availableItems.put("Port wine", 13.05);
        availableItems.put("Vermouth", 15.31);
        availableItems.put("Sherry", 12.69);
        availableItems.put("Madeira wine", 20.93);
        availableItems.put("Nougat", 13.04);
        availableItems.put("Toffee", 32.9);
        availableItems.put("Cake", 2.91);
        availableItems.put("Pizza", 5.72);
        availableItems.put("Ymer", 10.66);
        availableItems.put("Crisp bread", 11.51);
        availableItems.put("Pastry", 10.07);
        availableItems.put("DragÔøΩÔøΩe", 47.97);
        availableItems.put("Chewing gum", 3.77);
        availableItems.put("Marzipan", 7.7);
        availableItems.put("Salad dressing", 46.03);
        availableItems.put("Sauce", 0.49);
        availableItems.put("Salt", 0.66);
        availableItems.put("Butter", 23.53);
        availableItems.put("Butter substitute", 23.8);
        availableItems.put("Cream", 23.74);
        availableItems.put("Sugar", 8.52);
        availableItems.put("Sausage", 20.51);
        availableItems.put("Meatball", 44.75);
        availableItems.put("Mustard", 41.35);
        availableItems.put("Pate", 32.4);
        availableItems.put("Sugar substitute", 36.78);
        availableItems.put("Meat bouillon", 15.19);
        availableItems.put("Whey", 36.47);
        availableItems.put("Casein", 46.33);
        availableItems.put("Fruit preserve", 9.25);
        availableItems.put("Leavening agent", 36.46);
        availableItems.put("Marshmallow", 19.51);
        availableItems.put("Gelatin", 0.97);
        availableItems.put("Water", 17.89);
        availableItems.put("Baby food", 44.5);
        availableItems.put("Dumpling", 5.91);
        availableItems.put("Soup", 6.25);
        availableItems.put("Syrup", 31.3);
        availableItems.put("Tallow", 39.83);
        availableItems.put("Remoulade", 14.06);
        availableItems.put("Chocolate spread", 13.06);
        availableItems.put("Fruit gum", 35.43);
        availableItems.put("Curry powder", 22.82);
        availableItems.put("Meringue", 23.86);
        availableItems.put("Lard", 25.25);
        availableItems.put("Cocoa butter", 3.35);
        availableItems.put("Cocoa powder", 31.63);
        availableItems.put("Cocoa liquor", 4.85);
        availableItems.put("Chocolate", 43.54);
        availableItems.put("Hot chocolate", 13.16);
        availableItems.put("Dried milk", 46.24);
        availableItems.put("Kefir", 20.92);
        availableItems.put("Buttermilk", 1.41);
        availableItems.put("Soy sauce", 29.19);
        availableItems.put("Miso", 10.32);
        availableItems.put("Tofu", 45.87);
        availableItems.put("Zwieback", 33.98);
        availableItems.put("Roe", 35.08);
        availableItems.put("Cichlidae (Tilapia)", 38.88);
        availableItems.put("Icing", 9.13);
        availableItems.put("Snack bar", 39.77);
        availableItems.put("Green turtle", 0.94);
        availableItems.put("Energy drink", 5.68);
        availableItems.put("Burrito", 20.36);
        availableItems.put("Hamburger", 29.84);
        availableItems.put("Baked beans", 44.7);
        availableItems.put("Chili", 46.33);
        availableItems.put("Taco", 3.57);
        availableItems.put("Tortilla", 46.54);
        availableItems.put("Nachos", 1.13);
        availableItems.put("Processed cheese", 3.47);
        availableItems.put("Salad", 6.43);
        availableItems.put("Cream substitute", 49.72);
        availableItems.put("Dulce de leche", 4.0);
        availableItems.put("Topping", 3.04);
        availableItems.put("Sweet custard", 24.15);
        availableItems.put("Egg roll", 49.43);
        availableItems.put("Heart of palm", 34.8);
        availableItems.put("Popcorn", 47.27);
        availableItems.put("Potato chip", 37.82);
        availableItems.put("Tortilla chip", 28.53);
        availableItems.put("Corn chip", 25.34);
        availableItems.put("Hibiscus tea", 30.74);
        availableItems.put("Stew", 15.73);
        availableItems.put("Gelatin dessert", 45.84);
        availableItems.put("Junket", 0.41);
        availableItems.put("Falafel", 14.11);
        availableItems.put("Frybread", 18.03);
        availableItems.put("Lasagna", 8.99);
        availableItems.put("Morchella (Morel)", 37.33);
        availableItems.put("Pancake", 6.35);
        availableItems.put("Pectin", 33.43);
        availableItems.put("Pudding", 44.82);
        availableItems.put("Waffle", 4.39);
        availableItems.put("Soy milk", 14.53);
        availableItems.put("Meatloaf", 7.69);
        availableItems.put("Sake", 31.76);
        availableItems.put("Cocktail", 3.51);
        availableItems.put("Couscous", 9.47);
        availableItems.put("Bulgur", 22.6);
        availableItems.put("Coffee substitute", 46.76);
        availableItems.put("Coffee mocha", 0.72);
        availableItems.put("Chimichanga", 9.91);
        availableItems.put("Semolina", 35.58);
        availableItems.put("Tapioca pearl", 11.31);
        availableItems.put("Tostada", 9.61);
        availableItems.put("Quesadilla", 34.69);
        availableItems.put("Baked potato", 37.88);
        availableItems.put("Hot dog", 15.36);
        availableItems.put("Spread", 26.83);
        availableItems.put("Enchilada", 48.39);
        availableItems.put("Egg substitute", 9.55);
        availableItems.put("Ketchup", 16.17);
        availableItems.put("Breakfast sandwich", 26.48);
        availableItems.put("Adobo", 38.89);
        availableItems.put("Macaroni and cheese", 44.14);
        availableItems.put("Butterfat", 16.96);
        availableItems.put("Horned melon", 15.31);
        availableItems.put("Hushpuppy", 17.87);
        availableItems.put("Fruit juice", 2.46);
        availableItems.put("Relish", 18.34);
        availableItems.put("Fruit salad", 42.01);
        availableItems.put("Soy yogurt", 7.86);
        availableItems.put("Vegetarian food", 28.07);
        availableItems.put("Veggie burger", 30.14);
        availableItems.put("Cold cut", 19.41);
        availableItems.put("Mixed nuts", 26.39);
        availableItems.put("Canola", 28.59);
        availableItems.put("Babassu palm", 27.82);
        availableItems.put("CupuaÔøΩ_u", 45.35);
        availableItems.put("Shea tree", 12.23);
        availableItems.put("Oil-seed Camellia", 47.89);
        availableItems.put("Ucuhuba", 35.1);
        availableItems.put("Phyllo dough", 20.45);
        availableItems.put("Cooking oil", 24.31);
        availableItems.put("Pie crust", 38.24);
        availableItems.put("Pie filling", 6.52);
        availableItems.put("Pie", 48.58);
        availableItems.put("Shortening", 44.98);
        availableItems.put("Soy cream", 17.34);
        availableItems.put("Ice cream cone", 9.22);
        availableItems.put("Molasses", 12.7);
        availableItems.put("Cracker", 28.62);
        availableItems.put("Nance", 42.93);
        availableItems.put("Naranjilla", 33.53);
        availableItems.put("Natto", 43.38);
        availableItems.put("Ravioli", 28.29);
        availableItems.put("Scrapple", 13.29);
        availableItems.put("Succotash", 8.48);
        availableItems.put("Tamale", 33.15);
        availableItems.put("Rice cake", 42.47);
        availableItems.put("Tree fern", 4.15);
        availableItems.put("Evaporated milk", 5.27);
        availableItems.put("Flour", 6.45);
        availableItems.put("Akutaq", 10.64);
        availableItems.put("Dough", 33.02);
        availableItems.put("Pita bread", 45.4);
        availableItems.put("Focaccia", 3.75);
        availableItems.put("Bagel", 18.19);
        availableItems.put("Piki bread", 3.14);
        availableItems.put("French toast", 33.78);
        availableItems.put("Wheat bread", 46.05);
        availableItems.put("Rye bread", 12.7);
        availableItems.put("Oat bread", 26.17);
        availableItems.put("Potato bread", 21.04);
        availableItems.put("Cornbread", 31.1);
        availableItems.put("Corn grits", 3.28);
        availableItems.put("Multigrain bread", 30.1);
        availableItems.put("Rice bread", 12.46);
        availableItems.put("Pan dulce", 24.79);
        availableItems.put("Raisin bread", 27.76);
        availableItems.put("Wonton wrapper", 24.13);
        availableItems.put("Trail mix", 16.7);
        availableItems.put("Greenthread tea", 48.14);
        availableItems.put("Fruit-flavor drink", 22.4);
        availableItems.put("Vegetable juice", 0.19);
        availableItems.put("Horchata", 9.92);
        availableItems.put("Soft drink", 17.45);
        availableItems.put("Frozen yogurt", 38.98);
        availableItems.put("Milkshake", 11.85);
        availableItems.put("Chocolate mousse", 39.83);
        availableItems.put("Dripping", 26.98);
        availableItems.put("Pupusa", 37.82);
        availableItems.put("Empanada", 38.66);
        availableItems.put("Arepa", 37.49);
        availableItems.put("Ascidians", 22.4);
        availableItems.put("Gefilte fish", 47.32);
        availableItems.put("Yellow pond-lily", 3.16);
        availableItems.put("Fish burger", 4.22);
        availableItems.put("Pot pie", 32.24);
        availableItems.put("Stuffing", 21.9);
        availableItems.put("Edible shell", 31.84);
        availableItems.put("Fudge", 15.76);
        availableItems.put("Candy bar", 46.61);
        availableItems.put("Condensed milk", 34.85);
        availableItems.put("Margarine", 20.6);
        availableItems.put("Margarine-like spread", 40.63);
        availableItems.put("Hummus", 32.08);
        availableItems.put("Potato puffs", 26.55);
        availableItems.put("Potato gratin", 29.26);
        availableItems.put("Milk substitute", 48.05);
        availableItems.put("Pepper", 33.8);
        availableItems.put("Soft-necked garlic", 31.38);
        availableItems.put("Cabbage", 26.81);
        availableItems.put("Chinese bayberry", 17.43);
        availableItems.put("Mushrooms", 9.3);
        availableItems.put("Alcoholic beverages", 9.64);
        availableItems.put("Onion-family vegetables", 0.17);
        availableItems.put("Pomes", 16.73);
        availableItems.put("Brassicas", 45.0);
        availableItems.put("Cereals and cereal products", 1.84);
        availableItems.put("Citrus", 30.33);
        availableItems.put("Cocoa and cocoa products", 39.94);
        availableItems.put("Coffee and coffee products", 49.56);
        availableItems.put("Crustaceans", 2.6);
        availableItems.put("Milk and milk products", 25.88);
        availableItems.put("Fats and oils", 4.53);
        availableItems.put("Fishes", 30.98);
        availableItems.put("Herbs and Spices", 12.22);
        availableItems.put("Pulses", 20.05);
        availableItems.put("Animal foods", 45.18);
        availableItems.put("Mollusks", 33.3);
        availableItems.put("Nuts", 9.23);
        availableItems.put("Beverages", 17.07);
        availableItems.put("Fruits", 3.86);
        availableItems.put("Green vegetables", 36.55);
        availableItems.put("Root vegetables", 47.27);
        availableItems.put("Sunburst squash (pattypan squash)", 15.11);
        availableItems.put("Green zucchini", 43.48);
        availableItems.put("Yellow zucchini", 29.17);
        availableItems.put("Green bell pepper", 11.17);
        availableItems.put("Yellow bell pepper", 20.18);
        availableItems.put("Orange bell pepper", 17.1);
        availableItems.put("Red bell pepper", 38.99);
        availableItems.put("Italian sweet red pepper", 33.27);
        availableItems.put("Yellow wax bean", 28.95);
        availableItems.put("Green bean", 41.82);
        availableItems.put("Saskatoon berry", 47.54);
        availableItems.put("Nanking cherry", 0.71);
        availableItems.put("Japanese pumpkin", 13.83);
        availableItems.put("White cabbage", 41.35);
        availableItems.put("Romaine lettuce", 33.17);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 0% fat", 44.01);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 1% fat", 34.72);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 2% fat", 47.24);
        availableItems.put("Cow milk, pasteurized, vitamin D added, 3.25% fat", 31.22);

        return availableItems;
    };
}
