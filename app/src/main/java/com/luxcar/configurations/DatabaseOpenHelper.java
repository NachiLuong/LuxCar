package com.luxcar.configurations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.luxcar.constants.DATABASE;

import java.util.ResourceBundle;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = DATABASE.VERSION;
    private static final String DATABASE_NAME = DATABASE.NAME;
    private final ResourceBundle resourceBundleSchema = ResourceBundle.getBundle("schema");
    private final ResourceBundle resourceBundleData = ResourceBundle.getBundle("data");

    public DatabaseOpenHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_BRAND));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_CAR));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_USER));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_BILL));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_WAREHOUSE));
        insertData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_WAREHOUSE));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_BILL));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_BRAND));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_CAR));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_USER));

        this.onCreate(sqLiteDatabase);
    }

    /* //Truy vấn không trả kêt quả
     public void QueryData(String sql){
         SQLiteDatabase database  = getWritableDatabase();
         database.execSQL(sql);
     }
     //Truy vấn trả kết quả
     public Cursor GetData(String sql){
         SQLiteDatabase database = getReadableDatabase();
         return database.rawQuery(sql, null);
     }*/
    private void insertData(SQLiteDatabase sqLiteDatabase) {

        /** INSERT BRAND */
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Volkswagen', 'The company develops vehicles and engines, and produces and sells passenger cars, trucks, buses and motorcycles, light commercial vehicles, genuine parts, turbomachinery, large-bore diesel engines, propulsion components, special gear units and testing systems.', 'brand/image/Volkswagen.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Mercedes-Benz', 'Mercedes-Benz produces consumer luxury vehicles and commercial vehicles. Its first Mercedes-Benz-badged vehicles were produced in 1926. In 2018, Mercedes-Benz was the largest seller of premium vehicles in the world, having sold 2.31 million passenger cars.', 'brand/image/Mercedes.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Mitsubishi', 'Mitsubishi Corporation (MC) is a global integrated business enterprise that develops and operates businesses together with its offices and subsidiaries in approximately 90 countries and regions worldwide, as well as a global network of around 1,700 group companies.', 'brand/image/Mitsubishi.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Ford', 'Ford Motor Company is an American multinational automobile manufacturer headquartered in Dearborn, Michigan, United States. It was founded by Henry Ford and incorporated on June 16, 1903. The company sells automobiles and commercial vehicles under the Ford brand, and luxury cars under its Lincoln luxury brand.', 'brand/image/Ford.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Subaru', 'Subaru is a global transportation manufacturer with two main businesses: automobiles and aircraft. Subaru started out as Nakajima Aircraft Company, founded in 1917, just 14 years after the Wright brothers succeeded in the first powered flight in 1903.', 'brand/image/Subaru.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Maserati', 'Maserati is one of the worlds most glamorous automotive manufacturers, rich in tradition and sporting successes. It was founded on December 1st, 1914 in Bologna, Italy by Alfieri Maserati, together with his brothers Ettore and Ernesto, as a car engineering workshop called \"Officine Alfieri Maserati\".', 'brand/image/Maserati.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Chevrolet', 'Chevrolet (/ˌʃɛvrəˈleɪ/ SHEV-rə-LAY), colloquially referred to as Chevy and formally the Chevrolet Motor Division of General Motors Company, is an American automobile division of the American manufacturer General Motors (GM). Louis Chevrolet and ousted General Motors founder William C.', 'brand/image/Chevrolet.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('Dodge', 'Dodge, Inc. operates as a car dealer. The Company provides new and used cars, sports utility vehicles, rams, trucks, and parts and accessories, as well as financing and maintenance services. Dodge serves customers worldwide.', 'brand/image/Dodge.png');");
        sqLiteDatabase.execSQL("insert into brand (name, description, logo) values ('BMW', 'The acronym BMW stands for Bayerische Motoren Werke GmbH, which roughly translates to the Bavarian Engine Works Company. The name harks back to the companys origin in the German state of Bavaria. It also indicates BMWs original product range: engines for various applications.', 'brand/image/BMW.png');");

        /** INSERT CAR */
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Sebring', 'Brazil', 93558, '2021-03-24 16:48:05.591', 'car/image/Sebring.jpg', 33, 72, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Grand Prix', 'Ireland', 22509, '17/03/2022', 'car/image/Grand.jpg', 80, 59, 2);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('S6', 'Greece', 40202, '14/02/2022', 'car/image/S6.jpg', 34, 106, 3);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('G', 'Thailand', 83924, '16/02/2022', 'car/image/G.jpg', 29, 144, 2);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Avenger', 'Portugal', 36371, '28/09/2021', 'car/image/Avenger.jpg', 98, 44, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('S-Class', 'China', 79700, '19/09/2021', 'car/image/S.jpg', 86, 149, 3);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('GranTurismo', 'China', 20540, '08/11/2021', 'car/image/GranTurismo.jpg', 41, 62, 2);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('240SX', 'Philippines', 29194, '11/04/2022', 'car/image/240SX.jpg', 18, 49, 4);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('MX-5', 'Russia', 40364, '05/01/2022', 'car/image/MX.jpg', 17, 139, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Range Rover Sport', 'Ireland', 94511, '13/04/2021', 'car/image/Range.jpg', 1, 40, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Ram 1500', 'Mongolia', 89947, '12/07/2021', 'car/image/Ram.jpg', 84, 81, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('SL-Class', 'Sweden', 67287, '19/09/2021', 'car/image/SL.jpg', 75, 142, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Blazer', 'Indonesia', 79359, '02/10/2021', 'car/image/Blazer.jpg', 54, 103, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Silverado 2500', 'Indonesia', 77227, '05/11/2021', 'car/image/Silverado.jpg', 94, 165, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Mustang', 'United States', 83839, '10/03/2022', 'car/image/Mustang.jpg', 1, 141, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('SC', 'Philippines', 91012, '26/02/2022', 'car/image/SC.jpg', 80, 145, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Mustang', 'Vietnam', 76797, '16/02/2022', 'car/image/Mustang.jpg', 71, 57, 4);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('88', 'Benin', 62854, '24/03/2022', 'car/image/88.jpg', 27, 73, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('RX-8', 'Poland', 42388, '21/09/2021', 'car/image/RX.jpg', 29, 27, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('S-Class', 'Senegal', 32910, '08/08/2021', 'car/image/S.jpg', 71, 25, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Genesis', 'Sweden', 53256, '20/12/2021', 'car/image/Genesis.jpg', 31, 80, 3);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Quest', 'Sweden', 89350, '23/12/2021', 'car/image/Quest.jpg', 77, 164, 4);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Trans Sport', 'Pakistan', 42145, '07/07/2021', 'car/image/Trans.jpg', 21, 39, 2);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('M-Class', 'Philippines', 92533, '05/04/2021', 'car/image/M.jpg', 18, 83, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Passport', 'Indonesia', 54967, '24/03/2022', 'car/image/Passport.jpg', 99, 84, 4)");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Elan', 'Indonesia', 20192, '24/01/2022', 'car/image/Elan.jpg', 98, 24, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('NSX', 'China', 23972, '28/08/2021', 'car/image/NSX.jpg', 77, 163, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Express 2500', 'Vietnam', 97766, '16/01/2022', 'car/image/Express.jpg', 41, 118, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Reatta', 'Malta', 83717, '08/02/2022', 'car/image/Reatta.jpg', 73, 23, 1);");
        sqLiteDatabase.execSQL("insert into car (name, description, price, available_since, photo, mph, max_speed, brand_id) values ('Lumina', 'Russia', 90326, '15/02/2022', 'car/image/Lumina.jpg', 69, 79, 1);");
    }
}
