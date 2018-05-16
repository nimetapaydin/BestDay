package com.example.sam.bestday.data;

import android.provider.BaseColumns;

public class BestDayContract {

    //Entry dediğimiz tablo adımız

    public static final class NotlarEntry implements BaseColumns{

        public static final String TABLE_NAME = "notlar";

        public static final String ID = BaseColumns._ID;

        public static final String COLUMN_NOT_ICERIK = "notIcerik";
        public static final String COLUMN_OLUSTURULMA_TARIHI= "olusturulmaTarihi";
        public static final String COLUMN_BITIS_TARIHI= "bitisTarihi";
        public static final String COLUMN_YAPILDI= "yapildi";
        public static final String COLUMN_KATEGORI_ID= "kategoriID";


    }
    public static final class KategoriEntry implements BaseColumns {

        public static final String TABLE_NAME = "kategoriler";

        public static final String ID = BaseColumns._ID;

        public static final String COLUMN_KATEGORI = "kategori";

    }

}
