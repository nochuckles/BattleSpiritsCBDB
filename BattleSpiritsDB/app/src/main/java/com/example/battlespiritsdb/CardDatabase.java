package com.example.battlespiritsdb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Card.class, version = 1)
public abstract class CardDatabase extends RoomDatabase {

    private static CardDatabase instance;
    public abstract CardDao cardDao();

    public static synchronized CardDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CardDatabase.class, "cards_table")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulatedDbAsyncTask(instance).execute();
        }
    };

    private static class PopulatedDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CardDao cardDao;

        private PopulatedDbAsyncTask(CardDatabase db) {
            cardDao = db.cardDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cardDao.insert(new Card(R.drawable.img1, "CB02-001", "Agumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img2, "CB02-001", "Agumon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img3, "CB02-002", "Biyomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img4, "CB02-003", "Birdramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img5, "CB02-004", "Greymon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img6, "CB02-005", "Meramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img7, "CB02-006", "Leomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img8, "CB02-007", "Parrotmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img9, "CB02-008", "Skullgreymon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img10,"CB02-008", "Skullgreymon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img11,"CB02-009", "Metalgreymon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img12,"CB02-009", "Metalgreymon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img13,"CB02-010", "Pico Devimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img14,"CB02-011", "Gabumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img15,"CB02-011", "Gabumon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img16,"CB02-012", "Garurumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img17,"CB02-013", "Orgemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img18,"CB02-014", "Devimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img19,"CB02-015", "Pumpmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img20,"CB02-016", "Ladydevimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img21,"CB02-017", "Weregarurumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img22,"CB02-017", "Weregarurumon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img23,"CB02-018", "Vamdemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img24,"CB02-019", "Venomvamdemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img25,"CB02-020", "Tentomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img26,"CB02-021", "Palmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img27,"CB02-022", "Woodmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img28,"CB02-023", "Togemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img29,"CB02-024", "Kabuterimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img30,"CB02-025", "Jyureimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img31,"CB02-026", "Pinochimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img32,"CB02-027", "Gottsumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img33,"CB02-028", "Hagurumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img34,"CB02-029", "Tankmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img35,"CB02-030", "Mechanorimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img36,"CB02-031", "Vademon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img37,"CB02-031", "Vademon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img38,"CB02-032", "Megadramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img39,"CB02-032", "Megadramon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img40,"CB02-033", "Andromon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img41,"CB02-033", "Andromon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img42,"CB02-034", "Monzaemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img43,"CB02-034", "Monzaemon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img44,"CB02-035", "Mugendramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img45,"CB02-036", "Metaletemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img46,"CB02-037", "Patamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img47,"CB02-038", "Plotmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img48,"CB02-039", "Tailmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img49,"CB02-040", "Unimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img50,"CB02-041", "Angemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img51,"CB02-042", "Wizarmon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img52,"CB02-043", "Piemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img53,"CB02-044", "Otamamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img54,"CB02-045", "Gomamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img55,"CB02-046", "Gekomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img56,"CB02-047", "Ikkakumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img57,"CB02-048", "Seadramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img58,"CB02-049", "Whamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img59,"CB02-050", "Megaseadramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img60,"CB02-051", "Tonosamagekomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img61,"CB02-052", "Metalseadramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img62,"CB02-053", "Keramon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img63,"CB02-054", "Scumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img64,"CB02-055", "Numemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img65,"CB02-056", "Chrysalimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img66,"CB02-057", "Infermon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img67,"CB02-058", "Etemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img68,"CB02-058", "Etemon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img69,"CB02-059", "Apocalymon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img70,"CB02-060", "Diablomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img71,"CB02-060", "Diablomon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img72,"CB02-061", "Digitama", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img73,"CB02-062", "File Island", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img74,"CB02-063", "Digivice", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img75,"CB02-064", "Infinity Mountain", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img76,"CB02-065", "Spiral Mountain", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img77,"CB02-066", "Gaia Force", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img78,"CB02-067", "Night Raid", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img79,"CB02-068", "Shadow Wing", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img80,"CB02-069", "Grey Sword", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img81,"CB02-070", "Heaven's Knuckle", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img82,"CB02-071", "Ultimate Storm", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img83,"CB02-X01", "Wargreymon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img84,"CB02-X01", "Wargreymon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img85,"CB02-X02", "Garudamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img86,"CB02-X02", "Garudamon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img87,"CB02-X03", "Metalgarurumon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img88,"CB02-X03", "Metalgarurumon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img89,"CB02-X04", "Atlurkabuterimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img90,"CB02-X04", "Atlurkabuterimon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img91,"CB02-X05", "Lilimon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img92,"CB02-X05", "Lilimon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img93,"CB02-X06", "Angewomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img94,"CB02-X06", "Angewomon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img95,"CB02-X07", "Holyangemon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img96,"CB02-X07", "Holyangemon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img97,"CB02-X08", "Zudomon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img98,"CB02-X08", "Zudomon AA", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img99,"CB02-XX01", "Omegamon", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "XX RARE"));
            cardDao.insert(new Card(R.drawable.img100,"CB02/SD06-013", "Burst Draw", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img101,"CB02/BS18-075", "Mark-of-Zorro", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img102,"CB02/BS28-077", "Binding Root", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img103,"CB02/SD01-039", "Blizzard Wall", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img104,"CB02/SD23-013", "Symphonic Burst", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img105,"CB02/BS31-112", "Manta Draw", "Collaboration Booster (Digimon Super-Digivolution!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img106,"CPP17-12", "Ofanimon FM", "Collaboration Booster (Digimon Super-Digivolution! Ver. 1.5)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img107,"P17-12", "Ofanimon FM", "Promos", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img108,"CPP17-13", "Raguelmon", "Collaboration Booster (Digimon Super-Digivolution! Ver. 1.5)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img109,"P17-13", "Raguelmon", "Promos", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img110,"P18-03", "Ordinemon", "Promos", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img111,"P18-04", "Meicoomon", "Promos", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img112,"CB03-CP01", "Zubamon", "Collaboration Booster (Digimon Super-Digivolution! Ver. 1.5)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img113,"SD45-001", "Agumon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img114,"SD45-002", "Greymon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img115,"SD45-003", "Metalgreymon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img116,"SD45-004", "Leomon (2)", "Collaboration Starter (The Chosen Children)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img117,"SD45-005", "Wargeymon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img118,"SD45-006", "Omegamon (2)", "Collaboration Starter (The Chosen Children)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img119,"SD45-007", "Gabumon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img120,"SD45-008", "Garurumon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img121,"SD45-009", "Weregarurumon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img122,"SD45-010", "Metalgarurumon (2)", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img123,"SD45-011", "Crest of Courage", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img124,"SD45-012", "Crest of Friendship", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img125,"SD45-013", "Evolution Draw", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img126,"SD45-014", "Evolution Shoot", "Collaboration Starter (The Chosen Children)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img127,"SD45-X01", "Omegamon MM", "Collaboration Starter (The Chosen Children)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img128,"SD06-016", "Burst Wall", "Collaboration Starter (The Chosen Children)", 0, "UNCOMMON"));
            cardDao.insert(new Card(R.drawable.img129,"SD45-CP01", "Hououmon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img130,"SD45-CP02", "Heraklekabuterimon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img131,"SD45-CP03", "Rosemon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img132,"SD45-CP04", "Seraphimon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img133,"SD45-CP05", "Holydramon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img134,"SD45-CP06", "Vikemon", "Collaboration Starter (The Chosen Children)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img135,"BSBGSD/SD33-014", "Dyna Burst", "Battle Spirits Battler's Goods Set: Digimon", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img136,"BSBGSD/SD06-016", "Burst Wall", "Battle Spirits Battler's Goods Set: Digimon", 0, "UNCOMMON"));
            cardDao.insert(new Card(R.drawable.img137,"BSBGSD/BS33-079", "Diamond Wall", "Battle Spirits Battler's Goods Set: Digimon", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img138,"CB05-001", "Hawkmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img139,"CB05-002", "Bearmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img140,"CB05-003", "Aquilamon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img141,"CB05-004", "Tyranomon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img142,"CB05-005", "Holsmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img143,"CB05-006", "Fladramon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img144,"CB05-007", "Saberleomon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img145,"CB05-008", "Triceramon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img146,"CB05-009", "Silphymon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img147,"CB05-010", "Gazimon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img148,"CB05-011", "Bakumon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img149,"CB05-012", "Bakemon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img150,"CB05-013", "Evilmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img151,"CB05-014", "Skullsatamon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img152,"CB05-015", "Mummymon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img153,"CB05-016", "Demon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img154,"CB05-017", "Belialvamdemon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img155,"CB05-018", "Deathmeramon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img156,"CB05-019", "Floramon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img157,"CB05-020", "Wormmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img158,"CB05-021", "Kuwagamon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img159,"CB05-022", "Piccolomon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img160,"CB05-023", "Dokugumon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img161,"CB05-024", "Stingmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img162,"CB05-025", "Shurimon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img163,"CB05-026", "Lighdramon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img164,"CB05-027", "Archnemon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img165,"CB05-028", "Betamon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img166,"CB05-029", "Hackmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img167,"CB05-030", "Revolmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img168,"CB05-031", "Golemon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img169,"CB05-032", "Thunderballmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img170,"CB05-033", "Nanomon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img171,"CB05-034", "Knightmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img172,"CB05-035", "Elecmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img173,"CB05-036", "Armadimon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img174,"CB05-037", "Ankylomon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img175,"CB05-038", "Centalmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img176,"CB05-039", "Digmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img177,"CB05-040", "Nefertimon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img178,"CB05-041", "Pegasmon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img179,"CB05-042", "Hippogriffomon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img180,"CB05-043", "Qinglongmon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img181,"CB05-044", "Shakkoumon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img182,"CB05-045", "Gizamon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img183,"CB05-046", "V-mon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img184,"CB05-047", "XV-mon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img185,"CB05-048", "Shellmon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img186,"CB05-049", "Submarimon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img187,"CB05-050", "Dagomon", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img188,"CB05-051", "Orochimon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img189,"CB05-052", "Imperialdramon DM", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img190,"CB05-053", "Kuramon", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img191,"CB05-054", "Armagemon", "Collaboration Booster (Our Digimon Adventure!", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img192,"CB05-055", "Dark Tower", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img193,"CB05-056", "D-3", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img194,"CB05-057", "Omega Blade ", "Collaboration Booster (Our Digimon Adventure!", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img195,"CB05-058", "Sanctuary Bind", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img196,"CB05-059", "Ultimate Flare", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img197,"CB05-X01", "Blackwargreymon", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img198,"CB05-X01", "Blackwargreymon AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img199,"CB05-X02", "Jesmon", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img200,"CB05-X02", "Jesmon AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img201,"CB05-X03", "Magnamon", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img202,"CB05-X03", "Magnamon AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img203,"CB05-X04", "Paildramon", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img204,"CB05-X04", "Paildramon AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img205,"CB05-X05", "Imperialdramon FM", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img206,"CB05-X05", "Imperialdramon FM AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img207,"CB05-X06", "Alphamon", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img208,"CB05-X06", "Alphamon AA", "Collaboration Booster (Our Digimon Adventure!", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img209,"CB05-XX01", "Imperialdramon PM", "Collaboration Booster (Our Digimon Adventure!", 0, "XX RARE"));
            cardDao.insert(new Card(R.drawable.img210,"CB05/BS28-079", "Shut out", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img211,"CB05/BS33-CP03", "Double Blaster", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img212,"CB05/SD02-017", "Strong Draw", "Collaboration Booster (Our Digimon Adventure!", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img213,"CB07-001", "Guilmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img214,"CB07-002", "Leomon (Tamers)", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img215,"CB07-003", "Darktyranomon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img216,"CB07-004", "Growmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img217,"CB07-005", "Mihiramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img218,"CB07-006", "Indaramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img219,"CB07-007", "Megalogrowmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img220,"CB07-008", "Zhuqiaomon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img221,"CB07-009", "Megidramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img222,"CB07-010", "Impmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img223,"CB07-011", "Goburimon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img224,"CB07-012", "Icedevimon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img225,"CB07-013", "Devidramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img226,"CB07-014", "Dobermon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img227,"CB07-015", "Sandiramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img228,"CB07-016", "Mephismon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img229,"CB07-017", "Majiramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img230,"CB07-018", "Gulfmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img231,"CB07-019", "Sinduramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img232,"CB07-020", "Xuanwumon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img233,"CB07-021", "Terriermon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img234,"CB07-022", "Guardromon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img235,"CB07-023", "Galgomon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img236,"CB07-024", "Pajiramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img237,"CB07-025", "Maildramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img238,"CB07-026", "Vajramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img239,"CB07-027", "Rapidmon (Tamers)", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img240,"CB07-028", "Baihumon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img241,"CB07-029", "Monodramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img242,"CB07-030", "Cyberdramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img243,"CB07-031", "Kumbhiramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img244,"CB07-032", "Renamon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img245,"CB07-033", "Lopmon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img246,"CB07-034", "Makuramon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img247,"CB07-035", "Kyubimon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img248,"CB07-036", "Wendimon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img249,"CB07-037", "Taomon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img250,"CB07-038", "Cherubimon (Vice)", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img251,"CB07-038", "Cherubimon (Vice) AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img252,"CB07-039", "Andiramon (Deva)", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img253,"CB07-040", "Caturamon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img254,"CB07-041", "Vikaralamon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img255,"CB07-042", "Marinangemon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img256,"CB07-043", "D-Reaper ADR-02: Searcher", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img257,"CB07-044", "D-Reaper ADR-01: Juri", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img258,"CB07-045", "D-Reaper ADR-07: Palates Head", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img259,"CB07-046", "Reaper", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "MASTER RARE"));
            cardDao.insert(new Card(R.drawable.img260,"CB07-047", "Mother D-Reaper", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img261,"CB07-048", "Culumon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img262,"CB07-049", "DigiGnome", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img263,"CB07-050", "Grani", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img264,"CB07-051", "Behemoth", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img265,"CB07-052", "White Wings", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img266,"CB07-053", "Hypnos", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img267,"CB07-054", "Digital Monster Card Game", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img268,"CB07-055", "Shaggai", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img269,"CB07-056", "D-Ark", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img270,"CB07-057", "Red Card", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img271,"CB07-058", "Final Elysion", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img272,"CB07-059", "Darkness Claw", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img273,"CB07-060", "Petit Twister", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img274,"CB07-061", "Koyosetsu", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "COMMON"));
            cardDao.insert(new Card(R.drawable.img275,"CB07-062", "Blue Card", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "RARE"));
            cardDao.insert(new Card(R.drawable.img276,"CB07-X01", "Dukemon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img277,"CB07-X01", "Dukemon AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img278,"CB07-X02", "Beelzebumon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img279,"CB07-X02", "Beelzebumon AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img280,"CB07-X03", "Beelzebumon BM", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img281,"CB07-X04", "Saintgalgomon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img282,"CB07-X04", "Saintgalgomon AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img283,"CB07-X05", "Justimon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img284,"CB07-X05", "Justimon AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img285,"CB07-X06", "Sakuyamon", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "X RARE"));
            cardDao.insert(new Card(R.drawable.img286,"CB07-X06", "Sakuyamon AA", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "SECRET"));
            cardDao.insert(new Card(R.drawable.img287,"CB07-XX01", "Dukemon CM", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "XX RARE"));
            cardDao.insert(new Card(R.drawable.img288,"CB07-CP01", "Matsuda Takato", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img289,"CB07-CP02", "Lee Jianliang", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "NONE"));
            cardDao.insert(new Card(R.drawable.img290,"CB07-CP03", "Makino Ruki", "Collaboration Booster (Digimon - Settle it! Card Slash!)", 0, "NONE"));


            return null;
        }
    }

}
